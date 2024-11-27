package tp01;

public class Binaire {
	/**
	 * Retourne le nbr de bits à 1
	 * @param n
	 * @return
	 */
	public static byte nbBitV1(int n) {
		byte cpt = 0;
		int masque = 1;
		
		for (int i = 0; i < 32; i++) { // 32bits
			if ((n & masque) == masque) { // ou (n & masque) > 0
				cpt++;
			}
			masque = masque << 1;
		}
		return cpt;
	}
	
	public static byte nbBitV2(int n) {
		byte cpt = 0;
		int masque = 1;
		while (n != 0) {
			if ((n & masque) == masque) { 
				cpt++;
			}
			n = n >>> 1; // >>> insert des zéros! attention chiffre négatif
		}
		return cpt;
	}
	
	public static byte nbBitV3(int n) {
		byte cpt = 0;
		while (n != 0) {
			cpt = (byte) (cpt + (n & 1));
			n = n >>> 1;
		}
		return cpt;
	}
	
	// TODO
	public static byte nbBitV4(int n) {
		byte cpt = 0;
		while ((n & -1) != 0) {
			cpt = (byte) (cpt + (n & 1));
			n = n << 1;
		}
		return cpt;
	}
	
	
	public static String convertToHex(int n) {
		String resultatFinal = "";
		while (n != 0) {
			int masque = 15; // 0000...0001111
			int res = n & masque;
			
			//System.out.println(n & masque);
			
			for (int i = 0 ; i < 4 ; i++) {
				n = n >>> 1;
			}
			
			if (res < 10) {
				res = res + 48;
			}
			else if (res >= 10) {
				res = res + 55;
			}
			resultatFinal = (char) res + resultatFinal;
		}
		return "0x" + resultatFinal;
	}
	
	public static String convertToHexV2(int n) {
		String res = "";
		while (n != 0) {
			int masque = 15; // 0000...0001111
			int r = n & masque;
			r += (r < 10) ? 48 : 55;
			n = n >>> 4;
			res = (char) r + res;
			
		}
		return "0x" + res;
	}
	
	
	public static boolean estMajuscule(char c) {
		assert (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z'): "Ce n'est pas une lettre";
		int masque = 32; // 32 = 00100000 (binaire) (bite en 5eme position)
		boolean res = false;
		if (((int) c & masque) == 0) {
			res = true;
		}
		return res;
	}
	
	
// TODO nbBytesUtf8 en python
	public static int nbBytesUtf8_V1(char c) {
		// 0xff80 = 1111 1111 1000 0000 masque unicode
		if ((c & 0xff80) == 0) {
			return 1;
		}
		if ((c & 0xF800) == 0) {
			return 2;
		}
		return 3;
	}
	
// TODO nbBytesUtf8 en python
	public static int nbBytesUtf8_V2(char c) {
		// 128 = 0000 0000 0111 1111 ->  < 2^7
		// 2048 = 0000 0111 1111 1111 ->  < 2^8
		int n = (int) c;
		
		if (n < 128) {
			return 1;
		}
		if (n < 2048) {
			return 2;
		}
		return 3;
	}
	
	public static int decodeUtf8(int utf8) {
		// int = entier 32bits!
		
		assert ( utf8 & 0xf000000 ) == 0 : "Les 8 premiere bits (gauche) doivent etre égal à 0";
		
		int res = 0;
		
		// 1er cas
		if ((utf8 & 0x00ffff80) == 0) { 				// 0x00ffff80 = 0000 0000 1111 1111 1111 1111 1000 0000
			res = utf8;
		}
		// 2eme cas
		else {
			if ((utf8 & 0xff0000) == 0) { 				// 0xff0000 = 0000 0000 1111 1111 0000 0000 0000 0000
				assert ( utf8 & 0xe0c0 ) == 0xC080 : "le code utf8 n'est pas bon";
				
				res = utf8 & 0x3f; 						// 0x3f 	= 0000 0000 0000 0000 0000 0000 0011 1111
				res = res | ((utf8 & 0x1f00) >> 2);		// 0x1f00 	= 0000 0000 0000 0000 0001 1111 0000 0000
			}
			// 3eme cas
			else {
				assert ( utf8 & 0xf0C0C0 ) == 0xd08080 : "le code utf8 n'est pas bon";
				
				res = utf8 & 0x3f;
				res = res | ((utf8 & 0x3f00) >> 2); 	// 0x3f00	= 0000 0000 0000 0000 0011 1111 0000 0000
				res = res | ((utf8 & 0xf0000) >> 4); 	// 0xf0000  = 0000 0000 0000 1111 0000 0000 0000 0000
			}
		}
		return res;
	}
	
	
	/**
	 * Lancement des exemples
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(convertToHex(745));
		System.out.println(convertToHexV2(745));
	}
}

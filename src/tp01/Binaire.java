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
	
	/**
	 * Lancement des exemples
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(convertToHex(745));
		System.out.println(convertToHexV2(745));
	}
}

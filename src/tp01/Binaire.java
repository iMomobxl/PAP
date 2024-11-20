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
		for (int i = 0; i < 32; i++) {
			if ((n & masque) == masque)
				cpt++;
			masque = masque << 1;
		}
		return cpt;
	}

	/**
		 * Retourne le nbr de bits à 1
		 * @param n
		 * @return
		 */
	public static byte nbBitV2(int n) {
		byte cpt = 0;
		while (n != 0) {
			cpt = (byte) (cpt + (n & 1));
			n = n >>> 1;// ATTENTION injecte des 0
		}
		return cpt;
	}
}

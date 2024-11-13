package tp00;

public class Somme {
	/**
	 * Utilise une boucle For
	 * @param n <=0
	 * @return
	 */
	public static long sommeN_V1(int n) {
		assert n >= 0 : "N doit être >=0";
		long s = 0;
		// Passage de i en long pour éviter le débordement avec MAX_INT
		for (long i = 1; i <= n; i++)
			s = s + i;
		return s;
	}

	/**
	 * Version avec un calcul 
	 * @param n
	 * @return
	 */
	public static long sommeN_V2(int n) {
		assert n >= 0 : "N doit être >=0";
		return n * ((long) n + 1) / 2;// besoin d'un cast en long pour (n+1)
	}

	/**
	 * Version plus élaborée en utilisant des opérateurs binaires
	 * pour les divisions par 2 et le modulo 2
	 * @param n
	 * @return
	 */
	public static long sommeN_V3(int n) {
		assert n >= 0 : "N doit être >=0";
		if ((n & 1) == 0)
			return (n >> 1) * ((long) n + 1);
		return (((long) n + 1) >> 1) * n;
	}

	public static void main(String[] args) {
		System.out.println(sommeN_V1(Integer.MAX_VALUE));
	}

}

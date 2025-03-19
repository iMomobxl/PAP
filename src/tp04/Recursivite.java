package tp04;

public class Recursivite {
	
	/**
	 * le pivot sera égal à v[f]
	 * trouve la position du pivot (supposant l'indice x)
	 * Il faut ensuite que
	 * ==> v[i] < pivot pour d<=i<x
	 * ==> v[j]>= pivot pour x<j<= f
	 * hyp: d<=f  d>=0  f< taille de V 
	 * @param v
	 * @param d 
	 * @param f
	 */
	public static int posPivot(int[] v, int d, int f) {
		assert d <= f && d >= 0 && f < v.length: "assert erreur";
		
		// enregistre les parametres
		int i = d;
		int j = f - 1;
		int x = v[f];
		
		while (i <= j) {
            if (v[i] < x) {
                i++;
            }
            else if (v[j] >= x) {
                j--;
            }
            else {
            	int temp = v[i];
                v[i] = v[j];
                v[j] = temp;
            }
		}
		
		// met le pivot a la position final
		int temp = v[i];
        v[i] = v[f];
        v[f] = temp;
        
		return i;
	}
	
	public static void triRecursive(int[] v, int d, int f) {
	    if (d < f) {
	    	int index = posPivot(v, d, f); // Trouver la position du pivot
	        triRecursive(v, d, index - 1); // Trier la partie gauche
	        triRecursive(v, index + 1, f); // Trier la partie droite
	    }
	}
	
	
	/**
	 * Factorielle de n (recursivite)
	 * @param n <= 25
	 * @return
	 */
	public static long factoriel(int n) {
		assert n > 0 && n < 26: "n <= 25";
		if (n == 0) {
			return 1;
		}
		return n * factoriel(n - 1);
	}
	
	/**
	 * nombre de fibonacci
	 * @param n >= 0
	 * @return
	 */
	public static long fibonacci(int n) {
		assert n >= 0 : "n >= 0";
		if (n < 2) {
			return n;
		}
		return fibonacci(n - 1) + fibonacci(n - 2);
	}
	
	
	public static long power(long x, long y) {
		if (y == 0) {
			return 1;
		}
		if (y == 0 || x == 0 || x ==1) {
			return x;
		}
		long res = power(x, y / 2);
		res = res * res;
		if (y % 2 != 0) {
			res = res * x;
		}
		return res;
	}
	
	public static void deplacer(int n, int d, int a) {
		if (n == 1) {
			System.out.println("deplacer de " + d + " vers " + a);
		} else {
			int i = 6 - d - a;
			deplacer(n - 1, d, i);
			deplacer(1, d, a);
			deplacer(n - 1, i, a);
		}
	}

		
	public static void main(String[] args) {
		
		System.out.println(factoriel(25)); // max 25!!!
		System.out.println(fibonacci(7));
		System.out.println(power(2,62));
		System.out.println(Math.pow(2,62));
		deplacer(4, 1, 2);
		
		int[] v = { 1, 7, 5, 2, 9, 4 };
		for (int i = 0; i < v.length; i++) {
			System.out.print(v[i] + ", ");
		}
		System.out.println();
		triRecursive(v, 0, v.length - 1);
		for (int i = 0; i < v.length; i++) {
			System.out.print(v[i] + ", ");
		}
		System.out.println();
		int[] v2 = { 1, 7, 5, 2, 9, 4, 20, 13, 3, 0, 6, 24};
		for (int i = 0; i < v2.length; i++) {
			System.out.print(v2[i] + ", ");
		}
		System.out.println();
		triRecursive(v2, 0, v2.length - 1);
		for (int i = 0; i < v2.length; i++) {
			System.out.print(v2[i] + ", ");
		}
	}
}

package tp04;

import util.StackInt;

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
	public static void posPivot(int[] v, int d, int f) {
		assert d <= f : "assert erreur";
		
		// enregistre les parametres
		int i = d;
		int j = f - 1;
		int x = v[f];
		
		while (i <= j) {
            while (v[i] < x) {
            	i++;
            }
            while (j >= 0 && v[j] >= x) {
            	j--;
            }
            if (i < j) {
            	// swap
            	int tmp = v[i];
            	v[i] = v[j];
            	v[j] = tmp;
            	
            }
		}
		
		// met le pivot a la position final
        v[f] = v[i];
        v[i] = x;
	}
	
	/**
	 * quickSort recursif
	 * @param v
	 * @param d
	 * @param f
	 */
	public static void quickSort(int[] v, int d, int f) {
		assert d <= f : "assert erreur";
		
		// enregistre les parametres
		int i = d;
		int j = f - 1;
		int x = v[f];
		
		while (i <= j) {
            while (v[i] < x) {
            	i++;
            }
            
            while (j >= 0 && v[j] >= x) {
//            while (v[j] >= x && j >= 0) {
            	j--;
            }
            
            if (i < j) {
            	// swap
            	int tmp = v[i];
            	v[i] = v[j];
            	v[j] = tmp;
            	
            }
		}
		
		// met le pivot a la position final
        v[f] = v[i];
        v[i] = x;
        
        // partie recursif de posPivot
        // appeler le quickSort en fonction de la taille Gauche/Droite du pivot
        int tailleGauche = i - d;
        int tailleDroite = f - i;
        if (tailleGauche < tailleDroite) {
	        // minimum 2 element a gauche -> on rappel quickSort
	        if (tailleGauche > 1 ) {
	        	quickSort(v, d, i - 1);
	        }
	        // minimum 2 element a droite -> on rappel quickSort
	        if (tailleDroite > 1) {
	        	quickSort(v, i + 1, f);
	        }
        } else { // tailleGauche >= tailleDroite
        	// minimum 2 element a droite -> on rappel quickSort
	        if (tailleDroite > 1) {
	        	quickSort(v, i + 1, f);
	        }
        	// minimum 2 element a gauche -> on rappel quickSort
	        if (tailleGauche > 1 ) {
	        	quickSort(v, d, i - 1);
	        }
        }
	}
	
	// version non recursive
	public static int posPivot2(int[] v, int d, int f) {
		assert d <= f : "assert erreur";
		
		// enregistre les parametres
		int i = d;
		int j = f - 1;
		int x = v[f];
		
		while (i <= j) {
            while (v[i] < x) {
            	i++;
            }
            while (j >= 0 && v[j] >= x) {
            	j--;
            }
            if (i < j) {
            	// swap
            	int tmp = v[i];
            	v[i] = v[j];
            	v[j] = tmp;
            	
            }
		}
		
		// met le pivot a la position final
        v[f] = v[i];
        v[i] = x;
        return i;
	}
	
	/**
	 * quickSort non recursif
	 * @param v
	 * @param d
	 * @param f
	 */
	public static void quickSort2(int[] v, int d, int f) {
		int i, j, p;
		StackInt s = new StackInt(v.length + 1);
		s.push(d);
		s.push(f);
		while (!s.empty() ) {
			j = s.pop();
			i = s.pop();
			p = posPivot2(v, i, j);
			if (p - i > 1) {
				s.push(i);
				s.push(p - 1);
			}
			if (j - p > 1) {
				s.push(p + 1);
				s.push(j);
			}
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
		
		int[] v = { 1, 7, 5, 2, 0, 9, 4 };
		for (int i = 0; i < v.length; i++) {
			System.out.print(v[i] + ", ");
		}
		System.out.println();
		quickSort(v, 0, v.length - 1);
		for (int i = 0; i < v.length; i++) {
			System.out.print(v[i] + ", ");
		}
		
		System.out.println();
		
		int[] v2 = { 1, 7, 5, 2, 9, 4, 20, 13, 3, 6, 24 };
		for (int i = 0; i < v2.length; i++) {
			System.out.print(v2[i] + ", ");
		}
		System.out.println();
		quickSort(v2, 0, v2.length - 1);
		for (int i = 0; i < v2.length; i++) {
			System.out.print(v2[i] + ", ");
		}
		
		System.out.println();
		
		int[] v3 = { 1, 7, 5, 2, 9, 4, 20, 13, 3, 6, 24 };
		for (int i = 0; i < v3.length; i++) {
			System.out.print(v2[i] + ", ");
		}
		System.out.println();
		quickSort2(v3, 0, v3.length - 1);
		for (int i = 0; i < v3.length; i++) {
			System.out.print(v3[i] + ", ");
		}
	}
}

package tp04;

public class Recursivite {
	
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

	public static void placePivot(int[] v, int d, int f) {
		int pivot = v[f];
		int i = d;
		int j = f;
		while (v[i] < v[i + 1]) {
			i++;
		}
		while (v[j] < v[j +1]) {
			j++;
		}
		int val = v[i];
		v[i] = v[j];
		v[j] = v[i];
		placePivot(v, d, j+1);
		
	}
	
	public static void main(String[] args) {
		
		System.out.println(factoriel(25)); // max 25!!!
		System.out.println(fibonacci(7));
		System.out.println(power(2,62));
		System.out.println(Math.pow(2,62));
		deplacer(4, 1, 2);
			
	}
}

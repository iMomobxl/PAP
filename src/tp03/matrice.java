package tp03;


public class matrice {

	public static void afficheMat(int[][] m) {
		Integer max = maxDigitBis(m) + 2;
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				System.out.printf(("%" + max.toString() + "d"), m[i][j]);
			}
			System.out.println();
		} 
	}
	
	public static int maxDigitBis(int[][] m) { // for loop
		int res = 1;
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
//				if (Integer.toString(m[i][j]).length() > res) {
//					res = Integer.toString(m[i][j]).length();
//				}
				res = Math.max(res, Integer.toString(m[i][j]).length());
			}
		}
		return res;
	}
	
	public static int maxDigit(int[][] m) { // forEach loop
		int res = 1;
		for (int[] v : m) {
			for (int elem : v) {
				res = Math.max(res, Integer.toString(elem).length());
			}
		}
		return res;
	}
	
	public static int[][] creeMat(int n, int m) {
		int[][] mat = new int[n][m];
		int counter = 1;
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				mat[i][j] = counter++;
			}
		}
		return mat;
	}
		
	public static void main(String[] args) {
		
		int[][] m1 = { {1, 2, 3}, {4, 5, 6} };
//		for (int i = 0; i < m1.length; i++) {
//			for (int j = 0; j < m1[i].length; j++) {
//				System.out.print(m1[i][j] + " ");
//			}
//			System.out.println();
//		} 
//		System.out.println();
//		for (int i = 0; i < m1.length; i++) {
//			for (int j = 0; j < m1[i].length; j++) {
//				System.out.printf("%3d", m1[i][j]); // %3d valeur decimal sur 3 digit
//			}
//			System.out.println();
//		} 
		
		afficheMat(m1);
		System.out.println();
		afficheMat(creeMat(3,3));
//		System.out.println(maxMat(m1));
	}
	
}

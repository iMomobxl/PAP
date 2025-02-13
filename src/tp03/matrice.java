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
	
	public static int rechercheMin(int[][] m) {
		int min = m[0][0];
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				if (m[i][j] < min) {
					min = m[i][j];
				}
			}
		}
		return min;
	}
	
	// correction rechercheMin
	public static int rechercheMinV2(int[][] m) {
		int mini = m[0][0];
		for (int[] v : m) {
			for (int elem : v) {
				if (elem < mini) {
					mini = elem;
				}
			}
		}
		return mini;
	}
	
	public static boolean existeInMat(int[][] m, int valeur) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				if (m[i][j] == valeur) {
					return true;
				}
			}
		}
		return false;
	}
	
	// correction existeInMat
	public static boolean existeInMatV2(int[][] m, int valeur) {
		boolean trouve = false;
		int i = 0;
		while (!trouve && i < m.length) {
			int j = 0;
			while (!trouve && j < m[i].length) {
				trouve = m[i][j] == valeur;
				j++;
			}
			i++;
		}
		return trouve;
	}
		
	public static boolean estSymmetrique(int[][] m) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				if (m[i][j] != m[j][i]) {
					return false;
				}
			}
		}
		return true;
	}
	
	// correction estSymmetrique
	public static boolean estSymmetriqueV2(int[][] m) {
		return true;	}
	
	public static boolean validerSeq(int[] v, boolean[][] m) {
		for (int i = 0; i < v.length-1; i++) {
//			System.out.println("comparaison: i=" + v[i] + " and j=" + (v[i+1]) + " is " + m[v[i]][v[i+1]]);
			if (m[v[i]][v[i+1]] == false) {
				return false;
			}
		}
		return true;
	}
	
	// correction validerSeq
	public static boolean validerSeqV2(int[] v, boolean[][] m) {
		boolean valide = true;
		int i = 0;
		while (valide && i < v.length - 1) {
			valide = m[v[i]][v[i + 1]];
			i++;
		}
		return valide;
	}
	
	public static int[][] produitMat(int[][]m1, int[][]m2) {
		int[][] m = new int[m1.length][m2[0].length];
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				for (int k = 0; k < m1[0].length; k++) {
					m[i][j] += m1[i][k] * m2[k][j];
				}
			}
		}
		return m;
	}

	public static int calculeSomme(int[][]m, int posLigne, int posColonne, int dirX, int dirY) {
		int somme = 0;
		for (int i = 0; i < m.length; i++) {
			somme += m[posLigne][posColonne];
            posLigne += dirX;
            posColonne += dirY;
		}
		return somme;
	}
	
	public static boolean sommeIdentique(int[][] m) {
		// somme 1ere diagonal
		int somme = calculeSomme(m, 0, 0, 1, 1);
		
		// somme des lignes et colonne
		for (int i = 1; i < m.length; i++) {
			if (calculeSomme(m, i, 0, 0, 1) != somme || calculeSomme(m, 0, i, 1, 0) != somme) {
				return false;
			}    
		}
		
		// check la 2eme diagonale
		if(calculeSomme(m, 0, m.length - 1, 1, -1) != somme) {
			return false;
		}
				
		return true;
	}
	
	public static void main(String[] args) {
		
		int[][] m1 = { {4, 2, 3}, {4, 5, 6} };
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
//		
//		afficheMat(m1);
//		System.out.println();
//		afficheMat(creeMat(3,3));
//		System.out.println(maxMat(m1));
//		System.out.println(rechercheMin(m1));
		System.out.println(rechercheMinV2(m1));
//		System.out.println(existeInMat(m1,3));
		System.out.println(existeInMatV2(m1, 3));
//		int[][] m2 = { {9, -1, 6}, {-1, 5, 1}, {5, 1, 3} };
//		System.out.println(estSymmetrique(m2));
		System.out.println("---------------------------------");
		boolean[][] m3 = {
				{true, false, true, true}, 
				{false, true, false, true},
				{true, false, true, true}, 
				{true, true, false, false} 
				};
		int[] v1 = { 0, 0, 2, 2, 0, 3};
		int[] v2 = { 0, 2, 1, 1, 3 };
		System.out.println(validerSeq(v1, m3));
		System.out.println(validerSeq(v2, m3));
		System.out.println(validerSeqV2(v1, m3));
		System.out.println(validerSeqV2(v2, m3));
		System.out.println("---------------------------------");
		int[][] m4 = {
				{1, 2},
				{5, 3},
				{-1, 4}
		};
		int[][] m5 = {
				{5, 2},
				{3, 4}
		};
		afficheMat(produitMat(m4, m5));
		
		int [][] m6 = {
				{2, 7, 6},
				{9, 5, 1},
				{4, 3, 8}
		};	
		System.out.println(sommeIdentique(m6));
	}
}

package tp03;


public class matrice {

	public static String getColor(int value) {
		
//		font-color code:
//			blue: \u001B[34m
//			yellow: \u001B[33m
//			red: \u001B[31m
//		bg-color code:
//			black: \u001B[40m
//		font-size:
//			bold: \u001B[1m
	    switch (value) {
	        case -1: 
	        	// BORDURE -> font-color: blue, bg-color: black
	        	return "\033[34m\033[40m"; 
	        case 0: 
	        	// VIDE -> bg-color: black
	        	return "\033[40m"; 			
	        case 1: 
	        	// JAUNE -> font-color: yellow, bg-color: black, font-size: bold
	        	return "\033[33m\033[40m\033[1m";  
	        case 2: 
	        	// ROUGE -> font-color: red, bg-color: black, font-size: bold
	        	return "\033[31m\033[40m\033[1m";  
	        default: 
	        	// Réinitialisation par défaut
	        	return "\033[0m";  			
	    }
	}
	
	/**
	 * @param mat
	 * Affichage d'une matrice plus esthétique
	 */
	public static void afficheMat2(int[][] mat) {
		// Définir les caractères pour les bordures
		char bordureHorizontale = '\u2550';
		char bordureVerticale = '\u2551';
		char croixHorizVert = '\u256C';
		// nbr de colonnes
		int m = mat[0].length;
		// nombre de caractères max pour une donnée de mat
		int nb = nbMaxChar(mat) + 1;
		// max car pour afficher l'indice de ligne
		int maxCarLigne = Integer.toString(mat.length).length();
		// max car pour la 1ère colonne de la matrice
		int maxCarColonne1 = nbMaxCharCol1(mat) + 1;

		// début coin sup gauche
		System.out.printf("%" + maxCarLigne + "s" + bordureVerticale, " ");
		// indice de colonne avec un écart minimum pour la 1ère colonne
		for (int j = 0; j < m; j++) {
			int nbr = j == 0 ? maxCarColonne1 : nb;
			System.out.printf("%" + nbr + "d", j);
		}
		System.out.println();
		// Affichage d'une ligne horizontale de séparation
		int cpt = maxCarLigne;
		for (int j = 0; j < cpt; j++)
			System.out.print(bordureHorizontale);
		// La croix
		System.out.print(croixHorizVert);
		// La suite de la ligne horizontale
		cpt = m * nb;
		for (int j = 0; j < cpt; j++)
			System.out.print(bordureHorizontale);

		System.out.println();
		// la matrice avec les entêtes de ligne
		for (int i = 0; i < mat.length; i++) {
			// entête de ligne et séparation
			System.out.printf("%" + maxCarLigne + "d" + bordureVerticale, i);
			for (int j = 0; j < m; j++) {
	            String color = getColor(mat[i][j]);
				// les données en ligne avec le minimum d'espace pour la 1ère colonne
				int nbr = j == 0 ? maxCarColonne1 : nb;
				System.out.printf(color + "%" + nbr + "d" + "\u001B[0m", mat[i][j]);
			}
			System.out.println();
		}
	}

	/**
	 * Pour l'affichage afficheMat2
	 * Retourne le nombre maximum de caractères des nombres de la matrice
	 * @param mat
	 * @return
	 */
	private static int nbMaxChar(int[][] mat) {
		int maxi = 1;
		for (int[] v : mat)
			for (int elem : v)
				maxi = Math.max(maxi, Integer.toString(elem).length());
		return maxi;
	}

	/**
	 * Pour l'affichage afficheMat2
	 * nbr maimum de caractères pour la 1ère colonne de la matrice
	 * @param mat
	 * @return
	 */
	private static int nbMaxCharCol1(int[][] mat) {
		int maxi = 1;
		for (int i = 0; i < mat.length; i++)
			maxi = Math.max(maxi, Integer.toString(mat[i][0]).length());
		return maxi;
	}

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

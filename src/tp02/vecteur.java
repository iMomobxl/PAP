package tp02;

import java.util.Arrays;

public class vecteur {
	
	/*
	 * MinMax2
	 * declaration de la class (record) dans la classe vecteur
	 * 
	 * MinMax
	 * declaration de la class (record) dans MinMax.java
	 */
	record RMinMax(int minimum, int maximum) {
		
	}
	
	/**
	 * Affiche un vecteur d'entier
	 * @param v
	 */
	public static void afficheVect(int[] v) {
		assert v != null : "v est null";
		System.out.print("[");
		for (int i = 0; i < v.length - 1; i++) {
			System.out.print(v[i] + ", ");
		}
		System.out.print(v.length == 0 ? "]" : v[v.length - 1] + "]");
		System.out.println();
	}
	
	/**
	 * Affiche un vecteur de char (ma version)
	 * mais attention trop de if donc trop lourd si le vecteur est trés grand
	 * @param v
	 */
	public static void afficheVectV1(char[] v) {
		assert v != null : "v est null";
		
		System.out.print("[");
		for (int i = 0; i < v.length; i++) {
			if (i == v.length - 1) {
				System.out.print(v[i]);
			}
			else {
				System.out.print(v[i] + ", ");
			}
		}

		System.out.print("]");
		System.out.println();
	}
	
	/**
	 * Affiche un vecteur de char (version prof)
	 * @param v
	 */
	public static void afficheVectV2(char[] v) {
		assert v != null : "v est null";
		
		System.out.print("[");
		for (int i = 0; i < v.length - 1; i++) {
			System.out.print(v[i] + ", ");
		}
		System.out.print(v.length == 0 ? "]" : v[v.length - 1] + "]");
		System.out.println();
	}
	
	/**
	 * Affiche la somme d'un vecteur d'entier (ma version)
	 * @param v
	 */
	public static long sommeV(int[] v) {
		assert v != null : "v est null";
		
		long somme = 0;
		for (int elem : v) {
			somme += elem;
		}
		System.out.println(somme);
		return somme;
	}
	
	/**
	 * version prof: attention return long! car peut depasser le int (2^63)
	 * @param v
	 * @return
	 */
	public static long sommeV_V2(int[] v) {
		long res = 0;
		for (int elem : v) 
			res = res + elem;
		return res;
	}
	
	public static int maxElemV1(int[] v) {
		assert v.length > 0 : "vecteur est vide";
		int res = v[0];
		for (int elem : v) {
			if (elem > res) {
				res = elem;
			}
		}
		return res;
	}
	
	public static int maxElemV2(int[] v) {
		assert v.length > 0 : "vecteur est vide";
		int res = v[0];
		for (int i = 1; i < v.length; i++) {
			if (res < v[i]) {
				res = v[i];
			}
		}
		return res;
	}
	
	public static int minElemV1(int[] v) {
		assert v.length > 0 : "vecteur est vide";
		int res = v[0];
		for (int elem : v) {
			if (elem < res) {
				res = elem;
			}
		}
		return res;
	}
	
	public static int minMaxElemV(int[] v, boolean max ) {
		int res = v[0];
		for (int elem : v) {
			if (max) {
				if (elem > res) {
					res = elem;
				}
			} 
			else {
				if (elem < res) {
					res = elem;
				}
			}
		}
		return res;
	}
	
	public static int minMaxElemV_V2(int[] v, boolean max ) {
		int res = v[0];
		for (int elem : v) {
			if (elem > res && max) {
				res = elem;
			}
			else if (elem < res && !max) {
				res = elem;
			}
		}
		return res;
	}
	
	public static int minMaxElemV_V3(int[] v, boolean max ) {
		int res = v[0];
			if (max) {
				res = maxElemV1(v);
			} 
			else if (!max) {
				res = minElemV1(v);
			}
		
		return res;
	}
	
	public static int minMaxElemV_V4(int[] v, boolean max ) {
		return max ? maxElemV1(v) : minElemV1(v);
	}
	
	public static double avgElemV(int[] v) {
		double res = 0;
		for (int elem : v) {
			res += elem;
		}
		res = res / (double) v.length;
		return res;
	}
	
	public static double avgElemV2(int[] v) {
		return sommeV_V2(v) / (double) v.length;
	}
	
	/*
	 * fonction du prof
	 */
	public static double avgElemV3(int[] v) {
		long somme = sommeV_V2(v);
		return (double) somme / v.length;
	}
	
	public static int nbElemV(int[] v, int elem) {
		int cpt = 0;
		for (int element : v) {
			if (element == elem) {
				cpt++;
			}
		}
		return cpt;
	}
	
	
	public static int[] minMaxElemV(int[] v) {
		int[] v2 = new int[2];
		v2[0] = minElemV1(v);
		v2[1] = maxElemV1(v);
		return v2;
	}
	
	public static int[] minMaxElemV2(int[] v) {
		assert v.length > 0 : "Vecteur vide";
		int[] v2 = new int[2];
		// int[] v3 = { v[0], v[0] }; // autre facon de declarer le vecteur
		v2[0] = v[0];
		v2[1] = v[0];
		for (int element : v) {
			if (element < v2[0]) {
				v2[0] = element;
			} 
			else if (element > v2[1]) {
				v2[1] = element;
			}
		}
		return v2;
	}
	
	/**
	 * Utilsation du record
	 * @param v
	 * @return
	 */
	public static RMinMax minMaxElemV3(int[] v) {
		assert v.length > 0 : "Vecteur vide";
		int min = v[0];
		int max = v[0];
		for (int element : v) {
			if (element < min) {
				min = element;
			} 
			else if (element > max) {
				max = element;
			}
		}
		return new RMinMax(min, max);
	}
	
	
	public static int[] cloneV(int[] v) {
		int[] v2 = new int[v.length];
		for (int i = 0; i < v.length; i++) {
			v2[i] = v[i];
		}
		return v2;
	}
	
	/*
	 * Palindrom V1 
	 */
	public static boolean palindrome(char[] v) {
		boolean estPalindrome = true;
		//taille paire
		if (v.length % 2 == 0) {
			int i = 0;
			int j = v.length - 1;
			do {
				if (v[i] != v[j]) {
					estPalindrome = false;
				} else {
					i++;
					j--;
				}
			} while (estPalindrome && i < (v.length -1 / 2));
		} else { // taille impaire
			int i = 0;
			int j = v.length - 1;
			do {
				if (v[i] != v[j]) {
					estPalindrome = false;
				} else {
					i++;
					j--;
				}
			} while (estPalindrome && i < (v.length - 2 / 2));
		}
		
		return estPalindrome;
	}
	
	/**
	 * Palindrome V2
	 * @param v
	 * @return
	 */
	
	public static boolean palindromeV2(char[] v) {
		assert v.length > 0 : "vecteur vide";
		boolean estPalindrome = true;
		int tailleV = v.length / 2;
		int i = 0;
		int j = v.length - 1;
		while (estPalindrome && i < tailleV) {
			if (v[i] != v[j]) {
				estPalindrome = false;
			} else {
				i++;
				j--;
			}
		} 
		return estPalindrome;
	}
	
	public static boolean palindromeV3(char[] v) {
		assert v.length > 0 : "vecteur vide";
		boolean estPalindrome = true;
		int tailleV = v.length / 2;
		int i = 0;
		int j = v.length - 1;
		while (estPalindrome && i < tailleV) {
			estPalindrome = (v[i] == v[j]);
			i++;
			j--;
		} 
		return estPalindrome;
	}
	
	public static boolean palindromeString(String v) {
		assert v.length() > 0 : "vecteur vide";
		boolean estPalindrome = true;
		int tailleV = v.length() / 2;
		int i = 0;
		int j = v.length() - 1;
		while (estPalindrome && i < tailleV) {
			estPalindrome = (v.charAt(i) == v.charAt(j));
			i++;
			j--;
		} 
		return estPalindrome;
	}
	
	public static char[] copieInverseV1(char[] v) {
		char[] v1 = new char[v.length];
		int len = v.length - 1;
		for(int i = 0; i < len + 1; i++) {
			v1[i] = v[len - i];
		}
		return v1;
	}
	
	public static char[] copieInverseV2(char[] v) {
		char[] v2 = new char[v.length];
		int j = v.length - 1;
		for (char elem : v) {
			v2[j] = elem;
			j--;
		}
		return v2;
	}
	
	// attention V1 ne marche pas si v est null
	public static boolean rechercheBinaire(int[] v, int elem) {
		if (v.length == 0) {
			return false;
		}
		int d = 0;
		int f = v.length;
		int m = v.length / 2;
		boolean find = false;
		
		do {
			if (elem != v[m]) {
				if (elem < v[m]) {  // plus petit
					f = m - 1;
				} else {
					d = m + 1;		// plus grand
				}
				m = (d + f) / 2;
			} else {
				find = true;
			}
		} while (!find & d <= f);
		
		return find;
	}
	
	// version prof (pas de probleme si v est null)
	public static boolean rechercheBinaireV2(int[] v, int elem) {
		boolean trouve = false;
		int d = 0;
		int f = v.length - 1;
		while (!trouve & d <= f) {
			int m = (d + f) / 2;
			trouve = (v[m] == elem);
			if (elem < v[m]) {
				f = m - 1;
			} else {
				d = m + 1;
			}
		}
		return trouve;
	}
	
	public static boolean rechercheBinaireV3(int[] v, int elem) {
		if (v.length == 0) { // cas vecteur vide { }
			return false;
		}
		int d = 0;
		int f = v.length - 1;
		int m = (d + f) / 2;
		while (d < f & v[m] != elem) { // uniquement d < f pas d <= f
			if (elem < v[m]) {
				f = m - 1;
			} else {
				d = m + 1;
			}
			m = (d + f) / 2;
		}
		return (v[m] == elem);
	}
	
	/*
	 * ma version (que le prof n'a pas pensé ahah) (veridicte!!)
	 */
	public static boolean sansDoublonV1(int[] v) {
		boolean doublon = false;
		
		for(int i = 0; i < v.length - 1 && !doublon; i++) {
			//System.out.println("i=" + i);
			for (int j = i + 1; j < v.length && !doublon; j++) {
				//System.out.println("j=" + j);
				doublon = v[i] == v[j];
			}
		}
		
		return !doublon; // si doublon renvoie false, sinon true
	}
	/*
	 * version prof
	 */
	public static boolean sansDoublonV2(int[] v) {
		boolean doublon = false;
		int i = 0;
		while (!doublon && i < v.length - 1) {
			int j = i + 1;
			while (!doublon && j < v.length) {
				doublon = v[i] == v[j];
				j++;
			}
			i++;
		}
		return !doublon;
	}
	
	/*
	 * version tiré par les cheveux du prof
	 * 3 fonctions: sansDoublonV3(), rechercheBin(), insertToPos()
	 * 
	 */
	
	
	
	public static boolean sansDoublonV3(int[] v) {
		boolean doublon = true;
		
		int[] v2 = new int[v.length];
		v2[0] = v[0];
		int n = 1;
		int pos = 0;
		
		int i = 1;
		while (doublon && i < v.length - 1) {
			
			int elem = v[i];
			pos = rechercheBin(v2, n, elem);
			doublon = (pos == n) || (v2[pos] != elem);
			if (doublon) {
				n = insertToPos(v2, pos, n, elem);
				i++;
			}
			
		}
		
		return doublon;
	}
	
	// n = nombre d'element dans le vecteur
	// pos = position ou doit etre inserer elem
	// elem = element a inserer
	// v[] = vecteur ou elem doit etre inserer (trié)
	
	public static int insertToPos(int[] v, int pos, int n, int elem) {
		for (int i = n; i > pos; i--) {
			v[i] = v[i - 1];
		}
		v[pos] = elem;
		//afficheVect(v);
		return n + 1;
	}
	
	public static int rechercheBin(int[] v, int n, int elem) {
		boolean trouve = false;
		int d = 0;
		int f = n - 1;
		int m = 0;
		while (!trouve && d <= f) {
			m = (d + f) / 2;
			trouve = v[m] == elem;
			if (v[m] > elem) {
				f = m - 1;
			} else {
				d = m + 1;
			}
		}
		//return d;
		 if(trouve) {
		  	return m;
		 }
		 return v[m] < elem ? m +1 : m ;
	}
	
	
	
	
	public static void main(String[] args) {
		
		//---------------------------------------------------------
		
		int[] v = new int[4]; // créer un vecteur v de taille 4
		for (int i = 0; i < v.length; i++) {
			System.out.println(v + " ");
		}
		
		char[] vecteurDeChar = new char[10];
		
		for (int i = 0; i < vecteurDeChar.length; i++) {
			vecteurDeChar[i] = (char) (i);
			System.out.print((char) (vecteurDeChar[i] + 48) + ", ");
		}
		System.out.println();
		/*
		for (char elem: vecteurDeChar) {
			//System.out.print(elem);
		}
		*/
		
		//---------------------------------------------------------
		
		char[] vecteurHex = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
		
		for (char elem: vecteurHex ) {
			System.out.print(elem + ", ");
		}
		
		System.out.println();
		
		for (int i = 0; i < vecteurHex.length; i++) {
			System.out.print(vecteurHex[i] + ", ");
		}
		
		System.out.println();
		System.out.println();
		
		System.out.println("Affiche Vect:");
		afficheVectV1(vecteurHex);
		afficheVectV2(vecteurHex);
		
		char[] v2 = {};
		afficheVectV1(v2);
		afficheVectV2(v2);
		
		int[] v1 = {1 ,2, 3, 3, 4};
		

		int[] vecteurInt = {1, 2, 3, 4, 5, -2, 5, 5};
		System.out.println("Somme Vect: " + sommeV(vecteurInt));
		System.out.println("Somme Vect: " + sommeV_V2(vecteurInt));
		System.out.println("maxElemV: " + maxElemV1(vecteurInt));
		System.out.println("maxElemV: " + maxElemV2(vecteurInt));
		System.out.println("min_max_true V1: " + minMaxElemV(vecteurInt, true));
		System.out.println("min_max_false V1 : " + minMaxElemV(vecteurInt, false));
		System.out.println("min_max_true V2: " + minMaxElemV_V2(vecteurInt, true));
		System.out.println("min_max_false V2: " + minMaxElemV_V2(vecteurInt, false));
		System.out.println("min_max_true V3: " + minMaxElemV_V3(vecteurInt, true));
		System.out.println("min_max_false V3: " + minMaxElemV_V3(vecteurInt, false));
		System.out.println("min_max_true V4: " + minMaxElemV_V4(vecteurInt, true));
		System.out.println("min_max_false V4: " + minMaxElemV_V4(vecteurInt, false));
		System.out.println("avg_ElemV V1: " + avgElemV(vecteurInt));		
		System.out.println("avg_ElemV V2: " + avgElemV(vecteurInt));
		System.out.println("nbElemV: " + nbElemV(vecteurInt, 5));
		System.out.print("cloneV: ");
		afficheVect(cloneV(vecteurInt));
		System.out.print("minMaxElemV: ");
		afficheVect(minMaxElemV(vecteurInt));

		System.out.println("avg_ElemV V1: " + avgElemV(v1));		
		System.out.println("avg_ElemV V2: " + avgElemV2(v1));
		System.out.println("avg_ElemV V3: " + avgElemV3(v1));
		
		/*
		 * Utilisation du record MinMax (class)
		 */
		MinMax m = new MinMax(3, 45);
		System.out.println(m);
		System.out.println("Le mini est: " + m.minimun() + " , le max est: " + m.maximum());

		System.out.print("minMaxElemV2: ");
		afficheVect(minMaxElemV2(vecteurInt));
		
		int[] v3 = { 1, 209, 3, 3, 4, 0 };
		System.out.println(minMaxElemV3(v3));
		
		
		/*
		 * Palindrome
		 */
		char[] v4 = { 'a', 'b', 'b', 'b', 'a' };
		char[] v5 = { 'a', 'b', 'c', 'd', 'e'};
		System.out.println(palindrome(v4));
		System.out.println(palindromeV2(v4));
		System.out.println(palindromeV3(v4));
		System.out.println(palindromeString("abbba"));
		System.out.println(copieInverseV1(v5));
		System.out.println(copieInverseV2(v5));
		
		/*
		 * RechercheBinaire
		 */
		int[] v6 = { 2, 4, 7, 9, 9, 15, 20 };
		System.out.println(rechercheBinaire(v6,9));
		System.out.println(rechercheBinaireV2(v6,9));
		System.out.println(rechercheBinaireV3(v6,9));
		System.out.println(Arrays.binarySearch(v6, 9));
		System.out.println(sansDoublonV1(v6));
		int[] v7 = { 2, 4, 7, 10, 9, 15, 20 };
		System.out.println(sansDoublonV1(v7));
		System.out.println(sansDoublonV2(v6));
		System.out.println(sansDoublonV2(v7));
		int[] v8 = { 5, 8, 15, 0, 0, 0, 0, 0};
		int elem = 17;
		int position = rechercheBin(v8, 3, elem);
		System.out.println(position); // renvoie la position ou doit se trouver elem dans v2 (ordre croissant)
		int nbrElem = insertToPos(v8, position, 3, elem);
		System.out.println(nbrElem);
		

		System.out.println(sansDoublonV3(v6));
		System.out.println(sansDoublonV3(v7));
	}

}

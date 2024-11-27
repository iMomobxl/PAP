package tp02;

public class vecteur {
	
	
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
		res = res / v.length;
		return res;
	}
	
	public static double avgElemV2(int[] v) {
		return sommeV_V2(v) / v.length;
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
	
	
	public static int[] cloneV(int[] v) {
		int[] v2 = new int[v.length];
		for (int i = 0; i < v.length; i++) {
			v2[i] = v[i];
		}
		return v2;
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
		
		for (char elem: vecteurDeChar) {
			//System.out.print(elem);
		}
		
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
	}

}

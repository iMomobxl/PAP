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
	public static void sommeV(int[] v) {
		assert v != null : "v est null";
		
		int somme = 0;
		for (int elem : v) {
			somme += elem;
		}
		System.out.println(somme);
	}
	
	public static long sommeV_V2(int[] v) {
		long res = 0;
		for (int elem : v) 
			res = res + elem;
		return res;
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
		
		System.out.println("Somme Vect:");
		int[] vecteurInt = {1, 2, 3, 4, 5};
		sommeV(vecteurInt);
		System.out.println(sommeV_V2(vecteurInt));
	}

}

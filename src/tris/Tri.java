package tris;

import java.util.Arrays;
import java.util.stream.IntStream;

import tp02.vecteur;

public class Tri {
	
	public static void triIns(int[] v) { // tri par insertion (TriIns)
		
		for (int i = 1; i < v.length; i++) {
 			int elem = v[i];
			int j = i - 1;
			while (j >= 0 && v[j] > elem) {
				v[j + 1] = v[j];
				j--;
			}
			v[j + 1] = elem;
		}
		
	}
	
	
	
	
	
	public static void main(String[] args) {
		IntStream stream = IntStream.generate(() -> (int) (Math.random() * 1000));
		int[] v = stream.limit(20).toArray();
		
		
		int[] v2 = {7, 9, 8, 2, 13, 17};
		vecteur.afficheVect(v2);
		triIns(v2);
		vecteur.afficheVect(v2);
		vecteur.afficheVect(v);
		Arrays.sort(v);
//		vecteur.afficheVect(v);
		
//		Integer[] v2 = {4, 8, 3};
//		Arrays.sort(v2, (a, b) -> a - b);
//		System.out.println(Arrays.toString(v2));

	}
	
	
}

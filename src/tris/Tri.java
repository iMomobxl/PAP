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
	
	public static void triBulleV1(int[] v) { // tri a bulles V1
		
	}
	
	public static void triBulleV2(int[] v) { // tri a bulles V2
		int d = 1; // valeur bidon pour faire le while au minimum 1 fois
		int fin = v.length - 2;
		while (d > 0) {
			d = 0;
			for (int i = 0 ; i <= fin ; i++) {
				if (v[i] > v[i + 1]) {
					int tmp = v[i];
					v[i] = v[i + 1];
					v[i + 1] = tmp;
					d = i;
				}
			}
			fin = d - 1; 
		}
	}
	
	public static void triBulleV3(int[] v) {
		
		int d, g = -1;
		int debut = 0;
		int fin = v.length - 2;
		
		while (g < v.length) {
			
			d = 0;
			
			for (int i = debut ; i <= fin ; i++) {
				
				if (v[i] > v[i + 1]) {
					int tmp = v[i];
					v[i] = v[i + 1];
					v[i + 1] = tmp;
					d = i;
				}
				
			}
			
			g = v.length;
			
			if (d > 0) { //verifie si il y a eu echange
				
				for (int i = d ; i > debut ; i--) {
					
					if (v[i - 1] > v[i]) {
						
						int tmp = v[i];
						v[i] = v[i - 1];
						v[i - 1] = tmp;
						g = i;
					}
				}	
				
				fin = d - 1;
				debut = g;
			}
			
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

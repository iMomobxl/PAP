package tris;

import java.util.Arrays;
import java.util.stream.IntStream;

import tp02.vecteur;

public class MesTri {
	
	public static void main(String[] args) {
		IntStream stream = IntStream.generate(() -> (int) (Math.random() * 1000));
		int[] v = stream.limit(20).toArray();
		
		vecteur.afficheVect(v);
		
		Arrays.sort(v);
		
		vecteur.afficheVect(v);
		
		Integer[] v2 = {4, 8, 3};
		
		Arrays.sort(v2, (a, b) -> a - b);
		System.out.println(Arrays.toString(v2));

	}
	
	
}

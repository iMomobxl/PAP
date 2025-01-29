package tris;

import static org.junit.Assert.assertArrayEquals;

import org.junit.jupiter.api.Test;


public class TestTri {

	@Test
	public void triIns() {
		
		int[] vect0 = {4, 2};
		int[] vectTri0 = {2, 4};
		
		int[] vect1 = {4, 3, 2, 1};
		int[] vectTri1 = {1, 2, 3, 4};
		
		int[] vect2 = {1};
		int[] vectTri2 = {1};
		
		Tri.triIns(vect0);
		assertArrayEquals(vectTri0, vect0);
		
		Tri.triIns(vect1);
		assertArrayEquals(vectTri1, vect1);

		Tri.triIns(vect2);
		assertArrayEquals(vectTri2, vect2);		
	}
	
	@Test
	public void triBullesV2() {
		
		int[] vect00 = {4};
		
		int[] vect0 = {4, 2};
		int[] vectTri0 = {2, 4};
		
		int[] vect1 = {4, 3, 2, 1};
		int[] vectTri1 = {1, 2, 3, 4};
		
		int[] vect2 = {1};
		int[] vectTri2 = {1};
		
		Tri.triBulleV2(vect00);
		assertArrayEquals(vect00, vect00);
		
		Tri.triBulleV2(vect0);
		assertArrayEquals(vectTri0, vect0);
		
		Tri.triBulleV2(vect1);
		assertArrayEquals(vectTri1, vect1);

		Tri.triBulleV2(vect2);
		assertArrayEquals(vectTri2, vect2);	
	}
	
	@Test
	public void triBullesV3() {
		
		int[] vect00 = {4};
		
		int[] vect0 = {4, 2};
		int[] vectTri0 = {2, 4};
		
		int[] vect1 = {4, 3, 2, 1};
		int[] vectTri1 = {1, 2, 3, 4};
		
		int[] vect2 = {1};
		int[] vectTri2 = {1};
		
		Tri.triBulleV3(vect00);
		assertArrayEquals(vect00, vect00);
		
		Tri.triBulleV3(vect0);
		assertArrayEquals(vectTri0, vect0);
		
		Tri.triBulleV3(vect1);
		assertArrayEquals(vectTri1, vect1);

		Tri.triBulleV3(vect2);
		assertArrayEquals(vectTri2, vect2);	
	}
}

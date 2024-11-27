package tp02;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class test_vecteur {
	
	int[] v0 = { };
	int[] v1 = { 20 };
	int[] v2 = { 1, 8, 19 };
	int[] v5 = { 1, 8, 19 };
	int[] v3 = { Integer.MAX_VALUE, Integer.MAX_VALUE };
	int[] v4 = { 34, 23, 0 };
 
	@Test
	void testSommeV() {
		assertEquals(20, vecteur.sommeV(v1));
		assertEquals(28, vecteur.sommeV(v2));
		//assertEquals(28, vecteur.sommeV(v3));
		assertEquals(57, vecteur.sommeV(v4));
		assertEquals(20, vecteur.sommeV_V2(v1));
		assertEquals(28, vecteur.sommeV_V2(v2));
		assertEquals(57, vecteur.sommeV_V2(v4));
	}
	
	void testMaxElemV() {
		assertEquals(20, vecteur.maxElemV1(v1));
		assertEquals(29, vecteur.maxElemV1(v2));
		assertEquals(34, vecteur.maxElemV1(v4));
		assertEquals(20, vecteur.maxElemV2(v1));
		assertEquals(29, vecteur.maxElemV2(v2));
		assertEquals(34, vecteur.maxElemV2(v4));
	}
	/*
	void testMinMaxElemV {
		assertEquals(20, vecteur.minMaxElemV(v1, true));
		assertEquals(29, vecteur.minMaxElemV(v2, true));
		assertEquals(28, vecteur.minMaxElemV(v3, true));
		assertEquals(0, vecteur.minMaxElemV(v1));
		assertEquals(20, vecteur.minMaxElemV(v2));
		assertEquals(28, vecteur.minMaxElemV(v3));
	}*/
	void testCloneV() {
		assertArrayEquals(v5, vecteur.cloneV(v2));
	}
}

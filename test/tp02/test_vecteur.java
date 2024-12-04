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
	
	char[] c0 = { 'A' }; // true
	char[] c1 = { 'A' ,'A' }; // true
	char[] c2 = { 'A' ,'A', 'A' }; // true
	char[] c3 = { 'A' ,'B' }; // true
	char[] c4 = { 'A' ,'B', 'A' }; // false
	char[] c5 = { 'R' ,'A', 'D', 'A', 'R' }; // true
	char[] c6 = { 'A' ,'B', 'B', 'A' }; // true
	char[] c7 = { 'A' ,'B', 'C', 'D', 'B', 'A' }; // false
	char[] c8 = { 'A' ,'A', 'A', 'A', 'A', 'B' }; // false
	
	@Test
	void palindrome() {
		assertEquals(true, vecteur.palindrome(c0));
		assertEquals(true, vecteur.palindrome(c1));
		assertEquals(true, vecteur.palindrome(c2));
		assertEquals(false, vecteur.palindrome(c3));
		assertEquals(true, vecteur.palindrome(c4));
		assertEquals(true, vecteur.palindrome(c5));
		assertEquals(true, vecteur.palindrome(c6));
		assertEquals(false, vecteur.palindrome(c7));
		assertEquals(false, vecteur.palindrome(c8));
	}
	 
	@Test
	void palindromeV2() {
		assertEquals(true, vecteur.palindromeV2(c0));
		assertEquals(true, vecteur.palindromeV2(c1));
		assertEquals(true, vecteur.palindromeV2(c2));
		assertEquals(false, vecteur.palindromeV2(c3));
		assertEquals(true, vecteur.palindromeV2(c4));
		assertEquals(true, vecteur.palindromeV2(c5));
		assertEquals(true, vecteur.palindromeV2(c6));
		assertEquals(false, vecteur.palindromeV2(c7));
		assertEquals(false, vecteur.palindromeV2(c8));
	}
	
	@Test
	void palindromeV3() {
		assertEquals(true, vecteur.palindromeV3(c0));
		assertEquals(true, vecteur.palindromeV3(c1));
		assertEquals(true, vecteur.palindromeV3(c2));
		assertEquals(false, vecteur.palindromeV3(c3));
		assertEquals(true, vecteur.palindromeV3(c4));
		assertEquals(true, vecteur.palindromeV3(c5));
		assertEquals(true, vecteur.palindromeV3(c6));
		assertEquals(false, vecteur.palindromeV3(c7));
		assertEquals(false, vecteur.palindromeV3(c8));
	}
	
	@Test
	void palindromeString() {
		assertEquals(true, vecteur.palindromeString("A"));
		assertEquals(true, vecteur.palindromeString("AA"));
		assertEquals(true, vecteur.palindromeString("AAA"));
		assertEquals(false, vecteur.palindromeString("AB"));
		assertEquals(true, vecteur.palindromeString("ABA"));
		assertEquals(true, vecteur.palindromeString("RADAR"));
		assertEquals(true, vecteur.palindromeString("ABBA"));
		assertEquals(false, vecteur.palindromeString("ABCDBA"));
		assertEquals(false, vecteur.palindromeString("AAAAAB"));
		assertTrue(vecteur.palindromeString("A"));
		assertTrue(vecteur.palindromeString("AA"));
		assertTrue(vecteur.palindromeString("AAA"));
		assertFalse(vecteur.palindromeString("AB"));
		assertTrue(vecteur.palindromeString("ABA"));
		assertTrue(vecteur.palindromeString("RADAR"));
		assertTrue(vecteur.palindromeString("ABBA"));
		assertFalse(vecteur.palindromeString("ABCDBA"));
		assertFalse(vecteur.palindromeString("AAAAAB"));
		
	}
	
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
	@Test
	void testMaxElemV() {
		assertEquals(20, vecteur.maxElemV1(v1));
		//assertEquals(29, vecteur.maxElemV1(v2));
		//assertEquals(34, vecteur.maxElemV1(v4));
		//assertEquals(20, vecteur.maxElemV2(v1));
		//assertEquals(29, vecteur.maxElemV2(v2));
		//assertEquals(34, vecteur.maxElemV2(v4));
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

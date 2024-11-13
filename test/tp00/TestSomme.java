package tp00;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TestSomme {

	@Test
	void testSommeN_V1() {
		assertEquals(0, Somme.sommeN_V1(0));
		assertEquals(10, Somme.sommeN_V1(4));
		assertEquals(2305843008139952128L, Somme.sommeN_V1(Integer.MAX_VALUE));
		assertThrows(AssertionError.class, () -> Somme.sommeN_V1(-2));
	}

	@Test
	void testSommeN_V2() {
		assertEquals(0, Somme.sommeN_V2(0));
		assertEquals(10, Somme.sommeN_V2(4));
		assertEquals(2305843008139952128L, Somme.sommeN_V2(Integer.MAX_VALUE));
		assertThrows(AssertionError.class, () -> Somme.sommeN_V2(-2));
	}

	@Test
	void testSommeN_V3() {
		assertEquals(0, Somme.sommeN_V3(0));
		assertEquals(10, Somme.sommeN_V3(4));
		assertEquals(2305843008139952128L, Somme.sommeN_V3(Integer.MAX_VALUE));
		assertThrows(AssertionError.class, () -> Somme.sommeN_V3(-2));
	}

}

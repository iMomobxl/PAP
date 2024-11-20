package tp01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestBinaire {
	@Test
	void testnbBitV1() {
		assertEquals(0, Binaire.nbBitV1(0));
		assertEquals(1, Binaire.nbBitV1(1));
		assertEquals(3, Binaire.nbBitV1(25));
		assertEquals(32, Binaire.nbBitV1(-1));
	}
	@Test
	void testnbBitV2() {
		assertEquals(0, Binaire.nbBitV2(0));
		assertEquals(1, Binaire.nbBitV2(1));
		assertEquals(3, Binaire.nbBitV2(25));
		assertEquals(32, Binaire.nbBitV2(-1));
	}
	@Test
	void testnbBitV3() {
		assertEquals(0, Binaire.nbBitV3(0));
		assertEquals(1, Binaire.nbBitV3(1));
		assertEquals(3, Binaire.nbBitV3(25));
		assertEquals(32, Binaire.nbBitV3(-1));
	}
	@Test
	void estMajuscule() {
		assertEquals(true, Binaire.estMajuscule('A'));
		assertEquals(false, Binaire.estMajuscule('a'));
	}
}

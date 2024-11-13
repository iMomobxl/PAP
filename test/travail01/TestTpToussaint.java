package travail01;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class TestTpToussaint {
	@Test
	void testnbChiffresV1() {
		assertEquals(3, TpToussaint.nbChiffresV1(567));
		assertEquals(1, TpToussaint.nbChiffresV1(0));
		assertEquals(1, TpToussaint.nbChiffresV1(5));
		assertEquals(2, TpToussaint.nbChiffresV1(56));
		assertEquals(2, TpToussaint.nbChiffresV1(10));
		assertEquals(3, TpToussaint.nbChiffresV1(100));
		assertEquals(4, TpToussaint.nbChiffresV1(1000));
		assertEquals(6, TpToussaint.nbChiffresV1(100000));
		assertEquals(3, TpToussaint.nbChiffresV1(567));
		assertEquals(1, TpToussaint.nbChiffresV1(000));
		assertThrows(AssertionError.class, () -> TpToussaint.nbChiffresV1(-1));
	}
	@Test
	void testnbChiffresV2() {
		assertEquals(3, TpToussaint.nbChiffresV2(567));
		assertEquals(1, TpToussaint.nbChiffresV2(0));
		assertEquals(1, TpToussaint.nbChiffresV2(5));
		assertEquals(2, TpToussaint.nbChiffresV2(56));
		assertEquals(2, TpToussaint.nbChiffresV2(10));
		assertEquals(3, TpToussaint.nbChiffresV2(100));
		assertEquals(4, TpToussaint.nbChiffresV2(1000));
		assertEquals(6, TpToussaint.nbChiffresV2(100000));	
		assertEquals(3, TpToussaint.nbChiffresV2(567));
		assertEquals(1, TpToussaint.nbChiffresV2(000));
		assertThrows(AssertionError.class, () -> TpToussaint.nbChiffresV2(-1));
		
	}
	@Test
	void testnbChiffresV3() {
		assertEquals(3, TpToussaint.nbChiffresV3(567));
		assertEquals(1, TpToussaint.nbChiffresV3(0));
		assertEquals(1, TpToussaint.nbChiffresV3(5));
		assertEquals(1, TpToussaint.nbChiffresV3(1));
		assertEquals(2, TpToussaint.nbChiffresV3(56));
		assertEquals(2, TpToussaint.nbChiffresV3(10));
		assertEquals(3, TpToussaint.nbChiffresV3(100));
		assertEquals(4, TpToussaint.nbChiffresV3(1000));
		assertEquals(6, TpToussaint.nbChiffresV3(100000));
		assertEquals(3, TpToussaint.nbChiffresV3(567));
		assertEquals(1, TpToussaint.nbChiffresV3(000));
		assertThrows(AssertionError.class, () -> TpToussaint.nbChiffresV3(-1));
	}
	@Test
	void testinverseNbrV1() {
		assertEquals(0, TpToussaint.inverseNbrV1(0));
		assertEquals(1, TpToussaint.inverseNbrV1(10));
		assertEquals(987654321, TpToussaint.inverseNbrV1(123456789));
		assertEquals(101, TpToussaint.inverseNbrV1(1010));	
		assertEquals(765, TpToussaint.inverseNbrV1(567));
		assertEquals(12, TpToussaint.inverseNbrV1(21));
		assertEquals(9, TpToussaint.inverseNbrV1(9));
		assertThrows(AssertionError.class, () -> TpToussaint.inverseNbrV1(-1));
	}
	@Test
	void testinverseNbrV2() {
		assertEquals(0, TpToussaint.inverseNbrV2(0));
		assertEquals(1, TpToussaint.inverseNbrV2(10));
		assertEquals(987654321, TpToussaint.inverseNbrV2(123456789));
		assertEquals(101, TpToussaint.inverseNbrV2(1010));	
		assertEquals(765, TpToussaint.inverseNbrV2(567));
		assertEquals(12, TpToussaint.inverseNbrV2(21));
		assertEquals(9, TpToussaint.inverseNbrV2(9));
		assertThrows(AssertionError.class, () -> TpToussaint.inverseNbrV2(-1));
	}
	@Test
	void testconvertTemp() {
		assertEquals(100.4, TpToussaint.convertTemp(38,'C','F'), 0.01);
		assertEquals(38, TpToussaint.convertTemp(100.4,'F','C'), 0.01);
		assertEquals(311.15, TpToussaint.convertTemp(100.4,'F','K'), 0.01);
		assertEquals(38, TpToussaint.convertTemp(311.15,'K','C'), 0.01);
		assertEquals(38, TpToussaint.convertTemp(38,'C','C'), 0.01);
		assertEquals(38.0, TpToussaint.convertTemp(38.0, 'C', 'C'), 0.0);
		assertEquals(100.4, TpToussaint.convertTemp(38.0, 'C', 'F'), 0.0);
		assertEquals(311.15, TpToussaint.convertTemp(38.0, 'C', 'K'), 0.0);
		assertEquals(38.0, TpToussaint.convertTemp(100.4, 'F', 'C'), 0.0);
		assertEquals(311.15, TpToussaint.convertTemp(100.4, 'F', 'K'), 0.0);
		assertEquals(-273.15, TpToussaint.convertTemp(0, 'K', 'C'), 0.0);
		assertThrows(AssertionError.class, () -> TpToussaint.convertTemp(-100, 'K', 'C'));
		assertThrows(AssertionError.class, () -> TpToussaint.convertTemp(-100, 'X', 'C'));
		assertThrows(AssertionError.class, () -> TpToussaint.convertTemp(-100, 'C', 'X'));
	}
	@Test
	void testconvertTempV2() {
		assertEquals(100.4, TpToussaint.convertTempV2(38,'C','F'), 0.01);
		assertEquals(38, TpToussaint.convertTempV2(100.4,'F','C'), 0.01);
		assertEquals(311.15, TpToussaint.convertTempV2(100.4,'F','K'), 0.01);
		assertEquals(38, TpToussaint.convertTempV2(311.15,'K','C'), 0.01);
		assertEquals(38, TpToussaint.convertTempV2(38,'C','C'), 0.01);
		assertEquals(38.0, TpToussaint.convertTempV2(38.0, 'C', 'C'), 0.0);
		assertEquals(100.4, TpToussaint.convertTempV2(38.0, 'C', 'F'), 0.0);
		assertEquals(311.15, TpToussaint.convertTempV2(38.0, 'C', 'K'), 0.0);
		assertEquals(38.0, TpToussaint.convertTempV2(100.4, 'F', 'C'), 0.0);
		assertEquals(311.15, TpToussaint.convertTempV2(100.4, 'F', 'K'), 0.0);
		assertEquals(-273.15, TpToussaint.convertTempV2(0, 'K', 'C'), 0.0);
		assertThrows(AssertionError.class, () -> TpToussaint.convertTempV2(-100, 'K', 'C'));
		assertThrows(AssertionError.class, () -> TpToussaint.convertTempV2(-100, 'X', 'C'));
		assertThrows(AssertionError.class, () -> TpToussaint.convertTempV2(-100, 'C', 'X'));
	}
}

package tp00;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestEvaluation {

	@Test
	void testCalculDecision() {
		assertEquals("Refus", Evaluation.calculDecision(0));
		assertEquals("Refus", Evaluation.calculDecision(29));
		assertEquals("Ajourné", Evaluation.calculDecision(30));
		assertEquals("Ajourné", Evaluation.calculDecision(49));
		assertEquals("Réussite", Evaluation.calculDecision(50));
		assertEquals("Réussite", Evaluation.calculDecision(100));
		assertThrows(AssertionError.class, () -> Evaluation.calculDecision(-2));
		assertThrows(AssertionError.class, () -> Evaluation.calculDecision(101));
	}

}

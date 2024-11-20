import unittest
import tp00

class TestTp00(unittest.TestCase):
    
    def test_calculDecision(self):
        self.assertEqual("Refus",tp00.calculDecision(0))
        self.assertEqual("Refus",tp00.calculDecision(29))
        self.assertEqual("Ajourné",tp00.calculDecision(30))
        self.assertEqual("Ajourné",tp00.calculDecision(49))
        self.assertEqual("Réussite",tp00.calculDecision(50))
        self.assertEqual("Réussite",tp00.calculDecision(100))        
        self.assertRaises(AssertionError,tp00.calculDecision,-1)
        self.assertRaises(AssertionError,tp00.calculDecision,101)
    
if __name__ == "__main__":
    unittest.main()
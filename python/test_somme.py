import unittest
import tp_somme

class TestSomme(unittest.TestCase):
    
    def test_somme1(self):
        self.assertEqual(0,tp_somme.sommeN_V1(0))
        self.assertEqual(10,tp_somme.sommeN_V1(4))
        self.assertEqual(2305843008139952128,tp_somme.sommeN_V1(2**31-1))
        self.assertRaises(AssertionError,tp_somme.sommeN_V1,-2)
        
    def test_somme2(self):
        self.assertEqual(0,tp_somme.sommeN_V2(0))
        self.assertEqual(10,tp_somme.sommeN_V2(4))
        self.assertEqual(2305843008139952128,tp_somme.sommeN_V2(2**31-1))
        self.assertRaises(AssertionError,tp_somme.sommeN_V2,-2)
        
    def test_somme3(self):
        self.assertEqual(0,tp_somme.sommeN_V3(0))
        self.assertEqual(10,tp_somme.sommeN_V3(4))
        self.assertEqual(2305843008139952128,tp_somme.sommeN_V3(2**31-1))
        self.assertRaises(AssertionError,tp_somme.sommeN_V3,-2)
    
if __name__ == "__main__":
    unittest.main()
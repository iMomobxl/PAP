import unittest
import tp_toussaint
import math

class TestToussaint(unittest.TestCase):
    
    def test_nbChiffresV1(self):
        self.assertEqual(3,tp_toussaint.nbChiffresV1(567));
        self.assertEqual(1,tp_toussaint.nbChiffresV1(0));
        self.assertEqual(1,tp_toussaint.nbChiffresV1(5));
        self.assertEqual(2,tp_toussaint.nbChiffresV1(56));
        self.assertEqual(2,tp_toussaint.nbChiffresV1(10));
        self.assertEqual(3,tp_toussaint.nbChiffresV1(100));
        self.assertEqual(4,tp_toussaint.nbChiffresV1(1000));
        self.assertEqual(7,tp_toussaint.nbChiffresV1(1000000));
        self.assertRaises(AssertionError,tp_toussaint.nbChiffresV1,-1);
        self.assertEqual(1,tp_toussaint.nbChiffresV1(0));
        self.assertEqual(1,tp_toussaint.nbChiffresV1(9));
        self.assertEqual(2,tp_toussaint.nbChiffresV1(10));
        self.assertEqual(3,tp_toussaint.nbChiffresV1(567));
        
    def test_nbChiffresV2(self):
        self.assertEqual(3,tp_toussaint.nbChiffresV2(567));
        self.assertEqual(1,tp_toussaint.nbChiffresV2(0));
        self.assertEqual(1,tp_toussaint.nbChiffresV2(5));
        self.assertEqual(2,tp_toussaint.nbChiffresV2(56));
        self.assertEqual(2,tp_toussaint.nbChiffresV2(10));
        self.assertEqual(3,tp_toussaint.nbChiffresV2(100));
        self.assertEqual(4,tp_toussaint.nbChiffresV2(1000));
        self.assertEqual(7,tp_toussaint.nbChiffresV2(1000000));
        self.assertRaises(AssertionError,tp_toussaint.nbChiffresV2,-1);
        self.assertEqual(1,tp_toussaint.nbChiffresV2(0));
        self.assertEqual(1,tp_toussaint.nbChiffresV2(9));
        self.assertEqual(2,tp_toussaint.nbChiffresV2(10));
        self.assertEqual(3,tp_toussaint.nbChiffresV2(567));
        
    def test_nbChiffresV3(self):
        self.assertEqual(3,tp_toussaint.nbChiffresV3(567));
        self.assertEqual(1,tp_toussaint.nbChiffresV3(0));
        self.assertEqual(1,tp_toussaint.nbChiffresV3(5));
        self.assertEqual(2,tp_toussaint.nbChiffresV3(56));
        self.assertEqual(2,tp_toussaint.nbChiffresV3(10));
        self.assertEqual(3,tp_toussaint.nbChiffresV3(100));
        self.assertEqual(4,tp_toussaint.nbChiffresV3(1000));
        self.assertEqual(7,tp_toussaint.nbChiffresV3(1000000));
        self.assertRaises(AssertionError,tp_toussaint.nbChiffresV3,-1);
        self.assertEqual(1,tp_toussaint.nbChiffresV3(0));
        self.assertEqual(1,tp_toussaint.nbChiffresV3(9));
        self.assertEqual(2,tp_toussaint.nbChiffresV3(10));
        self.assertEqual(3,tp_toussaint.nbChiffresV3(567));
    
    def test_inverseNbrV1(self):
        self.assertEqual(0,tp_toussaint.inverseNbrV1(0));
        self.assertEqual(1,tp_toussaint.inverseNbrV1(10));
        self.assertEqual(987654321,tp_toussaint.inverseNbrV1(123456789));
        self.assertEqual(101,tp_toussaint.inverseNbrV1(1010));
        self.assertRaises(AssertionError,tp_toussaint.inverseNbrV1,-1);
        self.assertEqual(2,tp_toussaint.inverseNbrV1(20));
        self.assertEqual(12,tp_toussaint.inverseNbrV1(21));
        self.assertEqual(0,tp_toussaint.inverseNbrV1(0));
        self.assertEqual(9,tp_toussaint.inverseNbrV1(9));
        self.assertEqual(765,tp_toussaint.inverseNbrV1(567));
    
    def test_inverseNbrV2(self):
        self.assertEqual(0,tp_toussaint.inverseNbrV2(0));
        self.assertEqual(1,tp_toussaint.inverseNbrV2(10));
        self.assertEqual(987654321,tp_toussaint.inverseNbrV2(123456789));
        self.assertEqual(101,tp_toussaint.inverseNbrV2(1010));
        self.assertRaises(AssertionError,tp_toussaint.inverseNbrV2,-1);
        self.assertEqual(2,tp_toussaint.inverseNbrV2(20));
        self.assertEqual(12,tp_toussaint.inverseNbrV2(21));
        self.assertEqual(0,tp_toussaint.inverseNbrV2(0));
        self.assertEqual(9,tp_toussaint.inverseNbrV2(9));
        self.assertEqual(765,tp_toussaint.inverseNbrV2(567));
        
    def test_convertTemp(self):
        self.assertEqual(100.4, tp_toussaint.convertTemp(38,'C','F'));
        self.assertEqual(38, tp_toussaint.convertTemp(100.4,'F','C'));
        self.assertEqual(311.15, tp_toussaint.convertTemp(100.4,'F','K'));
        self.assertEqual(38, tp_toussaint.convertTemp(311.15,'K','C'));
        self.assertEqual(38, tp_toussaint.convertTemp(38,'C','C'));
        
    def test_convertTempV2(self):
        self.assertEqual(100.4, tp_toussaint.convertTempV2(38.0,'C','F'))
        self.assertEqual(38.0, tp_toussaint.convertTempV2(100.4,'F','C'))
        self.assertEqual(311.15, tp_toussaint.convertTempV2(100.4,'F','K'))
        self.assertEqual(38.0, tp_toussaint.convertTempV2(311.15,'K','C'))
        self.assertEqual(38.0, tp_toussaint.convertTempV2(38.0,'C','C'))
        self.assertEqual(38.0, tp_toussaint.convertTempV2(38.0, 'C', 'C'))
        self.assertEqual(100.4, tp_toussaint.convertTempV2(38.0, 'C', 'F'))
        self.assertEqual(311.15, tp_toussaint.convertTempV2(38.0, 'C', 'K'))
        self.assertEqual(38.0, tp_toussaint.convertTempV2(100.4, 'F', 'C'))
        self.assertEqual(311.15, tp_toussaint.convertTempV2(100.4, 'F', 'K'))
        self.assertEqual(-273.15, tp_toussaint.convertTempV2(0.0, 'K', 'C'))
        self.assertRaises(AssertionError, tp_toussaint.convertTempV2, -100, 'K', 'C')
        self.assertRaises(AssertionError, tp_toussaint.convertTempV2, -100, 'X', 'C')
        self.assertRaises(AssertionError, tp_toussaint.convertTempV2, -100, 'C', 'X')
        
if __name__ == "__main__":
    unittest.main()
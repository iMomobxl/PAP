package travail01;

import java.util.function.Function;

public class TpToussaint {

	// nombre de chiffre : Version 1
	public static byte nbChiffresV1(int n) {
		assert n >= 0 : "n doit étre >= 0";
		
		byte res = 1;
		while (n / 10 != 0) {
			res += 1;
			n = n / 10;
		}
		return res;
	}
	
	// nombre de chiffre : Version 2
	public static byte nbChiffresV2(int n) {
		assert n >= 0 : "n doit étre >= 0";
		
		String res = Integer.toString(n);
		return (byte) res.length();
	}

	// nombre de chiffre : Version 3
	public static byte nbChiffresV3(int n) {
		assert n >= 0 : "n doit étre >= 0";
		
		// exception pour n = 0
		if (n == 0 || n == 1) {
			return 1;
		}
		
		// exception pour n = 10, 100, 1000, etc..
		if (n % 10 == 0) {
			return (byte) (Math.ceil(Math.log10(n)) + 1);
		}
		
		return (byte) Math.ceil(Math.log10(n));
	}

	
	// inverse nombre : Version 1 (while loop)
	public static int inverseNbrV1(int n) {
		assert n >= 0 : "n doit étre >= 0";
		
		int res = 0;
		while (n != 0) {
			int i = n % 10;
			res = res * 10 + i;
			n = n / 10;
		}
		return res;
	}
	
	// inverse nombre : Version 2 (for loop)
	public static int inverseNbrV2(int n) {
		assert n >= 0 : "n doit étre >= 0";
		
		int res = 0;
		for(int i = 0 ; n != 0 ;  n = n / 10) {
			i = n % 10;
			res = res * 10 + i;
		}
		return res;
	}


	// convert temp V1
	public static double convertTemp(double t, char unitI, char unitD) {
		assert ((unitI == 'K' && t >= 0) || unitI == 'C' || unitI == 'F') : "unitI doit être K, C ou F";
		assert (unitD == 'K' || unitD == 'C' || unitD == 'F') : "unitD doit être K, C ou F";
		
		
 		if (unitI == unitD)
			return t;
 		
		if (unitI == 'C') {
			if (unitD == 'F') {
				return (t * 9/5) + 32;
			}
			// unitD = K
			return t + 273.15;
		}
		
		if (unitI == 'F') {
			if (unitD == 'C') {
				return (t - 32) * 5/9;
			}
			// unitD = K
			return (t - 32) * 5/9 + 273.15;
		}
		
		// unitI = K
		if (unitD == 'C') {
			return t - 273.15;
		}
		
		// unitI = K AND unitD = F
		return (t - 273.15) * 9/5 + 32;
	}
	
	// convert temp V2
	public static double convertTempV2(double t, char unitI, char unitD) {
		assert ((unitI == 'K' && t >= 0) || unitI == 'C' || unitI == 'F') : "unitI doit être K, C ou F";
		assert (unitD == 'K' || unitD == 'C' || unitD == 'F') : "unitD doit être K, C ou F";
			
		if (unitI == unitD)
			return t;
	 		
		Function<Double, Double> cf = (x) -> (x * 18) / 10 + 32.0;
		Function<Double, Double> fc = (x) -> (x * 32.0) * 10 / 18.0;
		Function<Double, Double> ck = (x) -> (x * 100 + 27315) / 100.0;
		Function<Double, Double> kc = (x) -> (x * 100 - 27315) / 100.0;
			
		double dc = switch (unitI) {
			case 'K' -> kc.apply(t);
			case 'F' -> fc.apply(t);
			default -> t;
		};
			
		double res = switch (unitD) {
			case 'K' -> ck.apply(dc);
			case 'F' -> cf.apply(dc);
			default -> dc;
		};
		return res;
	}

	// main
	public static void main(String[] args) {
		System.out.println(nbChiffresV1(1));
		System.out.println(nbChiffresV2(2631));
		System.out.println(nbChiffresV3(2631));
		System.out.println(nbChiffresV3(100));
		System.out.println(inverseNbrV1(2631));
		System.out.println(inverseNbrV1(12345));
		System.out.println(inverseNbrV2(2631));
		System.out.println(inverseNbrV2(54321));
		System.out.println(convertTemp(38, 'C', 'F'));
		System.out.println(convertTemp(100.4, 'F', 'C'));
		System.out.println(convertTemp(100.4, 'F', 'K'));
		System.out.println(convertTemp(311.15,'K','C'));
		
		// test assert convertTemp
		System.out.println(convertTemp(-235.15,'K', 'C'));
	}
}

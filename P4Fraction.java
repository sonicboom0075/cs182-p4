/*
Name: Aaron Avila
*/

class Fraction {
	int num;
	int den;

	Fraction(int n){
		int m = 1;
		int gcd = findGCD(n,m);

		num = n/gcd;
		den = m/gcd;
	}//constructor

	Fraction(int n, int m){
		int gcd = findGCD(n,m);

		num = n/gcd;
		den = m/gcd;
	}//constructor

	Fraction(Fraction f){
		int gcd = findGCD(f.num,f.den);

		num = f.num/gcd;
		den = f.den/gcd;
	}

	int findValue(){
		return num/den;
	}

	static int findGCD(int n, int m){
		if(n==0){
			return m;
		}
		//while loop
		while(n!=m){
			if(n>m){
				n=n-m;
			} //if
			else {
				m=m-n;
			} //else
		} //while

		return n;
	}

	public String toString(){
		if(den == 1){
			String s = Integer.toString(num);
			return s;
		}else if(num == 0){
			return "0";
		}
		return num +"/" +den;
	}

	static int fracCompare(Fraction f1, Fraction f2){
		int tempF1, tempF2;

		tempF1 = f1.num*f2.den;
		tempF2 = f2.num*f1.den;

		if(tempF1 > tempF2){
			return 1;										//if greater than, return 1
		}else if(tempF1 < tempF2){
			return 2;									 //if less than, return 2
		}else{
			return 0;									//if neither, return 0
		}
	}

}//class

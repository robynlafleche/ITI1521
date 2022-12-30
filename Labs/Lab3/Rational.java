public class Rational {

    private int numerator;
    private int denominator;

    // constructors

    public Rational(int numerator) {
	     this.numerator = numerator;
       this.denominator = 1;
       reduce ();
    }

    public Rational(int numerator, int denominator) {
      this.numerator = numerator;
      this.denominator = denominator;
      reduce ();
    }
    /**
    *this is a getter method
    *it is used to get the value of the variable numerator
    *@return int this returns the numerator
    */
    public int getNumerator() {
	     return numerator;
    }
    /**
    *this is a getter method
    *it is used to get the value of the variable denominator
    *@return int this returns the numerator
    */
    public int getDenominator() {
	     return denominator;
    }

    // instance methods

    public Rational plus(Rational other) {
      int num = this.getNumerator () * other.getDenominator () + other.getNumerator() * this.getDenominator();
      int denum = this.getDenominator() * other.getDenominator();
      int f = gcd (num, denum);
      Rational r = new Rational (num/f, denum/f);
      return r;
    }

    public static Rational plus(Rational a, Rational b) {
    	return a.plus(b);
    }

    // Transforms this number into its reduced form

    private void reduce() {
      if (numerator == 0){
        denominator = 1;
      }
      else {
        int f = gcd (numerator, denominator);
        numerator = numerator / f;
        denominator = denominator / f;
      }
    }

    // Euclid's algorithm for calculating the greatest common divisor
    private int gcd(int a, int b) {
      // Note that the loop below, as-is, will time out on negative inputs.
      // The gcd should always be a positive number.
      // Add code here to pre-process the inputs so this doesn't happen.
      if (a < 0){
        a = -a;
      }
      if (b < 0){
        b = -b;
      }

    	while (a != b){
        if (a > b)
    		    a = a - b;
    	   else
    		    b = b - a;
      }
    	return a;
    }

    public int compareTo(Rational other) {
      int a = this.getNumerator() * other.getDenominator();
      int b = other.getNumerator() * this.getDenominator();

      if (a < b) {
        return -1;
      }
      else if (a > b) {
        return 1;
      }
      else {
        return 0;
      }
    }

    public boolean equals(Rational other) {
      if (this.compareTo (other) == 0){
        return true;
      }
      else {
        return false;
      }
    }

    public String toString() {
    	String result;
    	if (denominator == 1) {
    	    result = getNumerator () + "";
    	} else {
    	    result = getNumerator () + "/" + getDenominator ();
    	}
    	return result;
    }

}

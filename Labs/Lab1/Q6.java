import java.util.Scanner;

class Q6 {
	public static void main(String[] args) {

    System.out.println ("Please enter 10 grades of type double.");
    Scanner scanGrades = new Scanner(System.in);
    double [] myGrades = new double [10];
    for (int i = 0; i < 10; i++){
    myGrades [i] = scanGrades.nextDouble();
    }
    double average, median;
    int failed, passed;
    average = calculateAverage (myGrades);
    median = calculateMedian (myGrades);
    failed = calculateNumberFailed (myGrades);
    passed = calculateNumberPassed (myGrades);
    System.out.println ("The average of the 10 grades is: " + average + " the median is: " + median + " the number of classes failed is: " + failed + " the number of classes passed is: " + passed);
  }

	public static double calculateAverage(double[] notes) {
	   double average = 0.0;

     for (int i = 0; i < notes.length; i++){
       average += notes [i];
     }
     return average/notes.length;
	}

	public static double calculateMedian(double[] notes) {
    double median = 0.0;
    double tmp;
    for (int i = 0; i < notes.length; i++){
      for (int j = i + 1; j < notes.length - 1; j++){
        if (notes [i] > notes [j]){
          tmp = notes [i];
          notes [i] = notes [j];
          notes [j] = tmp;
        }
      }
    }
		if (notes.length % 2 == 0){
			median = (notes [notes.length/2 - 1] + notes [notes.length/2]) / 2;
		} else {
			median = notes [(int) notes.length/2];
		}

    return median;
	}

	public static int calculateNumberFailed(double[] notes) {
	    int n = 0;

      for (int i = 0; i < notes.length; i++){
        if (notes [i] < 50.0) {
          n += 1;
        }
      }
      return n;
	}

	public static int calculateNumberPassed(double[] notes) {
    int n = 0;

    for (int i = 0; i < notes.length; i++){
      if (notes [i] >= 50.0) {
        n += 1;
      }
    }
    return n;
	}

}

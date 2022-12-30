import java.util.Scanner;

class Q4_VotingRight {

	public static void main(String[] args) {

	    System.out.print("How old are you? ");
	    Scanner scanAge = new Scanner(System.in);
 	    int myInt = scanAge.nextInt();

      if (myInt > 18){
        System.out.println("You have the right to vote!");
      }

      else{
        int years;
        years = 18 - myInt;
        System.out.println("You will be able to vote in " + years + " years!");
      }

	}
}

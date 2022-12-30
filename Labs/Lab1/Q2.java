public class Q2 {
  public static void main (String[] args){
    int i = 1;

    while (i <= 30){
      if (i % 3 == 0){
        System.out.println(i + " Fizz");
      }
      else if (i % 5 == 0){
        System.out.println(i + " Buzz");
      }
      else if (i % 15 == 0){
        System.out.println(i + " FizzBuzz");
      }
      i ++;
    }
  }
}

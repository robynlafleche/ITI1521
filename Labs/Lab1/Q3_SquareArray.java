public class Q3_SquareArray{
  public static int[] createArray(int size) {
    int i;
    int[] array;
    array = new int[size];

    for (i = 0; i < size; i ++){
      array[i] = i * i;
    }
    return array;
  }

  public static void main(String[] args){
    int size = 13;
    int[] array;
    int i;
    array = createArray (size);
    for (i = 0; i < size; i ++){
          System.out.println ("The square of " + i + " is: " + array[i]);
    }

  }
}

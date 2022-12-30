public class Q3_ArrayInsertionDemo{

    public static int[] insertIntoArray(int[] beforeArray, int indexToInsert, int valueToInsert){
    int[] afterArray = new int [beforeArray.length + 1] ;

    for (int i = 0; i < afterArray.length; i++){
      if (i == indexToInsert){
        afterArray [i] = valueToInsert;
      }
      else if (i < indexToInsert){
        afterArray [i] = beforeArray [i];
      }
      else if (i > indexToInsert){
        afterArray [i] = beforeArray [i - 1];
      }

    }
    return afterArray;
      }

      public static void main(String[] args){
      int [] beforeArray = new int[] {};
      int indexToInsert = beforeArray.length;
      int valueToInsert = 15;
          System.out.println("Array avant l"+ "'" + "insertion:");
      for (int i = 0; i < beforeArray.length; i++){
        System.out.println(beforeArray[i]);
      }
      System.out.println("Array apr" + '\u00E9' + "s l" + "'" + "insertion de " + valueToInsert + " " + '\u00E0' + " position " + indexToInsert + ":");
      int[] afterArray;
      afterArray = insertIntoArray (beforeArray, indexToInsert, valueToInsert);
      for (int i = 0; i < afterArray.length; i++){
        System.out.println(afterArray[i]);
      }

      }
  }

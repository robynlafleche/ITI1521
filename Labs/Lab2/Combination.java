public class Combination {

    private int first, second, third;

    public Combination ( int first, int second, int third ) {

      this.first = first;
      this.second = second;
      this.third = third;
    }

    public boolean equals ( Combination other ) {
      if (other == null) {
        return false;
      }
      if (this.first == other.first && this.second == other.second && this.third == other.third){
          return true;
        }

        return false;
    }

    public String toString () {
      String combo;
      combo = first + ":" + second + ":" + third;
      return combo;
    }
}

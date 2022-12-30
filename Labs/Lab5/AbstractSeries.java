public abstract class AbstractSeries implements Series {

    public double[] take(int k) {

        double[] s = new double [k];

        for (int i = 0; i < k; i++){
          s[i] = this.next();
        }
        return s;
    }
}

public class Arithmetic extends AbstractSeries {

    double s = 0;
    int c = 0;


    public double next() {

        c++;
        return s += c;


    }
}

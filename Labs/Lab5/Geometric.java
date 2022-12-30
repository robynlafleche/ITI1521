public class Geometric extends AbstractSeries {

    double s = 0;
    double c = 1;

    public double next() {

        s += c;
        c /= 2;
        return s;
    }
}

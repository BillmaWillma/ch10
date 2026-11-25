

public class EstimatingPi {
    public static void main(String[] args) {
        Fractions MILU = new Fractions(355, 113);
        final double EPSILON = Math.abs(Math.PI - MILU.toDouble());
        int num = 3;
        int denom = 1;
        Fractions guess = new Fractions(num, denom);
        while (Math.abs(Math.PI - guess.toDouble()) >= EPSILON) {
            if (guess.toDouble() < MILU.toDouble()) {
                num++;
            } else
                denom++;
            guess = new Fractions(num, denom);
        }
        Fractions ans = new Fractions(num, denom);
        System.out.println(ans.toString());
    }
}

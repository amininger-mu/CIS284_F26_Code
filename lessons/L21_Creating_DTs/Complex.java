import java.util.Arrays;

public class Complex {
    private final double real;
    private final double imag;

    public Complex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public double real() {
        return real;
    }

    public double imag() {
        return imag;
    }

    public Complex plus(Complex z) {
        double r = real + z.real;
        double i = imag + z.imag;
        return new Complex(r, i);
    }

    public Complex times(Complex z) {
        double r = real * z.real - imag * z.imag;
        double i = real * z.imag + imag * z.real;
        return new Complex(r, i);
    }

    public double mag() {
        return Math.sqrt(real*real + imag*imag);
    }

    public String toString() {
        return real + "+" + imag + "i";
    }

    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Complex)) return false;
        Complex c2 = (Complex)obj;
        return real == c2.real && imag == c2.imag;
    }

    public static void main(String[] args) {
        double real = Double.parseDouble(args[0]);
        double imag = Double.parseDouble(args[1]);
        Complex c = new Complex(real, imag);
        Complex z = new Complex(0, 0);

        // Iterate z^2 + c
        for (int i = 0; i < 5; i++) {
            System.out.println(i + ": " + z);
            z = z.times(z).plus(c);
        }
    }
}
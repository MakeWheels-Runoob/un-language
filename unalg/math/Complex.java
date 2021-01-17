package math;

import java.util.Objects;

/**
 * @author Richard
 */
@SuppressWarnings("unused")
public class Complex implements Type<Complex> {
    private double real;
    private double imag;

    private static final double DEFAULT_REAL = 0.0;
    private static final double DEFAULT_IMAG = 0.0;
    public static final Complex ROOT = Complex(1.0, 0.0);

    public Complex() {
        this(DEFAULT_REAL, DEFAULT_IMAG);
    }

    public Complex(double real, double imag) {
        this.real = Double.compare(real, -0.0) == 0 ? 0.0 : real;
        this.imag = Double.compare(imag, -0.0) == 0 ? 0.0 : imag;
    }

    public Complex(Complex c) {
        this(c.real, c.imag);
    }

    @Override
    public Complex add(Complex other) {
        return new Complex(real + other.real,
                           imag + other.imag);
    }
    public Complex add(double other) {
        return new Complex(real + other, imag);
    }

    @Override
    public Complex subtract(Complex other) {
        return new Complex(real - other.real,
                           imag - other.imag);
    }
    public Complex subtract(double other) {
        return new Complex(real - other, imag);
    }

    @Override
    public Complex multiply(Complex other) {
        return new Complex(real * other.real - imag * other.imag,
                           real * other.imag + imag * other.real);
    }
    public Complex multiply(double other) {
        return new Complex(real * other,
                           imag * other);
    }

    @Override
    public Complex divide(Complex other) {
        return this.multiply(other.negate()).divide(other.multiply(other.negate()).toDouble());
    }
    public Complex divide(double other) {
        return new Complex(real / other,
                           imag / other);
    }

    @Override
    public Complex negate() {
        return new Complex(real, -imag);
    }

    @Override
    public Complex pow(long exponent) {
        assert exponent >= 0 : "the exponent is less than zero.";
        if (exponent == 0) {
            return Complex.ROOT;
        } else if (exponent == 1) {
            return this;
        } else {
            if ((exponent & 1) == 0) {
                Complex c = pow(exponent / 2);
                return c.multiply(c);
            } else {
                return multiply(pow(exponent - 1));
            }
        }
    }

    @Override
    public boolean isZero() {
        return Double.compare(real, DEFAULT_REAL) == 0 && Double.compare(imag, DEFAULT_IMAG) == 0;
    }

    @Override
    public String toString() {
        return real + (imag > 0 ? "+" : "") + imag + "j";
    }

    @Override
    public double toDouble() {
        return real;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Complex)) {
            return false;
        }
        Complex complex = (Complex) o;
        return Double.compare(complex.real, real) == 0 && Double.compare(complex.imag, imag) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(real, imag);
    }

    public double getImag() {
        return imag;
    }

    public void setImag(double imag) {
        this.imag = imag;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }
}

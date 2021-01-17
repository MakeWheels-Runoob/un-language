package math;

/**
 * @author Richard
 * @date 2020-12-28
 */
@SuppressWarnings("unused")
public interface Type<C> {
    boolean TYPE_ERROR = false;
    /**
     * The add function is used to add this object to the other object.
     * @param other another object
     * @return sum
     */
    C add(C other);
    /**
     * The subtract function is used to minus this object to the other object.
     * @param other another object
     * @return sub
     */
    C subtract(C other);
    /**
     * The multiply function is used to multiply this object to the other object.
     * @param other another object
     * @return product
     */
    C multiply(C other);
    /**
     * The divide function is used this object divide by the other object.
     * @param other another object
     * @return div
     */
    C divide(C other);
    /**
     * The negate function is solve negative from this object
     * @return negative
     */
    C negate();
    /**
     * The pow function is this object pow of exponent
     * @param exponent exponent
     * @return answer
     */
    C pow(long exponent);

    /**
     * Is it zero?
     * @return is zero
     */
    boolean isZero();

    /**
     * Override
     * @param x another object
     * @return Is equals?
     */
    @Override
    boolean equals(Object x);

    /**
     * Override
     * @return override
     */
    @Override
    String toString();
    /**
     * Solve it
     * @return answer
     */
    double toDouble();
}

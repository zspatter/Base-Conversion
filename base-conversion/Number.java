// print all converted values

import java.math.BigInteger;

abstract public class Number implements INumber
{
    protected BigInteger data;

    // constants used to format console output
    protected static final String ANSI_BOLD = "\033[1m";
    protected static final String ANSI_RED = "\033[31m";
    protected static final String ANSI_YELLOW = "\033[33m";
    protected static final String ANSI_RESET = "\033[0m";
    protected static final String PADDING = "";

    public abstract void fromString(String userString);

    /**
     * Converts iNumber (any number that implements the INumber interface)
     * to this number type. This allows for any given base to be converted to
     * any other base
     * 
     * @param iNumber any INumber object (binary/octal/decimal/hex)
     */
    public void fromNumber(INumber iNumber)
    {
        this.data = iNumber.toBigInt();
    }

    /**
     * Returns the internal representation of BigInteger for any base
     *
     * @return BigInteger representing the number (base agnostic)
     */
    public BigInteger toBigInt()
    {
        return this.data;
    }

    /**
     * Converts any BigInteger value to a Number
     *
     * @param data BigInteger value
     */
    public void fromBigInt(BigInteger data)
    {
        this.data = data;
    }

    /**
     * This is the user-facing function that displays the input converted to
     * each base this converter supports. This will print a standard, formatted
     * string to the console indicating the equivalencies in different base systems
     *
     * @param iNumber any INumber object can be read (bin/oct/dec/hex)
     */
    public static void printConvertedValues(INumber iNumber)
    {
        BinaryNumber binaryNumber = new BinaryNumber();
        binaryNumber.fromNumber(iNumber);
        OctalNumber octalNumber = new OctalNumber();
        octalNumber.fromNumber(iNumber);
        DecimalNumber decimalNumber = new DecimalNumber();
        decimalNumber.fromNumber(iNumber);
        HexNumber hexNumber = new HexNumber();
        hexNumber.fromNumber(iNumber);

        System.out.printf("\n%sConverted values:%s" +
                        "\n\tBinary: %7s%s%s%s" +
                        "\n\tOctal: %8s%s%s%s" +
                        "\n\tDecimal: %6s%s%s%s" +
                        "\n\tHexadecimal: %2s%s%s%s\n\n",
                ANSI_BOLD, ANSI_RESET,
                PADDING, ANSI_YELLOW, binaryNumber.toString(), ANSI_RESET,
                PADDING, ANSI_YELLOW, octalNumber.toString(), ANSI_RESET,
                PADDING, ANSI_YELLOW, decimalNumber.toString(), ANSI_RESET,
                PADDING, ANSI_YELLOW, hexNumber.toString(), ANSI_RESET);
    }
}

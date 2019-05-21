// print all converted values

import java.math.BigInteger;

abstract public class Number implements INumber
{
    protected BigInteger data;

    private static final String ANSI_YELLOW = "\033[33m";
    private static final String ANSI_RESET = "\033[0m";
    private static final String PADDING = "";

    public abstract void fromString(String userString);

    public void fromNumber(INumber number)
    {
        this.data = number.toBigInt();
    }

    public BigInteger toBigInt()
    {
        return this.data;
    }

    public void fromBigInt(BigInteger data)
    {
        this.data = data;
    }

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

        System.out.printf("\nConverted values:" +
                        "\n\tBinary: %7s%s%s%s" +
                        "\n\tOctal: %8s%s%s%s" +
                        "\n\tDecimal: %6s%s%s%s" +
                        "\n\tHexadecimal: %2s%s%s%s\n\n",
                PADDING, ANSI_YELLOW, binaryNumber.toString(), ANSI_RESET,
                PADDING, ANSI_YELLOW, octalNumber.toString(), ANSI_RESET,
                PADDING, ANSI_YELLOW, decimalNumber.toString(), ANSI_RESET,
                PADDING, ANSI_YELLOW, hexNumber.toString(), ANSI_RESET);
    }
}

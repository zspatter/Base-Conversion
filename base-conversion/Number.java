// print all converted values

import java.math.BigInteger;

abstract public class Number implements INumber
{
    protected BigInteger data;

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

    // how do take an INumber object and convert bin byte[] to a string of each number class?
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
                        "\n\tBinary: %s" +
                        "\n\tOctal: %s" +
                        "\n\tDecimal: %s" +
                        "\n\tHexadecimal: %s\n\n",
                binaryNumber.toString(), octalNumber.toString(), decimalNumber.toString(), hexNumber.toString());
    }
}

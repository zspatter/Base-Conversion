// print all converted values

abstract public class Number implements INumber
{
    private byte[] data;

    public abstract void fromString(String userString);

    public void fromNumber(INumber number)
    {
        byte[] data = number.toBytes();
        fromBytes(data);
    }

    public byte[] toBytes()
    {
        return data;
    }

    public void fromBytes(byte[] data)
    {
        this.data = data;
    }

    // how do take an INumber object and convert bin byte[] to a string of each number class?
    public static void printConvertedValues(INumber number)
    {
        BinaryNumber binaryNumber = new BinaryNumber();
        binaryNumber.fromNumber(number);
        DecimalNumber decimalNumber = new DecimalNumber();
        decimalNumber.fromNumber(number);
        HexNumber hexNumber = new HexNumber();
        hexNumber.fromNumber(number);

        System.out.printf("Converted values:\n\tBinary: %s\n\tOctal: %s\n\tDecimal: %s\n\tHexadecimal: %s",
                binaryNumber.toString(), decimalNumber.toString(), hexNumber.toString());
    }
}

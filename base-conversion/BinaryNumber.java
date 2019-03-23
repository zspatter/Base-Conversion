public class BinaryNumber extends Number
{
    private byte[] data;

    @Override
    public String toString()
    {
        // how else can I read decimal byte values as binary?
        StringBuilder binString = new StringBuilder("0b");
        for (byte b : data)
            binString.append(Integer.toBinaryString(b));

        return binString.toString();
    }

    protected static boolean isValid(String userString)
    {
        if (!userString.startsWith("0b"))
            return false;

        // why does it think for loop doesn't loop?
        for (int i = 2; i < userString.length(); i++)
        {
            char checkedDigit = userString.charAt(i);

            if (checkedDigit == '0' || checkedDigit == '1')
                break;
            else
            {
                System.out.println("This input contains a digit that is invalid in binary." + checkedDigit);
                return false;
            }
        }
        return true;
    }

    @Override
    public void fromString(String userString)
    {
        int arrLength = (int) (Math.ceil((userString.length() - 2) / 8.0));
        data = new byte[arrLength];

        data[0] = handleLeadingZeros(userString);
        int index = 2 + ((userString.length() - 2) % 8);

        for (int i = 1; i < data.length; i++)
        {
            data[i] = getByte(userString.substring(index, index + 8));
            index += 8;
        }
    }

    private byte handleLeadingZeros(String string)
    {
        int byteRemainder = (string.length() - 2) % 8;
        String isolateFirstDigits = string.substring(2, (10 - byteRemainder));
        int firstDigits = Integer.parseInt(isolateFirstDigits);

        return (byte) firstDigits;
    }



    private byte getByte(String string)
    {
        // still can't handle bin bytes starting with 1
        byte b = Byte.parseByte(string.substring(1), 2);
        if (string.charAt(0) == '1')
            b += 0b10000000;
        return (byte)(b & 0xFF);
    }
}

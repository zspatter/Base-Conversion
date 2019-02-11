public class OctalNumber extends Number
{
    private byte[] data;

    @Override
    public String toString()
    {
        StringBuilder octalString = new StringBuilder("0o");
        StringBuilder binString = new StringBuilder();

        // build binary string from byte[]
        // handle bytes starting with 1
        // Integer.toBinaryString(b).substring(24)
        for (byte b : data)
            binString.append(Integer.toBinaryString(b).substring(24));

        // convert binary string to octal string
        for (int i = 0; i < binString.length(); i += 3)
            octalString.append(getOctDigitFromBinBits(binString.substring(i, i + 3)));

        return octalString.toString();
    }

    public static boolean isValid(String userString)
    {
        if (!userString.startsWith("0o"))
            return false;

        for (int i = 2; i < userString.length(); i++)
        {
            char checkedDigit = userString.charAt(i);

            if (checkedDigit == '0' || checkedDigit == '1' || checkedDigit == '2' || checkedDigit == '3'
                    || checkedDigit == '4' || checkedDigit == '5' || checkedDigit == '6' || checkedDigit == '7')
                break;
            else
            {
                System.out.println("This input contains a digit that is invalid in octal. \nInvalid character: " + checkedDigit);
                return false;
            }
        }
        return true;
    }

    @Override
    public void fromString(String userString)
    {
        int arrLength = (int) (Math.ceil(((userString.length() - 2) * 3) / 8.0));
        data = new byte[arrLength];

        String binString = buildBinString(userString);
        BinaryNumber binaryNumber = new BinaryNumber();
        binaryNumber.fromString(binString);
        fromNumber(binaryNumber);
    }

    private String buildBinString(String string)
    {
        string = string.substring(2);
        StringBuilder stringBuilder = new StringBuilder("0b");

        for (int i = 0; i < string.length(); i++)
        {
            stringBuilder.append(getBinStringFromDigit(Integer.parseInt(string.charAt(i) + "")));
        }
        return stringBuilder.toString();
    }

    private String getBinStringFromDigit(int n)
    {
        switch (n)
        {
            case 0:
                return "000";
            case 1:
                return "001";
            case 2:
                return "010";
            case 3:
                return "011";
            case 4:
                return "100";
            case 5:
                return "101";
            case 6:
                return "110";
            case 7:
                return "111";
        }
        return null;
    }

    private int getOctDigitFromBinBits(String octalDigit)
    {
        switch (octalDigit)
        {
            case "000":
                return 0;
            case "001":
                return 1;
            case "010":
                return 2;
            case "011":
                return 3;
            case "100":
                return 4;
            case "101":
                return 5;
            case "110":
                return 6;
            case "111":
                return 7;
        }
        return -1;
    }

    @Override
    public byte[] toBytes()
    {
        return data;
    }
}

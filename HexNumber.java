public class HexNumber extends Number
{
    private byte[] data;

    @Override
    public String toString()
    {
        StringBuilder stringBuilder = new StringBuilder("0x");
        for (byte b : data)
        {
            byte copyLeft = b;
            copyLeft = isolateLeftDigit(copyLeft);
            byte copyRight = b;
            copyRight = isolateRightDigit(copyRight);

            stringBuilder.append(getChar(copyLeft));
            stringBuilder.append(getChar(copyRight));
        }
        return stringBuilder.toString();
    }

    public static boolean isValid(String userString)
    {
        char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

        if (!userString.startsWith("0x"))
            return false;

        for (int i = 2; i < userString.length(); i++)
        {
            char checkedChar = userString.charAt(i);
            boolean validChar = false;

            for (char c : hexDigits)
            {
                if (checkedChar == c)
                {
                    validChar = true;
                    break;
                }
            }

            if (!validChar)
            {
                System.out.println("This input contains a character that is invalid in hexadecimal.");
                return false;
            }
        }
        return true;
    }

    @Override
    public void fromString(String userString)
    {
        data = new byte[(int) Math.ceil((userString.length() - 2) / 2.0)];

        // if hex string contains even number of digits,
        // get binary bytes representing 2 hex digits and assign to byte[]
        // for entire string after hex identifier (0x...)
        if (userString.length() % 2 == 0)
        {
            int index = 0;
            for (int i = 2; i < userString.length(); i += 2)
            {
                data[index] = getByte(userString.charAt(i), userString.charAt(i + 1));
                index++;
            }
        // if hex string contains odd number of digits,
        // handle leading zeros for first hex digit
        // then, gather binary bytes for 2 hex digits at a time
        } else
        {
            data[0] = getPartialByte(userString.charAt(2));
            int index = 1;

            for (int i = 3; i < userString.length(); i += 2)
            {
                data[index] = getByte(userString.charAt(i), userString.charAt(i + 1));
                index++;
            }
        }
    }

    private byte isolateLeftDigit(byte b)
    {
        // bit shifting can widen type to int resulting in undesired 1's
        // logical operator fixes this undesired behavior
        return (byte) (b >> 4 & 0b00001111);
    }

    private byte isolateRightDigit(byte b)
    {
        return (byte) (b & 0b00001111);
    }

    private char getChar(byte b)
    {
        switch (b)
        {
            case 0b00000000:
                return '0';
            case 0b00000001:
                return '1';
            case 0b00000010:
                return '2';
            case 0b00000011:
                return '3';
            case 0b00000100:
                return '4';
            case 0b00000101:
                return '5';
            case 0b00000110:
                return '6';
            case 0b00000111:
                return '7';
            case 0b00001000:
                return '8';
            case 0b00001001:
                return '9';
            case 0b00001010:
                return 'A';
            case 0b00001011:
                return 'B';
            case 0b00001100:
                return 'C';
            case 0b00001101:
                return 'D';
            case 0b00001110:
                return 'E';
            case 0b00001111:
                return 'F';
            default:
                return '\u0000';
        }
    }

    private byte getPartialByte(char ch)
    {
        switch (ch)
        {
            case '0':
                return 0b0000000;
            case '1':
                return 0b00000001;
            case '2':
                return 0b00000010;
            case '3':
                return 0b00000011;
            case '4':
                return 0b00000100;
            case '5':
                return 0b00000101;
            case '6':
                return 0b00000110;
            case '7':
                return 0b00000111;
            case '8':
                return 0b00001000;
            case '9':
                return 0b00001001;
            case 'A':
                return 0b00001010;
            case 'B':
                return 0b00001011;
            case 'C':
                return 0b00001100;
            case 'D':
                return 0b00001101;
            case 'E':
                return 0b00001110;
            case 'F':
                return 0b00001111;
            default:
                return -1;
        }
    }

    private byte bitShiftLeft(byte b)
    {
        return (byte) (b << 4);
    }

    private byte joinPartialBytes(byte b1, byte b2)
    {
        return (byte) (b1 + b2);
    }

    private byte getByte(char ch1, char ch2)
    {
        byte b1 = getPartialByte(ch1);
        b1 = bitShiftLeft(b1);
        byte b2 = getPartialByte(ch2);

        return joinPartialBytes(b1, b2);
    }
}

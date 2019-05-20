public class OctToBinBytes
{
    public static void main(String[] args)
    {
        for (int i = 1; i < 100; i++)
            System.out.println("(3 * " + i + ") % 8 = " + ((3 * i) % 8));
    }

    // if you want to do this, you should start with right most digit and work your way left...
    public void fromString(String string)
    {
        int arrLength = (int) (Math.ceil(((string.length() - 2) * 3) / 8.0));
        byte[] data = new byte[arrLength];
        // how can I pass truncated bits as well?
        data[0] = handleLeadingZeros(string);

        /*
        need truncated bits value
        AND number of truncated bits (0, 1, 2)
         */
    }

    private byte handleLeadingZeros(String string)
    {
        // how can I deal with truncated values?
        int digitCount = string.length() - 2;
        int byteRemainder = (digitCount * 3) % 8;

        byte bits1, bits2, bits3, b;
        bits1 = getBits(string.charAt(2));
        bits2 = getBits(string.charAt(3));
        bits3 = getBits(string.charAt(4));

        switch (byteRemainder)
        {
            case 0:
                b = (byte) (bitShiftLeft(bits1, 5) + bitShiftLeft(bits2, 2) + bitShiftRight(bits3, 1));
                break;
            case 1:
                b = (byte) (bitShiftLeft(bits1, 4) + bitShiftLeft(bits2, 1) + bitShiftRight(bits3, 2));
                break;
            case 2:
                b = (byte) (bitShiftLeft(bits1, 3) + bits2);
                break;
            case 3:
                b = (byte) (bitShiftLeft(bits1, 2) + bitShiftRight(bits2, 1));
                break;
            case 4:
                b = (byte) (bitShiftLeft(bits1, 1) + bitShiftRight(bits2, 2));
                break;
            case 5:
                b = bits1;
                break;
            case 6:
                b = bitShiftRight(bits1, 1);
                break;
            case 7:
                b = bitShiftRight(bits1, 2);
                break;
            default:
                b = -1;
        }
        return b;
    }

    private byte getTruncatedBitsFromFirstByte(String string)
    {
        int digitCount = string.length() - 2;
        int byteRemainder = (digitCount * 3) % 8;

        byte bits1, bits2, bits3, b;
        bits1 = getBits(string.charAt(2));
        bits2 = getBits(string.charAt(3));
        bits3 = getBits(string.charAt(4));

        // what if leading 0?
        switch (byteRemainder)
        {
            case 0:
                b = (byte)(bits3 & 0b001);
                break;
            case 1:
                b = (byte)(bits3 & 0b011);
                break;
            case 2:
                b = 0b0;
                break;
            case 3:
                b = (byte)(bits2 & 0b001);
                break;
            case 4:
                b = (byte)(bits2 & 0b011);
                break;
            case 5:
                b = 0b0;
                break;
            case 6:
                b = (byte)(bits1 & 0b001);
                break;
            case 7:
                b = (byte)(bits1 & 0b011);
                break;
            default:
                b = 1;
        }
        return b;
    }

    private byte getBits(char ch)
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
        }
        return -1;
    }

    private byte bitShiftLeft(byte b, int n)
    {
        return (byte) (b << n);
    }

    private byte bitShiftRight(byte b, int n)
    {
        return (byte) (b >> n);
    }
}

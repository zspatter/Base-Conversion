import java.math.BigInteger;

public class BinaryNumber extends Number
{
    /**
     * Determines whether or not a given string is a valid binary number
     *
     * @param userString string gathered from client (called from NumberFactory)
     * @return boolean indicating whether the number is valid
     */
    protected static boolean isValid(String userString)
    {
        if (!userString.startsWith("0b"))
            return false;
        char[] digits = userString.substring(2).toCharArray();

        for (char ch : digits)
        {
            if (ch == '0' || ch == '1')
                break;
            else
            {
                System.out.printf("\n%sThis input contains a digit that is invalid in binary: %c%s",
                        ANSI_RED, ch, ANSI_RESET);
                return false;
            }
        }
        return true;
    }

    /**
     * Converts input from string to Number's standard representation (BigInteger)
     *
     * @param userString string gathered from the client (prefix identifier is removed)
     */
    @Override
    public void fromString(String userString)
    {
        super.data = new BigInteger(userString.substring(2), 2);
    }


    @Override
    public String toString()
    {
        return "0b" + super.data.toString(2);
    }
}

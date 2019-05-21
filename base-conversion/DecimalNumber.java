import java.math.BigInteger;

public class DecimalNumber extends Number
{
    public static boolean isValid(String userString)
    {
        if (!userString.startsWith("0d"))
            return false;

        char[] digits = userString.substring(2).toCharArray();

        for (char ch : digits)
        {
            if (!(ch >= '0' && ch <= '9'))
            {
                System.out.printf("\n%sThis input contains a digit that is invalid in decimal: %c%s",
                        ANSI_RED, ch, ANSI_RESET);
                return false;
            }
        }
        return true;
    }

    @Override
    public void fromString(String userString)
    {
        super.data = new BigInteger(userString.substring(2), 10);
    }

    @Override
    public String toString()
    {
        return "0d" + super.data.toString(10);
    }
}

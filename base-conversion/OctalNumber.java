import java.math.BigInteger;

public class OctalNumber extends Number
{
    public static boolean isValid(String userString)
    {
        if (!userString.startsWith("0o"))
            return false;

        char[] digits = userString.substring(2).toCharArray();

        for (char ch : digits)
        {
            if (!(ch >= '0' && ch <= '7'))
            {
                System.out.printf("\n%sThis input contains a digit that is invalid in octal: %c%s",
                        ANSI_RED, ch, ANSI_RESET);
                return false;
            }
        }
        return true;
    }

    @Override
    public void fromString(String userString)
    {
        super.data = new BigInteger(userString.substring(2), 8);
    }

    public String toString()
    {
        return "0o" + super.data.toString(8);
    }
}

import java.math.BigInteger;

public class BinaryNumber extends Number
{
    @Override
    public String toString()
    {
        return "0b" + super.data.toString(2);
    }

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
                System.out.println("This input contains a digit that is invalid in binary." + ch);
                return false;
            }
        }
        return true;
    }

    @Override
    public void fromString(String userString)
    {
        super.data = new BigInteger(userString.substring(2), 2);
    }
}

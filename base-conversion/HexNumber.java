import java.math.BigInteger;

public class HexNumber extends Number
{
    @Override
    public String toString()
    {
        return "0x" + data.toString(16);
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
        super.data = new BigInteger(userString.substring(2), 16);
    }
}

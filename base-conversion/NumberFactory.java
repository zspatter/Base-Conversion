public class NumberFactory
{
    /**
     * Takes a string gathered from the user and standardizes the input.
     * This ensures the system is case insensitive as the base identifier
     * prefix is converted to lowercase and all other digits are converted
     * to uppercase
     *
     * @param userString input gathered from client
     * @return standardized string
     */
    private static String standardizeString(String userString)
    {
        if (userString.length() >= 2)
        {
            String prefix = userString.substring(0, 2).toLowerCase();
            String values = userString.substring(2).toUpperCase();
            return prefix + values;
        }
        return null;
    }

    /**
     * This function is the backbone of the entire system. This takes a string
     * parameter and determines whether the string is a valid number as well as
     * which base the number is in. Assuming the number is valid, this constructs
     * and returns the relevant Number object
     *
     * @param userString input from client representing a number
     * @return relevant Number type
     */
    public static INumber getNumber(String userString)
    {
        String baseIdentifier = userString.substring(0, 2).toLowerCase();
        String standardizedString = standardizeString(userString);
        if (standardizedString == null)
            return null;

        if (BinaryNumber.isValid(standardizedString) || OctalNumber.isValid(standardizedString)
                || DecimalNumber.isValid(standardizedString) || HexNumber.isValid(standardizedString))
        {
            switch (baseIdentifier)
            {
                case "0b":
                    INumber binaryNumber = new BinaryNumber();
                    binaryNumber.fromString(standardizedString);
                    return binaryNumber;
                case "0o":
                    INumber octalNumber = new OctalNumber();
                    octalNumber.fromString(standardizedString);
                    return octalNumber;
                case "0d":
                    INumber decimalNumber = new DecimalNumber();
                    decimalNumber.fromString(standardizedString);
                    return decimalNumber;
                case "0x":
                    INumber hexNumber = new HexNumber();
                    hexNumber.fromString(standardizedString);
                    return hexNumber;
                default:
                    System.out.println("Number not recognized");
                    return null;
            }
        }
        String ansi_red = "\033[31m";
        String ansi_reset = "\033[0m";

        System.out.printf("\n%sThe input isn't a valid binary, octal, decimal, or hexadecimal number.%s\n\n",
                ansi_red, ansi_reset);
        return null;
    }
}

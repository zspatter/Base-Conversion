public class NumberFactory
{
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
                    System.out.println("I don't know how to convert that type of number");
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

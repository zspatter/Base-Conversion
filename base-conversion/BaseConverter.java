import java.util.Scanner;

public class BaseConverter
{
    private static Scanner scanner = new Scanner(System.in);
    private static final String ANSI_BOLD = "\033[1m";
    private static final String ANSI_RESET = "\033[0m";
    private static final String PADDING = "";

    public static void main(String[] args)
    {
        System.out.println("This converter takes in a value and prints the " +
                "same value converted to binary, octal, decimal, and hex.");
        System.out.println("Indicate the base of the input using the provided prefixes.\n");
        converterLoop();
    }

    private static void printMenu()
    {
        System.out.printf("Choose one of the following options:" +
                        "\n\tPrefix %s0b%s: %3s for binary values" +
                        "\n\tPrefix %s0o%s: %3s for octal values" +
                        "\n\tPrefix %s0d%s: %3s for decimal values" +
                        "\n\tPrefix %s0x%s: %3s for hexadecimal values" +
                        "\n\tEnter %sEXIT%s: %2s to terminate\n\n",
                ANSI_BOLD, ANSI_RESET, PADDING,
                ANSI_BOLD, ANSI_RESET, PADDING,
                ANSI_BOLD, ANSI_RESET, PADDING,
                ANSI_BOLD, ANSI_RESET, PADDING,
                ANSI_BOLD, ANSI_RESET, PADDING);
    }

    private static void converterLoop()
    {
        while (true)
        {
            printMenu();
            String input = scanner.next();
            if (input.toUpperCase().equals("EXIT"))
                break;

            INumber iNumber = NumberFactory.getNumber(input);
            if (!(iNumber instanceof Number))
                continue;
//            Number number;
//
//            if (iNumber instanceof BinaryNumber)
//                number = (BinaryNumber) iNumber;
//            else if (iNumber instanceof OctalNumber)
//                number = (OctalNumber) iNumber;
//            else if (iNumber instanceof DecimalNumber)
//                number = (DecimalNumber) iNumber;
//            else if (iNumber instanceof HexNumber)
//                number = (HexNumber) iNumber;
//            else
//                continue;

            Number.printConvertedValues(iNumber);
        }
    }

}

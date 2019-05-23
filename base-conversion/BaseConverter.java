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

    /**
     * Prints menu to console indicating how to interact with the system
     */
    private static void printMenu()
    {
        System.out.printf("Choose one of the following options:" +
                        "\n\tPrefix %s0b%s: %3s for binary values" +
                        "\n\tPrefix %s0o%s: %3s for octal values" +
                        "\n\tPrefix %s0d%s: %3s for decimal values" +
                        "\n\tPrefix %s0x%s: %3s for hexadecimal values" +
                        "\n\tEnter %sexit%s: %2s to terminate\n\n",
                ANSI_BOLD, ANSI_RESET, PADDING,
                ANSI_BOLD, ANSI_RESET, PADDING,
                ANSI_BOLD, ANSI_RESET, PADDING,
                ANSI_BOLD, ANSI_RESET, PADDING,
                ANSI_BOLD, ANSI_RESET, PADDING);
    }

    /**
     * Continually loops through the system prompting the user for new
     * numeric inputs to convert until the client explicitly exits
     */
    private static void converterLoop()
    {
        while (true)
        {
            printMenu();
            String input = scanner.next();
            if (input.equalsIgnoreCase("EXIT"))
                break;

            INumber iNumber = NumberFactory.getNumber(input);
            if (!(iNumber instanceof Number))
                continue;

            Number.printConvertedValues(iNumber);
        }
    }
}

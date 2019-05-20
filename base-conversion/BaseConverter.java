import java.util.Scanner;

public class BaseConverter
{
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)
    {
        converterLoop();
    }

    public static void printMenu()
    {
        System.out.println("Enter a binary (0b), octal (0o), decimal (0d), or hexidecimal (0x) number with it's corresponding prefix:");
    }

    public static void converterLoop()
    {
        while (true)
        {
            printMenu();
            String input = scanner.next();
            if (input == "exit".toUpperCase())
                break;

            INumber iNumber = NumberFactory.getNumber(input);
            Number number;

            if (iNumber instanceof BinaryNumber)
                number = (BinaryNumber) iNumber;
            else if (iNumber instanceof OctalNumber)
                number = (OctalNumber) iNumber;
            else if (iNumber instanceof DecimalNumber)
                number = (DecimalNumber) iNumber;
            else if (iNumber instanceof HexNumber)
                number = (HexNumber) iNumber;
            else
                continue;

            Number.printConvertedValues(iNumber);
        }
    }

}

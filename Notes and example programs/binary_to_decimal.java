import java.util.Scanner;

public class binary_to_decimal
{
  public static int binaryToDecimal(String text)
  {
    int result = 0;
    String digits = "01";
    for (int i = 0; i < text.length(); i++)
    {
      String c = text.substring(i, i+1);
      int digit = digits.indexOf(c);
      if (digit == -1)
      {
        System.out.printf("Error: invalid binary number %s, exiting...\n", text);
        System.exit(0);
      }
      int power = (int) (Math.pow(2, text.length() - i - 1));
      result = result + digit * power;
    }
    return result;
  }


  public static void main(String[] args)
  {
    Scanner in = new Scanner(System.in);
    while (true)
    {
      System.out.printf("\nEnter a binary number (or q to exit): ");
      String binary = in.nextLine();
      if (binary.equals("q"))
      {
        System.out.println("Exiting...\n");
        break;
      }

      int result = binaryToDecimal(binary);
      System.out.printf("Binary number %s is decimal number %d.\n", binary, result);
    }
  }
}

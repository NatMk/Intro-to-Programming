import java.util.Scanner;

public class hexadecimal_to_decimal
{
  public static int hexToDecimal(String text)
  {
    int result = 0;
    String digits = "0123456789abcdef";
    for (int i = 0; i < text.length(); i++)
    {
      String c = text.substring(i, i+1);
      int digit = digits.indexOf(c);
      if (digit == -1)
      {
        System.out.printf("Error: invalid hexadecimal number %s, exiting...\n", text);
        System.exit(0);
      }
      int power = (int) (Math.pow(16, text.length() - i - 1));
      result = result + digit * power;
    }
    return result;
  }


  public static void main(String[] args)
  {
    Scanner in = new Scanner(System.in);
    while (true)
    {
      System.out.printf("\nEnter a hexadecimal number (or q to exit): ");
      String hex = in.nextLine();
      if (hex.equals("q"))
      {
        System.out.println("Exiting...\n");
        break;
      }

      int result = hexToDecimal(hex);
      System.out.printf("Hexadecimal number %s is decimal number %d.\n", hex, result);
    }
  }
}
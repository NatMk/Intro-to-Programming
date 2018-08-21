import java.util.Scanner;

public class example1
{
  public static String decimalToHex(int number)
  {
    String result = "";
    String digits = "0123456789abcdef";

    while(true)
    {
      int remainder = number % 16;
      String digit = digits.substring(remainder, remainder+1);
      result = digit + result;
      number = number / 16;
      if (number == 0)
      {
        break;
      }
    }
    return result;
  }

  public static void main(String[] args)
  {
    Scanner in = new Scanner(System.in);
    while (true)
    {
      System.out.printf("\nEnter a number, or q to quit: ");
      String text = in.nextLine();
      if (text.equals("q"))
      {
        System.out.println("Exiting...\n");
        break;
      }

      int number;
      try 
      {
        number = Integer.parseInt(text);
      }
      catch (Exception e)
      {
        System.out.printf("Error, %s is not a valid number.\n", text);
        continue;
      }
      String result = decimalToHex(number);
      System.out.printf("Decimal number %d is hexadecimal number %s.\n", number, result);
    }
      
  }
}
import java.util.Scanner;

public class decimal_to_binary
{
  public static String decimalToBinary(int number)
  {
    String result = "";
    while(true)
    {
      int remainder = number % 2;
      String digit = Integer.toString(remainder);
      result = digit + result;
      number = number / 2;
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
      String result = decimalToBinary(number);
      System.out.printf("Decimal number %d is binary number %s.\n", number, result);
    }
      
  }
}
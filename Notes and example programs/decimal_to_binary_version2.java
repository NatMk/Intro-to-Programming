import java.util.Scanner;

public class decimal_to_binary_version2
{
  public static void main(String[] args)
  {
    Scanner in = new Scanner(System.in);
    while (true)
    {
      System.out.printf("\nEnter a number (or q to exit): ");
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
      String result = Integer.toString(number, 2);
      System.out.printf("Decimal number %d is binary number %s.\n", number, result);
    }
      
  }
}
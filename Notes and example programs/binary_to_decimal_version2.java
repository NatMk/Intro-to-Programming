import java.util.Scanner;

public class binary_to_decimal_version2
{
  public static void main(String[] args)
  {
    Scanner in = new Scanner(System.in);
    while (true)
    {
      System.out.printf("\nEnter a binary number (or q to exit): ");
      String text = in.nextLine();
      if (text.equals("q"))
      {
        System.out.println("Exiting...\n");
        break;
      }

      int number;
      try 
      {
        number = Integer.parseInt(text, 2);
      }
      catch (Exception e)
      {
        System.out.printf("Error, %s is not a valid binary number.\n", text);
        continue;
      }
      System.out.printf("Binary number %s is decimal number %d.\n", text, number);
    }
  }
}
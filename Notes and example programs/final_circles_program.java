/* This program computes the circumference and area of circles.
   The main loop:
   - Asks the user for a radius.
   - Quits if the user enters "q".
   - Prints an error message if the radius is negative.
   - If the radius is valid, it prints the corresponding circumference and area.
*/

import java.util.Scanner;

public class final_circles_program 
{

  public static void main(String[] args) 
  {
    Scanner in = new Scanner(System.in);
    while (true)
    {
      System.out.printf("Enter the circle radius, or q to quit: ");
      String input = in.next();
      if (input.equals("q"))
      {
        System.out.printf("\nExiting...\n");
        break;
      }

      double radius;
      try
      {
        radius = Double.parseDouble(input);
      } catch (Exception e)
      {
        System.out.printf("Error: %s is not a valid radius.\n\n", input);
        continue;
      }

      if (radius < 0)
      {
        System.out.printf("Error: %.2f is less than zero.\n\n", radius);
        continue;
      }
      double circumference = 2 * Math.PI * radius;
      double area = Math.PI * Math.pow(radius, 2);
      System.out.printf("Circumference = %.2f.\n", circumference);
      System.out.printf("Area = %.2f.\n\n", area);
    }
  }
}

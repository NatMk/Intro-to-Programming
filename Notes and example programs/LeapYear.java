// A program that:
// - asks the user to enter a year (an integer)
// - prints if that year is a leap year or not.
//
// this is an example of nested if statements.


import java.util.Scanner;

public class LeapYear
{
  public static void main(String[] args) 
  {
    Scanner in = new Scanner(System.in);
    System.out.printf("Enter a year: ");
    int year = in.nextInt();
    if (year % 100 == 0)
    {
        if (year % 400 == 0)
        {
            System.out.printf("%d is a leap year.\n", year);
        }
        else
        {
            System.out.printf("%d is not a leap year.\n", year);
        }
    }
    else
    {
        if (year % 4 == 0)
        {
            System.out.printf("%d is a leap year.\n", year);
        }
        else
        {
            System.out.printf("%d is not a leap year.\n", year);
        }
    }
    
  }
}

/* This program determines if an integer is a prime.
   - It asks the user to enter an integer N.
   - It prints whether N is prime.
*/

import java.util.Scanner;

public class prime_numbers_for
{

  public static void main(String[] args)
  {
    Scanner in = new Scanner(System.in);
    System.out.printf("Enter an integer N: ");
    int N = in.nextInt();
    boolean N_is_prime = true;
    for (int i = 2; i < N; i++)
    {
      if (N % i == 0)
      {
        N_is_prime = false;
      }
    }
    if (N_is_prime)
    {
      System.out.printf("%d is prime.\n", N);
    } 
    else
    {
      System.out.printf("%d is not prime.\n", N);
    }
  }
}

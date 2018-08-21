import java.util.Scanner;

public class sum_of_digits 
{

  public static int sum_digits(int N)
  {
    int total = 0;

    int number = N;
    while (number > 0)
    {
      int remainder = number % 10;
      total = total + remainder;
      number = number / 10;
    }
    return total;
  }
  
  public static void main(String[] args) 
  {
    Scanner in = new Scanner(System.in);
    System.out.printf("Enter integer N: ");
    int N = in.nextInt();
    int result = sum_digits(N);
    System.out.printf("result = %d\n",result);
  }
}


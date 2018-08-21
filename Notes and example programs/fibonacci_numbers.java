import java.util.Scanner;

public class fibonacci_numbers
{

  public static int fibonacci(int N)
  {
    if (N == 0)
    {
      return 0;
    }
    if (N == 1)
    {
      return 1;
    }
    
    int last_number = 1;
    int second_to_last_number = 0;
    for (int i = 2; i <= N; i++)
    {
      int current_number = last_number + second_to_last_number;
      second_to_last_number = last_number;
      last_number = current_number;
    }
    
    return last_number;
  }
  
  public static void main(String[] args) 
  {
    Scanner in = new Scanner(System.in);
    System.out.printf("Enter integer N: ");
    int N = in.nextInt();
    int result = fibonacci(N);
    System.out.printf("result = %d\n",result);
  }
}


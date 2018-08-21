import java.util.Scanner;

public class sum_of_squares 
{

  public static int sum_squares(int N)
  {
    int total = 0;
    for (int i = 1; i*i <= N; i++)
    {
      total = total + i*i;
    }
    return total;
  }
  
  public static void main(String[] args) 
  {
    Scanner in = new Scanner(System.in);
    System.out.printf("Enter integer N: ");
    int N = in.nextInt();
    int result = sum_squares(N);
    System.out.printf("result = %d\n",result);
  }
}

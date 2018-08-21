import java.util.Scanner;

public class squares_less_than_N 
{

  public static void print_squares(int N)
  {
    for (int i = 1; i*i <= N; i++)
    {
      System.out.printf("%d\n", i*i);
    }
  }
  
  public static void main(String[] args) 
  {
    Scanner in = new Scanner(System.in);
    System.out.printf("Enter integer N: ");
    int N = in.nextInt();
    print_squares(N);
  }
}

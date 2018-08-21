import java.util.Scanner;



public class box_print 
{
  public static void repeat_star(int N)
  {
    for (int i = 0; i < N; i++)
    {
      System.out.printf("*");
    }
    System.out.printf("\n");
  
  }
  
  public static void box_print(String s)
  {
    int length = s.length();
    repeat_star(length+4);
    System.out.printf("* %s *\n", s);
    repeat_star(length+4);
  }

  public static void main(String[] args) 
  {
    Scanner in = new Scanner(System.in);
    System.out.printf("Enter a word: ");
    String word = in.next();
    box_print(word);
  }
}

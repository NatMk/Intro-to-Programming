import java.util.Scanner;



public class count_vowels 
{  
  public static int count_vowels(String s)
  {
    int counter = 0;
    
    for (int i = 0; i < s.length(); i++)
    {
      if ("aeiouAEIOU".indexOf(s.charAt(i)) >= 0)
      {
        counter++;
      }
    }
    
    return counter;
  }

  public static void main(String[] args) 
  {
    Scanner in = new Scanner(System.in);
    System.out.printf("Enter a word: ");
    String word = in.next();
    int result = count_vowels(word);
    System.out.printf("result = %d\n", result);
  }
}

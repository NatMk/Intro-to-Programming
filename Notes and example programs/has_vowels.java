import java.util.Scanner;



public class has_vowels 
{  
  public static boolean has_vowels(String s)
  {
    int counter = 0;
    
    for (int i = 0; i < s.length(); i++)
    {
      if ("aeiouAEIOU".indexOf(s.charAt(i)) >= 0)
      {
        counter++;
      }
    }
    
    return (counter > 0);
  }

  public static void main(String[] args) 
  {
    Scanner in = new Scanner(System.in);
    System.out.printf("Enter a word: ");
    String word = in.next();
    boolean result = has_vowels(word);
    System.out.printf("result = %b\n", result);
  }
}

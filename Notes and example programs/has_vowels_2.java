import java.util.Scanner;

public class has_vowels_2
{  
  public static boolean has_vowels(String s)
  {
    for (int i = 0; i < s.length(); i++)
    {
      if ("aeiouAEIOU".indexOf(s.charAt(i)) >= 0)
      {
        return true;
      }
    }
    
    return false;
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

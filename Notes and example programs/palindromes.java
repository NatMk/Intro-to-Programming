import java.util.Scanner;

public class palindromes 
{  
  public static boolean is_palindrome(String s)
  {
    for (int i = 0; i < s.length(); i++)
    {
      char first = s.charAt(i);
      char second = s.charAt(s.length() - i - 1);
      if (first != second)
      {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) 
  {
    Scanner in = new Scanner(System.in);
    System.out.printf("Enter a word: ");
    String word = in.next();
    boolean result = is_palindrome(word);
    System.out.printf("result = %b\n", result);
  }
}

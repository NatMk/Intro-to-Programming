// This is a program that:
// - asks the user to enter a string
// - prints if the first letter of that string is a vowel or not.
//
// This version checks for both lower-case and upper case vowels.

import java.util.Scanner;

public class StartsWithVowel2
{
  public static void main(String[] args) 
  {
    Scanner in = new Scanner(System.in);
    System.out.printf("Enter some word: ");
    String word = in.next();

    char c = word.charAt(0);
    if ("aeiouAEIOU".indexOf(c)!= -1)
    {
        System.out.printf("Your word starts with a vowel\n");
    }
    else
    {
        System.out.printf("Your word does not start with a vowel\n");
    }
    
  }
}

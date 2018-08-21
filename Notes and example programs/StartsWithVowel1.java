// This is a program that:
// - asks the user to enter a string
// - prints if the first letter of that string is a vowel or not.
//
// It only checks for lower-case vowels.


import java.util.Scanner;

public class StartsWithVowel1 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.printf("Enter some word: ");
    String word = in.next();

    char c = word.charAt(0);
    if ((c == 'a') || (c == 'e') || (c == 'i') || (c == 'o') || (c == 'u'))
    {
        System.out.printf("Your word starts with a vowel\n");
    }
    else
    {
        System.out.printf("Your word does not start with a vowel\n");
    }
    
  }
}

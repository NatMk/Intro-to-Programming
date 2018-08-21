/* This program picks a random number, from zero up to and including 100.
   Then, the user tries to guess the number.
   After every guess, the system tells the user if the guess was correct,
   or should be higher or should be lower.
*/
import java.util.*;

public class guessing_game
{

  public static void main(String[] args)
  {
    Scanner in = new Scanner(System.in);
    Random rand = new Random();
    int pick = rand.nextInt(101); // Between 0 and 100.
    int attempt = 1;

    while (true)
    {
      System.out.printf("Try %d: Guess the number: ", attempt);
      int guess = in.nextInt();
      if (guess == pick)
      {
        System.out.printf("Correct!!!\n");
        break;
      } 
      else
      {
        if (guess < pick)
        {
          System.out.printf("Go higher.\n");
        } else
        {
          System.out.printf("Go lower.\n");
        }
      }
      attempt++;
    }
  }
}

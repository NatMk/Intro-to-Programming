import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;

public class file_printing 
{
  public static void print_file(String filename)
  {
    File temp = new File(filename);
    Scanner input_file;
    try
    {
      input_file = new Scanner(temp);
    }
    catch (Exception e)
    {
      System.out.printf("Failed to open file %s\n",
                        filename);
      return;
    }

    while(input_file.hasNextLine())
    {
      String line = input_file.nextLine();
      System.out.printf("%s\n", line);
    }
    input_file.close();
  }  


  public static void main(String[] args)
  {
    print_file("nba.txt");
    System.out.printf("\n");
    print_file("enrollments.txt");
  }
}

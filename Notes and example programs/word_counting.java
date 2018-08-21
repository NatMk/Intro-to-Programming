import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;

public class word_counting
{
  public static int count_words(String filename)
  {
    ArrayList<String> lines = read_file(filename);
    if (lines == null)
    {
      return 0;
    }

    int counter = 0;
    for (int i = 0; i < lines.size(); i++)
    {
      String line = lines.get(i);
      String[] words = line.split("[, .-]");
      counter += words.length;
    }
    
    return counter;
  }

  
  public static ArrayList<String> read_file(String filename)
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
      return null;
    }

    ArrayList<String> result = new ArrayList<String>();
    while(input_file.hasNextLine())
    {
      String line = input_file.nextLine();
      result.add(line);
    }
    
    input_file.close();
    return result;
  }  

          
  public static void main(String[] args)
  {
    String name;
    int result;
    
    name = "nba.txt";
    result = count_words(name);
    System.out.printf("%s has %d words.\n", name, result);

    name = "enrollments.txt";
    result = count_words(name);
    System.out.printf("%s has %d words.\n", name, result);
  }
}

import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;

public class length_of_file
{
  public static int file_length(String filename)
  {
    ArrayList<String> lines = read_file(filename);
    if (lines == null)
    {
      return 0;
    }

    int length = 0;
    for (int i = 0; i < lines.size(); i++)
    {
      String line = lines.get(i);
      length += line.length();
    }
    
    return length;
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
    int length;

    name = "nba.txt";
    length = file_length(name);
    System.out.printf("%s has %d characters.\n", name, length);
    
    name = "enrollments.txt";
    length = file_length(name);
    System.out.printf("%s has %d characters.\n", name, length);
  }
}

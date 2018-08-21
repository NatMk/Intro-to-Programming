import java.io.File;
import java.util.*;

public class ExtractDate
{
  public static int[] extract_date(String s)
  {
    int[] results= new int[3];
    
    String[] date = s.split("/");
    
    for (int i = 0; i< date.length; i++)
    {
      String string_num = date[i];
      try
      {
        int num = Integer.parseInt(string_num);
        results[i] = num;
      }
      catch (Exception e)
      {
        System.out.printf("Incorrect date format.\n");
        System.exit(0);
      }
    }
    
    return results;
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

    ArrayList<String> result = new ArrayList();
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
    Scanner in = new Scanner(System.in);
    ArrayList<String> contents = read_file("enrollments.csv");
    
    for (int i = 1; i < contents.size(); i++)
    {
      String line = contents.get(i);
      String[] info = line.split(",");
      String date_string = info[0];
      int[] date= extract_date(date_string);
      System.out.printf("Month: %d\nDay: %d\nYear: %d\n\n", date[0],date[1],date[2]);
    }
  }

}
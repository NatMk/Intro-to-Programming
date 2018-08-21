import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.PrintWriter;

public class compute_grades
{
  public static void process_grades(String input_name, String csv_name, 
                                    String pretty_name)
  {
  } 


  public static String[][] read_spreadsheet(String filename)
  {
    ArrayList<String> lines = read_file(filename);
    if (lines == null)
    {
      return null;
    }

    int rows = lines.size();
    String[][] result = new String[rows][];

    for (int i = 0; i < rows; i++)
    {
      String line = lines.get(i);
      String[] values = line.split(",");
      result[i] = values;
    }

    return result;
  } 
  
  
  public static ArrayList<String> read_file(String filename)
  {
    File temp = new File(filename);
    Scanner input_file;
    ArrayList<String> result = new ArrayList<String>();

    try
    {
      input_file = new Scanner(temp);
    }
    catch (Exception e)
    {
      System.out.printf("Failed to open file %s\n",
                        filename);
      return result;
    }

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

    System.out.printf("Please enter the name of the input file: ");
    String input_name = in.next();
    System.out.printf("Please enter the name of the output CSV file: ");
    String csv_name = in.next();
    System.out.printf("Please enter the name of the output pretty-print file: ");
    String pretty_name = in.next();
    
    process_grades(input_name, csv_name, pretty_name);
    System.out.printf("\n\nExiting...\n");
  }
}

import java.io.File;
import java.util.*;

public class PrintColumn
{
  public static void print_column(String filename, int column)
  {
    ArrayList<String> lines = read_file(filename);
    for (int row = 0; row < lines.size(); row++)
    {
      String line = lines.get(row);
      String[] data = line.split(",");
      int number_of_columns = data.length;
      if (number_of_columns <= column)
      {
        continue;
      }

      String col_data = data[column];
      System.out.printf("%s\n", col_data);
    }
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
    System.out.printf("Enter file name: ");
    String filename = in.next();
    System.out.printf("Enter column: ");
    int col = in.nextInt();
    
    print_column(filename, col);
  }
}
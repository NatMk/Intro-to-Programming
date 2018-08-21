import java.util.*;
import java.io.File;

public class sort_file {

  public static ArrayList<String[]> array_to_list(String[][] a)
  {
    // create empty list
    ArrayList<String[]> result = new ArrayList();
    
    // loop through array elements
    for (int i = 0; i < a.length; i++)
    {
    //    add each element to the list
      String[] current = a[i];
      result.add(current);
    }
    
    return result;
  }
          
  public static int find_smallest_position(ArrayList<String[]> list, int column)
  {
    if (list.size() == 1)
    {
      System.out.printf("Error: empty list\n");
      System.exit(0);
    }
    
    String[] line_data = list.get(1);
    String column_text = line_data[column];
    double smallest_so_far = Double.parseDouble(column_text);
    int smallest_position = 1;
    
    for (int i = 2; i < list.size(); i++)
    {
      line_data = list.get(i);
      column_text = line_data[column];    
      double current = Double.parseDouble(column_text);
      if (current < smallest_so_far)
      {
        smallest_so_far = current;
        smallest_position = i;
      }
    }
    
    return smallest_position;
  }
  
  public static void print_sorted(String filename, int column)
  {
    String[][] data = read_spreadsheet(filename);
    
    ArrayList<String[]> list = array_to_list(data);
    
    while(list.size() > 0)
    {
      // find smallest element of the list
      int smallest_position = find_smallest_position(list, column);
      
      // print that smallest element
      String[] line_data = list.get(smallest_position);
      System.out.printf("%15s, %3s, %3s, %s\n", line_data[0],
                        line_data[1], line_data[2], line_data[3]);
      
      // remove that smallest element from a
      list.remove(smallest_position);
    }
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
    System.out.printf("Enter a filename: ");
    Scanner in = new Scanner(System.in);
    String filename = in.next();
    
    System.out.printf("Enter a column: ");
    int column = in.nextInt();
    
    print_sorted(filename, column);
  }
}

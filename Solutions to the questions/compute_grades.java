import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.PrintWriter;

public class compute_grades
{
  public static void process_grades(String input_name, String csv_name, 
                                    String pretty_name)
  {
    // read the input file
    String[][] in_data = read_spreadsheet(input_name);
    if (in_data == null)
    {
      System.out.printf("Error: failed to read data from %s.\n", input_name);
      return;
    }
    
    int rows = in_data.length-1;
    
    // string_data will contain, for each student,
    // first name, last name, letter grade
    String[][] string_data = new String[rows][3];

    // number_data will contain, for each student,
    // homework score, exam score, minimum score.
    double[][] number_data = new double[rows][3];
    
    // note that we are passing as arguments string_data and number_data
    // These arrays do not store any information, but the compute_grades 
    // function will put information there.
    compute_grades(in_data, string_data, number_data);
    
    // Save the data as CSV and also in pretty-print format.
    save_csv(csv_name, string_data, number_data);
    save_pretty(pretty_name, string_data, number_data);
  }
  
  // in_data contains grade information read from a CSV file.
  // The function will store:
  // - in string_data[row][0] the first name of the student at that row.
  // - in string_data[row][1] the last name of the student at that row.
  // - in string_data[row][2] the letter grade of the student at that row.
  // - in number_data[row][0] the exam average score of the student at that row.
  // - in number_data[row][1] the homework average score of the student at that row.
  // - in number_data[row][2] the smallest among the exam and homework scores 
  //                          of the student at that row.
  // Note that arguments string_data and number_data do not provide any
  // information to compute_grades, but rather they RECEIVE information from
  // compute_grades.
  public static void compute_grades(String[][] in_data, String[][] string_data,
                                    double[][] number_data)
  {
    for (int row = 0; row < string_data.length; row++)
    {
      string_data[row][0] = in_data[row+1][0]; // first name
      string_data[row][1] = in_data[row+1][1]; // last name

      // compute exam average score, and store it at number_data[row][0]
      double exam_average = compute_average(in_data, row+1, 2, 4);
      number_data[row][0] = exam_average;

      // compute homework average score, and store it at number_data[row][1]
      double hw_average = compute_average(in_data, row+1, 5, 11);
      number_data[row][1] = hw_average;

      // compute min score, and store it at number_data[row][2]
      double min_score = exam_average;
      if (hw_average < exam_average)
      {
        min_score = hw_average;
      }
      number_data[row][2] = min_score;

      // compute letter grade, and store it at string_data[row][2]
      string_data[row][2] = score_to_grade(min_score);
    }
  }

  
  // the data is a 2D array of strings. We assume that elements from
  // data[row][start_col] up to and including data[row][end_col] contain numbers,
  // and this function computes and returns the average of those numbers.
  public static double compute_average(String[][] data, int row, int start_col, int end_col)
  {
    double total = 0;
    for (int col = start_col; col <= end_col; col++)
    {
      String score_string = data[row][col]; // get the score as a string
      try
      {
        double score = Double.parseDouble(score_string);
        total += score;
      }
      catch (Exception e)
      {
        System.out.printf("Error: failed to read number at row %d, col %d\n", 
                          row, col);
        return -1;
      }
    }
    // compute and return the average of the values we have read.
    return total / (end_col - start_col + 1);
  }
  
  
  // convert a score to a letter grade, based on hardcoded thresholds.
  public static String score_to_grade(double score)
  {
    if (score >= 90)
    {
      return "A";
    }
    else if (score >= 80)
    {
      return "B";
    }
    else if (score >= 70)
    {
      return "C";
    }
    else if (score >= 60)
    {
      return "D";
    }
    else
    {
      return "F";
    }        
  }
  
  
  // Saves the computed data as a CSV file.
  // See comments before the compute_grades function for a description of 
  // the contents of arrays string_data and number_data.
  public static void save_csv(String filename, String[][] string_data, double[][] number_data)
  {
    // open the output file.
    PrintWriter out = null;
    try
    {
      out = new PrintWriter(filename);
    }
    catch (Exception e)
    {
      System.out.printf("Error: failed to open file %s.\n", filename);
    }
    
    // print the column names.
    out.printf("name,exam score,hw score,min score,grade\r\n");
    
    // print the data for each row.
    for (int row = 0; row < string_data.length; row++)
    {
      String name = string_data[row][0] + " " + string_data[row][1];
      double exam_score = number_data[row][0];
      double hw_score = number_data[row][1];
      double min_score = number_data[row][2];
      String grade = string_data[row][2];
      out.printf("%s,%f,%f,%f,%s\r\n",
                 name, exam_score, hw_score, min_score, grade);
    }
   out.close();
  } 
    

  // Saves the computed data as a CSV file.
  // See comments before the compute_grades function for a description of 
  // the contents of arrays string_data and number_data.
  public static void save_pretty(String filename, String[][] string_data, double[][] number_data)
  {
    // open the output file.
    PrintWriter out = null;
    try
    {
      out = new PrintWriter(filename);
    }
    catch (Exception e)
    {
      System.out.printf("Error: failed to open file %s.\n", filename);
    }

    // print the column names.
    out.printf("%20s: %10s, %8s, %9s, %s\r\n",
               "name", "exam score", "hw score", "min score", "grade");

    // print the data for each row.
    for (int row = 0; row < string_data.length; row++)
    {
      String name = string_data[row][0] + " " + string_data[row][1];
      double exam_score = number_data[row][0];
      double hw_score = number_data[row][1];
      double min_score = number_data[row][2];
      String grade = string_data[row][2];
      out.printf("%20s: %10.2f, %8.2f, %9.2f, %s\r\n",
                 name, exam_score, hw_score, min_score, grade);
    }
   out.close();
  } 
    

  public static void print_data(String[][] string_data, double[][] number_data)
  {
    System.out.printf("%20s: %8s, %10s, %9s, %s\n",
                      "name", "hw score", "exam score", "min score", "grade");
    for (int row = 0; row < string_data.length; row++)
    {
      String name = string_data[row][0] + " " + string_data[row][1];
      double hw_score = number_data[row][0];
      double exam_score = number_data[row][1];
      double min_score = number_data[row][2];
      String grade = string_data[row][2];
      System.out.printf("%20s: %8.2f, %10.2f, %9.2f, %s\n",
                        name, hw_score, exam_score, min_score, grade);
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

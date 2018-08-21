public class matrix_average {
  public static double average(double[][] matrix)
  {
    // First compute the sum
    double sum = 0.0;
    double number_of_entries = 0;
    for (int i = 0; i < matrix.length; i++)
    {
      number_of_entries += matrix[i].length;
      for (int j = 0; j < matrix[i].length; j++)
      {
        sum = sum + matrix[i][j];
      }
    }
    
    // Then divide the sum by the number of values in the matrix.
    double result = sum / number_of_entries;
    return result;
  }
  
  public static double column_average(double[][] matrix, int col)
  {
    // first compute the sum of values in that column
    double sum = 0;
    double number_of_values = 0;
    for (int i = 0; i < matrix.length; i++)
    {
      if (col < matrix[i].length)
      {
        sum = sum + matrix[i][col];
        number_of_values = number_of_values + 1;
      }
    }
    
    // then divide the sum by the number of values in that column
    double result = sum / number_of_values;
    return result;
  }
  
  public static void main(String[] args)   
  {
    double[][] a = { {3.2, 2.1, 5.3},
                     {8.0, 4.9, 5.7, 4.1} };

    double result = average(a);
    System.out.printf("average(a) = %.1f\n", result);
    result = column_average(a, 2);
    System.out.printf("column_average(a, 2) = %.1f\n", result);
  }  
}

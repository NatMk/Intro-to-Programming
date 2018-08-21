public class array_copy {
  public static double[] copy_array(double[] x)
  {
    double[] result = new double[x.length];
    
    for (int i = 0; i < x.length; i++)
    {
      result[i] = x[i];
    }
    return result;
  }
  
  public static void print_double_array(double[] x)
  {
    for (int i = 0; i < x.length; i++)
    {
      System.out.printf("%.1f\n", x[i]);
    }
  }
  
  public static void main(String[] args)   
  {
    double[][] a = { {3.2, 2.1, 5.3},
                     {8.0, 4.9, 5.7, 4.1} };

    double[] result = copy_array(a[1]);
    print_double_array(result);
  }  
}

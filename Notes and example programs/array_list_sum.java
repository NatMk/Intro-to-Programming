import java.util.ArrayList;

public class array_list_sum 
{
  public static ArrayList<Double> array_list_sum(ArrayList<Double> x, ArrayList<Double> y)
  {
    if (x.size() != y.size())
    {
      return null;
    }
    
    ArrayList<Double> result = new ArrayList<Double>();
    for (int i = 0; i < x.size(); i++)
    {
      double temp = x.get(i) + y.get(i);
      result.add(temp);
    }
    
    return result;
  }    
  
  public static void main(String[] args)   
  {
    ArrayList<Double> a = new ArrayList<Double>();
    a.add(1.0);
    a.add(2.0);
    a.add(3.0);
    
    ArrayList<Double> b = new ArrayList<Double>();
    b.add(10.0);
    b.add(11.0);
    b.add(12.0);
    
    ArrayList<Double> c = array_list_sum(a, b);
    System.out.println(c);
  }  
}

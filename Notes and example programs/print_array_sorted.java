import java.util.*;

public class print_array_sorted {

  public static ArrayList<Integer> array_to_list(int[] a)
  {
    // create empty list
    ArrayList<Integer> result = new ArrayList();
    
    // loop through array elements
    for (int i = 0; i < a.length; i++)
    {
    //    add each element to the list
      int current = a[i];
      result.add(current);
    }
    
    return result;
  }
          
  public static int find_smallest_position(ArrayList<Integer> list)
  {
    if (list.size() == 0)
    {
      System.out.printf("Error: empty list\n");
      System.exit(0);
    }
    int smallest_so_far = list.get(0);
    int smallest_position = 0;
    for (int i = 1; i < list.size(); i++)
    {
      int current = list.get(i);
      if (current < smallest_so_far)
      {
        smallest_so_far = current;
        smallest_position = i;
      }
    }
    
    return smallest_position;
  }
  
  public static void print_sorted(int[] a)
  {
    ArrayList<Integer> list = array_to_list(a);
    
    while(list.size() > 0)
    {
      // find smallest element of the list
      int smallest_position = find_smallest_position(list);
      
      // print that smallest element
      System.out.printf("%d\n", list.get(smallest_position));
      
      // remove that smallest element from a
      list.remove(smallest_position);
    }
  }
  
  public static void main(String[] args)
  {
    int[] a = {123, 53, 532, 99, 923, 93};
    print_sorted(a);
  }
}

import java.io.PrintWriter;

public class file_writing_example {
  public static void main(String[] args)
  {
    String filename = "out1.txt";
    PrintWriter out = null;
    try
    {
      out = new PrintWriter("out1.txt");
    }
    catch (Exception e)
    {
      System.out.printf("Error: failed to open file %s.\n", filename);
      System.exit(0);
    }
    out.printf("writing a line to a file.\n");
    out.printf("writing a second line.\n");
    out.close();
    System.out.printf("Done writing to file %s.\n", filename);
  }  
}

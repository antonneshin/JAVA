import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Vetvlenie2001
{
	public static void main(String[] args)
	{
		float a=0,b=0,c=0;
		try
		{
			Scanner sc = new Scanner(new File("input2001.txt"));
			a=sc.nextFloat();
			b=sc.nextFloat();
			sc.close();
        }
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
    
		c=a+b;
    
		try
		{
			PrintWriter pw = new PrintWriter(new File("output2001.txt"));
			pw.println((int)c);
			pw.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}            
	}
}
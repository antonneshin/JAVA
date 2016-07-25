import java.io.*;
import java.util.*;

public class Array2021 
{
    public static void main(String[] args) 
	{
		int a[]={20};
        try {
           Scanner scanner = new Scanner(new File("input2021.txt"));
		   int size = scanner.nextInt(),max;
		   ArrayList<Integer> arr = new ArrayList<Integer>();
            for (int k=0;k<size;k++) {
                int i = scanner.nextInt();
				arr.add(i);               
                System.out.println("числа: " + i);                
            }
			max=arr.get(0);
			for (int k=1;k<size;k++) 
			{
				if (arr.get(k)>max)
					max=arr.get(k);
			}
			try
			{
				PrintWriter pw = new PrintWriter(new File("output2021.txt"));
				for (int k=0;k<size;k++) 
				{	
					if (arr.get(k)==max)
						pw.println((int)arr.get(k)/2);
					else
						pw.println((int)arr.get(k));
				}
				pw.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			
			scanner.close();
        } catch (IOException e){System.out.println("ошибка " + e); }
		
    }

}
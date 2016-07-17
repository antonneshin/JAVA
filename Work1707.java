/**
 * Created by Пентагон on 17.07.2016.
 */
import java.io.*;

public class Work1707
{
    public static void main (String[] args)
    {
        File f=new File("C:\\Users\\Пентагон\\Desktop\\HomeWork1707\\src\\input.txt");
        try {
            FileReader reader = new FileReader(f);
            char[] buffer = new char[(int) f.length()];
            // считаем файл полностью
            reader.read(buffer);
            String myStr=new String(buffer);

            String[] strAr = myStr.split(" ");
            int strArLen = strAr.length;
            String perem;
            for (int j = 0; j < strArLen; j++) {
                for (int i = 0; i < strArLen - 1; i++) {
                    if (strAr[i].length() > strAr[i + 1].length()) {
                        perem = strAr[i];
                        strAr[i] = strAr[i + 1];
                        strAr[i + 1] = perem;
                    }
                }
            }
            for (int i = 0; i < strArLen; i++) {
                System.out.println(strAr[i]+" "+strAr[i].length() );
            }

        }
        catch (IOException e) {
            System.out.print(e.getMessage());
        }

    }
}

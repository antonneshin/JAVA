package src.lesson2507;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Student on 25.07.2016.
 */
public class FinallyTest2 {
    public static void main(String[] args) {
        FileInputStream in=null;
        FileOutputStream out=null;
        try
        {
            in=new FileInputStream("");
            out=new FileOutputStream("");
            out.write(in.read());
        }catch (FileNotFoundException e){
            System.out.println(e.toString());
        }catch (IOException e){
            System.out.println(e.toString());
        }finally{
            try {
                if (in!=null) {
                    in.close();
                }
                if (out!=null) {
                    out.close();
                }
            } catch (IOException e){
                System.out.println(e.toString());
            }
        }
    }
}

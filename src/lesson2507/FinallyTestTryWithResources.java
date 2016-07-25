package src.lesson2507;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Student on 25.07.2016.
 */
public class FinallyTestTryWithResources {
    public static void main(String[] args) {
        try (
            FileInputStream in = new FileInputStream("");
            FileOutputStream out = new FileOutputStream("");
        ){ out.write(in.read());
        } catch (IOException e){
            System.out.println(e.toString());
        }
    }
}

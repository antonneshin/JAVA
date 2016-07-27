package src.home.sbt.task2707;

import com.sun.xml.internal.ws.api.ha.StickyFeature;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by Пентагон on 27.07.2016.
 */
public class Task2707 {
    public static void readUrlContent(String url) throws IOException
    {
        url=url.toLowerCase();
        URL site = new URL(url);
        BufferedReader reader = new BufferedReader(new InputStreamReader(site.openStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        Boolean flag=true;
        while(flag) {
            try {
                System.out.print("Enter URL: ");
                String url=in.next();
                System.out.println("You have entered url: "+url);
                readUrlContent(url);
                flag = false;
            } catch (IOException e) {
                System.out.println("You have entered incorrect URL!\ntry again...");
                flag = true;
            }
        }
    }
}

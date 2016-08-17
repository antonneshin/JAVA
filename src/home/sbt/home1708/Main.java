package src.home.sbt.home1708;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Пентагон on 17.08.2016.
 */
public class Main {
    public static Integer cntLetters=0;
    public static void main(String[] args) {
        try{
            List<String> ls= Files.readAllLines(Paths.get("C:\\Users\\Пентагон\\Desktop\\JAVAnew\\src\\home\\sbt\\home1708\\input.txt"));
            Integer poolSize=Integer.parseInt(Files.readAllLines(Paths.get("C:\\Users\\Пентагон\\Desktop\\JAVAnew\\src\\home\\sbt\\home1708\\poolSize.txt")).get(0));
            ArrayList<String> words = new ArrayList<>();
            String[] strWords;
            for (String line:ls){
                strWords=line.split(" ");
                for (String word:strWords){
                    words.add(word);
                }
            }
            System.out.println("pool Size = "+poolSize);
            //words.stream().forEach(System.out::println);
            System.out.println("count of words = "+words.size());
            Integer part=words.size()/poolSize;
            Thread t;
            List<Thread> listT = new ArrayList<>();
            for (int i=0;i<words.size();i+=part){
                t = new Thread(new CountTask(words,i,(i+part>words.size())?words.size():i+part));
                listT.add(t);
                t.start();
            }
            Boolean flag=true;
            Integer curInd=0;
            while (flag){
                if (listT.get(curInd).isAlive()){
                    Thread.yield();
                } else {
                    curInd++;
                    flag=curInd<listT.size();
                }
            }
            /*try{
                listT.get(listT.size()-1).join();
            } catch (InterruptedException e){
                e.printStackTrace();
            }*/

            System.out.println("Count of letters = "+Main.cntLetters);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}

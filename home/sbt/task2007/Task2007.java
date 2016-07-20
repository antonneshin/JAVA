package home.sbt.task2007;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * Created by Пентагон on 20.07.2016.
 */
class MyWords implements Comparator<String>
{
    String word;

    @Override
    public int compare(String o1, String o2) {
        if (o1.length()>o2.length())
            return 1;
        else
            if (o1.length()==o2.length())
                return o1.compareTo(o2);
            else
                return -1;
    }
}

public class Task2007 {
    public void print(String s)
    {
        System.out.println(s);
    }
    public List<String> readFile(String path)
    {
        List<String> lines=null;
        try {
            lines=Files.readAllLines(Paths.get(path));
        }
        catch (IOException ex)
        {
            System.out.println(ex.getMessage());
        }
        return lines;
    }

    public List<String> getWords(String s)
    {
        List<String> words=new ArrayList<>();
        s=s.trim();
        int len=s.length();
        String word="";
        for(int i=0;i<len;i++) {
            if (((s.charAt(i) >= 'a') && (s.charAt(i) <= 'z')) || ((s.charAt(i) >= 'A') && (s.charAt(i) <= 'Z'))) {
                word = word + s.charAt(i);
            } else {
                if (word.length() > 0) {
                    words.add(word);
                    word = "";
                }
            }
        }
        if (word.length() > 0) {
            words.add(word);
        }
        return words;
    }

    public void showMap(Map<String,Integer> wc)
    {
        Set<String> keys=wc.keySet();
        for(String key:keys)
        {
            System.out.println("key="+key+" cnt="+wc.get(key));
        }
    }

    public static void main(String[] args)
    {
        Task2007 tsk=new Task2007();
        Map wordCnt=new HashMap<String,Integer>();
        Integer fl;
        List<String> lines=tsk.readFile("C:\\Users\\Пентагон\\Desktop\\JAVAnew\\home\\sbt\\task2007\\input.txt");
        for (String line:lines)
        {
            //System.out.println(line);
            try {
                List<String> words = tsk.getWords(line);
                for (String word1 : words) {
                    //System.out.println(word1);
                    if ((fl=(Integer)wordCnt.get(word1))==null) {
                        wordCnt.put(word1,1);
                    }
                    else
                    {
                        wordCnt.put(word1,fl+1);
                    }
                }
            }
            catch (NullPointerException ex)
            {
                System.out.println("my error "+ex.getMessage());
            }
        }

        System.out.println("\n WORDS - COUNTS");
        tsk.showMap(wordCnt);

        System.out.println("\n   STROKI v OBRATNOM PORYADKE\n");
        for (int i=lines.size()-1;i>-1;i--)
        {
            System.out.println(lines.get(i));
        }

        System.out.println("\n   SORTING \n");
        TreeSet<String> sortWords=new TreeSet<String>(new MyWords());
        Set<String> keys=wordCnt.keySet();
        for(String key:keys)
        {
            sortWords.add(new String(key));
        }
        Iterator<String> j=sortWords.iterator();
        while(j.hasNext()) {
            System.out.println(j.next());
        }

        System.out.println("\n  VIVOD 2-oi STROKI");
        System.out.print(lines.get(1));

    }
}

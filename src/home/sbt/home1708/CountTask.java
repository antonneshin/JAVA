package src.home.sbt.home1708;

import java.util.ArrayList;
import java.util.concurrent.ThreadFactory;

/**
 * Created by Пентагон on 17.08.2016.
 */
public class CountTask implements Runnable {
    private Integer start=0;
    private Integer end=0;
    private ArrayList<String> al;
    public CountTask(ArrayList alp, Integer startp, Integer endp){
        al=alp;
        start=startp;
        end=endp;
    }
    @Override
    public void run() {
        Integer sum=0;
        String word;
        for(int i=start;i<end;i++){
            //System.out.println(Thread.currentThread().getName()+" == "+al.get(i));
            word=al.get(i);
            for (int j=0;j<word.length();j++){
                if( ((word.charAt(j)>='a')&&(word.charAt(j)<='z'))||((word.charAt(j)>='A')&&(word.charAt(j)<='Z')) ){
                    sum+=1;
                }
            }

        }
        Main.cntLetters+=sum;
    }
}

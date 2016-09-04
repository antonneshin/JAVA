package src.home.sbt.task_16;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Пентагон on 04.09.2016.
 */
public class MainJIT16 {
    public static void AddMapVal(){
        Map<Integer, String> testMap = new HashMap<>();
        for(int i=0;i<100000;i++){
            testMap.put(i,"value = "+i);
        }
        System.out.println(testMap.size());
    }
    public static void main(String[] args) {
        MainJIT16.AddMapVal();
    }
}

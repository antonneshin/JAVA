package src.home.sbt.task_16;

/**
 * Created by Пентагон on 04.09.2016.
 */
public class TestGC {
    public static void main(String[] args) {
        /*Integer newObj, object=new Integer(1);
        while (true){
            newObj = new Integer(object);
            object=newObj;
        }*/
        Integer elem;
        while(true){
            elem = new Integer(777);
        }
    }
}

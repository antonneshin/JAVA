package src.home.sbt.home2508;

import java.util.concurrent.Callable;

/**
 * Created by Пентагон on 25.08.2016.
 */
public class Task<T> {
    private final Callable<? extends T> callable;
    private volatile T res;
    public Task(Callable<? extends T> call){
        callable=call;
        res=null;
    }

    public T get(){
        if (res==null){
            synchronized (this){
                if (res==null){
                    try {
                        res=callable.call();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Integer val=77;
        Task<Integer> t = new Task(()->{
            try{
                return Math.sqrt(val*1.0);
            } catch (Exception e){
                throw new CallableError("Incorrect value in task");
            }
        });
        System.out.println("result = "+t.get());
    }
}

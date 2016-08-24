package src.home.sbt.home2508;

/**
 * Created by Пентагон on 25.08.2016.
 */
public class CallableError extends RuntimeException{
    public CallableError(){
        super("Trow error");
    }
    public CallableError(String mes){
        super("Throw error with message: "+mes);
    }

}

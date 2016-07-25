package src.lesson2507;

/**
 * Created by Student on 25.07.2016.
 */
class Ok implements AutoCloseable {
    private String mes;
    public Ok(String mes)
    {
        this.mes=mes;
        System.out.println("it is - "+mes);
    }

    @Override
    public void close() throws Exception {
        System.out.println("all is free");
    }
}

public class MyAutoCloseable {
    public static void main(String[] args) throws Exception{
        try (Ok k=new Ok("k"); Ok z=new Ok("z")){
            System.out.println("task has been done!");
        }
    }
}

package src.lesson2207;

/**
 * Created by Student on 22.07.2016.
 */
public class A<T> {
    public A(){
    }
    public A(T param)
    {
        this.param1=param;
    }
    public T getParam1() {
        return param1;
    }

    public void setParam1(T param1) {
        this.param1 = param1;
    }

    T param1;
    public String getType()
    {
        return param1.getClass().getTypeName();
    }

}

package src.lesson2507;

import java.beans.VetoableChangeListener;

/**
 * Created by Student on 25.07.2016.
 */
class Engine
{
    void  startEngine()
    {
        System.out.println("Engine start");
    }
}

class Vehicle
{
    private Engine engine;

    public void setEngine(Engine engine) {
        this.engine = engine;
    }
    public void startEngine()
    {
        engine.startEngine();
    }
}

public class NPT {
    public static void main(String[] args)
    {
        Engine engine=new Engine();

        Vehicle car=new Vehicle();
        car.setEngine(engine);

        Vehicle bike=new Vehicle();
        bike.setEngine(engine);

        car.startEngine();
        bike.startEngine();

        System.out.println("All engines start");
    }
}

package src.lesson_19_1209;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Student on 12.09.2016.
 */
public class Client {
    public static void main(String[] args) {
        MeteoStation meteo = new MeteoStation();
        Observer cons = new ConsoleObserver();

        meteo.addObserver(cons);
        meteo.setData(23,444);
    }
}

interface Observable {
    void notifyObserver(int temp, int pres);
    void addObserver(Observer o);
    void removeObserver(Observer o);
}

interface Observer {
    void onChange(int temp, int pres);
}

class MeteoStation implements Observable{
    int temperature;
    int presure;
    List<Observer> observers = new ArrayList<>();

    void setData(int temp, int pres){
        this.temperature = temp;
        this.presure = pres;
        this.notifyObserver(temp, pres);
    }

    @Override
    public void notifyObserver(int temp, int pres) {
        for (Observer observer1 : observers){
            observer1.onChange(temp,pres);
        }
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }
}

class ConsoleObserver implements Observer{

    @Override
    public void onChange(int temp, int pres) {
        System.out.println("temp="+temp+"  pressure="+pres);
    }
}
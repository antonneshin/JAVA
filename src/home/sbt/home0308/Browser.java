package src.home.sbt.home0308;

/**
 * Created by Пентагон on 03.08.2016.
 */
public class Browser {
    public static void main(String[] args) {
        try {
            PluginManager pm = new PluginManager("");
            Plugin fp = pm.load("C:\\Users\\Пентагон\\Desktop\\JAVAnew\\src\\home\\sbt\\home0308", "src.home.sbt.home0308.FirstPlugin");
            fp.sayHello();
            Plugin sp = pm.load("C:\\Users\\Пентагон\\Desktop\\JAVAnew\\src\\home\\sbt\\home0308", "src.home.sbt.home0308.SecondPlugin");
            sp.sayHello();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

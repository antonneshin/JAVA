package src.home.sbt.home0308;

import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by Пентагон on 03.08.2016.
 */
public class PluginManager {
    private final String pluginRootDirectory;

    public PluginManager(String pluginRootDirectory) {
        this.pluginRootDirectory = pluginRootDirectory;
    }

    public Plugin load(String pluginName, String pluginClassName) throws Exception {
        Class<?> pluginClazz;
        try {
            URLClassLoader urlClassLoader = new URLClassLoader(new URL[]{new URL(pluginName/*"file:/J:/lecture7/person.jar"*/)}, null);
            pluginClazz = urlClassLoader.loadClass(pluginClassName/*"ru.sbt.bvv.lecture7.CalculatorImpl"*/);
        } catch (Exception e){
            pluginClazz=PluginManager.class.getClassLoader().loadClass(pluginClassName);
        }
        return (Plugin)pluginClazz.newInstance();
    }

}

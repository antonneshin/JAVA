package src.home.sbt.home2808;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Пентагон on 28.08.2016.
 */
public class InvocationHandlerImpl implements InvocationHandler {
    private final Object delegate;
    private ConcurrentHashMap<Integer, Integer> cache = new ConcurrentHashMap<>();

    public InvocationHandlerImpl(Object delegate) {
        this.delegate = delegate;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (cache.contains((Integer)args[0]))
            return cache.get((Integer)args[0]);
        Integer res=(Integer)method.invoke(delegate,args);
        cache.put((Integer)args[0],res);
        return method.invoke(delegate,args);
    }
}

package src.home.sbt.home2808;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Пентагон on 28.08.2016.
 */
public class InvocationHandlerImpl<T> implements InvocationHandler {
    private T obj;
    private ConcurrentHashMap<Integer, LockValC> cache = new ConcurrentHashMap<>();
    private Lock cacheLock = new ReentrantLock();

    public InvocationHandlerImpl(T paramObj) {
        this.obj = paramObj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        cacheLock.lock();
        Object key=args[0];
        System.out.println(Thread.currentThread().getName()+" locked the cache");
        if (cache.containsKey(key)){
            cacheLock.unlock();
            LockValC elem = cache.get(key);
            Lock valLock = elem.getLockVal();
            valLock.lock();
            Object val = elem.getVal();
            System.out.println("hello");
            System.out.println("val from cache="+val.toString()+"with key="+key.toString());
            valLock.unlock();
            System.out.println(Thread.currentThread().getName()+" unlocked the cache");
            return val;
        } else{
            LockValC newLV = new LockValC(new ReentrantLock());
            cache.put((Integer)key,newLV);
            newLV.getLockVal().lock();
            cacheLock.unlock();
            System.out.println(Thread.currentThread().getName()+" unlocked the cache");
            System.out.println(method.getName()+" working with args="+args[0].toString());
            Object val=method.invoke(obj,key);
            cache.get(key).setVal(val);
            newLV.getLockVal().unlock();
            System.out.println(Thread.currentThread().getName()+" counted val="+val+" with key"+key);
            return val;
        }
    }

    private static class LockValC{
        private Object val;
        private final Lock lockVal;

        private LockValC(Lock lockVal) {
            this.lockVal = lockVal;
        }

        public Object getVal() {
            return val;
        }

        public void setVal(Object val) {
            this.val = val;
        }

        public Lock getLockVal() {
            return lockVal;
        }
    }
}

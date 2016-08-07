package src.home.sbt.task0708.main;

import java.util.Iterator;

/**
 * Created by Пентагон on 07.08.2016.
 */
public class MyIter<T> implements Iterable<T> {
    private T[] elems;
    private int size=0;
    private int lastInd=0;
    public MyIter (int n){
        elems=(T[])new Object[n];
        size=n;
    }
    @Override
    public Iterator<T> iterator(){
        return new Iterator<T>() {
            int pos=-1;
            @Override
            public boolean hasNext() {
                return pos<size-1;
            }

            @Override
            public T next() {
                if (hasNext()){
                    pos++;
                    return elems[pos];
                }
                return null;
            }
        };
    }
    public void add(T elem){
        elems[lastInd]=elem;
        lastInd++;
    }

    public void show()
    {
        for (int i=0;i<size;i++)
        {
            System.out.println(elems[i]);
        }
    }

    public static void main(String[] args) {
        MyIter<Integer> arr= new MyIter<>(3);
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.show();
        Iterator c=arr.iterator();
        while (c.hasNext()){
            System.out.println(c.next());
        }
    }
}

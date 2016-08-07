package src.home.sbt.task2407;

import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * Created by Пентагон on 24.07.2016.
 */
public class MyLinkedList<T>{
    private int size;
    private Node<T> first;
    private Node<T> last;
    public class Node<T>
    {
        private T val;
        private Node<T> next;
        private Node<T> prev;
        private Node(Node<T> p, T v, Node<T> n)
        {
            prev=p;
            val=v;
            next=n;
        }
    }
    public MyLinkedList()
    {
        size=0;
        first=null;
        last=null;
    }
    public void add(T val)
    {
        if (this.size==0) {
            Node<T> newNode = new Node<>(null, val, null);
            this.first=newNode;
            this.last=newNode;
        }
        else
        {
            Node<T> newNode = new Node<>(this.last, val, null);
            this.last=newNode;
            this.last.prev.next=this.last;
        }
        this.size++;
    }
    public void add(int index,T val)
    {
        if (index>size-1)
        {
            System.out.println("Can't add value on that index!");
            return;
        }
        if ((this.size==0)&&(index==0)) {
            Node<T> newNode = new Node<>(null, val, null);
            this.first=newNode;
            this.last=newNode;
        }
        else
        {   if (this.size!=0)
            {
                if (index==0)
                {
                    Node<T> cur=this.first;
                    this.first=new Node<T>(null,val,cur);
                    cur.prev=this.first;
                    this.size++;
                    return;
                }
                if (index==size-1)
                {
                    Node<T> cur=this.last.prev;
                    Node<T> newNode=new Node<T>(cur,val,this.last);
                    cur.next=newNode;
                    this.last.prev=newNode;
                    this.size++;
                    return;
                }
                Node<T> cur=this.first;
                int curInd=0;
                while (curInd!=index)
                {
                    curInd++;
                    cur=cur.next;
                }
                if (curInd==index) {
                    cur=cur.prev;
                    Node<T> newNode = new Node<>(cur, val, cur.next);
                    cur.next.prev=newNode;
                    cur.next=newNode;
                }

            }
        }
        this.size++;
    }
    public void showList()
    {
        Node<T> cur=this.first;
        while (cur!=null)
        {
            System.out.println(cur.val);
            cur=cur.next;
        }
    }
    public void showListObrat()
    {
        Node<T> cur=this.last;
        while (cur!=null)
        {
            System.out.println(cur.val);
            cur=cur.prev;
        }
    }
    public T get (int index)
    {
        if (index>this.size-1)
            return null;
        int curInd=0;
        Node<T> cur=this.first;
        while(curInd!=index)
        {
            curInd++;
            cur=cur.next;
        }
        return cur.val;
    }
    public T remove(int index)
    {
        if (index>this.size-1)
            return null;
        if (index==0)
        {
            Node<T> cur=this.first;
            this.first=this.first.next;
            this.first.prev=null;
            this.size--;
            return cur.val;
        }
        if (index==this.size-1)
        {
            Node<T> cur=this.last;
            this.last=this.last.prev;
            this.last.next=null;
            this.size--;
            return cur.val;
        }
        int curInd=0;
        Node<T> cur=this.first;
        while (index!=curInd)
        {
            curInd++;
            cur=cur.next;
        }
        cur.prev.next=cur.next;
        cur.next.prev=cur.prev;
        this.size--;
        return cur.val;
    }

    public static void main(String[] args)
    {
        MyLinkedList<Integer> my=new MyLinkedList<>();
        my.add(1);
        my.add(2);
        my.add(3);
        System.out.println("ind="+0+" "+my.get(0));
        System.out.println("ind="+1+" "+my.get(1));
        my.showList();
        my.showListObrat();

        MyLinkedList<String> ms=new MyLinkedList<>();
        ms.add("one");
        ms.add("two");
        ms.add("three");
        ms.add(1,"zero");
        ms.add(0,"zero1");
        ms.add(4,"FIVE");
        ms.showList();
        System.out.println(ms.size);
        ms.showListObrat();

        System.out.println("udalen="+ms.remove(2));
        ms.showList();
        System.out.println(ms.size);
    }
}

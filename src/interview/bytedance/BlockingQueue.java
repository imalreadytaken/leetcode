package interview.bytedance;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueue<T> {

    private Node<T> head;
    private Node<T> tail;
    private Lock lock;
    private int maxSize;
    private int size;

    public BlockingQueue(int maxSize){
        this.maxSize = maxSize <= 0 ? Integer.MAX_VALUE : maxSize;
        this.head = new Node();
        this.tail = head;
        this.lock = new ReentrantLock();
        this.size = 0;
    }

    public void add(T val){
        lock.lock();
        while(size >= maxSize){
            lock.unlock();
            wait();
            lock.get();
        }
        tail.next = new Node(val);
        tail = tail.next;
        size++;
        lock.release();
    }

    public T get(){
        lock.get;
        if(head.next == null){
            lock.realease();
            return null;
        }
        T ret = head.next.val;
        head.next = head.next.next;
        size--;
        notifyAll();
        lock.release();
        return ret;
    }

    class Node<T>{
        Node next;
        T value;
        public Node(){
            this.next = null;
        }
        public Node(T val){
            this.value = val;
            this.next = null;
        }
    }

}
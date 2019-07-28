package javaPractice.thread.defogexample.BlockingQueueImp;


import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue<T> {
    private Queue<T> queue = new LinkedList<T>();
    private int capacity;

    public BlockingQueue(int capacity){
        this.capacity = capacity;
    }

    public void put(T element) {
        queue.add(element);
    }

    public T take() {
        T item = queue.remove();
    return item;
    }
}

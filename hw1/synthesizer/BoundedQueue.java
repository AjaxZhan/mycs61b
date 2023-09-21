package synthesizer;

import java.util.Iterator;

/**
 * @author Cagur
 * @version 1.0
 */
public interface BoundedQueue<T> extends Iterable<T>{
    int capacity(); // return the size of the buffer
    int fillCount(); // return numbers of the item currently in the buffer
    void enqueue(T x); // add item to back of queue
    T dequeue(); // delete and return item at the front of the queue
    T peek(); // return item at front of the queue
    Iterator<T> iterator();
    default boolean isEmpty(){
        return fillCount() == 0;
    }
    default boolean isFull(){
        return fillCount() == capacity();
    }

}

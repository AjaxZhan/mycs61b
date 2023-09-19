/**
 * @author Cagur
 * @version 1.0
 */
public class ArrayDeque<T>{
    /** Inner data struct to store data. */
    private T[] items;
    /** Size of the deque. */
    private int size;
    /** front index */
    private int front;
    /** last index */
    private int last;

    /** constructor for empty ArrayDeque*/
    public ArrayDeque(){
        items = (T[]) new Object[8];
        size = 0;
        front = 4;
        last = 4;
    }

    /** help function : index plus one. Condition : addLast*/
    private int plusOne(int index, int module){
        index %= module;
        if(index == module - 1){
            return 0;
        }
        return index  +  1;
    }

    /** help function : index minus one. Condition : addFirst*/
    private int minusOne(int index){
        if(index == 0){
            return capacity() - 1;
        }
        return index - 1;
    }

    /** resize array bigger*/
    private void grow(){
        T[] newItems = (T[])new Object[capacity()*2];
        int p1 = front;
        // new array's front
        int p2 = capacity();
        while(p1!=last){
            newItems[p2] = items[p1];
            p1 = plusOne(p1,capacity());
            p2 = plusOne(p2,capacity()*2);
        }
        front = capacity();
        last = p2;
        items = newItems;
    }
    /** resize array smaller*/
    private void shrink(){
        T[] newItems = (T[]) new Object[capacity()/2];
        int p1 = front;
        int p2 = capacity() / 4 ;
        while(p1!=last){
            newItems[p2] = items[p1];
            p1 = plusOne(p1,capacity());
            p2 = plusOne(p2,capacity()/2);
        }
        front = capacity() / 4;
        last = p2;
        items = newItems;
    }

    /** help function : get capacity*/
    private int capacity(){
        return items.length;
    }

    /**  Adds an item of type T to the front of the deque.*/
    public void addFirst(T item){
        if(size() == capacity()-1){
            grow();
        }
        front = minusOne(front);
        items[front] = item;
        size++;
    }

    /** Adds an item of type T to the back of the deque.*/
    public void addLast(T item){
        if(size() == capacity()-1){
            grow();
        }
        items[last] = item;
        last = plusOne(last,capacity());
        size++;
    }

    /** Returns true if deque is empty, false otherwise. */
    public boolean isEmpty(){
        return size == 0;
    }
    /**  Returns the number of items in the deque.*/
    public int size(){
        return size;
    }
    /**  Prints the items in the deque from first to last, separated by a space.*/
    public void printDeque(){
        for(int i =0;i<size();i++){
            System.out.print(get(i) + " ");
        }
    }
    /** Removes and returns the item at the front of the deque. If no such item exists, returns null.*/
    public T removeFirst(){
        if(capacity()>=16 && capacity() / size() >=4){
            shrink();
        }
        if(size() == 0){
            return null;
        }
        T res = items[front];
        front = plusOne(front,capacity());
        size -=1;
        return res;
    }
    /** Removes and returns the item at the back of the deque. If no such item exists, returns null.*/
    public T removeLast(){
        if(capacity() >= 16 && capacity() / size() >=4){
            shrink();
        }
        if(size() == 0){
            return null;
        }
        last = minusOne(last);
        size -= 1;
        return items[last];
    }
    /**  Gets the item at the given index. If no such item exists, returns null.*/
    /* use iteration */
    public T get(int index){
        if(index >= size){
            return null;
        }
        int p = front;
        for(int i = 0;i<index;i++){
            p = plusOne(p,capacity());
        }
        return items[p];
    }

}

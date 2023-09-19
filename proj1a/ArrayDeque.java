/**
 * @author Cagur
 * @version 1.0
 */
public class ArrayDeque<T>{
    private T[] items;
    private int size;
    private int front;
    private final double  FACTOR = 1.5;
    private final double UFACTOR = 0.25;

    public ArrayDeque(){
        items = (T[]) new Object[8];
        front = size = 0;
    }

    /** help function : get capacity*/
    private int capacity(){
        return items.length;
    }

    /** help function : calculate index of ring array . */
    private int getIndex(int i){
        return ( i + capacity()) % capacity();
    }

    /** help function : check if need shorten the array*/
    private void check(){
        System.out.println("size = " + size);
        System.out.println("capacity() = " + capacity());
        // 难点：如何找到新的front
        if((double)size() / capacity() < UFACTOR){
            T[] arr = (T[])new Object[capacity()/2 + 1];
            System.arraycopy(items,0,arr,0,size());
            items = arr;
        }
    }

    /** resize */
    private void resize(int cap){
        T[] arr = (T[])new Object[cap];
        System.arraycopy(items,0,arr,0,capacity());
        items = arr;
    }

    /**  Adds an item of type T to the front of the deque.*/
    public void addFirst(T item){
        if(size() == capacity()){
            resize((int)( capacity()* FACTOR));
        }
        front = getIndex(front-1);
        items[front] = item;
        size++;
    }

    /** Adds an item of type T to the back of the deque.*/
    public void addLast(T item){
        if(size() == capacity()){
            resize((int)( capacity()* FACTOR));
        }
        int rear = getIndex(front+size());
        items[rear] = item;
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
        int i = getIndex(front);
        for(int j = 0;j<size();j++){
            System.out.print(items[i]);
            System.out.print(' ');
            i = getIndex(i+1);
        }
    }
    /** Removes and returns the item at the front of the deque. If no such item exists, returns null.*/
    public T removeFirst(){
        if(size() == 0){
            return null;
        }
        check();
        T tmp = items[front];
        front = getIndex(front+1);
        size --;
        return tmp;
    }
    /** Removes and returns the item at the back of the deque. If no such item exists, returns null.*/
    public T removeLast(){
        if(size() == 0){
            return null;
        }
        check();
        int rear = getIndex(front+size()-1);
        T tmp = items[rear];
        size --;
        return tmp;
    }
    /**  Gets the item at the given index. If no such item exists, returns null.*/
    /* use iteration */
    public T get(int index){
        if(index >= size()){
            return null;
        }
        int i = getIndex(front+index);
        return items[i];
    }

    public static void main(String[] args) {

        ArrayDeque<Integer> ad = new ArrayDeque<>();
        for(int i=0;i<100;i++){
            ad.addLast(i);
        }
        System.out.println(ad.capacity());
        ad.printDeque();
        System.out.println();
        for(int i=0;i<99;i++){
            ad.removeFirst();
        }
        System.out.println(ad.capacity());
        ad.printDeque();

    }

}

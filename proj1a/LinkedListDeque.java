/**
 * @author Cagur
 * @version 1.0
 */
public class LinkedListDeque<T> {

    private class Node<T>{
        public Node prev;
        public T val;
        public Node next;
        public Node(T val, Node prev, Node next){
            this.prev = prev;
            this.val = val;
            this.next = next;
        }

        /** private helper function */
        private T getNodeRecursive(int index){
            if(index == 0){
                return val;
            }
            return (T) next.getNodeRecursive(index-1);
        }
    }

    private Node sentinel;
    private int size;

    public LinkedListDeque(){
        sentinel = new Node(28,null,null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    /**  Adds an item of type T to the front of the deque.*/
    public void addFirst(T item){
        sentinel.next.prev = new Node(item,sentinel,sentinel.next);
        sentinel.next = sentinel.next.prev;
        size +=1;
    }

    /** Adds an item of type T to the back of the deque.*/
    public void addLast(T item){
        sentinel.prev.next = new Node(item,sentinel.prev,sentinel);
        sentinel.prev = sentinel.prev.next;
        size +=1;
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
        Node tmp = sentinel.next;
        for(int i=0;i<size();i++){
            System.out.print(tmp.val);
            System.out.print(' ');
            tmp = tmp.next;
        }
    }
    /** Removes and returns the item at the front of the deque. If no such item exists, returns null.*/
    public T removeFirst(){
        if(isEmpty()){
            return null;
        }
        T val = (T)sentinel.next.val;
        sentinel.next.prev = sentinel;
        sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;
        size --;
        return val;
    }
    /** Removes and returns the item at the back of the deque. If no such item exists, returns null.*/
    public T removeLast(){
        if(isEmpty()){
            return null;
        }
        T tmp = (T)sentinel.prev.val;
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        size --;
        return tmp;
    }
    /**  Gets the item at the given index. If no such item exists, returns null.*/
    /* use iteration */
    public T get(int index){
        if(index >= size()){
            return null;
        }
        Node tmp = sentinel.next;
        T rVal = null;
        for(int i=0;i<size();i++){
            if(i == index){
                rVal = (T)tmp.val;
                break;
            }
            tmp = tmp.next;
        }
        return rVal;
    }
    /**  Gets the item at the given index. If no such item exists, returns null.*/
    /* use recursion */
    public T getRecursive(int index){
        if( index >= size){
            return null;
        }
        return (T)sentinel.next.getNodeRecursive(index);
    }

}

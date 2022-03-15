import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class LinkedList<T> {

    // Inner class for nodes
    private class Node<T>{
        T data;
        Node<T> next;
        public Node(T data){
            this.data = data; this.next = null;
        }
        void setNext(Node<T> n){
            next = n;
        }
        T getData(){
            return this.data;
        }
        private Node<T> getNext(){
            return next == null ? null : next;
        }
    }
    // End inner class

    // Size of linked list
    private int size;
    // Always first element of the list
    private Node<T> head;

    // Public constructor that takes one or more values to add to the list
    public LinkedList(T... values){
        Arrays.stream(values).forEach(this::push);
    }

    // Reverses the linked list
    void reverse(){
        Node<T> curr = head;
        Node<T> foll = null;
        Node<T> prev = null;
        while(curr != null){
            foll = curr.next;
            if(foll == null){
                head = curr;
            }
            curr.next = prev;
            prev = curr;
            curr = foll;
        }
    }

    // Returns the list as array using Reflection on the Array class
   T[] asArray(Class<T> c){
        T[] array;
        array = (T[]) Array.newInstance(c, size);
        int index = 0;
       while(this.hasNext()){
            array[index] = this.pop();
            index++;
       }
       return array;
   }

    int size(){
        return size;
    }

     // Removes the element at the back of the list
     T pop(){
        if(size < 1) throw new NoSuchElementException("LinkedList empty");
        size--;
        T data = head.getData();
        head = head.getNext();
        return data;
    }

    //Adds an item to the back of the list
    void push(T item){
        Node<T> n = new Node<>(item);
        size++;
        if(head == null){
            head = n;
        }else {
            n.setNext(head);
            head = n;
        }
    }

    // Checks if list is not empty
    boolean hasNext(){
        return size > 0;
    }



}

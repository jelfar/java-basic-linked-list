/**
  * BasicLinkedList.java
  *
  * Definition for a Doubley-Linked List.
  * Also contains an iterator.
  *
  * @author Jonathon Elfar jelfar jonathon.elfar@gmail.com
  * @version Sunday, June 2, 2013
  */
import java.util.*;
public class BasicLinkedList<E> implements BasicList<E>, java.lang.Iterable<E> {

    private Node<E> first, last;
    private int size;

    /**
      * Node class that represents elements in the Linked List.
      */
    private class Node<E> {
        public E data;
        public Node<E> next;
        public Node<E> prev;
    }
    
    
    /**
      * Constructor that instantiates the instance variables.
      */ 
    public BasicLinkedList(){
        first = null;
        last = null;
        size = 0;
    }

    public void add(E element){
        Node<E> newNode = new Node<E>();
        newNode.data = element;

        if(size == 0){
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            newNode.prev = last;
            last = newNode;
        }
        size++;
    }

    public void add(int index, E element){
        if((index < 0) || (index > size))
            throw new IndexOutOfBoundsException();

        if((size == 0) || (size == index))
            add(element);
        else{
            Node<E> temp = new Node<E>();
            temp.data = element;
            temp.next = first;

            int i = 0;
            while(i < index-1){
                temp.next = temp.next.next;
                i++;
            }
            
            //Adding to the front of list
            if(index == 0){
                first.prev = temp.next;
                temp.next = first;
                first = temp;
            } else if(index < size){ //Adding in middle
                Node<E> next = temp.next.next;
                temp.next.next = temp;
                temp.prev = temp.next;
                temp.next = next;
            }
            size++;
        }
    }

    public void clear(){
       first = null;
       last = null;
       size = 0;
    }

    public boolean contains(E element){
        if(size == 0)
            return false;

        Node<E> temp = new Node<E>();
        temp.next = first;
        int i = 0;
        while(i < size){
            if((temp.next.data == null) && (element == null))
                return true;
            if(temp.next.data.equals(element))
                return true;
            temp.next = temp.next.next;
            i++;
        }

        return false;
    }
    
    public E get(int index){
        if((index < 0) || (index >= size) || (first == null)){
            throw new IndexOutOfBoundsException();
        }

        Node<E> temp = new Node<E>();
        temp.next = first;
        int i = 0;
        while(i < index){
            temp.next = temp.next.next;
            i++;
        }

        return temp.next.data;
    }

    public int indexOf(E element){
        if(!contains(element)){
            throw new NoSuchElementException();
        }

        Node<E> temp = new Node<E>();
        temp.next = first;
        int i = 0;
        while(i < size){
            if((temp.next.data == null) && (element == null))
                return i;
            if(temp.next.data.equals(element))
                return i;
            temp.next = temp.next.next;
            i++;
        }

        return -1;
    }

    public E remove(int index){
        if((index < 0) || (index >= size) || (first == null))
            throw new IndexOutOfBoundsException();

        Node<E> temp = new Node<E>();
        temp.next = first;

        int i = 0;
        while(i < index){
            temp = temp.next;
            i++;
        }

        if(index == 0){
            if(size == 1){
               E element = temp.next.data;
               clear();
               return element;
            } else {
                E element = temp.next.data;
                first = temp.next.next;
                first.prev = null;
                size--;
                return element;
            }
        } else if (index == (size-1)) {
            E element = last.data;
            last = last.prev;
            last.next = null;
            size--;
            return element;
        } else {
            E element = temp.next.data;
            temp.next = temp.next.next;
            temp.next.prev = temp;
            size--;
            return element;
        }
    }

    public E set(int index, E element){
        if((index < 0) || (index >= size) || (first == null))
            throw new IndexOutOfBoundsException();

        Node<E> temp = new Node<E>();
        temp.next = first;

        int i = 0;
        while(i < index)
        {
            temp.next = temp.next.next;
            i++;
        }
        
        E e = temp.next.data;
        temp.next.data = element;
        return e;
    }

    public int size(){
        return size;
    }

    /**
      * Returns a reference to a unique instance of a private inner class implementing 
      * the BasicListIterator interface.
      *
      * @return                         An instance of a private inner class implementing
      *                                 the BasicListIterator interface.
      */
    public BasicListIterator<E> basicListIterator(){
        return new BasicIter();
    }

    /**
      * Returns an iterator over the list of elements of type E.
      *
      * @return                         An iterator over the list of elements.
      */
    public Iterator<E> iterator(){
        return new BasicIter();
    }

    //Inner class

    /**
      * BasicIter
      *
      * Inner class to implement the list iterator.
      *
      * @author Jonathon Elfar jelfar jonathon.elfar@gmail.com Section 3/4
      * @version Sunday, June 2, 2013
      */
    private class BasicIter implements BasicListIterator<E>{
        private Node<E> position;

        /**
          * Constructor that instantiates the instance variables.
          */ 
        public BasicIter(){
            position = null;
        }

        public boolean hasPrevious(){
            return (position != null);
        }

        public E previous(){
            if(!hasPrevious()){
                throw new NoSuchElementException();
            } else {
                E o = position.data;
                if(position.prev == null)
                    position = null;
                else
                    position = position.prev;

                return o;
            }
        }

        public boolean hasNext(){
            if (position == null)
                return first != null;
            else
                return position.next != null;
        }

        public E next(){
            if(!hasNext())
                throw new NoSuchElementException();

            if(position == null){
                position = first;
                return position.data;
            } else {
                position = position.next;
                return position.data;
            }
        }

        public void remove(){
            throw new UnsupportedOperationException();
        }

    }

}

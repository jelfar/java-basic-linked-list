/**
  * BasicList.java
  *
  * Definition for the Basic List Interface.
  *
  * @author Jonathon Elfar jelfar jonathon.elfar@gmail.com
  * @version Sunday, June 2, 2013
  */
public interface BasicList<E> {

    /**
      * Adds the specified element to the logical end of the list.
      *
      * @param element                  The element to add to the logical end of the list.
      */
    public void add(E element);

    /**
      * Adds (inserts) the specified element at the specified index of the list- note
      * that it does not overwrite any existing data at that location.
      *
      * @param index                    The index to add (insert) the specified element.
      * @param element                  The element to add (insert) to the specified position.
      * @throws IndexOutOfBoundsException When the specified index is negative or past the logical
      *                                   end of the list.
      */
    public void add(int index, E Element);

    /**
      * Clears the list of it's contents - the list should be in the same state it is
      * after being constructed with the default constructor.
      */
    public void clear();

    /**
      * Using the provided element's equals method, this method determines if the list contains
      * the specified element or not.
      *
      * @param element                  The element to search for in the list.
      * @return                         True if the list contains an element logically equal to
      *                                 the specified element, otherwise false.
      */
    public boolean contains(E element);
    
    /**
      * Returns a reference to the element at the specified index.
      *
      * @param index                    The index of the element you want to get.
      * @return                         The element at the specified index.
      * @throws IndexOutOfBoundsException Thrown when the specified index is negative or past
      *                                   the logical end of the list.
      */
    public E get(int index);

    /**
      * Using the provided element's equals method, this method returns the index of the 
      * first element in the list that is equal to the provided element, if any.
      *
      * @param element                  The element to search for.
      * @return                         The index of the first matching element in the list.
      * @throws NoSuchElementException  If the list does not contain the specified element.
      */
    public int indexOf(E element);

    /**
      * Removes (and returns) the specified element from the list.
      *
      * @param index                    The index of the element you want to remove.
      * @return                         The element that was removed from the list.
      * @throws IndexOutOfBoundsException Thrown when the specified index is negative or
      *                                   past the logical end of the list.
      */
    public E remove(int index);

    /**
      * Replaces the element at the specified index with the specified element.
      *
      * @param index                    The index of the element whose value you want to set
      *                                 (change).
      * @return                         The old element (before you changed it) at the specified index.
      * @throws IndexOutOfBoundsException Thrown when the specified index is negative or
      *                                   past the logical end of the list.
      */
    public E set(int index, E element);

    /**
      * The logical size of the list (the number of elements that have been added or not removed).
      *
      * @return                         The number of elements currently in the list.
      */
    public int size();
}

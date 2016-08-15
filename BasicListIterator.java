/**
  * BasicListIterator.java
  *
  * Definition for a Basic List Iterator.
  *
  * @author Jonathon Elfar jelfar jonathon.elfar@gmail.com
  * @version Sunday, June 2, 2013
  */
public interface BasicListIterator<E> extends java.util.Iterator<E> {

    /**
      * Returns true if the iterator has a previous element.
      *
      * @return                     True if the iterator has a previous element,
      *                             otherwise false.
      */
    public boolean hasPrevious();

    /**
      * Returns the previous element and moves the iterator backward one
      * position with O(1) performance.
      *
      * @return                     The previous element.
      * @throws NoSuchElementException  if there is no previous element.
      */
    public E previous();
}

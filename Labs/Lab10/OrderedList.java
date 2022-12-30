import java.util.NoSuchElementException;

public class OrderedList implements OrderedStructure {

    // Implementation of the doubly linked nodes (nested-class)

    private static class Node {

      	private Comparable value;
      	private Node previous;
      	private Node next;

      	private Node ( Comparable value, Node previous, Node next ) {
      	    this.value = value;
      	    this.previous = previous;
      	    this.next = next;
      	}
    }

    // Instance variables

    private Node head;

    // Representation of the empty list.

    public OrderedList() {
      head = null;
    }

    // Calculates the size of the list

    public int size() {
      Node h = head;
      int c = 0;

      while (h != null)	{
        h = h.next;
        c++;
      }
      return c;
    }


    public Object get( int pos ) {
        if (pos < 0 || pos > size()) {
          throw new IndexOutOfBoundsException(Integer.toString(pos));
        }
        Node p = head;
        for (int i = 0; i < pos; i++) {
          if (p == null) {
            throw new IndexOutOfBoundsException(Integer.toString(pos));
          }
          else {
            p = p.next;
          }
        }
        return p.value;
    }

    // Adding an element while preserving the order

    public boolean add( Comparable o ) {
      if ( o == null ) {
        throw new IllegalArgumentException( "null" );
      }
      if ( head == null ) {
        head = new Node( o, null, null );
      }
      else if ( head.value.compareTo(o) >= 0 ) {
        head = new Node( o, null, head );head.next.previous = head;
      }
      else {
        Node p = head;
        while ( p.next != null && p.next.value.compareTo( o ) < 0 ) {
          p = p.next;
        }
        Node q = p.next; p.next = new Node( o, p, q );q.previous = p.next;
      }
      return true;
    }

    //Removes one item from the position pos.

    public void remove( int pos ) {
      if (pos < 0 || pos > size ()) {
        throw new IndexOutOfBoundsException(Integer.toString(pos));
      }
      Node cur = head;
      for (int i = 0; i <= pos; i++) {
        if (cur.next == null) {
          throw new IndexOutOfBoundsException(Integer.toString(pos));
        }
        cur = cur.next;
      }
      head = head.next;
      head.previous = null;
      cur.value = null;
      cur.next =null;
    }

    // Knowing that both lists store their elements in increasing
    // order, both lists can be traversed simultaneously.

    public void merge( OrderedList other ) {
      Node p = head;
      Node q = other.head;

      while (q != null) {
        if (p == null) {
          head = new Node (q.value, null, null);
          p = head;
          q = q.next;
        }
        else if (q.value.compareTo(p.value) < 0) {
          if (p == head) {
            head = new Node (q.value, p.previous, p);
            p.previous = head;
          }
          else {
            p.previous.next = new Node (q.value, p.previous, p);
            p.previous = p.previous.next;
          }
          q = q.next;
        }
        else if (p.next == null) {
          p.next = new Node (q.value, p, null);
          p = p.next;
          q = q.next;
        }
        else {
          p = p.next;
        }
      }
    }
}

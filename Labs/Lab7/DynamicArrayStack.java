public class DynamicArrayStack<E> implements Stack<E> {

    // Instance variables

    private E[] elems;  // Used to store the elements of this ArrayStack
    private int top;    // Designates the first free cell
    private static final int DEFAULT_INC = 25;   //Used to store default increment / decrement

    @SuppressWarnings( "unchecked" )

    // Constructor
    public DynamicArrayStack( int capacity ) {
        elems =  (E[]) new Object[DEFAULT_INC];
        top = 0;

    }

    // Gets current capacity of the array
    public int getCapacity() {
        return elems.length;
    }

    // Returns true if this DynamicArrayStack is empty
    public boolean isEmpty() {
        return ( top == 0 );
    }

    // Returns the top element of this ArrayStack without removing it
    public E peek() {
      if (isEmpty() == true) {
          throw new  java.util.EmptyStackException();
      }
      else {
        return elems[ top-1 ];
      }
    }

    @SuppressWarnings( "unchecked" )

    // Removes and returns the top element of this stack
    public E pop() {
      if (isEmpty() == true) {
          throw new  java.util.EmptyStackException();
      }
      else {
        E saved;
        top--;
        saved = elems[top];
        elems[top] = null;
        if (elems.length != DEFAULT_INC) {
          E[] n;
          n =  (E[]) new Object[DEFAULT_INC];
          for (int i = 0; i < top; i++){
            n[i] = elems[i];
          }
          elems = n;
        }
      return saved;
      }
    }

    @SuppressWarnings( "unchecked" )

    // Puts the element onto the top of this stack.
    public void push( E element ) {
        elems[top] = element;
        top++;
        if (elems.length - top == 0) {
          E[] n;
          n =  (E[]) new Object[elems.length + DEFAULT_INC];
          for (int i = 0; i < top; i++){
            n[i] = elems[i];
          }
          elems = n;
        }
    }

    @SuppressWarnings( "unchecked" )

    public void clear() {
        for (int i = 0; i < top; i++) {
          elems[i] = null;
        }
        top = 0;
        elems =  (E[]) new Object[DEFAULT_INC];
    }

}

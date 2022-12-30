public class FullStackException extends RuntimeException{

  public FullStackException() {
    this ("The stack is full and no elements can be added to the stack");
  }

  public FullStackException(String exception) {
    super (exception);
  }
}

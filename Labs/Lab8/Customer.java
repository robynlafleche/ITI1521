import java.util.Random;

public class Customer {

  private static final int MAX_NUM_ITEMS = 25;

  private int arrivalTime;
  private int initialNumberOfItems;
  private int numberOfItems;

  public Customer(int arrivalTime) {
    Random generator;
    generator = new Random();
    this.arrivalTime = arrivalTime;
    numberOfItems = generator.nextInt(MAX_NUM_ITEMS - 1) + 1;
    initialNumberOfItems = numberOfItems;
  }

  public int getArrivalTime() {
    return arrivalTime;
  }

  public int getNumberOfItems() {
    return numberOfItems;
  }

  public int getNumberOfServedItems() {
    return initialNumberOfItems - numberOfItems;
  }

  public void serve() {
    numberOfItems--;
  }
}

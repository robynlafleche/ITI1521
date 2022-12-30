public class Cashier {

    private Queue queue;
    private Customer currentCustomer;
    private int totalCustomerWaitTime;
    private int customersServed;
    private int totalItemsServed;

    public Cashier () {
        queue = new ArrayQueue<Customer>();
        customersServed = 0;
        totalItemsServed = 0;
        totalCustomerWaitTime = 0;
    }

    public void addCustomer(Customer c) {
      queue.enqueue (c);
    }

    public int getQueueSize() {
      return queue.size();
    }

    public void serveCustomers(int currentTime) {
      if (currentCustomer == null && queue.isEmpty()) {
        return;
      }
      if (currentCustomer == null && queue.isEmpty() != true) {
        currentCustomer = (Customer) queue.dequeue();
        totalCustomerWaitTime += currentTime - currentCustomer.getArrivalTime();
        customersServed += 1;
      }
      currentCustomer.serve();
      if (currentCustomer.getNumberOfItems() == 0) {
        totalItemsServed = currentCustomer.getNumberOfServedItems() + totalItemsServed;
        currentCustomer = null;
      }
    }

    public int getTotalCustomerWaitTime() {
      return totalCustomerWaitTime;
    }

    public int getTotalCustomersServed() {
      return customersServed;
    }

    public int getTotalItemsServed() {
      return totalItemsServed;
    }

    public String toString() {
      String res;

      res = "The total number of customers served is " + customersServed;
      res += System.lineSeparator();
      res += "The average number of items per customer was " + (totalItemsServed/customersServed);
      res += System.lineSeparator();
      res += "The average waiting time (in seconds) was " + totalCustomerWaitTime/customersServed;

      return res;
    }
}

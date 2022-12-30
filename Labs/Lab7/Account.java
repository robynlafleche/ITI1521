public class Account {

  private double balance;

  public Account() {
    this.balance = 0;
  }

  public double getBalance() {
    return balance;
  }

  public void deposit(double amount) {
    balance += amount;
    System.out.println("New balance is: " + amount + "$");
  }

  public void withdraw(double amount) {
    if (amount > balance) {
      throw new NotEnoughMoneyException(amount, balance);
    }
    else {
      balance -= amount;
      System.out.println("New balance is: " + amount + "$");
    }
  }
}

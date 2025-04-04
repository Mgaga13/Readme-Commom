package SRP;


interface PaymentProcessor {

  void processPayment(double amount);
}

class CreditCardProcessor implements PaymentProcessor {

  @Override
  public void processPayment(double amount) {
    System.out.println("Processing credit card payment of $" + amount);
  }
}

class CashProcessor implements PaymentProcessor {

  @Override
  public void processPayment(double amount) {
    System.out.println("Processing cash payment of $" + amount);
  }
}

abstract class Order {

  protected double amount;

  protected PaymentProcessor processor;

  public Order() {
  }

  public Order(double amount, PaymentProcessor processor) {
    this.amount = amount;
    this.processor = processor;
  }

  public void processPayment() {
    processor.processPayment(amount);
  }
}

class OnlineOder extends Order {

  public OnlineOder(double amount, PaymentProcessor processor) {
    super(amount, processor);
  }
}

class InStoreOrder extends Order {

  public InStoreOrder(double amount, PaymentProcessor paymentProcessor) {
    super(amount, paymentProcessor);
  }
}

class Main {

  public static void main(String[] args) {
    Order order = new OnlineOder(1000, new CreditCardProcessor());
    order.processPayment();
    Order orderLocal = new InStoreOrder(5000, new CashProcessor());
    orderLocal.processPayment();
  }
}
















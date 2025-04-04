interface Notifier {
    void notify(String message);
}

class EmailNotifier implements Notifier {
    @Override
    public void notify(String message) {
        System.out.println("Sending email: " + message);
    }
}

class SMSNotifier implements Notifier {
    @Override
    public void notify(String message) {
        System.out.println("Sending SMS: " + message);
    }
}

class OrderProcessor {
    private final int orderId;
    private final Notifier notifier;

    public OrderProcessor(int orderId, Notifier notifier) {
        this.orderId = orderId;
        this.notifier = notifier;
    }

    public void processOrder() {
        System.out.println("Processing order " + orderId);
        notifier.notify("Order " + orderId + " has been processed");
    }
}

class Main {
    public static void main(String[] args) {
        Notifier emailNotifier = new EmailNotifier();
        Notifier smsNotifier = new SMSNotifier();

        OrderProcessor orderProcessorEmail = new OrderProcessor(123, emailNotifier);
        orderProcessorEmail.processOrder();

        OrderProcessor orderProcessorSms = new OrderProcessor(456, smsNotifier);
        orderProcessorSms.processOrder();
    }
}
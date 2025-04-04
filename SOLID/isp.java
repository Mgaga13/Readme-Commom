interface Placeable {
    void placeOrder();
}
interface Cancelable {
    void cancelOrder();
}
interface Trackable {
    void trackOrder();
}
interface Refundable {
    void refundOrder();
}

class InStoreOrder implements Placeable, Cancelable {
    @Override
    public void placeOrder() {
        System.out.println("Placing in-store order");
    }

    @Override
    public void cancelOrder() {
        System.out.println("Cancelling in-store order");
    }
}

class OnlineOrder implements Placeable, Cancelable, Trackable, Refundable {
    @Override
    public void placeOrder() {
        System.out.println("Placing online order");
    }

    @Override
    public void cancelOrder() {
        System.out.println("Cancelling online order");
    }

    @Override
    public void trackOrder() {
        System.out.println("Tracking online order");
    }

    @Override
    public void refundOrder() {
        System.out.println("Refunding online order");
    }
}
class Main {
    public static void main(String[] args) {
        InStoreOrder inStoreOrder = new InStoreOrder();
        inStoreOrder.placeOrder();

        OnlineOrder onlineOrder = new OnlineOrder();
        onlineOrder.placeOrder();
        onlineOrder.trackOrder();  
    }
}
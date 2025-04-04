package SRP;


import java.util.UUID;

interface ItemEncoder {
  String encode(Item item);
}

class JsonItemEncoder implements ItemEncoder {

  @Override
  public String encode(Item item) {
    return "{ \"id\": \"" + item.getId() + "\", \"price\": " + item.getPrice() + " }";
  }
}

class HtmlItemEncoder implements ItemEncoder {
  @Override
  public String encode(Item item) {
    return "<div><h2>" + item.getSpec().getName() + "</h2><p>Price: $" + item.getPrice() + "</p></div>";
  }
}

class XMLItemEncoder implements ItemEncoder {

  @Override
  public String encode(Item item) {
    return "<item><id>" + item.getId() + "</id><price>" + item.getPrice() + "</price></item>";
  }
}

class ItemSpec {
  String name;
  String color;
  String type;

  public ItemSpec(String name, String color, String type) {
    this.name = name;
    this.color = color;
    this.type = type;
  }

  //Elasticsearch
  public boolean isCompare(ItemSpec itemSpec){
    return this.name.equals(itemSpec.name)
        && this.type.equals(itemSpec.type)
        && this.color.equals(itemSpec.color);
  }

  public String getName() {
    return name;
  }

  public String getColor() {
    return color;
  }

  public String getType() {
    return type;
  }
}
class Item {
  private UUID id;
  private ItemSpec spec;
  private String imageUrl;
  private int quantity;
  private float price;
  public Item(){}
  public Item(UUID id, ItemSpec spec, String imageUrl, int quantity, float price) {
    this.id = id;
    this.spec = spec;
    this.imageUrl = imageUrl;
    this.quantity = quantity;
    this.price = price;
  }

  public UUID getId() {
    return id;
  }

  public ItemSpec getSpec() {
    return spec;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public int getQuantity() {
    return quantity;
  }

  public float getPrice() {
    return price;
  }

  public boolean setPrice(float price) {
    if(price < 0) return false;
    this.price = price;
    return true;
  }
  public boolean incrementQuantity(int amount){
    if(quantity < 0) return false;
    this.quantity += amount;
    return true;
  }

  public boolean decrementQuantity(int amount){
    if(quantity < 0) return false;
    this.quantity -= amount;
    return true;
  }
}

class ItemPresenter {
  private final ItemEncoder encoder;

  public ItemPresenter(ItemEncoder encoder) {
    this.encoder = encoder;
  }

  public void display(Item item) {
    String output = encoder.encode(item);
    System.out.println(output);
  }
}

class Main{
  public static void main(String[] args) {
    Item item = new Item(UUID.randomUUID(), new ItemSpec("ocp","Yellow","book"), "imageUrl", 10, 100.0f);
    ItemPresenter presenter = new ItemPresenter(new JsonItemEncoder());
    presenter.display(item);

    presenter = new ItemPresenter(new HtmlItemEncoder());
    presenter.display(item);

    presenter = new ItemPresenter(new XMLItemEncoder());
    presenter.display(item);
  }
}
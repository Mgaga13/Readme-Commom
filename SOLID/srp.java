package SRP;

import java.util.UUID;

class ItemSpec {
  String name;
  String color;
  String type;

  //Elasticsearch
  public boolean isCompare(ItemSpec itemSpec){
    return this.name.equals(itemSpec.name)
        && this.type.equals(itemSpec.type)
        && this.color.equals(itemSpec.color);
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
  public boolean saveDB(String path){
    return true ;
  }

  public String toJson(){
    return '{"id":' + id + ',"spec":' + spec + ',"imageUrl":' + imageUrl + ',"quantity":' + quantity + ',"price":' + price + '}';
  }

  public String toHTML(){
    String html = """
        <html>
        <head></head>
        <body></body>
        </html>
        """;
    return html;
  }

}

class Main{

  public static void main(String[] args) {

  }
}


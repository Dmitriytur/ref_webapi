package ua.nure.tur.testapi.entity;


public class Product{

    private int id;
    private String name;
    private int price;
    private int shopId;

    public Product(){}

    public Product(int id, String name, int price, int shopId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.shopId = shopId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }
}

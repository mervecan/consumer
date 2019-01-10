package models;

public class Product {
    private String productId;
    private String name;
    private String definition;
    private String price;

    public Product() {

    }

    public Product(String productId, String name, String definition, String price) {
        this.productId = productId;
        this.name = name;
        this.definition = definition;
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", name='" + name + '\'' +
                ", definition='" + definition + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}

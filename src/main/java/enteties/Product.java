package enteties;

public class Product {
    private String productName;
    private double price;
    private Long id;
    private Courency courency;




    public Product() {}


    public Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Courency getCourency() {
        return courency;
    }

    public void setCourency(Courency courency) {
        this.courency = courency;
    }


    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", price=" + price + '\'' +
                ", Id=" + id +
                ", currancy=" + courency +
                '}';
    }


}

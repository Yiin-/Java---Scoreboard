package lt.klpvm.jv18.janonis_stanislovas;

/**
 * Created by Stanislovas on 2016-02-24.
 */
public class Product {
    private int price;
    private float discount;
    private String type;

    public Product(int price, float discount) {
        this.price = price;
        this.discount = discount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

package lt.klpvm.jv18.janonis_stanislovas;

/**
 * Created by Stanislovas on 2016-02-25.
 */
public class Purchase {
    private Product product;
    private int amount;

    public Purchase(Product product, int amount) {
        this.product = product;
        this.amount = amount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}

package lt.klpvm.jv18.janonis_stanislovas;

import java.util.ArrayList;

/**
 * Created by Stanislovas on 2016-02-24.
 */
public class Customer {
    private ArrayList<Purchase> cart;
    private String date;

    public Customer(String date) {
        this.cart = new ArrayList<>();
        this.date = date; // new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
    }

    public ArrayList<Purchase> getCart() {
        return cart;
    }

    public void addToCart(Purchase cart) {
        this.cart.add(cart);
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

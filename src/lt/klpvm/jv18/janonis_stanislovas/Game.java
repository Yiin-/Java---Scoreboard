package lt.klpvm.jv18.janonis_stanislovas;

/**
 * Created by Stanislovas on 2016-02-24.
 */
public class Game extends Product {
    private String name;

    public Game(String name) {
        super(0, 0.0f);

        this.name = name;
    }

    public Game(String name, int price, float discount) {
        super(price, discount);

        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

package lt.klpvm.jv18.janonis_stanislovas;

/**
 * Created by Stanislovas on 2016-02-24.
 */
public class Extension extends Product {
    private Game game = null;
    private String name;

    public Extension() {
        super(0, 0.0f);
    }

    public Extension(Game game, String name, int price, float discount) {
        super(price, discount);

        this.game = game;
        this.name = name;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

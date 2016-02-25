package lt.klpvm.jv18.janonis_stanislovas;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.function.Consumer;

public class Main {

    protected static ArrayList<String> dataFiles = new ArrayList<String>() {{
        add("data/customers1.dat");
        add("data/customers2.dat");
    }};
    protected static String output = "data/output.txt";

    public static void main(String[] args) throws IOException {
        HashMap<String, Game> games = new HashMap<>();
        HashMap<String, Extension> extensions = new HashMap<>();
        HashMap<String, Customer> customers = new HashMap<>();

        for(String file : dataFiles) {
            Scanner in = new Scanner(new FileReader(new File(file)));

            read(games, extensions, customers, in);

            in.close();
        }
        PrintWriter out = new PrintWriter(new FileWriter(new File(output)));

        write(customers, out);

        out.close();
    }

    protected static void write(HashMap<String, Customer> customers, PrintWriter out) {
        int total_price = 0;

        for(String key : customers.keySet()) {
            Customer customer = customers.get(key);

            out.println(customer.getDate() + ":");

            int price = 0;

            for(Purchase purchase : customer.getCart()) {
                switch(purchase.getProduct().getType()) {
                    case "game": {
                        Game game = (Game)purchase.getProduct();

                        int item_price = Math.round((purchase.getAmount() * game.getPrice()) * (100.0f - game.getDiscount()) / 100.0f);

                        price += item_price;

                        String line = "\t" + purchase.getAmount() + "x " + game.getName() + " for " + (item_price / 100) + "." + (item_price % 100) + "EUR";
                        out.println(line);
                        break;
                    }
                    case "extension": {
                        Extension extension = (Extension)purchase.getProduct();

                        int item_price = Math.round((purchase.getAmount() * extension.getPrice()) * (100.0f - extension.getDiscount()) / 100.0f);

                        price += item_price;

                        String line = "\t" + purchase.getAmount() + "x " + extension.getName() + " (" + extension.getGame().getName() + ") for " + (item_price / 100) + "." + (item_price % 100) + "EUR";
                        out.println(line);
                        break;
                    }
                }
            }
            out.println("Total price: " + (price / 100) + "." + (price % 100) + "EUR");
            out.println("");

            total_price += price;
        }
        out.println("Sum: " + (total_price / 100) + "." + (total_price % 100) + "EUR");
    }

    protected static void read(
            HashMap<String, Game> games,
            HashMap<String, Extension> extensions,
            HashMap<String, Customer> customers,
            Scanner in
    ) {
        while(in.hasNext()) {
            String [] parts = in.nextLine().split(", ");

            String date = parts[0];
            String type = parts[1];
            int amount = Integer.parseInt(parts[2]);
            String name = parts[3];

            Product product = null;

            switch(type) {
                case "game": {
                    int price = Integer.parseInt(parts[4]);
                    float discount = Float.parseFloat(parts[5]);

                    if(games.containsKey(name)) {
                        Game game = games.get(name);

                        game.setPrice(price);
                        game.setDiscount(discount);

                        product = game;
                    }
                    else {
                        Game game = new Game(name, price, discount);
                        games.put(name, game);

                        product = game;
                    }

                    break;
                }
                case "extension": {
                    Extension extension = new Extension();

                    extension.setName(parts[4]);

                    int price = Integer.parseInt(parts[5]);
                    float discount = Float.parseFloat(parts[6]);

                    extension.setPrice(price);
                    extension.setDiscount(discount);

                    if(games.containsKey(name)) {
                        extension.setGame(games.get(name));
                    }
                    else {
                        Game game = new Game(name);
                        games.put(name, game);

                        extension.setGame(game);
                    }

                    product = extension;

                    break;
                }
            }

            if(product != null) {
                product.setType(type);

                Purchase purchase = new Purchase(product, amount);
                Customer customer;

                if(customers.containsKey(date)) {
                    customer = customers.get(date);
                }
                else {
                    customer = new Customer(date);
                    customers.put(date, customer);
                }
                customer.addToCart(purchase);
            }
        }
    }
}

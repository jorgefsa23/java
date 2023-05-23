import java.util.ArrayList;
import java.util.List;

/**
 * The CoffeeFlavors class contains a list of available flavors and its unit prices, initialized in the constructor.
 * The listFlavors method prints the available flavors and prices to the console.
 * The getFlavor method returns the flavor name corresponding to a given option.
 * The getPrice method returns the unit price of a flavor corresponding to a given option.
 */
public class CoffeeFlavors {
    private List<String> flavors;
    private List<Double> prices;

    public CoffeeFlavors() {
        flavors = new ArrayList<>();
        prices = new ArrayList<>();

        flavors.add("Regular");
        prices.add(1.0);
        flavors.add("Decaf");
        prices.add(1.2);
        flavors.add("Cappuccino");
        prices.add(2.0);
        flavors.add("Latte");
        prices.add(2.2);
    }

    public void listFlavors() {
        System.out.println("Here are the available flavors:");
        for (int i = 0; i < flavors.size(); i++) {
            System.out.println((i + 1) + ". " + flavors.get(i) + " - $" + prices.get(i));
        }
    }

    public String getFlavor(int option) {
        return flavors.get(option - 1);
    }

    public double getPrice(int option) {
        return prices.get(option - 1);
    }
}


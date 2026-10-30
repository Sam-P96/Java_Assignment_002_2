package Task_2_2_3;

import javax.sound.midi.SysexMessage;
import java.util.HashMap;
import java.util.TreeSet;

public class GroceryListManager {
    private HashMap<String, Double> groceryList = new HashMap<>();
    private HashMap<String, String> itemCategory = new HashMap<>();

    public void addItem(String item, double price, String category) {
        groceryList.put(item, price);
        itemCategory.put(item, category);
        System.out.println("Added " + item + " at " + price);
        System.out.println("Added " + item + " in " + category);
    }

    public void removeItem(String item) {
        if (groceryList.containsKey(item)) {
            groceryList.remove(item);
            itemCategory.remove(item);
            System.out.println("Removed \"" + item + "\" from the list.");
        } else {
            System.out.println("\"" + item + "\" was not in the list.");
        }
    }

    /* will not make a for loop list, cus this is easier to read in testing.*/
    public void displayList() {
        System.out.println(groceryList.toString());
    }

    public boolean checkItem(String x) {
        System.out.println("Checking if " + x + " is in this lies:");
        return groceryList.containsKey(x);
    }

    /*like dictionary and set, no index, uses keys*/
    public double calculateTotalCost() {
        double totalCostDollars = 0.0;
        for (double price : groceryList.values()) {
            totalCostDollars += price;
        }
        return totalCostDollars;
    }

    public void displayByCat() {
        System.out.println("Printing Items By Category: ");
        TreeSet<String> catSet = new TreeSet<>();


        for (String cat : itemCategory.values()) {
            System.out.println("Added to set: " + cat);
            catSet.add(cat);
            }

        for (String cat : catSet) {
            System.out.println(cat);
            for (String iKey : itemCategory.keySet()) {
                if (itemCategory.get(iKey) == cat) {
                    System.out.println(iKey + ": " + groceryList.get(iKey));
                }
            }
        }
    }

    public static void main(String[] args) {
        GroceryListManager kevin = new GroceryListManager();

        kevin.addItem("Sam", 1.00, "Human");
        kevin.addItem("Sam2", 2.49, "Not Human");
        kevin.addItem("Sam2", 6.7, "Not Human"); /*oh shit, this changes teh value, not adds.. guess it makes sense cus its like dictionary*/
        kevin.addItem("Sam3", 1.99, "Not Human");
        kevin.addItem("Potato Man", 33.3, "Potato Human");

        System.out.println(kevin.checkItem("Sam3"));

        kevin.displayList();

        System.out.println(kevin.checkItem("Sam3"));

        kevin.removeItem("Sam2");

        kevin.displayList();

        System.out.println("Total Cost: " + kevin.calculateTotalCost());

        kevin.displayByCat();
    }
}

package Task_2_2_2;

import java.util.HashMap;

public class GroceryListManager {
    private HashMap<String, Double> groceryList = new HashMap<>();

    public void addItem(String item, double price) {
        groceryList.put(item, price);
        System.out.println("Added " + item + " at " + price);
    }

    public void removeItem(String item) {
        if (groceryList.containsKey(item)) {
            groceryList.remove(item);
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

    public static void main(String[] args) {
        GroceryListManager kevin = new GroceryListManager();

        kevin.addItem("Sam", 1.00);
        kevin.addItem("Sam2", 2.49);
        kevin.addItem("Sam2", 6.7); /*oh shit, this changes teh value, not adds.. guess it makes sense cus its like dictionary*/
        kevin.addItem("Sam3", 1.99);

        System.out.println(kevin.checkItem("Sam3"));

        kevin.displayList();

        System.out.println(kevin.checkItem("sam3"));

        kevin.removeItem("Sam");

        kevin.displayList();

        System.out.println("Total Cost: " + kevin.calculateTotalCost());
    }
}

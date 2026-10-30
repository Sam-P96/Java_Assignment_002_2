package Task_2_2_4;

import java.util.HashMap;
import java.util.TreeSet;

public class GroceryListManager {
    private HashMap<String, Double> groceryList = new HashMap<>();
    private HashMap<String, String> itemCategory = new HashMap<>();
    private HashMap<String, Integer> itemQuantity = new HashMap<>();



    public void addItem(String item, double price, String category, int quanity) {
        groceryList.put(item, price);
        itemCategory.put(item, category);
        itemQuantity.put(item, quanity);
//        System.out.println("Added " + quanity + " "+ item + " at " + price);
//        System.out.println("Added " + item + " in " + category);
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

    /* will not make a for loop list, cus this is easier to read in testing .*/
    public void displayList() {
        System.out.println(groceryList.toString());
    }

    public boolean checkItem(String x) {
        System.out.println("Checking if " + x + " is in this lies:");
        return groceryList.containsKey(x);
    }

    /*like dictionary and set, no index, uses keys*/
//    public double calculateTotalCost() {
//        double totalCostDollars = 0.0;
//        for (double price : groceryList.values()) {
//            totalCostDollars += price;
//        }
//        return totalCostDollars;
//    }

    public double calculateTotalCost() {
        double totalCostDollars = 0.0;
        for (String iKey : groceryList.keySet()) {
            totalCostDollars += groceryList.get(iKey) * itemQuantity.get(iKey);
        }
        return totalCostDollars;
    }

    public void displayByCat() {
        System.out.println("Printing Items By Category: ");
        TreeSet<String> catSet = new TreeSet<>();


        for (String cat : itemCategory.values()) {
//            System.out.println("Added to set: " + cat);
            catSet.add(cat);
            }

        for (String cat : catSet) {
            System.out.println("");
            System.out.println(cat);
            for (String iKey : itemCategory.keySet()) {
                if (itemCategory.get(iKey) == cat) {
                    System.out.println(iKey + ": " + groceryList.get(iKey) + " [" + itemQuantity.get(iKey) + "]");
                }
            }
        }
    }

    public void displayAvailableItem() {
        System.out.println("");
        System.out.println("All Available Items: ");
        for (String iKey : groceryList.keySet()) {
            if (itemQuantity.get(iKey) > 0) {
                System.out.println(iKey + ": " + groceryList.get(iKey) + " [" + itemQuantity.get(iKey) + "]");
            }
        }
    }

    public void updateQuantity(String key, int newQ) {
        this.addItem(key, groceryList.get(key), itemCategory.get(key), newQ);
    }

    public void displayByCategory(String item) {
        System.out.println("Showing specifially: " + item);
        for (String iKey : itemCategory.keySet()) {
            if (itemCategory.get(iKey) == item) {
                System.out.println(iKey);
            }

        }
    }

    public static void main(String[] args) {
        GroceryListManager kevin = new GroceryListManager();

        kevin.addItem("Sam", 100000, "Human", 2);
        kevin.addItem("Sam11111", 100000, "Human", 2);
        kevin.addItem("Sam22222", 100000, "Human", 2);
        kevin.addItem("Sam2", 2, "Not Human", 3);
        kevin.addItem("Sam3", 6.7, "Not Human", 4);
        kevin.addItem("Sam3", 1.99, "Not Human", 55); /* confirming it just writes over, not like add, and stuff*/
        kevin.addItem("Potato Man", 33.10, "Potato Human", 2);
//
//        System.out.println(kevin.checkItem("Sam3"));
//
        kevin.displayList();
        System.out.println("");
//
//        System.out.println(kevin.checkItem("Sam3"));
//
//        kevin.removeItem("Sam2");

        System.out.println("UPDATE STUFF:");
        kevin.updateQuantity("Sam3", 3);
        kevin.updateQuantity("Sam", 0);

//        kevin.displayList();



//
        System.out.println("");
        kevin.displayByCat();

        kevin.displayAvailableItem();

        System.out.println("");
        System.out.println("Total Cost: " + kevin.calculateTotalCost());


        System.out.println("");
        System.out.println("");
        System.out.println("This was missing in Task 3 cus I misunderstood the task and I accidentally did task 5 in task 4 cus I didnt know that was the next question. Was just having fun.");
        kevin.displayByCategory("Human");
    }
}



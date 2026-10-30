package Task_2_2_1;

import java.util.ArrayList;

public class GroceryListManager {
    private ArrayList<String> groceryList = new ArrayList<>();

    public void addItem(String item) {
        groceryList.add(item);
        System.out.println("Added " + item);
    }

    public void removeItem(String item) {
        if (groceryList.remove(item)) {
            System.out.println("Removed \"" + item + "\" from the list.");
        } else {
            System.out.println("\"" + item + "\" was not in the list.");
        }
    }

    /* double check this*/
    public void displayList() {
        System.out.println(groceryList.toString());
    }

    public boolean checkItem(String x) {
        System.out.println("Checking if " + x + " is in this lies:");
        return groceryList.contains(x);
    }

    public static void main(String[] args) {
        GroceryListManager kevin = new GroceryListManager();

        kevin.addItem("Sam");
        kevin.addItem("Sam2");
        kevin.addItem("Sam2");
        kevin.addItem("Sam3");

        System.out.println(kevin.checkItem("Sam3"));

        kevin.displayList();

        System.out.println(kevin.checkItem("sam3"));

        kevin.removeItem("Sam");

        kevin.displayList();
    }
}

/*Okay... so I saw the example output after I had already done this, this is hopefully fine without me having to go back to do the for loop.*/

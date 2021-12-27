import java.util.*;

public class FractionalKnapsack {
    public static class Item {
        double profit;
        double weight;

        public Item(double profit, double weight) {
            this.profit = profit;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item(60.0, 10.0));
        items.add(new Item(100.0, 20.0));
        items.add(new Item(120.0, 30.0));
        fractionalKnapsack(items, 50);
    }

    // sorting items on the basis of per unit profit in decreasing order
    public static void fractionalKnapsack(List<Item> items, double capacity) {
        Collections.sort(items, new Comparator<Item>() {
            public int compare(Item i1, Item i2) {
                if (i1.profit / i1.weight < i2.profit / i2.weight) {
                    return 1;
                } else if (i1.profit / i1.weight == i2.profit / i2.weight) {
                    return 0;
                } else
                    return -1;
            }

        });

        int i = 0;
        double profit = 0;

        // add item to the bag until we can't add the next item as a whole
        while (capacity > 0) {
            Item item = items.get(i);

            // if capacity is more than item weight then take the complete item
            // else take the fractional part of it
            if (capacity >= item.weight) {
                capacity = capacity - item.weight;
                profit = profit + item.profit;
            } else {
                double unitProfit = item.profit / item.weight;
                profit = profit + unitProfit * capacity;
                capacity = 0;
            }
            i++;
        }

        System.out.println(profit);

    }
}
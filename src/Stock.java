import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Stock {

    private List<Item> items;

    public Stock() {
        this.items = new ArrayList<>(Arrays.asList(
                new Item("iPhone X", 1500),
                new Item("Samsung Galaxy S7", 600),
                new Item("Google Pixel", 1400)
        ));
    }

    public void addItem(Item newItem) {
        items.add(newItem);
    }

    public boolean deleteItem(String itemId) {
       return items.remove(findItemById(itemId));
    }

    public void replaceItemById(String itemId, Item newItem) throws Exception {
        items.set(items.indexOf(findItemById(itemId)), newItem);
    }

    public void displayStock() {
        System.out.println(String.format("%-8s\t%-20s\t%-10s", "ID", "NAME", "PRICE"));
        System.out.println(String.format("%-8s\t%-20s\t%-10s", "--", "----", "-----"));
        for (Item item : items) {
            System.out.println(item);
        }
    }

    public Item findItemById(String itemId) {
        for (Item item : items) {
            if (item.getId().equalsIgnoreCase(itemId)) {
                return item;
            }
        }
        return null;
    }

    public Item findItemByPriceRange(double minPrice, double maxPrice) {
        for (Item item : items) {
            if (item.getPrice() < maxPrice & item.getPrice() > minPrice) {
                return item;
            }
        }
        return null;
    }

    public Item findItemByName(String itemName) {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null;
    }

    /* JAVA 8 */
    public void displayStock8() {
        items.forEach(System.out::println);
    }

    public Item findItemById8(String itemId) {
        return items.stream()
                .filter(item -> item.getId().equalsIgnoreCase(itemId))
                .findFirst()
                .orElse(null);
    }

    public Item findItemByName8(String itemName) {
        return items.stream()
                .filter(item -> item.getName().equalsIgnoreCase(itemName))
                .findFirst()
                .orElse(null);
    }

    public Item findItemByPriceRange8(double minPrice, double maxPrice) {
        return items.stream()
                .filter(item -> item.getPrice() > minPrice & item.getPrice() < maxPrice)
                .findFirst()
                .orElse(null);
    }

    public void deleteItemById8(String itemId) {
        items.removeIf(item -> item.getId().equalsIgnoreCase(itemId));
    }

    public void replaceItemById8(List<Item> stock, String itemId, Item newItem) throws IndexOutOfBoundsException {
        stock.set(
                stock.indexOf(stock.stream().filter(item ->
                        item.getId().equalsIgnoreCase(itemId)).findFirst().orElse(null)
                ),
                newItem
        );
    }
    /*~ JAVA 8 ~*/
}

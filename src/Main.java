import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Stock stock = new Stock();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMenu();

            System.out.println("Choose an options: ");
            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    findItemById(stock, scanner);
                    break;
                case "2":
                    addItemToStock(stock, scanner);
                    break;
                case "3":
                    deleteItemById(stock, scanner);
                    break;
                case "4":
                    updateItemById(stock, scanner);
                    break;
                case "5":
                    findItemByName(stock, scanner);
                    break;
                case "6":
                    findItemByPriceRange(stock, scanner);
                    break;
                case "7":
                    stock.displayStock();
                    break;
                case "8":
                    System.exit(0);
                default:
                    System.err.println("Not an option!");

            }

        }
    }

    private static void displayMenu() {
        StringBuilder menuBuilder = new StringBuilder();
        menuBuilder
                .append("\n1. Find item by id.")
                .append("\n2. Add item to stock.")
                .append("\n3. Delete item by id.")
                .append("\n4. Update item by id.")
                .append("\n5. Find item by name.")
                .append("\n6. Find item by sales price range.")
                .append("\n7. Display stock.")
                .append("\n8. Exit.");

        System.out.println(menuBuilder);
    }

    private static void findItemById(Stock stock, Scanner scanner) {
        System.out.println("Enter item's id: ");
        String itemId = scanner.nextLine();

        Item item = stock.findItemById(itemId);
        System.out.println(item != null ? "Found item [" + item + "]" : "Item not found!");
    }

    private static void addItemToStock(Stock stock, Scanner scanner) throws NumberFormatException {
        try {
            System.out.println("Enter item's name: ");
            String itemName = scanner.nextLine();

            System.out.println("Enter item's price: ");
            double itemPrice = scanner.nextDouble();
            stock.addItem(new Item(itemName, itemPrice));

        } catch (NumberFormatException ex) {
            System.err.println("Invalid price entry!");
        }
    }

    private static void deleteItemById(Stock stock, Scanner scanner) {
        System.out.println("Enter item's id: ");
        String itemId = scanner.nextLine();

        System.out.println(stock.deleteItem(itemId)
                ? "Item of id '" + itemId + "' removed from stock"
                : "Could not remove item " + itemId + "; item does not exist");
    }

    private static void updateItemById(Stock stock, Scanner scanner) {
        try {
            System.out.println("Enter item's id: ");
            String itemId = scanner.nextLine();

            System.out.println("Enter new item");
            System.out.println("name: ");
            String itemName = scanner.nextLine();

            System.out.println("price: ");
            double itemPrice = scanner.nextDouble();

            stock.replaceItemById(itemId, new Item(itemName, itemPrice));
            System.out.println("Item of id '" + itemId + "' was updated successfully!");

        } catch (NumberFormatException ex) {
            System.err.println("Invalid price entry!");
        } catch (Exception ex) {
            System.err.println("Could not update item");
        }
    }

    private static void findItemByName(Stock stock, Scanner scanner) {
        System.out.println("Enter item's name: ");
        String itemName = scanner.nextLine();

        Item item = stock.findItemByName(itemName);
        System.out.println(item != null ? "Found item [" + item + "]" : "Item not found!");
    }

    private static void findItemByPriceRange(Stock stock, Scanner scanner) {
        try {
            System.out.println("Enter min price: ");
            double minPrice = scanner.nextDouble();

            System.out.println("Enter max price: ");
            double maxPrice = scanner.nextDouble();

            Item item = stock.findItemByPriceRange(minPrice, maxPrice);
            System.out.println(item != null ? "Found item [" + item + "]" : "Item not found!");

        } catch (NumberFormatException ex) {
            System.out.println("Invalid price entry!");
        }
    }


}

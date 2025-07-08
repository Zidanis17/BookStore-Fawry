public class Test {

    //Assumptions:
    // Tests are not required in a specific way, like Junit for example;
    // displayInventory function was added for ease of testing as I will need to display the inventory a lot;
    // E-books have infinite stock meaning they're always available;

    public static void testAddBooks() {
        QuantumBookstore store = new QuantumBookstore();
        System.out.println("Test: Adding books");
        System.out.println("===========================================");
        System.out.println("Inventory Before:");
        store.displayInventory();
        System.out.println("===========================================");

        store.addBook(new PaperBook("123", "Himothy Book", 2023, 25.0, 10));
        store.addBook(new EBook("456", "Herothy Book", 2024, 15.0, "PDF"));
        store.addBook(new ShowcaseBook("789", "Himothy Herothy Book", 2025));

        System.out.println("===========================================");
        System.out.println("Inventory After:");
        store.displayInventory();
        System.out.println("===========================================");
    }

    public static void testBuyPaperBook() {
        QuantumBookstore store = new QuantumBookstore();
        System.out.println("Test: Buy paper book");
        System.out.println("===========================================");

        store.addBook(new PaperBook("123", "Himothy Book", 2023, 25.0, 10));
        System.out.println("===========================================");

        try {
            store.buyBook("123", 2, "student@guc.edu.eg", "123 Main St");
            System.out.println("Paper book purchased successfully\n");
        } catch (Exception e) {
            System.out.println("Failed: " + e.getMessage() + "\n");
        }
        System.out.println("===========================================");

    }

    public static void testBuyEBook() {
        QuantumBookstore store = new QuantumBookstore();
        System.out.println("Test: Buy ebook");
        System.out.println("===========================================");
        store.addBook(new EBook("456", "Herothy Book", 2024, 15.0, "PDF"));
        System.out.println("===========================================");


        try {
            store.buyBook("456", 1, "student@guc.edu.eg", "");
            System.out.println("EBook purchased successfully\n");
        } catch (Exception e) {
            System.out.println("Failed: " + e.getMessage() + "\n");
        }
        System.out.println("===========================================");

    }

    public static void testBuyShowcaseBook() {
        QuantumBookstore store = new QuantumBookstore();

        System.out.println("Test: Try to buy showcase book (should fail as Showcase books are not for sale)");
        System.out.println("===========================================");
        store.addBook(new ShowcaseBook("789", "Himothy Herothy Book", 2025));
        System.out.println("===========================================");

        try {
            store.buyBook("789", 1, "failure@yahoo.com", "");
            System.out.println("This should have failed!\n");
        } catch (IllegalArgumentException e) {
            System.out.println("Correct error caught:\n" + e.getMessage());
        } catch (Exception e) {
            System.out.println("Wrong exception caught: " + e.getMessage() + "\n");
        }
        System.out.println("===========================================");

    }

    public static void testInsufficientStock() {
        QuantumBookstore store = new QuantumBookstore();

        System.out.println("Test: Try to buy more than available stock (should fail as you can't buy more than what is in stock)");
        System.out.println("===========================================");
        store.addBook(new PaperBook("123", "Himothy Book", 2023, 25.0, 10));
        System.out.println("===========================================");


        try {
            store.buyBook("123", 20, "notHimothy@kofta.com", "himothy's address");
            System.out.println("This should have failed!\n");
        } catch (IllegalArgumentException e) {
            System.out.println("Correct error caught\n" + e.getMessage());
        } catch (Exception e) {
            System.out.println("Wrong exception caught: " + e.getMessage() + "\n");
        }
    }

    public static void testRemoveOldBooks() {
        QuantumBookstore store = new QuantumBookstore();

        System.out.println("Test: Remove old books");
        System.out.println("===========================================");

        store.addBook(new PaperBook("123", "Himothy Book", 2023, 25.0, 10));
        store.addBook(new EBook("456", "Herothy Book", 2024, 15.0, "PDF"));
        store.addBook(new ShowcaseBook("789", "Himothy Herothy Book", 2025));
        store.addBook(new PaperBook("OLD1", "Old Himothy Book", 2010, 10.0, 5));
        System.out.println("===========================================");

        System.out.println("Before removing old books:");
        store.displayInventory();
        System.out.println("===========================================");

        store.removeOutDatedBooks(10); // Remove books older than 10 years
        System.out.println("===========================================");

        System.out.println("After removing old books:");
        store.displayInventory();
        System.out.println("===========================================");


    }

    public static void main(String[] args) {
        testRemoveOldBooks();

        //To test just put the function you want to test in here
    }
}

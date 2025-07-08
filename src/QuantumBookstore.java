import java.util.*;


public class QuantumBookstore {
    private List<Book> inventory;

    public QuantumBookstore() {
        this.inventory = new ArrayList<>();
    }


    public void addBook(Book book) {
        inventory.add(book);
        System.out.println(book.getTitle() + " was added to the inventory");
    }

    public void removeBook(Book book) {
        inventory.remove(book);
        System.out.println(book.getTitle() + " was removed from the inventory");
    }


    public List<Book> removeOutDatedBooks(int yearsOld) {
        int currentYear = java.time.Year.now().getValue();
        int cutoffYear = currentYear - yearsOld;

        ArrayList<Book> outdatedBooks = new ArrayList<>();
        for (Book book : inventory) {
            if (book.getPublicationYear() < cutoffYear) {
                outdatedBooks.add(book);
            }
        }

        inventory.removeAll(outdatedBooks);
        System.out.println("Removed " + outdatedBooks.size() + " outdated books (older than " + yearsOld + " years)");

        for (Book book : outdatedBooks) {
            System.out.println(book.getTitle() + " removed from the inventory");
        }

        return outdatedBooks;
    }

    public Book getBookByISBN(String isbn) {
        for (Book book : inventory) {
            if (book.getIsbn().equals(isbn)){
                return book;
            }
        }
        return null;
    }


    public double buyBook(String isbn, int quantity, String email, String address){ // buyBook is double return type as it is written as Return the paid amount in the pdf, just in case

        Book book = getBookByISBN(isbn);

        if (book == null) {
            throw new IllegalArgumentException("Book with isbn " + isbn + " was not found");
        }

        if (!book.isAvailable(quantity)){
            throw new IllegalArgumentException("Not enough stock for " + book.getTitle());

        }

        if(!book.isForSale()){
            throw new IllegalArgumentException(book.getTitle() + " is not for sale");
        }

        if (book instanceof PaperBook){
            PaperBook paperBook = (PaperBook) book;

            paperBook.reduceStock(quantity);
        }


        double totalPrice = book.getPrice() * quantity;

        book.processOrder(quantity, email,address);

        System.out.printf("Purchase successful! Total: $%.2f\n", totalPrice);

        if (book instanceof PaperBook) {
            System.out.println("Remaining stock for '" + book.getTitle() + "': " + ((PaperBook) book).getStock());
        }

        return totalPrice;
        //just in case as Return the paid amount in the pdf

    }


    public void displayInventory(){
        for (Book book : inventory) {
            System.out.println(book.getTitle());
        }
    }




}
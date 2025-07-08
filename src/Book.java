public abstract class Book {
    private String isbn;
    private String title;
    private int publicationYear;
    private double price;


    public Book(String isbn, String title, int publicationYear, double price) {
        this.isbn = isbn;
        this.title = title;
        this.publicationYear = publicationYear;
        this.price = price;
    }



    public String getIsbn() {
        return isbn;

    }

    public String getTitle() {
        return title;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public double getPrice() {
        return price;
    }

    public abstract void processOrder(int quantity, String email, String address);
    public abstract boolean isForSale();
    public abstract boolean isAvailable(int quantity);



}

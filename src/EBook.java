public class EBook extends Book {
    private String fileType;

    public EBook(String isbn, String title, int publicationYear, double price, String fileType) {
        super(isbn, title, publicationYear, price);
        this.fileType = fileType;
    }

    public String getFiletype() {
        return fileType;
    }

    @Override
    public void processOrder(int quantity, String email, String address) {
        MailService.send(this,email);
    }

    @Override
    public boolean isForSale() {
        return true;
    }

    @Override
    public boolean isAvailable(int quantity) {
        return true;
    }


}

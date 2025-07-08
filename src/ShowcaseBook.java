public class ShowcaseBook extends Book {

    public ShowcaseBook(String isbn, String title, int publicationYear) {
        super(isbn, title, publicationYear, 0);
    }


    @Override
    public void processOrder(int quantity, String email, String address) {
        throw new UnsupportedOperationException("Showcase/DemoBooks books are not for sale!");
    }

    @Override
    public boolean isForSale() {
        return false;
    }

    @Override
    public boolean isAvailable(int quantity) {
        return false;
    }



}

public class PaperBook extends Book{
    private int stock;

    public PaperBook(String isbn, String title, int publicationYear, double price, int stock){
        super(isbn, title,publicationYear,price);
        this.stock = stock;
    }

    public int getStock(){
        return stock;
    }

    public void setStock(int stock){
        if(stock < 0){
            throw new IllegalArgumentException("Cannot set stock to a negative number");
        }
        this.stock = stock;
    }

    @Override
    public void processOrder(int quantity, String email, String address){
        ShippingService.send(this, quantity, address);
    }

    @Override
    public boolean isForSale() {
        return true;
    }

    @Override
    public boolean isAvailable(int quantity) {
        if (this.getStock() >= quantity){
            return true;
        }
        return false;


    }


    public void reduceStock(int quantity) {
        this.setStock(this.getStock() - quantity);
    }

}

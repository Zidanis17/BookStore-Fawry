class ShippingService {
    public static void send(Book book, int quantity, String address) {
        System.out.println("Shipping " + quantity + "x '" + book.getTitle() + "' to: " + address);
    }
}
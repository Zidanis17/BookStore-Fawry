class MailService {
    public static void send(Book book, String email) {
        System.out.println("Sending ebook '" + book.getTitle() + "' to: " + email);
    }
}
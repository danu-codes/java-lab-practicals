package onlinelibrarysystem;

public class OnlineLibrarySystem {

    public static void main(String[] args) {
        Book book1 = new Book(1001, "George of the jungle", "George", 1500.00, 10);
        User user1 = new User(1, "Raj");

        Library library = new Library();
        library.addBook(book1);
        library.addUser(user1);
        library.displayDetails();
    }
}

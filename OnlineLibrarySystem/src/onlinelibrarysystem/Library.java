package onlinelibrarysystem;

public class Library {

    private Book[] books = new Book[3];
    private User[] users = new User[2];
    private int bookIndex = 0, userIndex = 0;

    public void addBook(Book book) {
        if (bookIndex < books.length) {
            books[bookIndex++] = book;
        } else {
            System.out.println("No space for more books!");
        }
    }

    public void addUser(User user) {
        if (userIndex < users.length) {
            users[userIndex++] = user;
        } else {
            System.out.println("No space for more users!");
        }
    }

    public void displayDetails() {
        System.out.println("=== Books ===");
        for (int index = 0; index < bookIndex; index++) {
            books[index].displayDetails();
            System.out.println();
        }
        System.out.println("=== Users ===");
        for (int index = 0; index < userIndex; index++) {
            users[index].displayDetails();
            System.out.println();
        }
    }
}

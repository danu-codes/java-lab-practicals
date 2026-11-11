
package onlinelibrarysystem;

public class Book {
     private int bookId;
     private String title, author;
     private double price;
     private int stockQuantity;
     private static int bookCount = 0;
    
     //constructor
     Book(int bookId, String title, String author, double price, int stockQuantity)
     {
         this.bookId = bookId;
         this.title = title;
         this.author = author;
         this.price = price;
         this.stockQuantity = stockQuantity;
         
         bookCount++;
     }
     
     //get
     public int getBookId()
     {
         return bookId;
     }
     public String getTitle()
     {
         return title;
     }
     public String getAuthor()
     {
         return author;
     }
     public double getPrice()
     {
         return price;
     }
     public int getStockQuantity()
     {
         return stockQuantity;
     }
     public static int getbookCount()
     {
         return bookCount;
     }
     
     //set
     public void setBookId(int bookId)
     {
         this.bookId = bookId;
     }
     public void setTitle(String title)
     {
         this.title = title;
     }
     public void setAuthor(String author)
     {
         this.author = author;
     }
     public void setPrice(double price)
     {
         this.price = price;
     }
     public void setStockQuantity(int stockQuantity)
     {
         this.stockQuantity = stockQuantity;
     }

     public void displayDetails()
     {
         System.out.println("Book ID    : " + bookId);
         System.out.println("Book Name  : " + title);
         System.out.println("Author     : " + author);
         System.out.println("Price      : " + price);
         System.out.println("Stock      : " + stockQuantity);
     }
}

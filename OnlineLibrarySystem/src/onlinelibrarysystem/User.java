
package onlinelibrarysystem;

public class User {
     private int userID;
     private String name;
     private int borrowedBooksCount;
     private static int userCount;
    
    //constructor;
    User(int userID, String name)
    {
        this.userID = userID;
        this.name = name;
        this.borrowedBooksCount = 0;
        
        userCount++;
        
    }
    
    //get
    public int getUserId()
    {
        return userID;
    }
    public String getName()
    {
        return name;
    }
    public  int getBorrowedBooksCount()
    {
        return borrowedBooksCount;
    }
    public  static int userCount()
    {
        return userCount;
    }
    
    //set
    public void setUserId(int userID)
    {
        this.userID = userID;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public void setBorrowedBooksCount(int borrowedBooksCount)
    {
        this.borrowedBooksCount = borrowedBooksCount;
    }

    public void displayDetails()
    {
        System.out.println("User ID    : " + userID);
        System.out.println("User Name  : " + name);
        System.out.println("Borrowed   : " + borrowedBooksCount);
    }
    
}

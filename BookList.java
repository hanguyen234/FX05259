import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class BookList {
    List<Book> myBooks = new ArrayList<>();
    public static int numRange(int min, int max, String message) {
        Scanner input = new Scanner(System.in);
        boolean isNum = true;
        int num = 0;
        do {
            if (input.hasNextInt()) {
                num = input.nextInt();
                if (num >= min && num <= max) {
                    isNum = false;
                } else {
                    System.out.println("(---It's outside the range " + min + " to " + max + " , retype---)");
                    System.out.print(message);
                }
            } else {
                input.next();
                System.out.println("(---Not a Number or Integer, retype---)");
                System.out.print(message);
            }
        } while (isNum);
        return num;
    }

    public void add() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter information for the new book:");

        System.out.print("ID: ");
        String id = input.nextLine();

        System.out.print("Title: ");
        String title = input.nextLine();

        System.out.print("Author: ");
        String author = input.nextLine();

        System.out.print("Is borrowed (1 = yes, 0 = no): ");
        int choice = numRange(0, 1, "Is borrowed (1 = yes, 0 = no): ");
        boolean isBorrowed = false;
        if (choice == 1) {
            isBorrowed = true;
        }
        addToList(id.toUpperCase(), title, author, isBorrowed);
        System.out.println("A new book has been added");
    }

    public void addToList(String id, String title, String author, Boolean isBorrowed) {
        Book book = new Book(id.toUpperCase(), title, author, isBorrowed);
        myBooks.add(book);
    }

    public void search() {
        Scanner input = new Scanner(System.in);
        List<Book> booksFound = new ArrayList<>();
        System.out.println("Enter book title to search.");
        System.out.print("Book title: ");
        String searchKey = input.nextLine();
        for (Book book : myBooks) {
            if (book.getTitle().contains(searchKey)) {
                booksFound.add(book);
            }
        }
        if (booksFound.isEmpty()){
            System.out.println("No book is found");
        } else {
            System.out.println(String.format("%-10s%-20s%-20s%-20s", "Id", "Title", "Author", "isBorrowed"));
            for (Book book : booksFound) {
                System.out.println(book.toString());
            }
        }
    }

    public void display () {
        System.out.println(String.format("%-10s%-20s%-20s%-20s", "Id", "Title", "Author", "isBorrowed"));
        for (Book book : myBooks) {
            System.out.println(book.toString());
        }
    }

    public void borrow() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter book ID to borrow:");
        System.out.print("Book ID: ");
        String searchKey = input.nextLine();
        for (Book aBook : myBooks) {
            if (aBook.getId().equalsIgnoreCase(searchKey)) {
                if (aBook.getBorrowed().equals(true)) {
                    System.out.println("You can not borrow this book. The book has been borrowed");
                    return;
                } else {
                    aBook.setBorrowed(true);
                    System.out.println("You have successfully borrow the book " + aBook.getTitle());
                }
            }
        }
    }

    public static boolean isExit = true;
    public void exit() {
        isExit = false;
    }
}

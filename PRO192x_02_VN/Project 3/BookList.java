// class chua danh sach cac sach va cac phuong thuc xu ly
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class BookList {
    // ArrayList chua sach da duoc them
    List<Book> myBooks = new ArrayList<>();
    // ham lay gia tri so nguyen trong gioi han
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
    // phuong thuc nhap thong tin ve sach
    public void add() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter information for the new book:");
        System.out.print("ID: ");
        boolean isEqualId = true;
        String id;
        do {
            id = input.nextLine();
            // kiem tra Id cua sach nhap vao co trung nhau khong
            for (Book book : myBooks) {
                if (book.getId().equalsIgnoreCase(id)) {
                    System.out.println("(---ID already exists---)");
                    System.out.print("ID: ");
                    isEqualId = true;
                    break;
                } else {
                    isEqualId = false;
                }
            }
            if (myBooks.isEmpty()) {
                isEqualId = false;
            }
        } while (isEqualId);

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
    // phuong thuc them sach vao ArrayList
    public void addToList(String id, String title, String author, Boolean isBorrowed) {
        Book book = new Book(id.toUpperCase(), title, author, isBorrowed);
        myBooks.add(book);
    }
    // phuong thuc tim sach trong ArrayList
    public void search() {
        Scanner input = new Scanner(System.in);
        List<Book> booksFound = new ArrayList<>(); // chua cac sach duoc tim thay
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
    // hien thi thong tin tat ca cac sach
    public void display () {
        System.out.println(String.format("%-10s%-20s%-20s%-20s", "Id", "Title", "Author", "isBorrowed"));
        for (Book book : myBooks) {
            System.out.println(book.toString());
        }
    }
    // phuong thuc muon sach theo id
    public void borrow() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter book ID to borrow:");
        System.out.print("Book ID: ");
        String searchKey = input.nextLine();
        // duyet qua tung cuon sach trong ArrayList
        for (Book aBook : myBooks) {
            // neu id sach giong voi id nhap
            if (aBook.getId().equalsIgnoreCase(searchKey)) {
                // neu sach da duoc muon
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

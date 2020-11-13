public class Manager {
    public static void main(String[] args) {
        BookList bookList = new BookList();
        System.out.println("Welcome to the online book library");
        int choice;
        while (BookList.isExit) {
            System.out.println("-------------------");
            System.out.println("1. Enter a new book");
            System.out.println("2. Search a book by book title");
            System.out.println("3. Display books");
            System.out.println("4. Borrow a book by book id");
            System.out.println("5. Exit");
            System.out.print("Your choice: ");
            choice = BookList.numRange(1, 5, "Your choice: ");
            if (choice == 1) {
                bookList.add();
            } else if (choice == 2) {
                bookList.search();
            } else if (choice == 3) {
                bookList.display();
            } else if (choice == 4) {
                bookList.borrow();
            } else {
                bookList.exit();
            }
        }
    }
}


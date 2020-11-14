// Dinh nghia cac thuoc tinh cua sach
public class Book {
    private String id;
    private String title;
    private String author;
    private Boolean isBorrowed;
    // ham constructor
    public Book (String id, String title, String author, Boolean isBorrowed) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isBorrowed = isBorrowed;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Boolean getBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean isBorrowed) {
        this.isBorrowed = isBorrowed;
    }

    /*
    public void setTitle() {
        this.title = title;
    }
     */

    /*
    public void setId(String id) {
        this.id = id;
    }
     */

    @Override
    public String toString() {
        return String.format("%-10s%-20s%-20s%-20b", id, title, author, isBorrowed);
    }
}

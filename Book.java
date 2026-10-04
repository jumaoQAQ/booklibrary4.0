package entity;

import java.time.LocalDateTime;

public class Book {
    private String isbn;
    private String name;
    private String author;
    private double price;
    private boolean isBorrowed=false;
    private LocalDateTime borrowTime;

    public String getBorrowUserName() {
        return borrowUserName;
    }

    public void setBorrowUserName(String borrowUserName) {
        this.borrowUserName = borrowUserName;
    }

    private String borrowUserName;

    public Book(){}

    public Book(String isbn, String name, String author, double price) {
        this.isbn = isbn;
        this.name = name;
        this.author = author;
        this.price = price;
    }



    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

    public LocalDateTime getBorrowTime() {
        return borrowTime;
    }

    public void setBorrowTime(LocalDateTime borrowTime) {
        this.borrowTime = borrowTime;
    }
    @Override
    public String toString(){
        if(isBorrowed){

            return "entity.Book{"+"isbn="+isbn+
                    ",name="+name+
                    ",author="+author+
                    ",price="+price+
                    ",isBorrowed="+isBorrowed+
                    ",borrowTime="+borrowTime+
                    ",borrowUsername="+ borrowUserName +
                    "}";
        }
        else{
            return "entity.Book{"+"isbn="+isbn+
                    ",name="+name+
                    ",author="+author+
                    ",price="+price+
                    ",isBorrowed="+isBorrowed+
                    "}";
        }

    }
    @Override
    public boolean equals(Object o){
        if(this==o)return true;
    else if(!(o instanceof Book))return false;
    Book book=(Book) o;
    return isbn.equals(book.isbn);
    }
    @Override
    public int hashCode(){
        return isbn.hashCode();
    }
}

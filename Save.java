package util;

import entity.Book;
import entity.User;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Save {
    public static void saveBook(List<Book> b) throws IOException {
        try(BufferedWriter bw=new BufferedWriter(new FileWriter("data/book.txt"))){
            for(Book books:b){
                String line;
                if(books.isBorrowed()){
                    line=books.getIsbn()+"|"
                            +books.getName()+"|"
                            +books.getAuthor()+"|"
                            +books.getPrice()+"|"
                            +books.isBorrowed()+"|"
                            +books.getBorrowTime()+"|"
                            +books.getBorrowUserName();

                }
                else{
                    line=books.getIsbn()+"|"
                            +books.getName()+"|"
                            +books.getAuthor()+"|"
                            +books.getPrice()+"|"
                            +books.isBorrowed();
                }
                bw.write(line);
                bw.newLine();
            }
        }
    }
    public static void saveUser(List<User> u){
        try(BufferedWriter bw=new BufferedWriter(new FileWriter("data/user.txt"))) {
            for(User users:u){
                String line= users.getName()+"|"
                        +users.getPassword()+"|"
                        + users.getRole();
                        bw.write(line);
                        bw.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

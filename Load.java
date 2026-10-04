package util;

import entity.Book;
import entity.User;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Load {
    public static List<Book> loadBook(){
        List<Book> books = new ArrayList<>();
        File file=new File("data/book.txt");
        if(!file.exists()){
            return books;
        }
        try(BufferedReader br = new BufferedReader(new FileReader("data/book.txt"))){
            String line;
            while((line= br.readLine())!=null){
                String[] part=line.split("\\|");
                Book book=new Book();
                book.setIsbn(part[0]);
                book.setName(part[1]);
                book.setAuthor(part[2]);
                book.setPrice(Double.parseDouble(part[3]));
                book.setBorrowed(Boolean.parseBoolean(part[4]));
                if(part.length>5){
                    book.setBorrowTime(LocalDateTime.parse(part[5]));
                    book.setBorrowUserName(part[6]);
                }
                books.add(book);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return books;
    }
    public static List<User> loadUser()  {
        List<User> user=new ArrayList<>();
        File file=new File("data/user.txt");
        if(!file.exists()){
            return user;
        }
        try(BufferedReader br=new BufferedReader(new FileReader("data/user.txt"))){
            String line;
            while((line=br.readLine())!=null){
                String[]part=line.split("\\|");
                User user1=new User();
                user1.setName(part[0]);
                user1.setPassword(part[1]);
                user1.setRole(part[2]);
                user.add(user1);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return user;
    }
}

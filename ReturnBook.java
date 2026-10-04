package operation;

import entity.Book;
import util.Rechoose;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class ReturnBook {
    public static void returnBook(Scanner s, List<Book> b){
        if(b.isEmpty()){
            System.out.println("当前没有书籍");
            return;
        }
        while(true){
            System.out.println("请输入想归还的书号");
            String isbn=s.nextLine();
            boolean life=true;
            for(Book book:b){
                if(Objects.equals(isbn,book.getIsbn())){
                    if(book.isBorrowed()){
                        book.setBorrowed(false);
                        book.setBorrowTime(null);
                        book.setBorrowUserName(null);
                        System.out.println("归还成功");
                        life=false;
                        break;
                    }
                }
            }
            if(life){
                System.out.println("当前书籍未借出或不存在");
            }
            if(Rechoose.again(s)){
                return;
            }
        }

    }
}

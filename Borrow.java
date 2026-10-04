package operation;

import entity.Book;
import util.Rechoose;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Borrow {
    public static void borrow(Scanner s, List<Book> b, String user){
        boolean life=true;
        if(b.isEmpty()){
            System.out.println("当前没有书籍");
            return;
        }
        while(true){
            System.out.println("请输入要借的书号");
            String isbn=s.nextLine();
            for(Book book:b){
                if(Objects.equals(isbn, book.getIsbn())){
                    if(book.isBorrowed()){
                        System.out.println("当前书已被借出");
                        life=false;
                        break;
                    }
                    System.out.println("当前书未被借出");
                    System.out.println("输1借出，输0返回");
                    String index=s.nextLine();
                    if(index.equals("1")){
                        book.setBorrowed(true);
                        book.setBorrowTime(LocalDateTime.now());
                        book.setBorrowUserName(user);
                        System.out.println("已借出");
                    }
                    else if(index.equals("0")){
                        break;
                    }
                    else{
                        System.out.println("输入无效");
                    }
                    life=false;
                }
            }
            if(life){
                System.out.println("未查询到对应书籍");
            }
            if(Rechoose.again(s)){
                return;
            }
        }
    }
}

package operation;

import entity.Book;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;


import util.Rechoose;

public class Add {
    public static void add(Scanner sc, List<Book> b){
        while(true){
            boolean life=true;
            System.out.println("请输入书号");
            String isbn=sc.nextLine();
            for(Book book:b){
                if(Objects.equals(book.getIsbn(), isbn)){
                    System.out.println("编号重复");
                    life=false;
                    break;
                }
            }
            if(life){
                System.out.println("请输入书名");
                String name=sc.nextLine();
                System.out.println("请输入作者");
                String author=sc.nextLine();
                double price=-1;
                while(price<0){
                    System.out.println("请输入价格");
                    price=Double.parseDouble(sc.nextLine());
                    if(price<0){
                        System.out.println("价格不能为负数");
                    }
                }
                b.add(new Book(isbn,name,author,price));
                System.out.println("添加成功");
                if(Rechoose.again(sc)){
                    return;
                }
            }
        }
    }
}

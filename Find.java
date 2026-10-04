package operation;

import entity.Book;
import util.Rechoose;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Find {
    public static void find(Scanner sc, List<Book> b){
        while(true){
            System.out.println("1.查询书号 2.查询书名 3.查询作者 4.显示全部 5.退出");
            System.out.println("请输入1-5");
            String i=sc.nextLine();
            switch (i){
                case "1"->{
                    System.out.println("请输入书号");
                    String isbn=sc.nextLine();
                    boolean life=true;
                    for(Book book:b){
                        if(Objects.equals(book.getIsbn(), isbn)){
                            System.out.println(book);
                            life=false;
                            break;
                        }
                    }
                    if(life) {
                        System.out.println("未查询到对应书籍");
                    }
                }
                case "2"->{
                    System.out.println("请输入书名");
                    String name=sc.nextLine();
                    b.stream().filter(s->s.getName().contains(name)).forEach(System.out::println);
                }
                case "3"->{
                    System.out.println("请输入作者");
                    String author=sc.nextLine();
                    b.stream().filter(s->s.getAuthor().contains(author)).forEach(System.out::println);
                }
                case "4"-> b.forEach(System.out::println);
                case "5"->{
                    return;
                }
                default-> System.out.println("请输入1-5");
            }
            if(Rechoose.again(sc)){
                return;
            }
        }
    }
}

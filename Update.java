package operation;

import entity.Book;
import util.Rechoose;

import java.util.*;

public class Update {
    public static void update(Scanner sc, List<Book> b){
        while (true){
            boolean life=true;
            if(b.isEmpty()){
                System.out.println("当前没有书籍");
                return;
            }
            System.out.println("请输入更新书籍对应书号");
            String isbnp=sc.nextLine();
            for(Book books:b){
                if(Objects.equals(books.getIsbn(), isbnp)){
                    System.out.println("当前要修改的书号为"+isbnp);
                    System.out.println("请输入新书名(回车不改)");
                    String name=sc.nextLine();
                    if(!name.isEmpty()){
                        books.setName(name);
                    }
                    System.out.println("请输入新作者(回车不改)");
                    String author=sc.nextLine();
                    if(!author.isEmpty()){
                        books.setAuthor(author);
                    }
                    while(true){
                        System.out.println("请输入新价格(回车不改)");
                        String prices=sc.nextLine();
                        if(!prices.isEmpty()){
                            try {
                                double price = Double.parseDouble(prices);
                                if(price<0){
                                    System.out.println("价格不能为负数");

                                }
                                else{
                                    books.setPrice(price);
                                    break;
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("价格必须是数字");
                            }
                        }
                        else{
                            break;
                        }
                    }
                    life=false;
                }
            }
            if(life){
                System.out.println("未查询到相应书籍");
            }
            if(Rechoose.again(sc)){
                return;
            }
        }
    }
}

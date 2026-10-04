package operation;

import entity.Book;
import util.Rechoose;

import java.util.*;

public class Remove {
    public static void remove(Scanner sc, List<Book> b) {
        while (true) {
            if (b.isEmpty()) {
                System.out.println("当前没有书籍");
                return;
            }
            System.out.println("请输入书号");
            String isbnp = sc.nextLine();
            boolean life = true;
            for (Book book : b) {
                if (Objects.equals(book.getIsbn(), isbnp)) {
                    life = false;
                    b.remove(book);
                    break;
                }
            }
            if (life) {
                System.out.println("未查询到对应书籍");
            }
            if (Rechoose.again(sc)) {
                return;
            }
        }
    }
}

package operation;

import entity.Book;
import entity.User;
import util.Rechoose;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Manager {
    public static void manage(Scanner s, List<Book> b, List<User> u,String admname){
        while(true){
            for(User user:u){
                System.out.print(user.getName()+" "+user.getPassword()+" "+user.getRole());
                System.out.print("      ");
                for(Book book:b){
                    if(Objects.equals(book.getBorrowUserName(), user.getName())){
                        System.out.print(book.getName()+"  ");
                    }
                }
                System.out.println(" ");
            }
            System.out.println("请输入你要进行的操作");
            System.out.println("1.删除用户 2.更改用户权限");
            String i=s.nextLine();
            boolean life=true;
            if(Objects.equals(i, "1")){
                System.out.println("请输入你要删除的用户名(删除后用户所借的书状态将更改为未借出)");
                String name=s.nextLine();
                for(User user:u){
                    if(Objects.equals(name, admname)){
                        System.out.println("不能删除自己");
                        life=false;
                        break;
                    }
                    if(Objects.equals(user.getName(), name)){
                        life=false;
                        u.remove(user);
                        for(Book book:b){
                            if(Objects.equals(book.getBorrowUserName(), user.getName())){
                                book.setBorrowUserName(null);
                                book.setBorrowTime(null);
                                book.setBorrowed(false);
                            }
                        }
                        System.out.println("删除成功");
                        break;
                    }
                }
                if(life){
                    System.out.println("未查询到该用户");
                }
            }
            else if(Objects.equals(i, "2")){
                boolean life2=true;
                System.out.println("请输入你要更改的用户");
                String name=s.nextLine();
                for(User user:u){
                    if(Objects.equals(user.getName(), name)){
                        life2=false;
                        if(Objects.equals(name, admname)){
                            System.out.println("不能更改自己");
                            break;
                        }
                        else if(Objects.equals(user.getRole(), "user")){
                            System.out.println("已将该用户更改为管理员");
                            user.setRole("admin");
                        }
                        else if(Objects.equals(user.getRole(), "admin")){
                            System.out.println("已将该用户更改为普通用户");
                            user.setRole("user");
                        }
                        break;
                    }
                }
                if(life2){
                    System.out.println("未查询到该用户");
                }
            }
            else{
                System.out.println("请输入1或2");
            }
            if(Rechoose.again(s)){
                return;
            }

        }
    }
}

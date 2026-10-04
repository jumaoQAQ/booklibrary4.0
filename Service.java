package service;

import entity.Book;
import entity.User;
import operation.*;
import util.Load;
import util.Save;

import java.io.IOException;
import java.util.*;

public class Service {
    private List<Book> books=Load.loadBook();
    private List<User> user=Load.loadUser();

    public void bookLibrary() throws IOException {
        Scanner s = new Scanner(System.in);
        while(true){
            System.out.println("欢迎来到图书管理系统");
            System.out.println("1.登录 2.注册");
            int i=Integer.parseInt(s.nextLine());
            if(i==1){
                System.out.println("请输入用户名");
                String name=s.nextLine();
                System.out.println("请输入密码");
                String password=s.nextLine();
                for(User u:user){
                    if(Objects.equals(u.getName(), name) && Objects.equals(u.getPassword(), password)){
                        if(Objects.equals(u.getRole(), "user")){
                            userMenu(s,name);
                        }
                        else{
                            adminMenu(s,name);
                        }
                        return;
                    }
                }
                System.out.println("用户名或密码错误");
            }
            else if(i==2){
                boolean life=true;
                System.out.println("请输入新用户名字");
                String name=s.nextLine();
                for(User u:user){
                    if(Objects.equals(u.getName(), name)){
                        System.out.println("当前用户已存在");
                        life=false;
                        break;
                    }
                }
                if(life){
                    System.out.println("请输入新用户密码");
                    String password=s.nextLine();
                    User u=new User();
                    u.setName(name);
                    u.setPassword(password);
                    u.setRole("user");
                    user.add(u);
                    Save.saveUser(user);
                    System.out.println("添加成功，请重新登录");
                }
            }
            else {
                System.out.println("请输入1或2");
            }
        }
    }

    public void adminMenu(Scanner s,String name) throws IOException {
        while (true) {
            System.out.println("1.添加图书");
            System.out.println("2.删除图书");
            System.out.println("3.修改图书");
            System.out.println("4.查询图书");
            System.out.println("5.借阅图书");
            System.out.println("6.归还图书");
            System.out.println("7.管理用户");
            System.out.println("8.退出系统");
            System.out.println("请输入1-8");
            switch (s.nextLine()) {
                case "1" -> Add.add(s, books);
                case "2" -> Remove.remove(s, books);
                case "3" -> Update.update(s, books);
                case "4" -> Find.find(s, books);
                case "5" -> Borrow.borrow(s, books,name);
                case "6" -> ReturnBook.returnBook(s, books);
                case "7" -> Manager.manage(s,books,user,name);
                case "8" -> {
                    Save.saveBook(books);
                    Save.saveUser(user);
                    System.out.println("再见");
                    return;
                }
                default -> System.out.println("请输入1-8");
            }
        }
    }
    public void userMenu(Scanner s,String name) throws IOException {
        while(true){
            System.out.println("1.查询图书");
            System.out.println("2.借阅图书");
            System.out.println("3.归还图书");
            System.out.println("4.退出系统");
            switch (s.nextLine()){
                case "1" -> Find.find(s, books);
                case "2" -> Borrow.borrow(s, books, name);
                case "3" -> ReturnBook.returnBook(s, books);
                case "4" -> {
                    System.out.println("再见");
                    Save.saveBook(books);
                    Save.saveUser(user);
                    return;
                }
                default -> System.out.println("请输入1-4");
            }
        }
    }
}

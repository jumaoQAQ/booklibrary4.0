package util;

import java.util.Objects;
import java.util.Scanner;

public class Rechoose {
    public static boolean again(Scanner s){
        String index;
        System.out.println("输1继续操作，输0返回菜单");
        while(true){
            index=s.nextLine();
            if(Objects.equals(index, "0")) {
                return true;
            }
            else if(Objects.equals(index, "1")){
                return false;
            }
            else{
                System.out.println("请输入1或0");
            }
        }
    }
}

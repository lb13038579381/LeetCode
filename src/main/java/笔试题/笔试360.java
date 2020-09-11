package 笔试题;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 笔试360 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> res = new ArrayList<>();
        int i = 0;
        while(i < 5) {
            i++;
            String s = sc.nextLine();
            if(s.length() < 8 ){
                res.add("Irregular password");
                continue;
            }
            boolean hasda = false;
            boolean hasxi = false;
            boolean hasel = false;
            boolean hasnum = false;
            for (char c : s.toCharArray()) {
                if(Character.isUpperCase(c)) {
                    hasda = true;
                }
                else if(Character.isLowerCase(c)) {
                    hasxi = true;
                }
                else if(Character.isDigit(c)) {
                    hasnum = true;
                }else {
                    hasel = true;
                }
            }
            if(hasda && hasxi && hasnum && hasel) {
                res.add("OK");
            }else{
                res.add("Irregular password");
            }
        }
        for (String re : res) {
            System.out.println(re);
        }
    }
}

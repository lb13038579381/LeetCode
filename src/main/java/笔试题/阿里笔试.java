package 笔试题;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class 阿里笔试 extends Thread {
    static int a;

    public static void main(String[] args) {
        //两个字符串，第一个的子串和第二个的子序列
        阿里笔试 s = new 阿里笔试();
        s.start();
        阿里笔试 s1 = new 阿里笔试();
        s1.start();
        阿里笔试 s2 = new 阿里笔试();
        s2.start();

    }

    @SneakyThrows
    @Override
    public void run() {
        synchronized (阿里笔试.class) {
            for (int i = 0; i < 100; i++) {
                System.out.println(a++);
            }
        }
    }
}

package domain;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class a {
    private static volatile a ab;

    public a() {
        System.out.println("a构造");
    }
    public a(int d) {
        System.out.println(d);
    }
    public void ddd(int o) {
        System.out.println("addd" + o);
    }
    public void eeee(Object o) {
        System.out.println("obj");
    }
    public void eeee(String s) {
        System.out.println(s);
        System.out.println("stirng");
    }


    public static void main(String[] args) {
//        int dddd = 1000;
//        Integer eeee = 1000;
//        int e = 1000;
//        System.out.println(dddd == eeee);
//        System.out.println();
//        a f = new b(3);
//        f.ddd(10);
//        int a = 5;
//        Integer b = a;
//        List<Integer> list = new ArrayList<>();
//        list.sort(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2 - o1;
//            }
//        });
//        ExecutorService executorService = Executors.newFixedThreadPool(10);
//        executorService.submit(new Thread(() -> System.out.println("aaa")));
    }
}

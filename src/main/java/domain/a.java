package domain;

import 回溯.三数之和;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

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


    public static void main(String[] args) throws InterruptedException {
        int i = 0;
        int a = i++;
        int i1 = 0;
        int b = ++i1;
        System.out.println(++a);
        System.out.println(b);
        Thread t1 = new Thread(() -> {
            ThreadLocal<String> threadLocal = new ThreadLocal<>();
            threadLocal.set("kkk");
            ThreadLocal<String> threadLocal1 = new ThreadLocal<>();
            threadLocal1.set("2333");
            threadLocal1.get();
            System.out.println(threadLocal.get());
        });
        Thread t2 = new Thread(() -> {
            ThreadLocal<String> threadLocal = new ThreadLocal<>();
            threadLocal.set("t2");
            threadLocal.set("222");
            System.out.println(threadLocal.get());
        });
        t1.start();
        Thread.sleep(100);
        t2.start();
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

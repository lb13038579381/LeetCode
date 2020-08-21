package domain;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class a {
    private static volatile a ab;

    public a() {
    }

    public static void main(String[] args) {
        int a = 5;
        Integer b = a;
        List<Integer> list = new ArrayList<>();
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.submit(new Thread(() -> System.out.println("aaa")));
    }
}

package tiku;

import com.alibaba.excel.EasyExcel;
import lombok.Data;
import org.terracotta.offheapstore.HashingMap;

import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

@Data
public class importExcel {
    Boolean xxx;
    public static void main(String[] args) throws FileNotFoundException {
//        File file = new File("tiku/222.xls");
//        ExcelListener listener = new ExcelListener();
//        try {
//            // 解析每行结果在listener中处理
//            EasyExcel.read(file, listener).sheet().doRead();
//            System.out.println("\n\n\n"+listener.getDatas());
//        } catch (Exception e) {
//                throw new RuntimeException(e);
//        }
//        importExcel importExcel = new importExcel();
//        if(importExcel.getXxx()) {
//            System.out.println("xasd");
//        }
        int a = 1;
        int b = 2;
        AtomicReference atomicReference = new AtomicReference();
        atomicReference.set(a);
        atomicReference.lazySet(b);
        System.out.println(atomicReference.get());
    }
    public static void xxx() {
    }
}

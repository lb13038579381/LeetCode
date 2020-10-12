package 笔试题;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;

public class 神策 implements  aa{
    public static void main(String[] args) {
        String s = "SensorsData";
        StringBuilder res = new StringBuilder();
        if (s.length() == 0) {
            System.out.println("");
            return;
        }
        int i = 0;
        if (Character.isUpperCase(s.charAt(0))) {
            res.append(String.valueOf(s.charAt(0)).toLowerCase());
            i++;
        }
        while (i < s.length()) {
            if (Character.isUpperCase(s.charAt(i))) {
                res.append("_");
                res.append(String.valueOf(s.charAt(i)).toLowerCase());
            } else {
                res.append(s.charAt(i));
            }
            i++;
        }
        System.out.println(res.toString());

        new 神策().fun();
    }
}

interface aa{

    default void fun(){
        System.out.println("---------------------");
    }

    static void hun(){
        System.out.println("asdfadsfasd");
    }
}

interface bb{

    default void fun(){
        System.out.println("=================");
    }

    static void hun(){
        System.out.println("asdfadsfasd");
    }
}

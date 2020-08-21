//import com.alibaba.excel.EasyExcelFactory;
//import com.alibaba.excel.ExcelWriter;
//import com.alibaba.excel.metadata.Sheet;
//import com.alibaba.excel.metadata.Table;
//
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//public class EasyExcelTest {
//    public static void main(String[] args) {
//        simpleWrite();
//    }
//    public static void simpleWrite(){
//
//        // 文件输出位置
//        String outPath = "test111.xlsx";
//
//        try {
//            // 所有行的集合
//            List<List<Object>> list = new ArrayList<List<Object>>();
//
//            ExcelWriter excelWriter = EasyExcelFactory.getWriter(new FileOutputStream(outPath));
//            // 表单
//            Sheet sheet = new Sheet(1,0);
//            sheet.setSheetName("第一个Sheet");
//            // 创建一个表格
//            Table table = new Table(1);
//            // 动态添加 表头 headList --> 所有表头行集合
//            List<List<String>> headList = new ArrayList<List<String>>();
//            // 第 n 行 的表头
//            List<String> headTitle0 = new ArrayList<String>();
//            List<String> headTitle1 = new ArrayList<String>();
//            List<String> headTitle2 = new ArrayList<String>();
//            List<String> headTitle3 = new ArrayList<String>();
//            List<String> headTitle4 = new ArrayList<String>();
//            List<String> headTitle5 = new ArrayList<String>();
//            List<String> headTitle6 = new ArrayList<String>();
//            List<String> headTitle7 = new ArrayList<String>();
//            List<String> headTitle8 = new ArrayList<String>();
//            List<String> headTitle9 = new ArrayList<String>();
//            List<String> headTitle10 = new ArrayList<String>();
//            List<String> headTitle11 = new ArrayList<String>();
//
//            String nickName="昵称",name="姓名",number="学号",score="成绩";
//            headList.add(Arrays.asList(nickName,nickName));
//            headList.add(Arrays.asList(name,name));
//            headList.add(Arrays.asList(number,number));
//            headList.add(Arrays.asList(score,score));
//
//            Integer objQsize = 10;
//            Integer subJsize = 5;
//            for (int i = 0; i < objQsize + subJsize;i++) {
//                ss.numberToChinese(i);
//            }
//
//            headTitle4.add("第一题");
//            headTitle4.add("题型");
//            headTitle5.add("第一题");
//            headTitle5.add("作答内容");
//            headTitle6.add("第一题");
//            headTitle6.add("正确答案");
//            headTitle7.add("第一题");
//            headTitle7.add("得分");
//
//            headTitle8.add("第二题");
//            headTitle8.add("题型");
//            headTitle9.add("第二题");
//            headTitle9.add("作答内容");
//            headTitle10.add("第二题");
//            headTitle10.add("正确答案");
//            headTitle11.add("第二题");
//            headTitle11.add("得分");
//
//            headList.add(headTitle0);
//            headList.add(headTitle1);
//            headList.add(headTitle2);
//            headList.add(headTitle3);
//            headList.add(headTitle4);
//            headList.add(headTitle5);
//            headList.add(headTitle6);
//            headList.add(headTitle7);
//            headList.add(headTitle8);
//            headList.add(headTitle9);
//            headList.add(headTitle10);
//            headList.add(headTitle11);
//
//            table.setHead(headList);
//
//            excelWriter.write1(list,sheet,table);
//            // 记得 释放资源
//            excelWriter.finish();
//            System.out.println("ok");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//}

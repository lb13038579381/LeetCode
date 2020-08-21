//import com.alibaba.excel.EasyExcelFactory;
//import com.alibaba.excel.ExcelWriter;
//import com.alibaba.excel.metadata.Sheet;
//import com.alibaba.excel.metadata.Table;
//import com.alibaba.excel.write.metadata.WriteSheet;
//import com.alibaba.excel.write.metadata.WriteTable;
//import com.google.common.collect.Lists;
//
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.OutputStream;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//public class ExcelTest {
//    public static void main(String[] args) throws IOException {
//        test();
//    }
//    public static void test() throws IOException {
//        // 文件输出位置
//        OutputStream out = new FileOutputStream("test111.xlsx");
//        ExcelWriter writer = EasyExcelFactory.getWriter(out);
//
//        // 动态添加表头，适用一些表头动态变化的场景
//        WriteSheet sheet1 = new WriteSheet();
//        sheet1.setSheetName("成绩统计");
//        sheet1.setSheetNo(0);
//        // 创建一个表格，用于 Sheet 中使用
//        WriteTable table = new WriteTable();
//        table.setTableNo(1);
//        table.setHead(head());
//        // 写数据
//        writer.write(null, sheet1, table);
//        writer.finish();
//        out.close();
//    }
//
//    private static List <List<String>> head(){
//        List<List<String>> headTitles = Lists.newArrayList();
//        String nickname = "昵称",name = "姓名",number = "学号",score="成绩";
//        headTitles.add( Lists.newArrayList(nickname,nickname));
//        headTitles.add( Lists.newArrayList(name,name));
//        headTitles.add( Lists.newArrayList(number,number));
//        headTitles.add( Lists.newArrayList(score,score));
//        Integer objQsize = 10;
//        Integer subJsize = 5;
//        List<String> questionNoList = new ArrayList<>(objQsize+subJsize);
//        for (int i = 1; i <= objQsize + subJsize;i++) {
//            StringBuilder qNo = new StringBuilder("第");
//            questionNoList.add(qNo.append(ss.numberToChinese(i)).append("题").toString());
//        }
//        List<String> objQuestionInfoList = Arrays.asList("题型","作答内容","正确答案","得分");
//        List<String> sbjQuestionInfoList = Arrays.asList("题型","作答内容","得分","整体评价");
//
//        questionNoList.forEach(no->{
//            objQuestionInfoList.forEach(info->{
//                headTitles.add(Arrays.asList(no,info));
//            });
//        });
//        return headTitles;
//    }
//
//}

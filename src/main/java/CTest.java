import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.metadata.Table;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.metadata.WriteTable;
import com.google.common.collect.Lists;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CTest {
    public static void main(String[] args) throws IOException {
        test();
    }
    public static void test() throws IOException {
        // 文件输出位置
        OutputStream out = new FileOutputStream("excel/test33333344.xlsx");
        ExcelWriter writer = EasyExcelFactory.getWriter(out);

        // 动态添加表头，适用一些表头动态变化的场景
        WriteSheet sheet1 = new WriteSheet();
        sheet1.setSheetName("成绩统计");
        sheet1.setSheetNo(0);
        // 创建一个表格，用于 Sheet 中使用
        WriteTable table = new WriteTable();
        table.setTableNo(1);
        table.setHead(head());
        // 写数据
        List<List<String>> data = new ArrayList<>();
        List<String> l1 = new ArrayList<>();
        List<String> l2 = new ArrayList<>();

        l1.add("时间");
        l1.add("到达量");
        l1.add("打开量");
        l1.add("打开率");
        List<String> l3 = new ArrayList<>();

        l3.add("20200909");
        l3.add("6666");
        l3.add("9999");
        l3.add("50%");
        data.add(l2);
        data.add(l1);
        data.add(l3);
        writer.write(data, sheet1, table);
        writer.finish();
        out.close();
    }

    private static List <List<String>> head(){
        List<List<String>> headTitles = Lists.newArrayList();
        String nickname = "推送量",name = "姓名",number = "学号",score="成绩";
        headTitles.add( Lists.newArrayList("推送量","到达量","打开量"));
        headTitles.add( Lists.newArrayList("10000","20000","8000"));
        return headTitles;
    }

}

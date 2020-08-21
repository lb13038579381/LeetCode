package tiku.domain;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class ImportDto {
    @ExcelProperty("题干")
    private String title;
    @ExcelProperty("题型")
    private String typeStr;
    @ExcelProperty("答案")
    private String answer;
    @ExcelProperty("A")
    private String optionA;
    @ExcelProperty("B")
    private String optionB;
    @ExcelProperty("C")
    private String optionc;
    @ExcelProperty("D")
    private String optionD;
    @ExcelProperty("解析")
    private String analyse;
}

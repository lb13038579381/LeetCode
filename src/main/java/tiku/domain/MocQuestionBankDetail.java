package tiku.domain;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class MocQuestionBankDetail {
    /**
     * 填空题参考答案
     */
    private String stdAnswer;
    /**
     * 类型： 1单选题 2多选题 3客观填空题 4判断题 10主观题
     */
    private Integer type;
    /**
     * 位置，从0开始
     */
    private Integer position;
    /**
     * 类型： 1数值 2文字
     */
    private Integer fillblankType;
    /**
     * 是否允许上传
     */
    private Integer allowUpload;
    /**
     * 分值
     */
    private BigDecimal score;
    /**
     * oj问题支持的语言-使用bitmap存储
     */
    private Long ojSupportedLanguage;
    /**
     * 可尝试次数
     */
    private Integer ojTryTime;
    /**
     * 时间限制-ms
     */
    private Integer ojTimeLimit;
    /**
     * 内存限制-b
     */
    private Long ojMemLimit;
    /**
     * oj题型是否需要Input
     */
    private Integer oj_need_input;
    /**
     * 题干
     */
    private String title;
    /**
     * 题干附件
     */
    private String titleAttachment;
    /**
     * 主观题示例答案["asdf","asdf"]
     */
    private String sampleAnswerJson;
    /**
     * 选项[{id:uuid,content:"",answer:true,analyse:"",score(训练)}]
     */
    private String optionsDetail;
    /**
     * 判断标准 [{msg:"需要...",score:2},...]
     */
    private String judgerules;
    /**
     * 题目解析
     */
    private String analyse;
    /**
     * 题目细节描述
     */
    private String description;

    private Long bankId;


}
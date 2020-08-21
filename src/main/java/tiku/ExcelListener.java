package tiku;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.exception.ExcelAnalysisStopException;
import lombok.SneakyThrows;
import tiku.domain.JudgeRule;
import tiku.domain.MocQuestionBankDetail;
import tiku.domain.OptionDetailDto;

import java.util.*;

public class ExcelListener extends AnalysisEventListener<Map<Integer, String>> {
    //自定义用于暂时存储data。
    //可以通过实例获取该值
    private List<MocQuestionBankDetail> datas = new ArrayList<>();
    private Integer failCount = 0;
    private Map<String, Integer> paramsWithIndex;
    private List<Map<Integer, String>> failDatas;

    @SneakyThrows
    @Override
    public void invoke(Map<Integer, String> curData, AnalysisContext context) {
        Integer curRow = context.getCurrentRowNum();
        MocQuestionBankDetail questionBankDetail = convertToMoc(curData, paramsWithIndex);
        if (questionBankDetail != null) {
            datas.add(questionBankDetail);
        } else {
            failDatas = new ArrayList<>();
            failDatas.add(curData);
            //todo 导入题目失败，类型不匹配
            System.out.println("题目类型不支持" + curData);
        }
    }

    private List<String> getHeader() {
        List<String> needParams = new ArrayList<>();
        needParams.add("题型");
        needParams.add("题干");
        needParams.add("正确答案");
        needParams.add("答案");
        needParams.add("题目解析");
        needParams.add("解析");
        needParams.add("答案解析");
        needParams.add("选项");
        needParams.add("A");
        needParams.add("B");
        needParams.add("C");
        needParams.add("D");
        return needParams;
    }


    private MocQuestionBankDetail convertToMoc(Map<Integer, String> curData, Map<String, Integer> paramsWithIndex) {

        MocQuestionBankDetail mocQuestion = new MocQuestionBankDetail();
        mocQuestion.setBankId(11111L);
        fillBasicInfo(mocQuestion, curData);
        Integer questionType = mocQuestion.getType();
        if (questionType == 0) {
            return null;
        }
        int indexOfA = paramsWithIndex.get("A");
        //单选和多选
        List<OptionDetailDto> optionDetails = new ArrayList<>();
        if (questionType.equals(1) || questionType.equals(2)) {
            Integer indexOfCorrectOptions = Optional.ofNullable(paramsWithIndex.get("正确答案")).orElse(paramsWithIndex.get("答案"));
            String correctOption = curData.get(indexOfCorrectOptions);
            char[] options = correctOption.toCharArray();
            List<Integer> correctIndexes = convertOptionsToIndexes(options);
            int start = indexOfA;
            for (Map.Entry<Integer, String> entry : curData.entrySet()) {
                if (entry.getKey() < start) {
                    continue;
                }
                OptionDetailDto optionDetailDto = new OptionDetailDto();
                optionDetailDto.setContent(entry.getValue());
                optionDetailDto.setId(123123);
                if (correctIndexes.contains(entry.getKey())) {
                    optionDetailDto.setAnswer(true);
                } else {
                    optionDetailDto.setAnswer(false);
                }
                optionDetails.add(optionDetailDto);
            }
            mocQuestion.setOptionsDetail(optionDetails.toString());
        }
        //填空
        else if (questionType.equals(3)) {
            StringBuilder answers = new StringBuilder();
            for (Map.Entry<Integer, String> entry : curData.entrySet()) {
                if (entry.getKey() < indexOfA) {
                    continue;
                }
                answers.append(entry.getValue()).append(" ");
            }
            mocQuestion.setStdAnswer(answers.toString());
        }
        //判断
        else if (questionType.equals(4)) {
            Integer correctIndex = Optional.ofNullable(paramsWithIndex.get("答案")).orElse(paramsWithIndex.get("正确答案"));
            String correctOption = curData.get(correctIndex);
            OptionDetailDto optionA = new OptionDetailDto();
            optionA.setId(22222);
            optionA.setContent("正确");
            OptionDetailDto optionB = new OptionDetailDto();
            optionB.setId(33333);
            optionB.setContent("错误");
            if (correctOption.equals("正确")) {
                optionA.setAnswer(true);
                optionB.setAnswer(false);
            } else if (correctOption.equals("错误")) {
                optionA.setAnswer(false);
                optionB.setAnswer(true);
            } else if (correctOption.equals("A")) {
                if (curData.get(indexOfA).equals("正确")) {
                    optionA.setAnswer(true);
                    optionA.setAnswer(false);
                }
            } else if (correctOption.equals("B")) {
                optionA.setAnswer(false);
                optionB.setAnswer(true);
            }
            optionDetails.add(optionA);
            optionDetails.add(optionB);
        }
        //主观
        else if (questionType.equals(5)) {
            JudgeRule judgeRule = new JudgeRule();
            judgeRule.setId(99999L);
            mocQuestion.setJudgerules(judgeRule.toString());
            Integer indexOfAnalyse = Optional.ofNullable(paramsWithIndex.get("解析")).orElse(Optional.ofNullable(paramsWithIndex.get("题目解析")).orElse(paramsWithIndex.get("答案解析")));
            mocQuestion.setAnalyse(curData.get(indexOfAnalyse));
        }
        return mocQuestion;
    }

    private void fillBasicInfo(MocQuestionBankDetail mocQuestion, Map<Integer, String> curData) {
        String typeStr = curData.get(paramsWithIndex.get("题型"));
        Integer questionType = getQuestiontypeByStr(typeStr);
        mocQuestion.setType(questionType);
        String title = curData.get(paramsWithIndex.get("题干"));
        mocQuestion.setTitle(title);
    }

    private List<Integer> convertOptionsToIndexes(char[] options) {
        List<Integer> result = new ArrayList<>();
        for (char option : options) {
            Integer correctIndex = paramsWithIndex.get(option + "");
            if (correctIndex != null) {
                result.add(correctIndex);
            }
//            if (option == 'A') {
//                result.add(paramsWithIndex.get("A"));
//            } else if (option == 'B') {
//                result.add(paramsWithIndex.get("B"));
//
//            } else if (option == 'C') {
//                result.add(paramsWithIndex.get("C"));
//
//            } else if (option == 'D') {
//                result.add(paramsWithIndex.get("D"));
//            }
        }

        return result;
    }

    private Integer getQuestiontypeByStr(String typeStr) {
        if (typeStr.indexOf("单选") != -1) {
            return 1;
        } else if (typeStr.indexOf("多选") != -1) {
            return 2;
        } else if (typeStr.indexOf("填空") != -1) {
            return 3;
        } else if (typeStr.indexOf("判断") != -1) {
            return 4;
        } else if (typeStr.indexOf("主观") != -1 || typeStr.indexOf("论述") != -1 || typeStr.indexOf("简答") != -1) {
            return 5;
        }
        return 0;
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        System.out.println("解析完毕");
        for (MocQuestionBankDetail data : datas) {
            System.out.println(data);
        }
        datas.clear();//解析结束销毁不用的资源
    }

    @Override
    public void invokeHeadMap(Map<Integer, String> curData, AnalysisContext context) {
        List<String> needParams = getHeader();
        paramsWithIndex = new HashMap<String, Integer>();
        for (Map.Entry<Integer, String> entry : curData.entrySet()) {
            paramsWithIndex.put(entry.getValue(), entry.getKey());
            needParams.remove(entry.getValue());

        }
        if (needParams.size() > 4) {
            throw new RuntimeException("表头有误");
        }
    }

    public List<MocQuestionBankDetail> getDatas() {
        return datas;
    }

    public void setDatas(List<MocQuestionBankDetail> datas) {
        this.datas = datas;
    }
    @Override
    public void onException(Exception e,AnalysisContext context) {
        if(e instanceof RuntimeException) {
            throw new ExcelAnalysisStopException("表头有误，表头需包含以下元素：题型，题干，正确答案，解析，A，B，C，D至少四个选项");
        }else {
            throw new ExcelAnalysisStopException("当前行" + context.getCurrentRowNum() + "未知异常" + e);
        }

    }
}
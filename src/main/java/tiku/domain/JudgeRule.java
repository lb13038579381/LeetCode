package tiku.domain;

import lombok.Data;

@Data
public class JudgeRule {
    private Long id;
    private String msg;
    private Integer maxScore;
    private Integer refScore;
    private String details;
}

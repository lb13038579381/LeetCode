package tiku.domain;


import lombok.Data;

@Data
public class OptionDetailDto {
    private int id;
    private String content;
    private boolean answer;
    private String analyse;
}

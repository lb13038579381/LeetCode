package tiku;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ByteDanceTest {

    public static void main(String[] args) {
        String[] xxx = {"1111","2222"};
        List<String> x = Arrays.asList(xxx);
        List<String> strs = new ArrayList<>();
        strs.add("12678687 www.toutiao.com 31");
        strs.add("12678687 www.byte.com 60");
        strs.add("12678687 www.bytedance.com 210");
        strs.add("12678685 www.toutiao.com 20");
        strs.add("12678685 www.byte.com 90");
        strs.add("12678683 www.toutiao.com 15");
        strs.add("12678683 www.byte.com 40");
        strs.add("12678688 www.toutiao.com 15");
        ByteDanceTest test = new ByteDanceTest();
            List<ByteDanceDto> result = new ArrayList<>();
            for (String s : strs) {
                boolean isContain = false;
                String[] str = s.split(" ");
                for (ByteDanceDto byteDanceDto : result) {
                    if(byteDanceDto.url.equals(str[1])) {
                        byteDanceDto.ids.add(Long.parseLong(str[0]));
                        byteDanceDto.time = byteDanceDto.time + Integer.parseInt(str[2]);
                        isContain = true;
                        break;
                    }
                }
                if(!isContain) {
                    ByteDanceDto danceDto = new ByteDanceDto();
                    danceDto.ids = new ArrayList<>();
                    danceDto.url = str[1];
                    danceDto.ids.add(Long.parseLong(str[0]));
                    danceDto.time = Integer.parseInt(str[2]);
                    result.add(danceDto);
                }
            }
            List<ByteDanceDto> result1 = new ArrayList<>();
            for (ByteDanceDto danceDto : result) {
                if(danceDto.time > 180) {
                    result1.add(danceDto);
                }
            }
            if(result1.size() == 0) {
                System.out.println("null");
            }else {
                result1.sort(Comparator.comparingInt(o -> o.time));
                System.out.println(result1.get(0).url);
            }

    }

    public  String fun(List<String> strs) {
        ArrayList<ByteDanceDto> result = new ArrayList<>();
        result.iterator();
        for (String s : strs) {
            boolean isContain = false;
            String[] str = s.split(" ");
            for (ByteDanceDto byteDanceDto : result) {
                if(byteDanceDto.url.equals(str[1])) {
                    byteDanceDto.ids.add(Long.parseLong(str[0]));
                    byteDanceDto.time = byteDanceDto.time + Integer.parseInt(str[2]);
                    isContain = true;
                    break;
                }
            }
            if(!isContain) {
                ByteDanceDto danceDto = new ByteDanceDto();
                danceDto.ids = new ArrayList<>();
                danceDto.url = str[1];
                danceDto.ids.add(Long.parseLong(str[0]));
                danceDto.time = Integer.parseInt(str[2]);
                result.add(danceDto);
            }
        }
        List<ByteDanceDto> result1 = new ArrayList<>();
        for (ByteDanceDto danceDto : result) {
            if(danceDto.time > 180) {
                result1.add(danceDto);
            }
        }
        if(result1.size() == 0) {
            return null;
        }
        System.out.println(result1);
        result1.sort(Comparator.comparingInt(o -> o.time));
        return result1.get(0).url;
    }

    static class ByteDanceDto {
        List<Long> ids;
        String url;
        Integer time;
    }
}

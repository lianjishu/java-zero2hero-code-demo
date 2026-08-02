package webcrawler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SurnameSet {
    // 获取姓氏的API地址
    public static final String SURNAME_API = "https://hanyu.baidu.com/shici/detail?pid=0b2f26d4c0ddb3ee693fdb1137ee1b0d&from=kg0";
    // 获取男生名字的API地址
    public static final String BOY_NAME_API = "https://www.meimeiming.com/zhouyi/5143.html";
    // 获取女生名字的API地址
    public static final String GIRL_NAME_API = "https://www.meimeiming.com/zhouyi/8347.html";

    private static final String regexp = ".{4}(，|。)";

    public static ArrayList<String> getSurname(String html, String regexp) {
        ArrayList<String> list = new ArrayList<>();
        //按照正则表达式的规则 去获取数据
        Pattern pattern = Pattern.compile(regexp);
        Matcher matcher = pattern.matcher(html);
        while (matcher.find()) {
            String group = matcher.group();
            System.out.println(group);
        }
        return list;
    }

    public static void main(String[] args) throws IOException {
        getSurname(Crawler.getHtml(SURNAME_API), regexp);
    }
}

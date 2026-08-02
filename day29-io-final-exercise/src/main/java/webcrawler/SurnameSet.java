package webcrawler;

import java.io.IOException;
import java.util.ArrayList;

public class SurnameCrawler {
    // 获取姓氏的API地址
    public static final String SURNAME_API = "https://hanyu.baidu.com/shici/detail?pid=0b2f26d4c0ddb3ee693fdb1137ee1b0d&from=kg0";
    // 获取男生名字的API地址
    public static final String BOY_NAME_API = "https://www.meimeiming.com/zhouyi/5143.html";
    // 获取女生名字的API地址
    public static final String GIRL_NAME_API = "https://www.meimeiming.com/zhouyi/8347.html";

    public static ArrayList<String> getSurname(String html, String regexp) {

    }

    public static void main(String[] args) throws IOException {
        System.out.println(Crawler.getHtml(SURNAME_API));
    }
}

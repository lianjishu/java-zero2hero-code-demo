package io.github.lianjishu.Day19_API_RegularExpression.Crawler.Crawler01;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class CrawlerPractise {

    private static final String TEXT = "Java自从95年问世以来，经历了很多版本，目前企业中用的最多的是java8和java11，因为这两个是长期支持版本，下一个长期支持版本是java17，相信在未来不久java17也会逐渐登上历史舞台";
    private static final String REGEX = "java\\d{1,2}";

    public CrawlerPractise method01() {
        Pattern p = Pattern.compile(REGEX);

        Matcher m = p.matcher(TEXT);

        System.out.println("------- finding 1 ------");
        m.find();
        String s1 = m.group();
        System.out.println(s1);
        System.out.println("");


        System.out.println("------- finding 2 ------");
        m.find();
        String s2 = m.group();
        System.out.println(s2);
        System.out.println("");


        System.out.println("------- finding 3 ------");
        m.find();
        String s3 = m.group();
        System.out.println(s3);
        System.out.println("");


        System.out.println("------- finding 4 ------");   
        m.find();
        String s4 = m.group();
        System.out.println(s4);
        System.out.println("");


        System.out.println("\n");

        return this;
    }
    

    public void method02() {
        Pattern p = Pattern.compile(REGEX);
        Matcher m = p.matcher(TEXT);
        while (m.find()) {
            System.out.println(m.group());
            System.out.println("------------------------");
        }
    }
}

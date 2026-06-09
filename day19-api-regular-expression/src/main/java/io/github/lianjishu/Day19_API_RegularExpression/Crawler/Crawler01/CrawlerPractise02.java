package io.github.lianjishu.Day19_API_RegularExpression.Crawler.Crawler01;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/*
    **需求**：把下面文本中的电话，邮箱，手机号，热线都爬取出来。
    ```
    来黑马程序员学习Java，

    电话：18512516758，18512508907

    或者联系邮箱：boniu@itcast.cn，

    座机电话：01036517895，010-98951256

    邮箱：bozai@itcast.cn，

    热线电话：400-618-9090，400-618-4000，4006184000，4006189090
    ```
*/
public class CrawlerPractise02 {
    private static final String TEXT = 
                            """
                                来黑马程序员学习Java，
                                电话：18512516758，18512508907
                                或者联系邮箱：boniu@itcast.cn，
                                座机电话：01036517895，010-98951256
                                邮箱：bozai@itcast.cn，
                                热线电话：400-618-9090，400-618-4000，4006184000，4006189090
                            """;

    private static final String REGEX = "1[3-9]\\d{9}"
            + "|\\w+@[\\w&&[^_]]{2,12}(\\.[\\w&&[^_]]{2,12}){1,4}"
            + "|0\\d{2,3}-?[1-9]\\d{4,9}"
            + "|400-?\\d{3}-?\\d{4}";

    public void pase() {
        Matcher matcher = Pattern.compile(REGEX).matcher(TEXT);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
    

}

class Main {
    public static void main(String[] args) {
        new CrawlerPractise02().pase();
    }

}


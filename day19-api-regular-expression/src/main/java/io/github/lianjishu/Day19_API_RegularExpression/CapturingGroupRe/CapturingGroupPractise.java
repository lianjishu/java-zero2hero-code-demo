package io.github.lianjishu.Day19_API_RegularExpression.CapturingGroupRe;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static java.util.regex.Pattern.matches;


public class CapturingGroupPractise {
    /**
     * **需求 1：** 判断一个字符串的开始字符和结束字符是否一致？只考虑一个字符
     *     **举例：** a123a b456b 17891 &abc&
     */
    public CapturingGroupPractise q1() {
        final String REGEX = "(.).+\\1";

        ArrayList<String> testCases = new ArrayList<>(List.of(
                "a123a",
                "b456b",
                "17891",
                "&abc&"
        ));

        Iterator<String> it = testCases.iterator();
        System.out.println("# =====================");
        System.out.println("# 需求一");
        System.out.println("# =====================");
        while(it.hasNext()) {
            String testCase = it.next();
            System.out.println(testCase.matches(REGEX));
        }
        System.out.println("# =====================");

        return this;
    }



     //**需求 2：** 判断一个字符串的开始部分和结束部分是否一致？可以有多个字符
//    **举例：** abc123abc b456b 123789123 &!@abc&!@
    public CapturingGroupPractise q2() {
        final String REGEX = "(.+).+\\1";

        ArrayList<String> testCases = new ArrayList<>(List.of(
                "abc123abc",
                "b456b",
                "123789123",
                "&!@abc&!@"
        ));

        Iterator<String> it = testCases.iterator();
        System.out.println("# =====================");
        System.out.println("# 需求二");
        System.out.println("# =====================");
        while(it.hasNext()) {
            String testCase = it.next();
            System.out.println(testCase.matches(REGEX));
        }
        System.out.println("# =====================");

        return this;
    }

//    **需求 3：** 判断一个字符串的开始部分和结束部分是否一致？开始部分内部每个字符也需要一致
//    **举例：** aaa123aaa bbb456bbb 111789111 &&abc&&
    public  CapturingGroupPractise q3() {
        final String REGEX = "(.)\\1*.+\\1+"; // "((.)\\2*).+\\1"

        ArrayList<String> testCases = new ArrayList<>(List.of(
                "aaa123aaa",
                "bbb456bbb",
                "111789111",
                "&&abc&&"
        ));

        Iterator<String> it = testCases.iterator();
        System.out.println("# =====================");
        System.out.println("# 需求三");
        System.out.println("# =====================");
        while(it.hasNext()) {
            String testCase = it.next();
            System.out.println(testCase.matches(REGEX));
        }
        System.out.println("# =====================");

        return this;
    }
}

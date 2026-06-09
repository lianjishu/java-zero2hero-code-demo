package io.github.lianjishu.Day19_API_RegularExpression.RegExp.RegExpPractice;

public class TelValidator implements Validator {

    // 规则
    // 区号: 0开头 而且 一共是3到4位
    // '-' : 出现0到1次
    // 号码: 第一位不为零 , 总长度5到10位
    private static String TEL_REGEX = "0\\d{2,3}-?[1-9]\\d{4,9}";

    @Override
    public boolean validate(String telString) {

        return telString.matches(TEL_REGEX);
    }
}

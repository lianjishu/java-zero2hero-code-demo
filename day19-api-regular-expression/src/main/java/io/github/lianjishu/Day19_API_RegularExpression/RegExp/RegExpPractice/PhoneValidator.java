package io.github.lianjishu.Day19_API_RegularExpression.RegExp.RegExpPractice;

public class PhoneValidator implements Validator {
    /**
     * 手机号码
     * 
     * 一共11位
     * 第一位是1
     * 第二位是3-9
     * 之后随意
     */
    private static final String PHONE_REGEX = "1[3-9]\\d{9}";

    @Override
    public boolean validate(String phoneString) {
        return phoneString.matches(PHONE_REGEX);
    }
}

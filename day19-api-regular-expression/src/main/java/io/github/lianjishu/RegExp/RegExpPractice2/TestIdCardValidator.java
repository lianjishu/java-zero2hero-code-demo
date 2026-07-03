package io.github.lianjishu.RegExp.RegExpPractice2;

public class TestIdCardValidator {
    public static void main(String[] args) {
        /**
         * 基础校验用
         * 12345678901234567X
         * 123456789012345678
         * 
         * 严格校验用（地区码+合法日期+校验位都对）：
         * 
         * 11010119900307803X
         * 110101199003077416
         */
        System.out.println(new IdCardValidator().isIdCardValid("12345678901234567x"));
        System.out.println(new IdCardValidator().isIdCardValid("123456789012345678"));
        System.out.println("==========================");
        System.out.println(new IdCardValidator().isIdCardStrictValid("11010119900307803X"));
        System.out.println(new IdCardValidator().isIdCardStrictValid("110101199003077416"));
    }
}

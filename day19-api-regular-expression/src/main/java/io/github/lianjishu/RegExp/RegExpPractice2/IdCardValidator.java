package io.github.lianjishu.RegExp.RegExpPractice2;

/**
 * 简单要求：18位，前17位任意数字，最后一位可以是数字可以是大写或小写的x
 * 复杂要求：按照身份证号码的格式严格要求。
 */
public class IdCardValidator {
    // "\\d{17}[\\dxX]" ==> "\\d{17}(?i:[\\dX])"
    private static final String IDCARD_REGEX = "\\d{17}(?i:[\\dX])";

    public boolean isIdCardValid(String input) {// 基础
        return input.matches(IDCARD_REGEX);
    }

    // ========================================
    // ========= 身份证号码的严格校验 ===========
    // =========================================
    // 410861 1993 02 28 457x
    // 前面6位: 省份，市区，派出所等信息 第一位不能是0，后面5位是任意数字

    // 年的前半段: 19 20
    // 年的后半段: 任意数字出现两次
    // 月份: 01 ~ 09 10 11 12
    // 日期: 01 ~ 31
    // 后面四位: 任意数字出现3次 最后一位可以是数字也可以是大写X或者小写x

    private static final String IDCARD_STRICT_REGEX = "[1-9]\\d{5}" //前面6位: 省份，市区，派出所等信息 第一位不能是0，后面5位是任意数字
                                                    + "(19|20)" //年的前半段: 19 20
                                                    + "\\d{2}" //年的后半段: 任意数字出现两次
                                                    + "(0[1-9]|1[0-2])" //月份: 01 ~ 09 10 11 12
                                                    + "(0[1-9]|[12]\\d|3[0-1])" //日期: 01 ~ 31
                                                    + "\\d{3}(\\d|(?i)x)"; // 后面四位: 任意数字出现3次 最后一位可以是数字也可以是大写X或者小写x

    public boolean isIdCardStrictValid(String input) {// 严格
        return input.matches(IDCARD_STRICT_REGEX);
    }
}

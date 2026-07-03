package io.github.lianjishu.RegExp.RegExpDebutExperience;

/**
 * 先爽一下正则表达式
 * 
 * 正则表达式可以校验字符串是否满足一定的规则，并用来校验数据格式的合法性。
 * 需求：假如现在要求校验一个qq号码是否正确
 * 规则：6位及20位之内，0不能在开头，必须全部是数字。
 * 先使用目前所学知识完成校验需求
 * 然后体验一下正则表达式检验
 */
public class RegExpQQValidator {

    // 6位及20位之内，0不能在开头，必须全部是数字
    private static final String QQ_REGEX = "[1-9]\\d{5,19}";

    private static boolean bf(String qqUId) {
        int n = qqUId.length();
        if (n < 6 || n > 20)
            return false;
        if (qqUId.startsWith("0"))
            return false;

        for (int i = 0; i < n; ++i) {
            if (qqUId.charAt(i) < '0' || qqUId.charAt(i) > '9')
                return false;
        }
        return true;
    }

    // public boolean matches(String regex)
    private static boolean withRegExp(String qqUId) {
        // 6位及20位之内，0不能在开头，必须全部是数字
        // 6位及20位之内，必须全部是数字 ===> [\d]{6,20}

        return qqUId.matches(QQ_REGEX);
    }

    public static boolean validateWithBf(String qqUId) {
        return RegExpQQValidator.bf(qqUId);
    }

    public static boolean validateWithRegExp(String qqUId) {
        return RegExpQQValidator.withRegExp(qqUId);
    }
}

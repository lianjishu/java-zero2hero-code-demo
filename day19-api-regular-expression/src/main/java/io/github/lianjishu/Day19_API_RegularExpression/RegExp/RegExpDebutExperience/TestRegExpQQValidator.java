package io.github.lianjishu.Day19_API_RegularExpression.RegExp.RegExpDebutExperience;

class TestRegExpQQValidator {
    public static void main(String[] args) {
        final String QQUID1 = "3021969177";

        var res1 = RegExpQQValidator.validateWithBf(QQUID1);
        System.out.println(res1);
        var res2 = RegExpQQValidator.validateWithRegExp(QQUID1);
        System.out.println(res2);
    }
}
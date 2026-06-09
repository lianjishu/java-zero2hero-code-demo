package io.github.lianjishu.Day19_API_RegularExpression.RegExp.RegExpPractice;

public class EmailValidator implements Validator {

    // @左侧: 任意的数字字母下划线 至少出现一次
    // @本身: 必须有且只出现一次
    // @右侧:
    //// .左侧:可以是任意字母数字不能有下划线
    //// '.com'结构: .必须存在 大写字母小写字母都可以 | 整体可出现2到4次
    //// e.g. name@st.huas.edu.cn
    ////
    private static String EMAIL_REGEX = "\\w+@[\\w&&[^_]]{2,12}(\\.[\\w&&[^_]]{2,12}){2,4}";

    @Override
    public boolean validate(String emailString) {

        return emailString.matches(EMAIL_REGEX);
    }
}

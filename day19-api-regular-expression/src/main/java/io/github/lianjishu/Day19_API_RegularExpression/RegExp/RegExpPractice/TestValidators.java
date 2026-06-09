package io.github.lianjishu.Day19_API_RegularExpression.RegExp.RegExpPractice;

public class TestValidators {
    public static void main(String[] args) {

        Validator emailValidator = ValidatorsFactory.getValidator(ValidatorType.EMAIL);
        System.out.println(emailValidator.validate("zhouyake@st.huas.edu.cn"));

        Validator phoneValidator = ValidatorsFactory.getValidator(ValidatorType.PHONE);
        System.out.println(phoneValidator.validate("13712455668"));

        Validator telValidator = ValidatorsFactory.getValidator(ValidatorType.TEL);
        System.out.println(telValidator.validate("0769-3242434"));

    }
}

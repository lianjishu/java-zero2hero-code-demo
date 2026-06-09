package io.github.lianjishu.Day19_API_RegularExpression.RegExp.RegExpPractice;

public class ValidatorsFactory {

    public static Validator getValidator(ValidatorType validatorType) {
        return switch (validatorType) {
            case ValidatorType.EMAIL -> new EmailValidator();
            case ValidatorType.PHONE -> new PhoneValidator();
            case ValidatorType.TEL -> new TelValidator();
            default -> throw new IllegalArgumentException(
                "Unknown validator type: " + validatorType
            );

        };
    }
}

package io.github.lianjishu.RegExp.RegExpPractice;

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

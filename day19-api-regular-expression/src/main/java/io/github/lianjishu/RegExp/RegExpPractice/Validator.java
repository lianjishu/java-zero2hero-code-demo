package io.github.lianjishu.RegExp.RegExpPractice;

/**
 * 使用工厂设计模式
 * 
 * 定义标准接口
 * 具体的实现类
 * 工厂类(负责按需制造)
 * 使用(极其清爽, 屏蔽细节)
 */
public interface Validator {

    public boolean validate(String input);
}
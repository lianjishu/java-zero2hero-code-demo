package io.github.lianjishu;
public class Car {
    String carName;
    int carAge;
    Color carColor;

    // 内部类是外部类一部分
    // 内部类单独出现没有任何意义
    private class Engine {
        String engineName;
        int engineAge;
    }
}


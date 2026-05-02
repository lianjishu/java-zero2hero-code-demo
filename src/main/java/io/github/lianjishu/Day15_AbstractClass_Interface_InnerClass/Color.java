package io.github.lianjishu.Day15_AbstractClass_Interface_InnerClass;
enum Color {
    RED(0, "红"), GREEN(1, "绿"), BLUE(2, "蓝");

    private final int cValue;
    private final String zhString;

    public Color(int cValue, String zhString) {
        this.cValue  = cValue;
        this.zhString = zhString;
    }

    @Override
    public String toString() {
        return this.zhString;
    }
}
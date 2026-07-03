package io.github.lianjishu;

public class InterfacesFrog extends Pet implements Swimming {
    public InterfacesFrog() {
        super();
    }

    public InterfacesFrog(String name, int age) {
        super(name, age);
    }

    @Override
    public void eating() {
        System.out.println("吃虫子🐛");
    }
    @Override
    public void swimming() {
        System.out.println("🐸会游泳");
    }
}

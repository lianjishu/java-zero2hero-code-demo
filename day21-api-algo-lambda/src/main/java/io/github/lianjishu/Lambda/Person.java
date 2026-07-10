package io.github.lianjishu.Lambda;

/**
 * lambda替代的是函数式接口的实现类
 */
public class Person {

    private String name;

    Person() {
    }

    Person(String name) {
        this.name = name;
    }

    private void swimLogic(FooFunctionalInterface swimInterface) {
        swimInterface.doSwim();
    }

    /**
     * public void doSwim() {
            this.swimLogic(new FooFunctionalInterface() {
                @Override
                public void doSwim() {
                    System.out.println("swimming...");
                }
            });
        }
     */

    public void doSwim() {
        this.swimLogic(() -> {
            System.out.println("swimming...");
        });
    }

    public static void main(String[] args) {
        Person p = new Person("zzy");
        p.doSwim();
    }
}

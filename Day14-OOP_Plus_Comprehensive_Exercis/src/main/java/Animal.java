public class Animal {
    //Animal属性
    private int age;
    private String color;
    //构造方法
    public Animal(){}
    public Animal(int age, String color){
        this.age = age;
        this.color = color;
    }
    //吃行为
    public void eat(String sth) {
        System.out.println("正在吃"+sth+"......");
    }
}
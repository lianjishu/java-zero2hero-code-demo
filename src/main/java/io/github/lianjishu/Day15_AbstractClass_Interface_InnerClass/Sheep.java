
public class Sheep extends Animal {
    public Sheep() {
        super();
    }
    public Sheep(String name, int age) {
        super(name, age);
    }
    @Override
    public void eating() {
        System.out.println("吃🌿");
    }
}

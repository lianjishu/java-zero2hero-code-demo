package implement2;

public class TestFooThread {
    public static void main(String[] args) {
        Thread threadFoo = new Thread(new BarImplemation());
        Thread threadBar = new Thread(new BarImplemation());
        Thread threadBaz = new Thread(new BarImplemation());

        threadFoo.setName("theading_foo");
        threadBar.setName("theading_bar");
        threadBaz.setName("theading_baz");

        threadFoo.start();
        threadBar.start();
        threadBaz.start();

    }
}

package e;

public class Test {
    public static void main(String[] args) {
        RaffleDraw raffleDraw = new RaffleDraw();

        Thread t1 = new Thread(raffleDraw, "抽奖箱1");
        Thread t2 = new Thread(raffleDraw, "抽奖箱2");

        t1.start();
        t2.start();
    }
}

package d;

public class Test {
    public static void main(String[] args) {
        GrabbingRedPackets grabbingRedPackets = new GrabbingRedPackets();
        new Thread(grabbingRedPackets, "第一个人").start();
        new Thread(grabbingRedPackets, "第二个人").start();
        new Thread(grabbingRedPackets, "第三个人").start();
        new Thread(grabbingRedPackets, "第四个人").start();
        new Thread(grabbingRedPackets, "第五个人").start();
    }
}

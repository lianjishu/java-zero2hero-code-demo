package ShowDeadLock;

public class TestThreadAB {
    public static void main(String[] args) {
        Thread threadA = new Thread(new ThreadAB(), "threadA");
        Thread threadB = new Thread(new ThreadAB(), "threadB");

        threadA.start();
        threadB.start();
    }
}

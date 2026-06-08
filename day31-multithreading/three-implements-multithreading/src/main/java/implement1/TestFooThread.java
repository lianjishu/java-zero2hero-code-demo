package implement1;

public class TestFindPrimeThread {
    public static void main(String[] args) {
        FindPrimeThread fpt1 = new FindPrimeThread();
        FindPrimeThread fpt2 = new FindPrimeThread();

        fpt1.setName("线程1");
        fpt2.setName("线程2");

        fpt1.start();
        fpt2.start();

    }
}

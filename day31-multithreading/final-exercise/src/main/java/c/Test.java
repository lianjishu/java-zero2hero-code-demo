package c;

public class Test {
    public static void main(String[] args) {
        EvenPrinter evenPrinter = new EvenPrinter();
        Thread t1 = new Thread(evenPrinter);
        Thread t2 = new Thread(evenPrinter);

        t1.start();
        t2.start();
    }
}

package ComprehensivePracticalExercises.OddPrinter;

public class Test {
    public static void main(String[] args) {
        Thread printer1 = new Thread(new OddPrinter());
        Thread printer2 = new Thread(new OddPrinter());
        printer1.start();
        printer2.start();
    }
}

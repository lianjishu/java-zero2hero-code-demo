package ComprehensivePracticalExercises.PresentGifts;

public class Test {
    public static void main(String[] args) {
        Thread giver1 = new Thread(new Giver());
        Thread giver2 = new Thread(new Giver());

        giver1.start();
        giver2.start();
    }
}

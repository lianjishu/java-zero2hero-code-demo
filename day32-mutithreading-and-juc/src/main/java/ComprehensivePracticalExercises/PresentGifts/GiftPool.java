package ComprehensivePracticalExercises.PresentGifts;

public class GiftPool {
    private static final int DEF_EMPTY_SIGNAL = 100;

    public static int getSignal() {
        signal = (count < 10 ? 0 : 1);
        return signal;
    }

    public static void setSignal(int signal) {
        GiftPool.signal = signal;
    }

    private static int signal = 1;

    public static void setCount(int count) {
        GiftPool.count = count;
    }

    public static int getCount() {
        return count;
    }

    private static int count = DEF_EMPTY_SIGNAL;

    public static final Object lock = new Object();


}

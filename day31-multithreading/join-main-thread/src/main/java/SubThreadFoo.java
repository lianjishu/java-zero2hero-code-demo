public class SubThreadFoo implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(
                    String.format("%s: %s",
                            Thread.currentThread().getName(),
                            "running...")
            );
        }
    }
}


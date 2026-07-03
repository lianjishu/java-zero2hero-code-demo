package io.github.lianjishu.ComprehensivePracticalExercises.OddPrinter;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class OddPrinter implements Runnable {
    public static final Lock lock = new ReentrantLock(true);
//    public static final Object lock = new Object();

    public static int index = 1;

    public static int signal = 1;

    public static int calcOdd(int n) {
        return 2 * n - 1;
    }


//    public void run() {
//        while (true) {
//            synchronized (lock) {
//                if (OddPrinter.signal <= 0) {
//                    break;
//                } else { // if: OddPrinter.signal > 0
//                    int res = OddPrinter.calcOdd(OddPrinter.index);
//                    if (res > 100) {
//                        OddPrinter.signal = 0;
//                        break;
//                    }
//                    System.out.printf(
//                            "[%s] - %d\n",
//                            Thread.currentThread().getName(),
//                            res
//                    );
//                    OddPrinter.index++;
//                }
//            }
//        }
//
//    }


    @Override
    public void run() {
        while (true) {
            try {
                OddPrinter.lock.lock();
                if (OddPrinter.signal <= 0) {
//                    OddPrinter.lock.unlock();
                    break;
                } else { // if: OddPrinter.signal > 0
                    int res = OddPrinter.calcOdd(OddPrinter.index);
                    if (res > 100) {
                        OddPrinter.signal = 0;
//                        OddPrinter.lock.unlock();
                        break;
                    }
                    System.out.printf(
                            "[%s] - %d\n",
                            Thread.currentThread().getName(),
                            res
                    );
                    OddPrinter.index++;
//                    OddPrinter.lock.unlock();
                }
            } finally {
                OddPrinter.lock.unlock();
            }
        }
    }

}

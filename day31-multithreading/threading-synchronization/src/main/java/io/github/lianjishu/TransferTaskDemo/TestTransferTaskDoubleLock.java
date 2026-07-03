package io.github.lianjishu.TransferTaskDemo;

// 模板:照 TODO 填完后,把 .tpl 后缀去掉,改名为 TestDeadlock.java
public class TestTransferTaskDoubleLock {

    public static void main(String[] args) throws InterruptedException {
        Account alice = new Account("Alice", 1000);
        Account bob = new Account("Bob", 1000);

        Thread thread1 = new Thread(new TransferTaskDoubleLock(alice, bob, 200), "T-AtoB");
        Thread thread2 = new Thread(new TransferTaskDoubleLock(bob, alice, 200), "T-BtoA");

        thread1.start();
//        thread1.join();
        thread2.start();
//        thread2.join();

        System.out.println("alice balance: " + alice.getBalance());
        System.out.println("bob balance: " + bob.getBalance());
    }
}

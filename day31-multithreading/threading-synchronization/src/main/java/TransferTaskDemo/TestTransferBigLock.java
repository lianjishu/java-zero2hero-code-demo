package TransferTaskDemo;

public class TestTransferBigLock {
    public static void main(String[] args) throws InterruptedException {
        Account alice = new Account("Alice", 1000);
        Account bob = new Account("Bob", 1000);

        Thread thread1 = new Thread(new TransferTaskBigLock(alice, bob, 200), "T-AtoB");
        Thread thread2 = new Thread(new TransferTaskBigLock(bob, alice, 200), "T-BtoA");

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
        System.out.println("alice balance: " + alice.getBalance());
        System.out.println("bob balance: " + bob.getBalance());
    }
}

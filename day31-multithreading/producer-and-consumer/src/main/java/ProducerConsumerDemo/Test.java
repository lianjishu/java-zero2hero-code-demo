package ProducerConsumerDemo;

public class Test {
    public static void main(String[] args) {
        Thread guest = new Thread(new Consumer(), "[guest-threading]");
        Thread chef = new Thread(new Producer(), "[chef-threading]");
        guest.start();
        chef.start();


    }
}

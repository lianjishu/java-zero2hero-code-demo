package threadpoolexecutor.availableprocessors;

public class GetAvailableProcessors {
    public static void main(String[] args) {
        int count = Runtime.getRuntime().availableProcessors();
        System.out.println("Available processors: " + count);
    }
}

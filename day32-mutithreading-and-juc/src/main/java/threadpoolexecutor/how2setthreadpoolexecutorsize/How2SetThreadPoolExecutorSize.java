package threadpoolexecutor.how2setthreadpoolexecutorsize;

public class How2SetThreadPoolExecutorSize {
    public static void main(String[] args) {
        // Cpu密集型 : 最大并行数+1
        // I/O密集型 : 最大并行数 * 期望CPU利用率 * (总时间=CPU计算时间+等待时间) / CPU计算时间
    }
}

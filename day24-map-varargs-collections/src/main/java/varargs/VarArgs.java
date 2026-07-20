package varargs;

/**
 * Sync : 修饰符 返回值类型 方法名(参数类型... 形参名){  }
 * 底层：其实就是一个数组
 * 好处: 在传递数据的时候，省的我们自己创建数组并添加元素了，JDK底层帮我们自动创建数组并添加元素了
 */
public class VarArgs {
    private static int getSum(int... num) {
        int sum = 0;
        for (var n : num)
            sum += n;
        return sum;
    }

    public static void main(String[] args) {
        System.out.printf("getSum: %d%n", getSum(1, 1, 1, 1));
    }
}

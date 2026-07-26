package exception.tryout.throwexception;

import java.util.PriorityQueue;

/**
 * throws：写在方法定义处，表示声明一个异常。告诉调用者，使用本方法可能会有哪些异常。
 * throw ：写在方法内，结束方法。手动抛出异常对象，交给调用者。方法中下面的代码不再执行了。
 * 运行时异常可以不throws声明出来
 * <p>
 * 需求：
 * 定义一个方法求数组的最大值
 */
public class MaxOfArray {
    private MaxOfArray() {
    }

    public static int getMaxOfArray(int[] array) /*throws NullPointerException, IllegalArgumentException*/ {
        if (array == null) throw new NullPointerException();
        if (array.length == 0) throw new IllegalArgumentException("Array is empty");

        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        try {
            getMaxOfArray(arr);
        } catch (NullPointerException | IllegalArgumentException e) {
            e.printStackTrace();
        } finally {
            System.out.println("程序正常结束...");
        }
    }
}

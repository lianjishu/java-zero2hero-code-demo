package io.github.lianjishu.Day22_Collection_List.TasteCollection;

// # Collection
// Collection是单列集合的祖宗接口，它的功能是全部单列集合都可以继承使用的。

// | 方法名称                                  | 说明               |
// |---------------------------------------|------------------|
// | `public boolean add(E e)`             | 把给定的对象添加到当前集合中   |
// | `public void clear()`                 | 清空集合中所有的元素       |
// | `public boolean remove(E e)`          | 把给定的对象在当前集合中删除   |
// | `public boolean contains(Object obj)` | 判断当前集合中是否包含给定的对象 |
// | `public boolean isEmpty()`            | 判断当前集合是否为空       |
// | `public int size()`                   | 返回集合中元素的个数/集合的长度 |

import java.util.ArrayList;
import java.util.Collection;

public class TasteCollectionInterface {
    static Collection<Integer> arrList = new ArrayList<>();

    // 辅助方法：打印集合当前内容
    private void printCollection(String label) {
        System.out.println(label + " -> " + arrList);
    }

    public TasteCollectionInterface testAdd() {
        System.out.println("===== testAdd =====");
        arrList.add(4);
        arrList.add(2);
        arrList.add(1);
        arrList.add(3);
        printCollection("添加 4, 2, 1, 3 后");
        return this;
    }

    public TasteCollectionInterface testClear() {
        System.out.println("===== testClear =====");
        // 先确保集合有元素
        if (arrList.isEmpty()) {
            arrList.add(10);
            arrList.add(20);
            arrList.add(30);
            printCollection("重新添加元素");
        }
        arrList.clear();
        printCollection("clear() 后");
        return this;
    }

    public TasteCollectionInterface testRemove() {
        System.out.println("===== testRemove =====");
        // 先确保集合有元素
        arrList.add(1);
        arrList.add(2);
        arrList.add(3);
        printCollection("添加 1, 2, 3 后");
        boolean removed = arrList.remove(Integer.valueOf(2));
        printCollection("remove(2) 后");
        System.out.println("remove 返回值: " + removed);
        return this;
    }

    public TasteCollectionInterface testContains() {
        System.out.println("===== testContains =====");
        // 先确保集合有元素
        if (arrList.isEmpty()) {
            arrList.add(1);
            arrList.add(2);
            arrList.add(3);
            printCollection("当前集合");
        }
        boolean has2 = arrList.contains(2);
        boolean has5 = arrList.contains(5);
        System.out.println("contains(2) = " + has2);
        System.out.println("contains(5) = " + has5);
        return this;
    }

    public TasteCollectionInterface testIsEmpty() {
        System.out.println("===== testIsEmpty =====");
        System.out.println("当前集合: " + arrList);
        System.out.println("isEmpty() = " + arrList.isEmpty());
        arrList.clear();
        System.out.println("clear() 后集合: " + arrList);
        System.out.println("isEmpty() = " + arrList.isEmpty());
        return this;
    }

    public TasteCollectionInterface testSize() {
        System.out.println("===== testSize =====");
        arrList.add(10);
        arrList.add(20);
        arrList.add(30);
        System.out.println("当前集合: " + arrList);
        System.out.println("size() = " + arrList.size());
        arrList.add(40);
        System.out.println("添加 40 后集合: " + arrList);
        System.out.println("size() = " + arrList.size());
        return this;
    }

    public static void main(String[] args) {
        new TasteCollectionInterface()
                .testAdd()
                .testClear()
                .testRemove()
                .testContains()
                .testIsEmpty()
                .testSize();
    }

}

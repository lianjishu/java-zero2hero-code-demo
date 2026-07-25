package stream.way2getstream;

import javax.print.attribute.standard.PrinterURI;
import java.util.*;
import java.util.stream.Stream;

/**
 * 获取Stream流的四种方式
 * <p>
 * <table border="1" cellpadding="5" style="border-collapse: collapse;">
 *     <caption>获取Stream流的方式汇总</caption>
 *     <thead>
 *         <tr>
 *             <th>数据来源</th>
 *             <th>获取Stream流的方式</th>
 *             <th>所属</th>
 *         </tr>
 *     </thead>
 *     <tbody>
 *         <tr>
 *             <td>单列集合</td>
 *             <td>{@code default Stream<E> stream()}</td>
 *             <td>Collection中的默认方法</td>
 *         </tr>
 *         <tr>
 *             <td>双列集合</td>
 *             <td>无</td>
 *             <td>无法直接使用stream流</td>
 *         </tr>
 *         <tr>
 *             <td>数组</td>
 *             <td>{@code public static <T> Stream<T> stream(T[] array)}</td>
 *             <td>Arrays工具类中的静态方法</td>
 *         </tr>
 *         <tr>
 *             <td>一堆零散数据</td>
 *             <td>{@code public static <T> Stream<T> of(T... values)}</td>
 *             <td>Stream接口中的静态方法</td>
 *         </tr>
 *     </tbody>
 * </table>
 *
 * @see java.util.Collection#stream()
 * @see java.util.Arrays#stream(Object[])
 * @see java.util.stream.Stream#of(Object...)
 * @since 1.8
 */
public class Way2GetStream {
    //从单列集合获取Stream
    private static void fromCollection() {

        //List
        ArrayList<String> al = new ArrayList<>();
        Collections.addAll(al, "a", "b", "c");
        al.stream().forEach(s -> System.out.printf("%s ", s));

        LinkedList<String> ll = new LinkedList<>();
        Collections.addAll(ll, "a", "b", "c");
        ll.stream().forEach(s -> System.out.printf("%s ", s));

        //Set
        HashSet<String> hs = new HashSet<>();
        Collections.addAll(hs, "a", "b", "c");
        hs.stream().forEach(s -> System.out.printf("%s ", s));

        LinkedHashSet<String> lhs = new LinkedHashSet<>();
        Collections.addAll(lhs, "a", "b", "c");
        lhs.stream().forEach(s -> System.out.printf("%s ", s));

        TreeSet<String> ts = new TreeSet<>();
        Collections.addAll(ts, "a", "b", "c");
        ts.stream().forEach(s -> System.out.printf("%s ", s));

        //Queue
        PriorityQueue<String> pq = new PriorityQueue<>();
        Collections.addAll(pq, "a", "b", "c");
        pq.stream().forEach(s -> System.out.printf("%s ", s));

        ArrayDeque<String> ad = new ArrayDeque<>();
        Collections.addAll(ad, "a", "b", "c");
        ad.stream().forEach(s -> System.out.printf("%s ", s));

    }

    //从双列集合获取Stream
    private static void fromMap() {
        HashMap<String, String> hm = new HashMap<>();
        Stream<Map.Entry<String, String>> hmStream = hm.entrySet().stream();

        TreeMap<String, String> tm = new TreeMap<>();
        Stream<Map.Entry<String, String>> tmStream = tm.entrySet().stream();
    }

    //从数组获取Stream
    private static void fromPrimitiveArray() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Arrays.stream(arr).forEach(i -> System.out.print(i + " "));
        System.out.println();
        String[] arr2 = {"a", "b", "c", "d"};
        Arrays.stream(arr2).forEach(s -> System.out.print(s + " "));
        System.out.println();
    }

    //一堆零散数据
    private static void fromSpecifiedData() {
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0).forEach(i -> System.out.print(i + " "));
        System.out.println();
        Stream.of("A", "B", "C", "D").forEach(s -> System.out.print(s + " "));
        System.out.println();
    }
}

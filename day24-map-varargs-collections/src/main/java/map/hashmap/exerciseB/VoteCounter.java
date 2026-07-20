package map.hashmap.exerciseB;

import java.util.*;

/**
 * 案例  Map集合案例-统计投票人数
 *
 * <p>
 * 需求
 * </p>
 *
 * <p>
 * 某个班级80名学生，现在需要组成秋游活动，班长提供了四个景点依次是（A、B、C、D），每个学生只
 * 能选择一个景点，请统计出最终哪个景点想去的人数最多。
 * </p>
 *
 * @author lianjishu
 * @see java.util.Map
 * @see java.util.HashMap
 * @since 2026-07-17
 */
public class VoteCounter {
    private static HashMap<String, Integer> counter = new HashMap<>();

    // TODO:
    //   1. 准备 80 名学生的投票数据（Mock 即可，如 String[] votes = {"A","B","A",...};）
    //   2. 用 Map<String, Integer> 统计每个景点的票数
    //      - 推荐 HashMap<K,V> 或数组下标索引法二选一
    //   3. 遍历 map，找出 value 最大的那个 key，输出 "想去 X 的最多，共 N 人"

    public static void doVote(Vote[] votesList) {
        for (var v : votesList) {
            voteLogic(v);
        }
    }

    private static void voteLogic(Vote vote) {
        if (!counter.containsKey(vote.getScenicSpot().getName()))
            counter.put(vote.getScenicSpot().getName(), 1);
        else
            counter.put(vote.getScenicSpot().getName(), counter.get(vote.getScenicSpot().getName()) + 1);
    }

    public static ArrayList<Map.Entry<String, Integer>> voteStats(int k) {
        if (k <= 0 || k > counter.size()) return new ArrayList<>();
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                (a, b) -> b.getValue() - a.getValue()   // value 降序,堆顶最大
        );
        pq.addAll(counter.entrySet());
        var res = new ArrayList<Map.Entry<String, Integer>>(k);
        for (int i = 0; i < k; i++) res.add(pq.poll());
        return res;
    }

    public static void printer() {
        Set<Map.Entry<String, Integer>> entrySet = counter.entrySet();
        for (var e : entrySet) System.out.printf("%s->%d%n", e.getKey(), e.getValue());
    }
}
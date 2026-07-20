package map.hashmap.exerciseB;

public class Test {
    public static void main(String[] args) {
        Vote[] votes = MockData.getMockData();
        VoteCounter.doVote(votes);
        var res = VoteCounter.voteStats(1);   // k=1: explicitly asking for the winner
        var winner = res.getFirst();
        System.out.printf("想去 %s 的最多，共 %d 人%n", winner.getKey(), winner.getValue());
        System.out.println("投票结果如下:");
        VoteCounter.printer();
    }

}

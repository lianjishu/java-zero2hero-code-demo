package comprehensivexercise.exerciseA.randomrollcallsystem.v2.weightedpick;

import java.util.Random;

/**
 * <h1>班级里有N个学生</h1>
 * <strong>要求</strong>
 * <ul>
 * <li>70%概率随机到男生</li>
 * <li>30%概率随机到女生</li>
 * </ul>
 */
public class WeightedPick {
    private Random random = new Random();
    private String[] roster = null;

    public void receive(String[] roster) {
        this.roster = roster;
//        Random
    }

    public String doPick() {
        int luckyDog = random.nextInt(roster.length);
        return roster[luckyDog];
    }

    public void show() {
        System.out.println();
    }
}

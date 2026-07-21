package comprehensivexercise.exerciseA.randomrollcallsystem.v1.uniformpick;

import java.util.Random;

/**
 * <h1>自动点名器1</h1>
 * <p>班级里有N个学生, 实现随机点名器</p>
 */
public class UniformPick {
    private Random random = new Random();
    private String[] roster = null;

    public void receive(String[] roster) {
        this.roster = roster;
    }

    public String doPick() {
        int luckyDog = random.nextInt(roster.length);
        return roster[luckyDog];
    }

    public void show() {
        System.out.println();
    }

}

package comprehensivexercise.exerciseA.randomrollcallsystem.v3.uniquepick;

import java.util.ArrayList;
import java.util.Random;

/**
 * 自动点名器3
 * 班级里有N个学生
 * 要求：
 * 被点到过的学生不会再被点到。
 * 但是如果班级中所有的学生都点完了，需要重新开启第二轮点名
 */
public class UniquePick {
    private ArrayList<String> primaryRoster;
    private ArrayList<String> secondaryRoster;
    private final Random r = new Random();

    UniquePick() {
    }

    public void receive(ArrayList<String> roster) {
        this.primaryRoster = new ArrayList<>(roster);
        this.secondaryRoster = new ArrayList<>(roster.size());
    }

    public ArrayList<String> selectName(int n) {
        if (n <= 0 || n > primaryRoster.size() + secondaryRoster.size())
            return null;

        ArrayList<String> selections = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            if (primaryRoster.isEmpty()) {
                primaryRoster.addAll(secondaryRoster);
            }
            int IndSelection = r.nextInt(primaryRoster.size());
            String selection = primaryRoster.remove(IndSelection);
            selections.add(selection);
            this.secondaryRoster.add(selection);
        }
        return selections;
    }
}

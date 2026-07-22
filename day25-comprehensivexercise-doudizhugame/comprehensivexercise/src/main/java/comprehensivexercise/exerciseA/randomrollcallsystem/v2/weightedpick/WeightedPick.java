package comprehensivexercise.exerciseA.randomrollcallsystem.v2.weightedpick;

import java.util.List;
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
    private static int[] genderList = new int[]{0, 0, 0, 1, 1, 1, 1, 1, 1, 1};

    private int selectMaleOrFemale() {
        return genderList[new Random().nextInt(genderList.length)];
    }

    public String selectName(List<String> maleList, List<String> femaleList) {
        int gender = this.selectMaleOrFemale();
        Random r = new Random();
        return switch (gender) {
            case 0 -> femaleList.get(r.nextInt(femaleList.size()));
            case 1 -> maleList.get(r.nextInt(maleList.size()));
            default -> "";
        };
    }


}

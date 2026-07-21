package comprehensivexercise.exerciseA.randomrollcallsystem.v1.uniformpick;

public class Test {
    private static String[] roster = new String[]{
            "张三", "李四"
    };

    public static void main(String[] args) {
        UniformPick picker = new UniformPick();
        picker.receive(roster);
        System.out.println(picker.doPick());
        ;
    }
}

package map.hashmap.exerciseB;

public enum ScenicSpot {
    SPOT_A("A"), SPOT_B("B"), SPOT_C("C"), SPOT_D("D");

    private String name;

    ScenicSpot(String strOrdinary) {
        this.name = strOrdinary;
    }

    public String getName() {
        return name;
    }
}

package map.hashmap.exerciseB;

import java.util.Objects;

public class Vote {
    private String id;
    private ScenicSpot scenicSpot;

    public Vote() {
    }

    public Vote(String id, ScenicSpot scenicSpot) {
        this.id = id;
        this.scenicSpot = scenicSpot;
    }

    public String getId() {
        return id;
    }

    public ScenicSpot getScenicSpot() {
        return scenicSpot;
    }

    public void setScenicSpot(ScenicSpot scenicSpot) {
        this.scenicSpot = scenicSpot;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Vote{" +
                "id='" + id + '\'' +
                ", scenicSpot=" + scenicSpot +
                '}';
    }

//    @Override
//    public boolean equals(Object o) {
//        if (o == null || getClass() != o.getClass()) return false;
//        Vote vote = (Vote) o;
//        return Objects.equals(id, vote.id) && scenicSpot == vote.scenicSpot;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, scenicSpot);
//    }
}

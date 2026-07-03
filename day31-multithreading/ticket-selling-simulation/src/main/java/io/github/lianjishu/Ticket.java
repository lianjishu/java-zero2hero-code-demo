package io.github.lianjishu;

public class Ticket {
    private String id;
    private String time;
    private String movie;

    public Ticket() {
    }

    public Ticket(String id, String time, String movie) {
        this.id = id;
        this.time = time;
        this.movie = movie;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id='" + id + '\'' +
                ", time='" + time + '\'' +
                ", movie='" + movie + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }
}

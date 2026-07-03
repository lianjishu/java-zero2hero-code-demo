package io.github.lianjishu.implement2;

public class BarImplemation implements Runnable{

    private String id;
    private Thread cthread;

    public BarImplemation() {}
//    public BarImplemation(String id) {setId(id);}


    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    private void toRun() {
        setId(Thread.currentThread().getName());
        for (int i=0; i<10; ++i) {System.out.println(String.format("%s: %s", getId(), "running..."));}
    }

    public void run() {
        toRun();
    }

}

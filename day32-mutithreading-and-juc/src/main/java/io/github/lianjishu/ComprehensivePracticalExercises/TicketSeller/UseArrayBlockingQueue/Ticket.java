package io.github.lianjishu.ComprehensivePracticalExercises.TicketSeller.UseArrayBlockingQueue;

import java.util.ArrayList;

public class Ticket {
    private String id;
    private String movieName;

    public Ticket(String movieName, String id) {
        this.movieName = movieName;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    Ticket() {}

    public static ArrayList<Ticket> TicketGenerater() {
        ArrayList<Ticket> tickets = new ArrayList<>(1000);
        String[] movieNames = {
                // 国产大片
                "流浪地球3", "封神第三部", "哪吒之魔童闹海",
                "唐探1900", "射雕英雄传", "熊出没·重启未来",
                "满江红", "长津湖", "战狼2", "你好李焕英",
                // 经典华语
                "霸王别姬", "大话西游", "无间道", "让子弹飞",
                "功夫", "喜剧之王", "少林足球", "倩女幽魂",
                // 好莱坞
                "阿凡达3", "复仇者联盟5", "蜘蛛侠：新纪元",
                "碟中谍8", "速度与激情11", "侏罗纪世界4",
                "哈利波特与被诅咒的孩子", "星际穿越2",
                // 动画
                "疯狂动物城2", "冰雪奇缘3", "千与千寻",
                "龙猫", "你的名字", "铃芽之旅",
                // 科幻经典
                "黑客帝国5", "盗梦空间2", "银翼杀手2099",
                "异形：觉醒", "沙丘3", "终结者7",
                // 🔥 恐怖片
                "咒怨", "午夜凶铃", "厉鬼将映",
                "安娜贝尔3", "招魂4", "小丑回魂3",
                "电锯惊魂11", "死神来了6", "潜伏5",
                "寂静之地3", "逃出绝命镇", "遗传厄运",
                "仲夏夜惊魂", "哭悲", "灵媒",
                "关灯以后2", "昆池岩", "鬼影",
                "恐怖邮轮", "闪灵续篇", "驱魔人：信徒"
        };
        for (int i = 1; i <= 1000; i++) {
            String movieName = movieNames[i % movieNames.length];
            String id = String.format("%s-%04d", movieName, i);
            tickets.add(new Ticket(movieName, id));
        }
        return tickets;
    }


}

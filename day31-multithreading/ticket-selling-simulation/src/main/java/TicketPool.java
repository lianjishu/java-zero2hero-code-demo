import java.util.ArrayList;
import java.util.Arrays;

public class TicketPool {

    public static Object LOCK = new Object();

    public static boolean isEmpty() {
        return TicketPool.remaining==0;
    }

    private static ArrayList<Ticket> tickets = new ArrayList<>(Arrays.asList(
            // 阿凡达2 - 10:00 场 (5张)
            new Ticket("0001", "10:00", "阿凡达2"),
            new Ticket("0002", "10:00", "阿凡达2"),
            new Ticket("0003", "10:00", "阿凡达2"),
            new Ticket("0004", "10:00", "阿凡达2"),
            new Ticket("0005", "10:00", "阿凡达2"),

            // 流浪地球3 - 13:30 场 (5张)
            new Ticket("0006", "13:30", "流浪地球3"),
            new Ticket("0007", "13:30", "流浪地球3"),
            new Ticket("0008", "13:30", "流浪地球3"),
            new Ticket("0009", "13:30", "流浪地球3"),
            new Ticket("0010", "13:30", "流浪地球3"),

            // 满江红 - 16:00 场 (5张)
            new Ticket("0011", "16:00", "满江红"),
            new Ticket("0012", "16:00", "满江红"),
            new Ticket("0013", "16:00", "满江红"),
            new Ticket("0014", "16:00", "满江红"),
            new Ticket("0015", "16:00", "满江红"),

            // 速度与激情10 - 19:00 场 (5张)
            new Ticket("0016", "19:00", "速度与激情10"),
            new Ticket("0017", "19:00", "速度与激情10"),
            new Ticket("0018", "19:00", "速度与激情10"),
            new Ticket("0019", "19:00", "速度与激情10"),
            new Ticket("0020", "19:00", "速度与激情10"),

            // 无名 - 21:30 场 (5张)
            new Ticket("0021", "21:30", "无名"),
            new Ticket("0022", "21:30", "无名"),
            new Ticket("0023", "21:30", "无名"),
            new Ticket("0024", "21:30", "无名"),
            new Ticket("0025", "21:30", "无名"),

            // 新增加的电影场次 ↓↓↓

            // 变形金刚7 - 10:30 场 (3张)
            new Ticket("0026", "10:30", "变形金刚7"),
            new Ticket("0027", "10:30", "变形金刚7"),
            new Ticket("0028", "10:30", "变形金刚7"),

            // 消失的她 - 14:00 场 (3张)
            new Ticket("0029", "14:00", "消失的她"),
            new Ticket("0030", "14:00", "消失的她"),
            new Ticket("0031", "14:00", "消失的她"),

            // 疯狂元素城 - 15:30 场 (3张)
            new Ticket("0032", "15:30", "疯狂元素城"),
            new Ticket("0033", "15:30", "疯狂元素城"),
            new Ticket("0034", "15:30", "疯狂元素城"),

            // 孤注一掷 - 18:00 场 (3张)
            new Ticket("0035", "18:00", "孤注一掷"),
            new Ticket("0036", "18:00", "孤注一掷"),
            new Ticket("0037", "18:00", "孤注一掷"),

            // 封神第一部 - 20:30 场 (3张)
            new Ticket("0038", "20:30", "封神第一部"),
            new Ticket("0039", "20:30", "封神第一部"),
            new Ticket("0040", "20:30", "封神第一部"),

            // 八角笼中 - 22:00 场 (2张)
            new Ticket("0041", "22:00", "八角笼中"),
            new Ticket("0042", "22:00", "八角笼中"),

            // 长安三万里 - 11:00 场 (2张)
            new Ticket("0043", "11:00", "长安三万里"),
            new Ticket("0044", "11:00", "长安三万里"),

            // 热烈 - 17:00 场 (2张)
            new Ticket("0045", "17:00", "热烈"),
            new Ticket("0046", "17:00", "热烈"),

            // 阿嬷的情书 - 14:30 场 (3张)
            new Ticket("0047", "14:30", "阿嬷的情书"),
            new Ticket("0048", "14:30", "阿嬷的情书"),
            new Ticket("0049", "14:30", "阿嬷的情书")
    ));

    private static Integer remaining = tickets.size();

    public static Integer getRemaining() {
        return TicketPool.remaining;
    }

    public static void setRemaining(int remaining) {
        TicketPool.remaining = remaining;
    }

    public static void setTickets(ArrayList<Ticket> tickets) {
        TicketPool.tickets = tickets;
    }

    public static ArrayList<Ticket> getTickets() {
        return tickets;
    }

}

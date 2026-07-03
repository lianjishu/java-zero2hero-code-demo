package io.github.lianjishu;

import java.util.ArrayList;
import java.util.List;

/**
 * 注: 本类历史上由注解处理器生成(target/generated-sources/annotations/),
 * 但仓库未配置对应的 processor,导致 plain {@code mvn compile} 会失败。
 * 此处补一份最小可编译的实现,使其在不改 pom 的前提下通过编译。
 */
public class TicketPool {

    private static final List<Ticket> tickets = new ArrayList<>();
    private static int remaining = 1000;

    public static boolean isEmpty() {
        return remaining <= 0;
    }

    public static List<Ticket> getTickets() {
        return tickets;
    }

    public static int getRemaining() {
        return remaining;
    }

    public static void setRemaining(int remaining) {
        TicketPool.remaining = remaining;
    }
}

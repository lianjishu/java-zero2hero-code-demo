package io.github.lianjishu.Iterator;

import java.util.*;

public class TasteIterator {
    private ArrayList<String> arrayList = new ArrayList<>(List.of(
            "三",
                    "连",
                    "外",
                    "加",
                    "转",
                    "发",
                    "了",
                    "吗",
                    "?",
                    "?",
                    "?"
    ));
    public TasteIterator test() {
        System.out.println(arrayList);
        Iterator<String> it = arrayList.iterator();
        boolean signal = it.hasNext();
        while (signal) {
            String next = it.next();
            System.out.println(next);
            signal = it.hasNext();
        }

        return this;
    }
}

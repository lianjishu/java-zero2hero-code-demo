package io.github.lianjishu;

import java.util.*;

public class PokerGame {
    //牌盒
    static HashMap<Integer, String> cardBox = new HashMap<>();
    static ArrayList<Integer> cardList = new ArrayList<>();

    static {
        String[] suit = {"♦", "♣", "♥", "♠"};                                              //花色
        String[] rank = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"}; //数字
        int weight = 1;
        for (String r : rank)
            for (String s : suit) cardBox.put(weight++, s + r);
        cardBox.put(weight++, "SMALL_JOKER");
        cardBox.put(weight, "BIG_JOKER");

        //初始化cardList
        Set<Map.Entry<Integer, String>> entries = cardBox.entrySet();
        entries.forEach(e -> cardList.add(e.getKey()));
    }

    PokerGame() {
        //shuffle洗牌
        Collections.shuffle(cardList);

        //deal发牌
        ArrayList<Integer> landlord = new ArrayList<>(); //地主
        ArrayList<Integer> player1 = new ArrayList<>();  //玩家1
        ArrayList<Integer> player2 = new ArrayList<>();  //玩家2
        ArrayList<Integer> player3 = new ArrayList<>();  //玩家3
        for (int i = 0; i < cardList.size(); ++i) {
            if (i <= 2) {
                landlord.add(cardList.get(i));
                continue;
            }
            if (i % 3 == 0)
                player1.add(cardList.get(i));
            else if (i % 3 == 1)
                player2.add(cardList.get(i));
            else
                player3.add(cardList.get(i));
        }

        //ShowHand看牌 || Showdown 摊牌
        // 根据每张牌的weight来排序
        Collections.sort(landlord);
        Collections.sort(player1);
        Collections.sort(player2);
        Collections.sort(player3);
        // 展示手中的牌
        showHand("底牌", landlord);
        showHand("刚脑壳", player1);
        showHand("大帅比", player2);
        showHand("蛋筒", player3);
    }

    /**
     *
     * @params String 玩家
     * @params ArrayList<String> 玩家的牌
     */
    private void showHand(String player, ArrayList<Integer> cards) {
        System.out.print(player + ": ");
        for (Integer c : cards)
            System.out.print(cardBox.get(c) + " ");
        System.out.println();
    }
}

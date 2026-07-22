package io.github.lianjishu;

import java.util.ArrayList;
import java.util.Collections;

public class PokerGame {
    static ArrayList<String> cardBox = new ArrayList<>();

    {
        String[] rank = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};
        String[] suit = {"♦", "♣", "♥", "♠"};

        for (String r : rank)
            for (String s : suit) cardBox.add(s + r);
        cardBox.add("RED_JOKER");
        cardBox.add("BLACK_JOKER");
    }

    public PokerGame() {
        System.out.println(cardBox);
        //shuffle洗牌
        Collections.shuffle(cardBox);
        System.out.println(cardBox);

        //deal发牌
        ArrayList<String> landlord = new ArrayList<>(); //地主
        ArrayList<String> player1 = new ArrayList<>();  //玩家1
        ArrayList<String> player2 = new ArrayList<>();  //玩家2
        ArrayList<String> player3 = new ArrayList<>();  //玩家3
        for (int i = 0; i < cardBox.size(); ++i) {
            if (i <= 2) {
                landlord.add(cardBox.get(i));
                continue;
            }
            //轮流给三个玩家发牌
            if (i % 3 == 0)
                player1.add(cardBox.get(i));
            else if (i % 3 == 1)
                player2.add(cardBox.get(i));
            else
                player3.add(cardBox.get(i));
        }

        //ShowHand 看牌 Showdown 摊牌
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
    private void showHand(String player, ArrayList<String> cards) {
        System.out.print(player + ": ");
        for (String c : cards)
            System.out.print(c + " ");
        System.out.println();
    }
}

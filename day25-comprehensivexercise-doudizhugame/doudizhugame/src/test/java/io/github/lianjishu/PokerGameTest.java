package io.github.lianjishu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PokerGameTest {

    @Test
    void cardBoxShouldHave54Cards() {
        assertEquals(54, PokerGame.cardBox.size());
    }

    @Test
    void firstCardShouldBe3() {
        assertEquals("3", PokerGame.cardBox.get(1).substring(1));
    }

    @Test
    void bigJokerShouldBe54() {
        assertEquals("BIG_JOKER", PokerGame.cardBox.get(54));
    }
}
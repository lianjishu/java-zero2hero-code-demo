package io.github.lianjishu;
public class GameTest {
    public static void main(String[] args) {
        Role QiaoFeng = new Role("乔峰");
        Role JiuZhimo = new Role("鸠智摩");
        FightGame fightGame = new FightGame(QiaoFeng, JiuZhimo);

        fightGame.go();

    }



}

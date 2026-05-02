package io.github.lianjishu.Day09_OOP_Practice;
public class FightGame {
    private Role roleA;
    private Role roleB;

    public FightGame() {}
    public FightGame(Role role1, Role role2) {
        this.roleA = role1;
        this.roleB = role2;
    }
    public void go() {
        System.out.println("游戏开始！");
        while(roleA.getHp()>0 && roleB.getHp()>0){
            int damage_A2B = roleA.attack(roleB);
            System.out.println(roleA.getName()+"打了"+roleB.getName()+"一下，" +
                    "造成了"+damage_A2B+"点伤害，"+roleB.getName()+"还剩下"+roleB.getHp()+"点血量");
            if(roleB.getHp() == 0) break;
            int damage_B2A = roleB.attack(roleA);
            System.out.println(roleB.getName()+"打了"+roleA.getName()+"一下，" +
                    "造成了"+damage_B2A+"点伤害，"+roleA.getName()+"还剩下"+roleA.getHp()+"点血量");
            if(roleA.getHp() == 0) break;
        }
        if(roleA.getHp() == 0)
            System.out.println(roleB.getName() + "K.O.了" + roleA.getName());
        if(roleB.getHp() == 0)
            System.out.println(roleA.getName() + "K.O.了" + roleB.getName());
    }

    public void broadcast(int damage) {
        System.out.println();
    }
}

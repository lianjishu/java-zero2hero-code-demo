import javax.swing.text.StyledEditorKit;
import java.util.Random;

public class Role {
    private String name;
    private int hp = 100;
//    private Role opponent;
//    private boolean death;

    public Role() {}
    public Role(String name) {
        this.name = name;
    }
    public void setAttr(int hp) {
        this.hp = hp;
    }

    public int getHp() {
        return (Math.max(this.hp, 0));
    }
    public String getName() {
        return this.name;
    }

    public int attack(Role who) {
        Random r = new Random();
        int damage = r.nextInt(6) + 10;
        who.hp -= damage;
        return damage;
    }

}
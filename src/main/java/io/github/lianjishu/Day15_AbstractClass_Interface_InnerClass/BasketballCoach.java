
public class BasketballCoach extends Person{
    public BasketballCoach() {
        super();
    }
    public BasketballCoach(String name, int age) {
        super(name, age);
    }

    @Override
    public void working() {
        System.out.println("教打篮球🏀");
    }
    @Override
    public int getAge() {
        return super.getAge();
    }
    @Override
    public void setAge(int age) {
        super.setAge(age);
    }
    @Override
    public String getName() {
        return super.getName();
    }
    @Override
    public void setName(String name) {
        super.setName(name);
    }
}

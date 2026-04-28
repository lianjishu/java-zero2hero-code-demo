public class Person{
    private String name;
    private int age;

    public Person(){}
    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void keepPet(){
        System.out.println("养宠物......");
    }
}
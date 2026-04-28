public class Switch {
    public static void main(String[] args) {
        /*
        * 旧写法:
        * switch(num){
        * case 1:
        *   System.out.println("一");
        *   break;
        * case 2:
        *    System.out.println("二");
              break;
        * case 3:
        *       System.out.println("三");
                break;
        * default :
        *       System.out.println("NONONO");
                break;
        * }
        * */

        // 新写法 JDK12
        int num = 1;
        switch (num){
            case 1 -> {
                System.out.println("一");
            }
            case 2 -> {
                System.out.println("二");
            }
            default -> {
                System.out.println("NONONO");
            }
        }
    }
}

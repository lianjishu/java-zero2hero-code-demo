import java.util.Stack;

public class ComputerData {
    public static void example(){
        System.out.println("二进制表示: ");
        System.out.println(0b1000000);
        System.out.println("八进制表示: ");
        System.out.println(0100);
        System.out.println("十六进制: ");
        System.out.println(0x40);
        System.out.println("十进制: ");
        System.out.println(64);
    }

    public static int dec2bin(int num){
        if (num==0) return 0;
        Stack<Integer> stack = new Stack<>();
        while(true){
            stack.push(num % 2);
            num /= 2;
            if(num == 0) break;
        }   

        return 0;
        
    }
    public static void main(String[] args) {
        example();
    }
}

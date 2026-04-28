import java.util.ArrayList;
import java.util.Stack;

/**
 *
 *需求：
   某系统的数字密码（大于0），比如1983，采用加密方式进行传输。
 * 规则如下：
   先得到每位数，然后每位数都加上5 , 再对10求余，最后将所有数字反转，得到一串新数。
 * 举例：
            1	9	8	3
    +5		6   14  13  8
    %10		6   4   3   8
   反转	    8   3   4   6
   加密后的结果就是：8346
 */
class DigitalEncryption {

    public static void main(String[] args) {
        String passwd = "1983";
        ArrayList<Integer> new_pswd = new ArrayList<>();
        Stack<Integer> stk = new Stack<>();
        for(int i=0; i<passwd.length(); ++i) {
            int digit = passwd.charAt(i)-'0';
            digit += 5;
            digit %= 10;
            stk.push(digit);
        }
        while(!stk.empty()) {
            new_pswd.add(stk.peek());
            stk.pop();
        }
        int res = 0;
        for(var it : new_pswd) {
            res*=10;
            res+=it;
        }
        System.out.println(res);
    }
}

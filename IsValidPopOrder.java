import java.util.ArrayList;
import java.util.Deque;
import java.util.ArrayDeque;

public class IsValidPopOrder {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA == null && popA == null) return false;
        
        Deque<Integer> stack = new ArrayDeque<>();
        int pu = 1, po = 0;
        stack.push(pushA[0]);
        while (po < popA.length) {
            if (popA[po] == stack.peek()) {
                stack.pop();
                po++;
            } else {
                while (pu < pushA.length) {
                    stack.push(pushA[pu]);
                    if (popA[po] == pushA[pu]) {
                        if (pu + 1 < pushA.length) pu++;
                        break;
                    }
                    pu++;
                }
                if (pu >= pushA.length) return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        int[] pushA = new int[] {1,2,3,4,5};
        int[] popA = new int[] {4,5,3,2,1};
        IsValidPopOrder test = new IsValidPopOrder();
        boolean res = test.IsPopOrder(pushA, popA);
        System.out.println(res);
    }
}
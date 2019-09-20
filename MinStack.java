import java.util.Deque;
import java.util.ArrayDeque;

public class MinStack {
    private Deque<Integer> data = new ArrayDeque<>();
    private Deque<Integer> min = new ArrayDeque<>();
    
    public void push(int node) {
        data.push(node);
        if (min.isEmpty() || node < min()) {
            min.push(node);
        } else {
            min.push(min());
        }
    }
    
    public void pop() {
        assert(!min.isEmpty() && !data.isEmpty());
        min.pop();
        data.pop();
    }
    
    public int top() {
        return min.peek();
    }
    
    public int min() {
        assert(!min.isEmpty() && !data.isEmpty());
        return min.peek();
    }
}
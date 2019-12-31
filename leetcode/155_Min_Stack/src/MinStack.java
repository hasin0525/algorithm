import java.util.Stack;

class MinStack {
	class Element {
		int val, min;

		public Element(int val, int min) {
			this.val = val;
			this.min = min;
		}
		
	}
	private Stack<Element> stack;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int x) {
    	int min = stack.isEmpty() ? x : (x < stack.peek().min ? x : stack.peek().min);
    	stack.push(new Element(x,min));
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek().val;
    }
    
    public int getMin() {
    	return stack.peek().min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
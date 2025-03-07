package easy30;

import java.util.Stack;

/**
 * @Author ayl
 * @Date 2023-04-16
 * 面试题 03.04. 化栈为队
 * 实现一个MyQueue类，该类用两个栈来实现一个队列。
 * <p>
 * <p>
 * 示例：
 * <p>
 * MyQueue queue = new MyQueue();
 * <p>
 * queue.push(1);
 * queue.push(2);
 * queue.peek();  // 返回 1
 * queue.pop();   // 返回 1
 * queue.empty(); // 返回 false
 * <p>
 * 说明：
 * <p>
 * 你只能使用标准的栈操作 -- 也就是只有 push to top, peek/pop from top, size 和 is empty 操作是合法的。
 * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 * 假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）。
 */
public class Code4 {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    /**
     * Initialize your data structure here.
     */
    public Code4() {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        //如果1有
        while (stack1.isEmpty() == false) {
            //推入2
            stack2.push(stack1.pop());
        }
        //加入本身
        stack1.push(x);
        //如果1有
        while (stack2.isEmpty() == false) {
            //推入2
            stack1.push(stack2.pop());
        }
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        return stack1.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        return stack1.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return stack1.empty();
    }

    public static void main(String[] args) {
        Code4 code4 = new Code4();
        code4.push(1);
        code4.push(3);
        code4.push(4);
        System.out.println(code4.pop());
        System.out.println(code4.peek());
        System.out.println(code4.empty());
    }

}

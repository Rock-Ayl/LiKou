package normal25;

import java.util.Stack;

/**
 * @Author ayl
 * @Date 2023-10-12
 * 面试题 03.05. 栈排序
 * 提示
 * 中等
 * 102
 * 相关企业
 * 栈排序。 编写程序，对栈进行排序使最小元素位于栈顶。最多只能使用一个其他的临时栈存放数据，但不得将元素复制到别的数据结构（如数组）中。该栈支持如下操作：push、pop、peek 和 isEmpty。当栈为空时，peek 返回 -1。
 * <p>
 * 示例1:
 * <p>
 * 输入：
 * ["SortedStack", "push", "push", "peek", "pop", "peek"]
 * [[], [1], [2], [], [], []]
 * 输出：
 * [null,null,null,1,null,2]
 * 示例2:
 * <p>
 * 输入：
 * ["SortedStack", "pop", "pop", "push", "pop", "isEmpty"]
 * [[], [], [], [1], [], []]
 * 输出：
 * [null,null,null,null,null,true]
 * 说明:
 * <p>
 * 栈中的元素数目在[0, 5000]范围内。
 */
public class Code2 {

    //栈
    private Stack<Integer> stack;
    //临时栈
    private Stack<Integer> spaceStack;

    public Code2() {
        //初始化
        this.stack = new Stack<>();
        this.spaceStack = new Stack<>();
    }

    public void push(int val) {
        //如果有更小的
        while (stack.isEmpty() == false && stack.peek() < val) {
            //存入临时
            spaceStack.push(stack.pop());
        }
        //加入本次
        stack.push(val);
        //如果有更小的
        while (spaceStack.isEmpty() == false) {
            //放回去
            stack.push(spaceStack.pop());
        }
    }

    public void pop() {
        //如果存在内容
        if (stack.isEmpty() == false) {
            //执行
            stack.pop();
        }
    }

    public int peek() {
        //如果存在内容
        if (stack.isEmpty() == false) {
            //执行
            return stack.peek();
        } else {
            //默认
            return -1;
        }
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Code2 code2 = new Code2();
        code2.push(3);
        code2.push(1);
        code2.push(2);
        code2.push(4);
        code2.push(0);
        code2.push(5);
        System.out.println();

    }

}

package normal25;

import java.util.Stack;

/**
 * @Author ayl
 * @Date 2023-10-25
 * 面试题 03.03. 堆盘子
 * 提示
 * 中等
 * 58
 * 相关企业
 * 堆盘子。设想有一堆盘子，堆太高可能会倒下来。因此，在现实生活中，盘子堆到一定高度时，我们就会另外堆一堆盘子。请实现数据结构SetOfStacks，模拟这种行为。SetOfStacks应该由多个栈组成，并且在前一个栈填满时新建一个栈。此外，SetOfStacks.push()和SetOfStacks.pop()应该与普通栈的操作方法相同（也就是说，pop()返回的值，应该跟只有一个栈时的情况一样）。 进阶：实现一个popAt(int index)方法，根据指定的子栈，执行pop操作。
 * <p>
 * 当某个栈为空时，应当删除该栈。当栈中没有元素或不存在该栈时，pop，popAt 应返回 -1.
 * <p>
 * 示例1:
 * <p>
 * 输入：
 * ["StackOfPlates", "push", "push", "popAt", "pop", "pop"]
 * [[1], [1], [2], [1], [], []]
 * 输出：
 * [null, null, null, 2, 1, -1]
 * 示例2:
 * <p>
 * 输入：
 * ["StackOfPlates", "push", "push", "push", "popAt", "popAt", "popAt"]
 * [[2], [1], [2], [3], [0], [0], [0]]
 * 输出：
 * [null, null, null, null, 2, 1, 3]
 */
public class Code13 {

    //每个子栈允许的最大数量
    private int cap;
    //栈
    private Stack<Stack<Integer>> stack;

    public Code13(int cap) {
        this.cap = cap;
        this.stack = new Stack<>();
    }

    public void push(int val) {
        //如果是特殊情况
        if (cap < 1) {
            //过
            return;
        }
        //如果没有 or 最后一个满了
        if (this.stack.isEmpty() || this.stack.peek().size() == cap) {
            //初始化新的
            this.stack.push(new Stack<>());
        }
        //插入
        this.stack.peek().push(val);
    }

    public int pop() {
        //实现
        return popAt(stack.size() - 1);
    }

    public int popAt(int index) {
        //判空 or 越界
        if (stack.isEmpty() || index >= stack.size()) {
            //过
            return -1;
        }
        //获取栈
        Stack<Integer> stack = this.stack.get(index);
        //判空
        if (stack.isEmpty()) {
            //过
            return -1;
        }
        //获取结果
        Integer pop = stack.pop();
        //如果此时没有了
        if (stack.isEmpty()) {
            //删除对应栈
            this.stack.remove(index);
        }
        //返回
        return pop;
    }

    public static void main(String[] args) {


        Code13 code13 = new Code13(1);
        code13.push(1);
        code13.push(2);
        System.out.println(code13.popAt(1));
        System.out.println(code13.pop());
        System.out.println(code13.pop());
        System.out.println();

        //2,1,-1

    }

}

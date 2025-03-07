package easy30;

import java.util.Stack;

/**
 * @Author ayl
 * @Date 2023-04-15
 * 剑指 Offer 30. 包含min函数的栈
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.min();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.min();   --> 返回 -2.
 * <p>
 * <p>
 * 提示：
 * <p>
 * 各函数的调用总次数不超过 20000 次
 * <p>
 * <p>
 * 注意：本题与主站 155 题相同：https://leetcode-cn.com/problems/min-stack/
 */
public class Code3 {

    //栈
    private Stack<Integer> stack;
    //最小
    private Integer min = null;

    /**
     * initialize your data structure here.
     */
    public Code3() {
        //初始化
        this.stack = new Stack<>();
    }

    public void push(int x) {
        //push
        this.stack.push(x);
        //判空
        if (min == null) {
            //如果没有
            if (stack.isEmpty()) {
                //记录最小至
                min = x;
            }
        } else {
            //如果有更新
            if (x < min) {
                //更新
                min = x;
            }
        }
    }

    public void pop() {
        //push
        int num = this.stack.pop();
        //如果是最小
        if (min != null && min.equals(num)) {
            //置空
            min = null;
        }
    }

    public int top() {
        //偷窥
        return this.stack.peek();
    }

    public int min() {
        //如果有缓存
        if (min != null) {
            //返回
            return min;
        } else {
            //计算最小值
            int min = this.stack.stream().mapToInt(Integer::intValue).min().getAsInt();
            //更新
            this.min = min;
            //返回
            return min;
        }
    }

}

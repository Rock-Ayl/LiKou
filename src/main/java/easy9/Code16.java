package easy9;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 安永亮
 * @Date 2021-06-29
 * @Description
 * 155. 最小栈
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 *
 *
 * 示例:
 *
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 *
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 *
 * 解释：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *
 *
 * 提示：
 *
 * pop、top 和 getMin 操作总是在 非空栈 上调用。
 * 通过次数252,465提交次数443,267
 */
public class Code16 {

    public Integer minNum = Integer.MAX_VALUE;
    public List<Integer> list = new ArrayList();

    /**
     * initialize your data structure here.
     */
    public Code16() {

    }

    public void push(int val) {
        if (val < minNum) {
            minNum = val;
        }
        list.add(val);
    }

    public void pop() {
        int num = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        if (num == minNum) {
            minNum = Integer.MAX_VALUE;
            for (Integer integer : list) {
                if (integer < minNum) {
                    minNum = integer;
                }
            }
        }
    }

    public int top() {
        return list.get(list.size() - 1);
    }

    public int getMin() {
        return minNum;
    }

}

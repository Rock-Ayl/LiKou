package normal44;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @Author ayl
 * @Date 2025-07-12
 * 946. 验证栈序列
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给定 pushed 和 popped 两个序列，每个序列中的 值都不重复，只有当它们可能是在最初空栈上进行的推入 push 和弹出 pop 操作序列的结果时，返回 true；否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 * 输出：true
 * 解释：我们可以按以下顺序执行：
 * push(1), push(2), push(3), push(4), pop() -> 4,
 * push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 * 示例 2：
 * <p>
 * 输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
 * 输出：false
 * 解释：1 不能在 2 之前弹出。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= pushed.length <= 1000
 * 0 <= pushed[i] <= 1000
 * pushed 的所有元素 互不相同
 * popped.length == pushed.length
 * popped 是 pushed 的一个排列
 */
public class Code23 {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        //栈
        Stack<Integer> stack = new Stack<>();
        //已经进入栈的缓存
        Set<Integer> set = new HashSet<>();
        //索引
        int pushedIndex = 0;
        int poppedIndex = 0;
        //循环
        while (poppedIndex < popped.length) {
            //目标值
            int target = popped[poppedIndex];
            //如果存在栈
            if (set.contains(target) == true) {
                //获取上一个
                int pop = stack.pop();
                //如果不同
                if (pop != target) {
                    //无法达成
                    return false;
                }
                //下一个
                poppedIndex++;
            } else {
                //当前要插入的
                int push = pushed[pushedIndex++];
                //如果正好是目标值
                if (push == target) {
                    //下一个
                    poppedIndex++;
                } else {
                    //记录
                    stack.push(push);
                    set.add(push);
                }
            }
        }
        //默认可以
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Code23().validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1}));
    }

}

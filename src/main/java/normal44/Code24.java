package normal44;

import java.util.Stack;

/**
 * @Author ayl
 * @Date 2025-07-13
 * LCR 148. 验证图书取出顺序
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 现在图书馆有一堆图书需要放入书架，并且图书馆的书架是一种特殊的数据结构，只能按照 一定 的顺序 放入 和 拿取 书籍。
 *
 * 给定一个表示图书放入顺序的整数序列 putIn，请判断序列 takeOut 是否为按照正确的顺序拿取书籍的操作序列。你可以假设放入书架的所有书籍编号都不相同。
 *
 *
 *
 * 示例 1：
 *
 * 输入：putIn = [6,7,8,9,10,11], takeOut = [9,11,10,8,7,6]
 * 输出：true
 * 解释：我们可以按以下操作放入并拿取书籍：
 * push(6), push(7), push(8), push(9), pop() -> 9,
 * push(10), push(11),pop() -> 11,pop() -> 10, pop() -> 8, pop() -> 7, pop() -> 6
 * 示例 2：
 *
 * 输入：putIn = [6,7,8,9,10,11], takeOut = [11,9,8,10,6,7]
 * 输出：false
 * 解释：6 不能在 7 之前取出。
 *
 *
 * 提示：
 *
 * 0 <= putIn.length == takeOut.length <= 1000
 * 0 <= putIn[i], takeOut < 1000
 * putIn 是 takeOut 的排列。
 * 注意：本题与主站 946 题相同：https://leetcode-cn.com/problems/validate-stack-sequences/
 *
 *
 */
public class Code24 {

    public boolean validateBookSequences(int[] putIn, int[] takeOut) {
        //栈
        Stack<Integer> stack = new Stack<>();
        //索引
        int pushedIndex = 0;
        int poppedIndex = 0;
        //循环
        while (poppedIndex < takeOut.length) {
            //目标值
            int target = takeOut[poppedIndex];
            //获取上一个,如果是目标结果
            if (stack.isEmpty() == false && stack.peek() == target) {
                //拉取
                stack.pop();
                //下一个
                poppedIndex++;
                //本轮过
                continue;
            }
            //如果越界
            if (pushedIndex >= putIn.length) {
                //不可以
                return false;
            }
            //当前要插入的
            int push = putIn[pushedIndex++];
            //如果正好是目标值
            if (push == target) {
                //下一个
                poppedIndex++;
            } else {
                //记录
                stack.push(push);
            }
        }
        //默认可以
        return true;
    }

}

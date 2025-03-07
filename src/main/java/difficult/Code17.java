package difficult;

import java.util.Stack;

/**
 * @Author ayl
 * @Date 2023-01-08
 * 1944. 队列中可以看到的人数
 * 有 n 个人排成一个队列，从左到右 编号为 0 到 n - 1 。给你以一个整数数组 heights ，每个整数 互不相同，heights[i] 表示第 i 个人的高度。
 * <p>
 * 一个人能 看到 他右边另一个人的条件是这两人之间的所有人都比他们两人 矮 。更正式的，第 i 个人能看到第 j 个人的条件是 i < j 且 min(heights[i], heights[j]) > max(heights[i+1], heights[i+2], ..., heights[j-1]) 。
 * <p>
 * 请你返回一个长度为 n 的数组 answer ，其中 answer[i] 是第 i 个人在他右侧队列中能 看到 的 人数 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：heights = [10,6,8,5,11,9]
 * 输出：[3,1,2,1,1,0]
 * 解释：
 * 第 0 个人能看到编号为 1 ，2 和 4 的人。
 * 第 1 个人能看到编号为 2 的人。
 * 第 2 个人能看到编号为 3 和 4 的人。
 * 第 3 个人能看到编号为 4 的人。
 * 第 4 个人能看到编号为 5 的人。
 * 第 5 个人谁也看不到因为他右边没人。
 * 示例 2：
 * <p>
 * 输入：heights = [5,1,2,3,10]
 * 输出：[4,1,1,1,0]
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == heights.length
 * 1 <= n <= 105
 * 1 <= heights[i] <= 105
 * heights 中所有数 互不相同 。
 */
public class Code17 {

    public int[] canSeePersonsCount(int[] heights) {
        //数组
        int[] result = new int[heights.length];
        //指针
        int p = heights.length;
        //栈
        Stack<Integer> stack = new Stack<>();
        //初始化第一个值
        stack.push(heights[--p]);
        //循环
        while (p > 0) {
            //当前人的高度高度
            int height = heights[--p];
            //本次可见的数量
            int count = 0;
            //如果还有东西,并且现在大于顶部
            while (stack.isEmpty() == false && height > stack.peek()) {
                //删除顶部
                stack.pop();
                //记录可见
                count++;
            }
            //如果还有
            if (stack.isEmpty() == false) {
                //还能看到比自己高的第一个
                count++;
            }
            //记录结果
            result[p] = count;
            //push当前
            stack.push(height);
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Code17().canSeePersonsCount(new int[]{10, 6, 8, 5, 11, 9}));
    }

}

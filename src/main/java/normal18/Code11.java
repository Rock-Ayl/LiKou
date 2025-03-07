package normal18;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @Author ayl
 * @Date 2023-01-07
 * 503. 下一个更大元素 II
 * 给定一个循环数组 nums （ nums[nums.length - 1] 的下一个元素是 nums[0] ），返回 nums 中每个元素的 下一个更大元素 。
 * <p>
 * 数字 x 的 下一个更大的元素 是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,1]
 * 输出: [2,-1,2]
 * 解释: 第一个 1 的下一个更大的数是 2；
 * 数字 2 找不到下一个更大的数；
 * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
 * 示例 2:
 * <p>
 * 输入: nums = [1,2,3,4,3]
 * 输出: [2,3,4,-1,4]
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 */
public class Code11 {

    public int[] nextGreaterElements(int[] nums) {
        //结果
        int[] result = new int[nums.length];
        //最大数字
        int maxNum = nums[0];
        int maxP = 0;
        //循环
        for (int i = 1; i < nums.length; i++) {
            //当前
            int num = nums[i];
            //如果更大
            if (num > maxNum) {
                //更新
                maxNum = num;
                maxP = i;
            }
        }
        //缓存
        Stack<Integer> stack = new Stack<>();
        //循环1
        for (int i = maxP; i >= 0; i--) {
            //当前数字
            int num = nums[i];
            //如果当前数字更大,则一直删除到最后
            while (stack.isEmpty() == false && num >= stack.peek()) {
                //删除最后
                stack.pop();
            }
            //如果有内容
            if (stack.isEmpty() == false) {
                //使用
                result[i] = stack.peek();
            } else {
                //默认
                result[i] = -1;
            }
            //push
            stack.push(num);
        }
        //循环2
        for (int i = nums.length - 1; i > maxP; i--) {
            //当前数字
            int num = nums[i];
            //如果当前数字更大,则一直删除到最后
            while (stack.isEmpty() == false && num >= stack.peek()) {
                //删除最后
                stack.pop();
            }
            //如果有内容
            if (stack.isEmpty() == false) {
                //使用
                result[i] = stack.peek();
            } else {
                //默认
                result[i] = -1;
            }
            //push
            stack.push(num);
        }
        //返回结果
        return result;
    }

    public int[] start(int[] nums) {
        //长度
        int length = nums.length;
        //结果
        int[] result = new int[length];
        //填充所有未-1
        Arrays.fill(result, -1);
        //栈
        Deque<Integer> stack = new LinkedList<Integer>();
        //循环
        for (int i = 0; i < length * 2 - 1; i++) {
            //循环,如果栈有值 and
            while (stack.isEmpty() == false && nums[stack.peek()] < nums[i % length]) {
                result[stack.pop()] = nums[i % length];
            }
            stack.push(i % length);
        }
        //返回结果
        return result;
    }

    public static void main(String[] args) {
        new Code11().start(new int[]{1, 2, 3, 4, 3});
    }

}

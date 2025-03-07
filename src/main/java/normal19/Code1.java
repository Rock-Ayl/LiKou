package normal19;

import java.util.Collections;
import java.util.Stack;

/**
 * @Author ayl
 * @Date 2023-02-09
 * 962. 最大宽度坡
 * 给定一个整数数组 A，坡是元组 (i, j)，其中  i < j 且 A[i] <= A[j]。这样的坡的宽度为 j - i。
 * <p>
 * 找出 A 中的坡的最大宽度，如果不存在，返回 0 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[6,0,8,2,1,5]
 * 输出：4
 * 解释：
 * 最大宽度的坡为 (i, j) = (1, 5): A[1] = 0 且 A[5] = 5.
 * 示例 2：
 * <p>
 * 输入：[9,8,1,0,1,9,4,0,4,1]
 * 输出：7
 * 解释：
 * 最大宽度的坡为 (i, j) = (2, 9): A[2] = 1 且 A[9] = 1.
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= A.length <= 50000
 * 0 <= A[i] <= 50000
 */
public class Code1 {

    public int maxWidthRamp(int[] nums) {
        //正序有效的越来越大栈
        Stack<Integer> bigStack = new Stack<>();
        //倒序有效的越来越小栈
        Stack<Integer> smallStack = new Stack<>();
        //循环
        for (int i = 0; i < nums.length; i++) {
            //如果当前大于等于上一个
            while (bigStack.isEmpty() == false && nums[i] >= nums[bigStack.peek()]) {
                //删除
                bigStack.pop();
            }
            //记录当前的
            bigStack.push(i);
        }
        //循环
        for (int i = nums.length - 1; i >= 0; i--) {
            //如果当前大于等于上一个
            while (smallStack.isEmpty() == false && nums[i] <= nums[smallStack.peek()]) {
                //删除
                smallStack.pop();
            }
            //记录当前的
            smallStack.push(i);
        }
        //反转
        Collections.reverse(smallStack);
        //最大可能
        int max = 0;
        //如果俩都值
        while (bigStack.isEmpty() == false && smallStack.isEmpty() == false) {
            //对比二者最后的,如果是目标值之一
            if (nums[bigStack.peek()] >= nums[smallStack.peek()]) {
                //刷新最大结果
                max = Math.max(max, bigStack.peek() - smallStack.peek());
                //删除小的
                smallStack.pop();
            } else {
                //删除大
                bigStack.pop();
            }
        }
        //返回结果过
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Code1().maxWidthRamp(new int[]{9, 8, 1, 0, 1, 9, 4, 0, 4, 1}));
    }

}

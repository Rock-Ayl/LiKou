package normal16;

import java.util.Random;
import java.util.Stack;

/**
 * @Author ayl
 * @Date 2022-09-05
 * 384. 打乱数组
 * 给你一个整数数组 nums ，设计算法来打乱一个没有重复元素的数组。打乱后，数组的所有排列应该是 等可能 的。
 * <p>
 * 实现 Solution class:
 * <p>
 * Solution(int[] nums) 使用整数数组 nums 初始化对象
 * int[] reset() 重设数组到它的初始状态并返回
 * int[] shuffle() 返回数组随机打乱后的结果
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入
 * ["Solution", "shuffle", "reset", "shuffle"]
 * [[[1, 2, 3]], [], [], []]
 * 输出
 * [null, [3, 1, 2], [1, 2, 3], [1, 3, 2]]
 * <p>
 * 解释
 * Solution solution = new Solution([1, 2, 3]);
 * solution.shuffle();    // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。例如，返回 [3, 1, 2]
 * solution.reset();      // 重设数组到它的初始状态 [1, 2, 3] 。返回 [1, 2, 3]
 * solution.shuffle();    // 随机返回数组 [1, 2, 3] 打乱后的结果。例如，返回 [1, 3, 2]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 50
 * -106 <= nums[i] <= 106
 * nums 中的所有元素都是 唯一的
 * 最多可以调用 104 次 reset 和 shuffle
 */
public class Code11 {

    //原始
    private int[] nums;
    //随机数对象
    private Random random = new Random();

    public Code11(int[] nums) {
        //记录
        this.nums = nums;
    }

    public int[] reset() {
        //返回原始
        return this.nums;
    }

    public int[] shuffle() {
        //栈
        Stack<Integer> stack = new Stack<>();
        //循环
        for (int num : this.nums) {
            //组装
            stack.add(num);
        }
        //结果
        int[] result = new int[nums.length];
        //指针
        int p = 0;
        //如果还有
        while (stack.isEmpty() == false) {
            //获取一个随机数
            int next = random.nextInt(stack.size());
            //根据随机数,获取的对应数字
            Integer num = stack.get(next);
            //获取并组装
            result[p++] = num;
            //删除对应数字
            stack.removeElement(num);
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        Code11 code11 = new Code11(new int[]{1, 2, 3});
        code11.shuffle();
        code11.shuffle();
        code11.shuffle();
        code11.shuffle();
        code11.shuffle();
        code11.shuffle();
        code11.shuffle();
    }

}

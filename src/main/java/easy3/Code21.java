package easy3;

/**
 * Created By Rock-Ayl on 2020-11-13
 * 面试题 17.04. 消失的数字
 * 数组nums包含从0到n的所有整数，但其中缺了一个。请编写代码找出那个缺失的整数。你有办法在O(n)时间内完成吗？
 * <p>
 * 注意：本题相对书上原题稍作改动
 * <p>
 * 示例 1：
 * <p>
 * 输入：[3,0,1]
 * 输出：2
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：[9,6,4,2,3,5,7,0,1]
 * 输出：8
 */
public class Code21 {

    public static int missingNumber(int[] nums) {
        //真实和
        int sum = 0;
        //实际和
        int sum2 = 0;
        //数字个数
        int size = nums.length;
        //循环记录
        while (size > 0) {
            //叠加
            sum += size;
            //递减
            size--;
        }
        //循环
        for (int num : nums) {
            //叠加
            sum2 += num;
        }
        //计算并返回
        return sum - sum2;
    }

    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{9,6,4,2,3,5,7,0,1}));
    }
}

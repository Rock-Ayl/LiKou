package easy;

/**
 * Created By Rock-Ayl on 2020-07-21
 * 两数之和
 * <P>
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * </P>
 * <p>
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * </p>
 */
public class Code1 {

    /**
     * 我的解决方案
     * 暴力法
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        //循环
        for (int i = 0; i < nums.length; i++) {
            //循环
            for (int j = 0; j < nums.length; j++) {
                //如果是同一位置元素
                if (i == j) {
                    //跳过本次逻辑
                    continue;
                }
                //如果相加是目标值,说明是结果了
                if (target == (nums[i] + nums[j])) {
                    //返回对应结果下标
                    return new int[]{i, j};
                }
            }
        }
        //默认返回null
        return null;
    }

    public static void main(String[] args) {
        //实现
        int[] result = twoSum(new int[]{2, 7, 11, 15}, 9);
        //循环
        for (int i : result) {
            //输出结果
            System.out.println(i + ",");
        }
    }

}

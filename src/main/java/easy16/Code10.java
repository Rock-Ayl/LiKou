package easy16;

/**
 * 1995. 统计特殊四元组
 * 给你一个 下标从 0 开始 的整数数组 nums ，返回满足下述条件的 不同 四元组 (a, b, c, d) 的 数目 ：
 * <p>
 * nums[a] + nums[b] + nums[c] == nums[d] ，且
 * a < b < c < d
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,6]
 * 输出：1
 * 解释：满足要求的唯一一个四元组是 (0, 1, 2, 3) 因为 1 + 2 + 3 == 6 。
 * 示例 2：
 * <p>
 * 输入：nums = [3,3,6,4,5]
 * 输出：0
 * 解释：[3,3,6,4,5] 中不存在满足要求的四元组。
 * 示例 3：
 * <p>
 * 输入：nums = [1,1,1,3,5]
 * 输出：4
 * 解释：满足要求的 4 个四元组如下：
 * - (0, 1, 2, 3): 1 + 1 + 1 == 3
 * - (0, 1, 3, 4): 1 + 1 + 3 == 5
 * - (0, 2, 3, 4): 1 + 1 + 3 == 5
 * - (1, 2, 3, 4): 1 + 1 + 3 == 5
 * <p>
 * <p>
 * 提示：
 * <p>
 * 4 <= nums.length <= 50
 * 1 <= nums[i] <= 100
 */
public class Code10 {

    public int countQuadruplets(int[] nums) {
        //记录
        int size = 0;
        //循环1
        for (int i = 0; i < nums.length; i++) {
            //a
            int a = nums[i];
            //循环2
            for (int j = i + 1; j < nums.length; j++) {
                //b
                int b = nums[j];
                //和
                int sumb = a + b;
                //循环3
                for (int k = j + 1; k < nums.length; k++) {
                    //b
                    int c = nums[k];
                    //和
                    int sumc = sumb + c;
                    //循环4
                    for (int l = k + 1; l < nums.length; l++) {
                        //b
                        int d = nums[l];
                        //如果是
                        if (sumc == d) {
                            //记录
                            size++;
                        }
                    }
                }
            }
        }
        //结果
        return size;
    }

    public static void main(String[] args) {
        System.out.println(new Code10().countQuadruplets(new int[]{28, 8, 49, 85, 37, 90, 20, 8}));
    }

}

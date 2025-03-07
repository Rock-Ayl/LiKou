package easy;

/**
 * Created By Rock-Ayl on 2020-08-28
 * 1313. 解压缩编码列表
 * 给你一个以行程长度编码压缩的整数列表 nums 。
 * <p>
 * 考虑每对相邻的两个元素 [freq, val] = [nums[2*i], nums[2*i+1]] （其中 i >= 0 ），每一对都表示解压后子列表中有 freq 个值为 val 的元素，你需要从左到右连接所有子列表以生成解压后的列表。
 * <p>
 * 请你返回解压后的列表。
 * <p>
 * 示例：
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：[2,4,4,4]
 * 解释：第一对 [1,2] 代表着 2 的出现频次为 1，所以生成数组 [2]。
 * 第二对 [3,4] 代表着 4 的出现频次为 3，所以生成数组 [4,4,4]。
 * 最后将它们串联到一起 [2] + [4,4,4] = [2,4,4,4]。
 * 示例 2：
 * <p>
 * 输入：nums = [1,1,2,3]
 * 输出：[1,3,3]
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 100
 * nums.length % 2 == 0
 * 1 <= nums[i] <= 100
 */
public class Code20 {

    public static int[] decompressRLElist(int[] nums) {
        //初始化返回值大小
        int size = 0;
        //循环
        for (int i = 0; i < nums.length; i = i + 2) {
            //叠加大小
            size = size + nums[i];
        }
        //根据返回值大小初始化返回值
        int[] newNums = new int[size];
        //坐标
        int newNumP = 0;
        //循环
        for (int i = 0; i < nums.length; i = i + 2) {
            //获取后一位
            int x = nums[i + 1];
            //获取次数
            int z = nums[i];
            //次数
            while (z > 0) {
                //记录
                newNums[newNumP] = x;
                //减一
                z--;
                //坐标
                newNumP++;
            }
        }
        //返回
        return newNums;
    }

    public static void main(String[] args) {
        for (int s : decompressRLElist(new int[]{1, 2, 3, 4})) {
            System.out.println(s);
        }
    }

}

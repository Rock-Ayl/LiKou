package normal46;

/**
 * @Author ayl
 * @Date 2025-09-19
 * 923. 多重三数之和
 * 算术评级: 5
 * 第 106 场周赛
 * Q3
 * 同步题目状态
 * <p>
 * 1711
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给定一个整数数组 arr ，以及一个整数 target 作为目标值，返回满足 i < j < k 且 arr[i] + arr[j] + arr[k] == target 的元组 i, j, k 的数量。
 * <p>
 * 由于结果会非常大，请返回 109 + 7 的模。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [1,1,2,2,3,3,4,4,5,5], target = 8
 * 输出：20
 * 解释：
 * 按值枚举(arr[i], arr[j], arr[k])：
 * (1, 2, 5) 出现 8 次；
 * (1, 3, 4) 出现 8 次；
 * (2, 2, 4) 出现 2 次；
 * (2, 3, 3) 出现 2 次。
 * 示例 2：
 * <p>
 * 输入：arr = [1,1,2,2,2,2], target = 5
 * 输出：12
 * 解释：
 * arr[i] = 1, arr[j] = arr[k] = 2 出现 12 次：
 * 我们从 [1,1] 中选择一个 1，有 2 种情况，
 * 从 [2,2,2,2] 中选出两个 2，有 6 种情况。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 3 <= arr.length <= 3000
 * 0 <= arr[i] <= 100
 * 0 <= target <= 300
 */
public class Code12 {

    public int threeSumMulti(int[] arr, int target) {
        //三层,第三层只需要最终结果
        int[] firstArr = new int[target + 1];
        int[] secondArr = new int[target + 1];
        int thirdArr = 0;
        //循环
        for (int number : arr) {

            /**
             * 第三层
             */

            //所需第二层的结果
            int needSecondNumber = target - number;
            //如果有
            if (needSecondNumber >= 0 && needSecondNumber < secondArr.length) {
                //叠加
                thirdArr = (thirdArr + secondArr[needSecondNumber]) % 1000000007;
            }

            /**
             * 第二层
             */

            //循环
            for (int secondSum = number; secondSum < secondArr.length; secondSum++) {
                //叠加
                secondArr[secondSum] = (secondArr[secondSum] + firstArr[secondSum - number]) % 1000000007;
            }

            /**
             * 第一层
             */

            //如果有
            if (number >= 0 && number < firstArr.length) {
                //第一层初始化
                firstArr[number]++;
            }

        }

        //返回
        return thirdArr;
    }

    public static void main(String[] args) {
        //System.out.println(new Code12().threeSumMulti(new int[]{1, 1, 2, 2, 3, 3, 4, 4, 5, 5}, 8));
        System.out.println(new Code12().threeSumMulti(new int[]{1, 0, 1, 0, 2, 1, 2}, 1));
    }

}

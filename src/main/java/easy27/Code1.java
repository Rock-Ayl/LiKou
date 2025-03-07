package easy27;

/**
 * @Author ayl
 * @Date 2023-01-12
 * 1566. 重复至少 K 次且长度为 M 的模式
 * 给你一个正整数数组 arr，请你找出一个长度为 m 且在数组中至少重复 k 次的模式。
 * <p>
 * 模式 是由一个或多个值组成的子数组（连续的子序列），连续 重复多次但 不重叠 。 模式由其长度和重复次数定义。
 * <p>
 * 如果数组中存在至少重复 k 次且长度为 m 的模式，则返回 true ，否则返回  false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [1,2,4,4,4,4], m = 1, k = 3
 * 输出：true
 * 解释：模式 (4) 的长度为 1 ，且连续重复 4 次。注意，模式可以重复 k 次或更多次，但不能少于 k 次。
 * 示例 2：
 * <p>
 * 输入：arr = [1,2,1,2,1,1,1,3], m = 2, k = 2
 * 输出：true
 * 解释：模式 (1,2) 长度为 2 ，且连续重复 2 次。另一个符合题意的模式是 (2,1) ，同样重复 2 次。
 * 示例 3：
 * <p>
 * 输入：arr = [1,2,1,2,1,3], m = 2, k = 3
 * 输出：false
 * 解释：模式 (1,2) 长度为 2 ，但是只连续重复 2 次。不存在长度为 2 且至少重复 3 次的模式。
 * 示例 4：
 * <p>
 * 输入：arr = [1,2,3,1,2], m = 2, k = 2
 * 输出：false
 * 解释：模式 (1,2) 出现 2 次但并不连续，所以不能算作连续重复 2 次。
 * 示例 5：
 * <p>
 * 输入：arr = [2,2,2,2], m = 2, k = 3
 * 输出：false
 * 解释：长度为 2 的模式只有 (2,2) ，但是只连续重复 2 次。注意，不能计算重叠的重复次数。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= arr.length <= 100
 * 1 <= arr[i] <= 100
 * 1 <= m <= 100
 * 2 <= k <= 100
 */
public class Code1 {

    public boolean containsPattern(int[] arr, int m, int k) {
        //如果长度不够
        if (arr.length < m * k) {
            //过
            return false;
        }
        //跳出标记
        out:
        //循环1
        for (int i = 0; i <= arr.length - m * k; i++) {
            //循环2
            for (int j = i; j < m + i; j++) {
                //第一个
                int first = arr[j];
                //次数,默认1
                int count = 1;
                //循环3
                for (int x = j + m; x < arr.length; x = x + m) {
                    //接下来
                    int next = arr[x];
                    //如果不是
                    if (first != next) {
                        //i开始不是,本轮跳出
                        continue out;
                    }
                    //记录次数,如果满足了
                    if (++count == k) {
                        //跳出
                        break;
                    }
                }
            }
            //是
            return true;
        }
        //默认
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Code1().containsPattern(new int[]{1, 2, 1, 2, 1, 1, 1, 3}, 2, 2));
    }

}

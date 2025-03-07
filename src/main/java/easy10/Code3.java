package easy10;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Author 安永亮
 * @Date 2021-07-03
 * @Description 985. 查询后的偶数和
 * 给出一个整数数组 A 和一个查询数组 queries。
 * <p>
 * 对于第 i 次查询，有 val = queries[i][0], index = queries[i][1]，我们会把 val 加到 A[index] 上。然后，第 i 次查询的答案是 A 中偶数值的和。
 * <p>
 * （此处给定的 index = queries[i][1] 是从 0 开始的索引，每次查询都会永久修改数组 A。）
 * <p>
 * 返回所有查询的答案。你的答案应当以数组 answer 给出，answer[i] 为第 i 次查询的答案。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：A = [1,2,3,4], queries = [[1,0],[-3,1],[-4,0],[2,3]]
 * 输出：[8,6,2,4]
 * 解释：
 * 开始时，数组为 [1,2,3,4]。
 * 将 1 加到 A[0] 上之后，数组为 [2,2,3,4]，偶数值之和为 2 + 2 + 4 = 8。
 * 将 -3 加到 A[1] 上之后，数组为 [2,-1,3,4]，偶数值之和为 2 + 4 = 6。
 * 将 -4 加到 A[0] 上之后，数组为 [-2,-1,3,4]，偶数值之和为 -2 + 4 = 2。
 * 将 2 加到 A[3] 上之后，数组为 [-2,-1,3,6]，偶数值之和为 -2 + 6 = 4。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * 1 <= queries.length <= 10000
 * -10000 <= queries[i][0] <= 10000
 * 0 <= queries[i][1] < A.length
 */
public class Code3 {

    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        //当前和
        int sum = 0;
        //循环
        for (int num : nums) {
            //如果是偶数
            if (num % 2 == 0) {
                //计算
                sum += num;
            }
        }
        //初始化寄过
        int[] result = new int[queries.length];
        //循环
        for (int i = 0; i < queries.length; i++) {
            //当前空间
            int[] space = queries[i];
            //当前值
            int thisNum = nums[space[1]];
            //记录老值
            int old = thisNum;
            //计算
            thisNum += space[0];
            //返回结果
            nums[space[1]] = thisNum;
            //如果老的是偶数
            if (old % 2 == 0) {
                if (thisNum % 2 == 0) {
                    //增加or减少
                    sum += thisNum - old;
                } else {
                    //减少了
                    sum -= old;
                }
            } else {
                if (thisNum % 2 == 0) {
                    //增加
                    sum += thisNum;
                }
            }
            //组装结果
            result[i] = sum;
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        for (int i : new Code3().sumEvenAfterQueries(new int[]{1}, new int[][]{new int[]{4, 0}})) {
            System.out.println(i);
        }
    }
}

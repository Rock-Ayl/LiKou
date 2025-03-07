package normal31;

import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2024-05-08
 * 881. 救生艇
 * 尝试过
 * 中等
 * 相关标签
 * 相关企业
 * 给定数组 people 。people[i]表示第 i 个人的体重 ，船的数量不限，每艘船可以承载的最大重量为 limit。
 * <p>
 * 每艘船最多可同时载两人，但条件是这些人的重量之和最多为 limit。
 * <p>
 * 返回 承载所有人所需的最小船数 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：people = [1,2], limit = 3
 * 输出：1
 * 解释：1 艘船载 (1, 2)
 * 示例 2：
 * <p>
 * 输入：people = [3,2,2,1], limit = 3
 * 输出：3
 * 解释：3 艘船分别载 (1, 2), (2) 和 (3)
 * 示例 3：
 * <p>
 * 输入：people = [3,5,3,4], limit = 5
 * 输出：4
 * 解释：4 艘船分别载 (3), (3), (4), (5)
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= people.length <= 5 * 104
 * 1 <= people[i] <= limit <= 3 * 104
 */
public class Code13 {

    public int numRescueBoats(int[] people, int limit) {
        //排序
        Arrays.sort(people);
        //结果
        int count = 0;
        //左右边界
        int left = 0;
        int right = people.length - 1;
        //循环
        while (left <= right) {
            //+1
            ++count;
            //如果只有一个
            if (left == right) {
                //跳出
                break;
            }
            //如果左右都可以 还是 右边可以
            if (people[left] + people[right] <= limit) {
                //移动
                ++left;
                --right;
            } else {
                //移动
                --right;
            }
        }
        //返回结果
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Code13().numRescueBoats(new int[]{3, 2, 2, 1}, 3));
    }

}

package easy36;

import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2024-03-11
 * 3074. 重新分装苹果
 * 简单
 * 相关企业
 * 提示
 * 给你一个长度为 n 的数组 apple 和另一个长度为 m 的数组 capacity 。
 * <p>
 * 一共有 n 个包裹，其中第 i 个包裹中装着 apple[i] 个苹果。同时，还有 m 个箱子，第 i 个箱子的容量为 capacity[i] 个苹果。
 * <p>
 * 请你选择一些箱子来将这 n 个包裹中的苹果重新分装到箱子中，返回你需要选择的箱子的 最小 数量。
 * <p>
 * 注意，同一个包裹中的苹果可以分装到不同的箱子中。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：apple = [1,3,2], capacity = [4,3,1,5,2]
 * 输出：2
 * 解释：使用容量为 4 和 5 的箱子。
 * 总容量大于或等于苹果的总数，所以可以完成重新分装。
 * 示例 2：
 * <p>
 * 输入：apple = [5,5,5], capacity = [2,4,2,7]
 * 输出：4
 * 解释：需要使用所有箱子。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n == apple.length <= 50
 * 1 <= m == capacity.length <= 50
 * 1 <= apple[i], capacity[i] <= 50
 * 输入数据保证可以将包裹中的苹果重新分装到箱子中。
 */
public class Code14 {

    public int minimumBoxes(int[] apple, int[] capacity) {
        //苹果数量
        int sum = Arrays.stream(apple).sum();
        //使用箱子数
        int count = 0;
        //排序
        Arrays.sort(capacity);
        //循环
        for (int i = capacity.length - 1; i >= 0; i--) {
            //装箱
            sum -= capacity[i];
            //进位
            count++;
            //如果装够了
            if (sum <= 0) {
                //跳出
                break;
            }
        }
        //返回
        return count;
    }

    public static void main(String[] args) {

    }

}

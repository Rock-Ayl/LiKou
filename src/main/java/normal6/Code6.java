package normal6;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2021-08-13
 * 1953. 你可以工作的最大周数
 * 给你 n 个项目，编号从 0 到 n - 1 。同时给你一个整数数组 milestones ，其中每个 milestones[i] 表示第 i 个项目中的阶段任务数量。
 * <p>
 * 你可以按下面两个规则参与项目中的工作：
 * <p>
 * 每周，你将会完成 某一个 项目中的 恰好一个 阶段任务。你每周都 必须 工作。
 * 在 连续的 两周中，你 不能 参与并完成同一个项目中的两个阶段任务。
 * 一旦所有项目中的全部阶段任务都完成，或者仅剩余一个阶段任务都会导致你违反上面的规则，那么你将 停止工作 。注意，由于这些条件的限制，你可能无法完成所有阶段任务。
 * <p>
 * 返回在不违反上面规则的情况下你 最多 能工作多少周。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：milestones = [1,2,3]
 * 输出：6
 * 解释：一种可能的情形是：
 * ​​​​- 第 1 周，你参与并完成项目 0 中的一个阶段任务。
 * - 第 2 周，你参与并完成项目 2 中的一个阶段任务。
 * - 第 3 周，你参与并完成项目 1 中的一个阶段任务。
 * - 第 4 周，你参与并完成项目 2 中的一个阶段任务。
 * - 第 5 周，你参与并完成项目 1 中的一个阶段任务。
 * - 第 6 周，你参与并完成项目 2 中的一个阶段任务。
 * 总周数是 6 。
 * 示例 2：
 * <p>
 * 输入：milestones = [5,2,1]
 * 输出：7
 * 解释：一种可能的情形是：
 * - 第 1 周，你参与并完成项目 0 中的一个阶段任务。
 * - 第 2 周，你参与并完成项目 1 中的一个阶段任务。
 * - 第 3 周，你参与并完成项目 0 中的一个阶段任务。
 * - 第 4 周，你参与并完成项目 1 中的一个阶段任务。
 * - 第 5 周，你参与并完成项目 0 中的一个阶段任务。
 * - 第 6 周，你参与并完成项目 2 中的一个阶段任务。
 * - 第 7 周，你参与并完成项目 0 中的一个阶段任务。
 * 总周数是 7 。
 * 注意，你不能在第 8 周参与完成项目 0 中的最后一个阶段任务，因为这会违反规则。
 * 因此，项目 0 中会有一个阶段任务维持未完成状态。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == milestones.length
 * 1 <= n <= 105
 * 1 <= milestones[i] <= 109
 */
public class Code6 {

    public long numberOfWeeks(int[] milestones) {
        //排序
        Arrays.sort(milestones);
        //和
        long sum = 0L;
        //最后的坐标
        int lastP = milestones.length - 1;
        //最后一个
        long last = milestones[lastP];
        //循环
        for (int i = 0; i < lastP; i++) {
            //计算
            sum += milestones[i];
        }
        //如果单一太大
        if (last > sum + 1) {
            //计算
            return sum + sum + 1;
        } else {
            //最终结果
            return sum + last;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Code6().numberOfWeeks(new int[]{11, 8, 5, 2, 1}));
    }

}

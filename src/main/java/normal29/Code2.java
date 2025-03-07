package normal29;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author ayl
 * @Date 2024-02-14
 * 1029. 两地调度
 * 中等
 * 相关标签
 * 相关企业
 * 公司计划面试 2n 人。给你一个数组 costs ，其中 costs[i] = [aCosti, bCosti] 。第 i 人飞往 a 市的费用为 aCosti ，飞往 b 市的费用为 bCosti 。
 * <p>
 * 返回将每个人都飞到 a 、b 中某座城市的最低费用，要求每个城市都有 n 人抵达。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：costs = [[10,20],[30,200],[400,50],[30,20]]
 * 输出：110
 * 解释：
 * 第一个人去 a 市，费用为 10。
 * 第二个人去 a 市，费用为 30。
 * 第三个人去 b 市，费用为 50。
 * 第四个人去 b 市，费用为 20。
 * <p>
 * 最低总费用为 10 + 30 + 50 + 20 = 110，每个城市都有一半的人在面试。
 * 示例 2：
 * <p>
 * 输入：costs = [[259,770],[448,54],[926,667],[184,139],[840,118],[577,469]]
 * 输出：1859
 * 示例 3：
 * <p>
 * 输入：costs = [[515,563],[451,713],[537,709],[343,819],[855,779],[457,60],[650,359],[631,42]]
 * 输出：3086
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 * n == costs.length
 * 2 <= costs.length <= 100
 * costs.length 为偶数
 * 1 <= aCosti, bCosti <= 1000
 */
public class Code2 {

    public int twoCitySchedCost(int[][] costs) {
        //排序
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                //计算a、b的费用差距
                int way2 = Math.abs(o2[0] - o2[1]);
                int way1 = Math.abs(o1[0] - o1[1]);
                //如果费用差距不同
                if (way2 != way1) {
                    //使用费用差距
                    return way2 - way1;
                }
                //默认
                return 0;
            }
        });
        //费用和
        int sum = 0;
        //每个城市需要去多少人
        int n = costs.length / 2;
        //a、b已经去的城市数量
        int aCount = 0;
        int bCount = 0;
        //循环
        for (int[] cost : costs) {
            //如果a已经满了
            if (aCount == n) {
                //直接去b
                sum += cost[1];
                bCount++;
                //本轮过
                continue;
            }
            //如果b已经满了
            if (bCount == n) {
                //直接去a
                sum += cost[0];
                aCount++;
                //本轮过
                continue;
            }
            //如果左边费用多
            if (cost[0] >= cost[1]) {
                //直接去b
                sum += cost[1];
                bCount++;
            } else {
                //直接去a
                sum += cost[0];
                aCount++;
            }
        }
        //返回
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Code2().twoCitySchedCost(new int[][]{
                new int[]{259, 770},
                new int[]{448, 54},
                new int[]{926, 667},
                new int[]{184, 139},
                new int[]{840, 118},
                new int[]{577, 469}
        }));
    }

}

package easy30;

import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2023-04-25
 * LCP 72. 补给马车
 * 远征队即将开启未知的冒险之旅，不过在此之前，将对补给车队进行最后的检查。supplies[i] 表示编号为 i 的补给马车装载的物资数量。
 * 考虑到车队过长容易被野兽偷袭，他们决定将车队的长度变为原来的一半（向下取整），计划为：
 * <p>
 * 找出车队中 物资之和最小 两辆 相邻 马车，将它们车辆的物资整合为一辆。若存在多组物资之和相同的马车，则取编号最小的两辆马车进行整合；
 * 重复上述操作直到车队长度符合要求。
 * 请返回车队长度符合要求后，物资的分布情况。
 * <p>
 * 示例 1：
 * <p>
 * 输入：supplies = [7,3,6,1,8]
 * <p>
 * 输出：[10,15]
 * <p>
 * 解释：
 * 第 1 次合并，符合条件的两辆马车为 6,1，合并后的车队为 [7,3,7,8]；
 * 第 2 次合并，符合条件的两辆马车为 (7,3) 和 (3,7)，取编号最小的 (7,3)，合并后的车队为 [10,7,8]；
 * 第 3 次合并，符合条件的两辆马车为 7,8，合并后的车队为 [10,15]；
 * 返回 [10,15]
 * <p>
 * 示例 2：
 * <p>
 * 输入：supplies = [1,3,1,5]
 * <p>
 * 输出：[5,5]
 * <p>
 * 解释：
 * <p>
 * 2 <= supplies.length <= 1000
 * 1 <= supplies[i] <= 1000
 */
public class Code11 {

    public int[] supplyWagon(int[] supplies) {
        //目标长度
        int target = supplies.length / 2;
        //目标
        int countP = 1;
        //合并次数
        int count = supplies.length - target;
        //如果需要合并
        while (countP <= count) {
            //右边边界
            int rightP = supplies.length - countP;
            //初始化最小
            int minSum = supplies[0] + supplies[1];
            int minP = 0;
            //从1开始
            int p = 1;
            //如果满足条件
            while (p < rightP) {
                //当前
                int thisSum = supplies[p] + supplies[p + 1];
                //如果更小
                if (thisSum < minSum) {
                    //更新
                    minSum = thisSum;
                    minP = p;
                }
                //下一个
                p++;
            }
            //合并
            supplies[minP] = supplies[minP] + supplies[minP + 1];
            supplies[++minP] = 0;
            //如果平移
            while (minP < rightP) {
                //前进
                supplies[minP] = supplies[minP + 1];
                //下一个
                minP++;
            }
            //下一次合并
            countP++;
        }
        //返回
        return Arrays.copyOf(supplies, target);
    }

    public static void main(String[] args) {
        int[] arr = new Code11().supplyWagon(new int[]{7, 3, 6, 1, 8});
        System.out.println();
    }

}

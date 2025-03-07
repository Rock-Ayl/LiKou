package easy26;

/**
 * @Author ayl
 * @Date 2022-12-30
 * 2511. 最多可以摧毁的敌人城堡数目
 * 给你一个长度为 n ，下标从 0 开始的整数数组 forts ，表示一些城堡。forts[i] 可以是 -1 ，0 或者 1 ，其中：
 * <p>
 * -1 表示第 i 个位置 没有 城堡。
 * 0 表示第 i 个位置有一个 敌人 的城堡。
 * 1 表示第 i 个位置有一个你控制的城堡。
 * 现在，你需要决定，将你的军队从某个你控制的城堡位置 i 移动到一个空的位置 j ，满足：
 * <p>
 * 0 <= i, j <= n - 1
 * 军队经过的位置 只有 敌人的城堡。正式的，对于所有 min(i,j) < k < max(i,j) 的 k ，都满足 forts[k] == 0 。
 * 当军队移动时，所有途中经过的敌人城堡都会被 摧毁 。
 * <p>
 * 请你返回 最多 可以摧毁的敌人城堡数目。如果 无法 移动你的军队，或者没有你控制的城堡，请返回 0 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：forts = [1,0,0,-1,0,0,0,0,1]
 * 输出：4
 * 解释：
 * - 将军队从位置 0 移动到位置 3 ，摧毁 2 个敌人城堡，位置分别在 1 和 2 。
 * - 将军队从位置 8 移动到位置 3 ，摧毁 4 个敌人城堡。
 * 4 是最多可以摧毁的敌人城堡数目，所以我们返回 4 。
 * 示例 2：
 * <p>
 * 输入：forts = [0,0,1,-1]
 * 输出：0
 * 解释：由于无法摧毁敌人的城堡，所以返回 0 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= forts.length <= 1000
 * -1 <= forts[i] <= 1
 */
public class Code10 {

    public int captureForts(int[] forts) {
        //最大结果
        int count = 0;
        //循环
        for (int i = 0; i < forts.length; i++) {
            //当前
            int fort = forts[i];
            //如果不是开始
            if (fort != 1) {
                //本轮过
                continue;
            }
            //计算
            count = Math.max(count, hit(forts, i));
        }
        //结果
        return count;
    }

    //计算得分
    private int hit(int[] forts, Integer p) {
        //结果
        int count1 = 0;
        int count2 = 0;
        //循环1
        for (int i = p - 1; i >= 0; i--) {
            //如果得分
            if (forts[i] == 0) {
                //记录
                count1++;
                //如果到头了
                if (i == 0) {
                    //不计入结果
                    count1 = 0;
                }
                //本轮过
                continue;
            } else {
                //如果不是结束
                if (forts[i] != -1) {
                    //不计入结果
                    count1 = 0;
                }
                //结束
                break;
            }
        }
        //循环1
        for (int i = p + 1; i < forts.length; i++) {
            //如果得分
            if (forts[i] == 0) {
                //记录
                count2++;
                //如果是头
                if (i == forts.length - 1) {
                    //不计入结果
                    count2 = 0;
                }
                //本轮过
                continue;
            } else {
                //如果不是头
                if (forts[i] != -1) {
                    //不计入结果
                    count2 = 0;
                }
                //结束
                break;
            }
        }
        //返回结果
        return Math.max(count1, count2);
    }

    public static void main(String[] args) {
        System.out.println(new Code10().captureForts(new int[]{1, 0, 0, -1, 0, 0, 0, 0, 1}));
    }

}

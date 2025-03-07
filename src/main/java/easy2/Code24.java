package easy2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created By Rock-Ayl on 2020-10-13
 * 有一堆石头，每块石头的重量都是正整数。
 * <p>
 * 每一回合，从中选出两块 最重的 石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 * <p>
 * 如果 x == y，那么两块石头都会被完全粉碎；
 * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 * 最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。
 * <p>
 * 示例：
 * <p>
 * 输入：[2,7,4,1,8,1]
 * 输出：1
 * 解释：
 * 先选出 7 和 8，得到 1，所以数组转换为 [2,4,1,1,1]，
 * 再选出 2 和 4，得到 2，所以数组转换为 [2,1,1,1]，
 * 接着是 2 和 1，得到 1，所以数组转换为 [1,1,1]，
 * 最后选出 1 和 1，得到 0，最终数组转换为 [1]，这就是最后剩下那块石头的重量。
 * <p>
 * 提示：
 * <p>
 * 1 <= stones.length <= 30
 * 1 <= stones[i] <= 1000
 */
public class Code24 {

    public static int lastStoneWeight(int[] stones) {
        //转化为list
        List<Integer> list = new ArrayList<>();
        //循环
        for (int stone : stones) {
            //组装
            list.add(stone);
        }
        //循环
        while (list.size() > 1) {
            //排序
            Collections.sort(list);
            //最大的
            int a = list.get(list.size() - 1);
            //第二大的
            int b = list.get(list.size() - 2);
            //全碎
            list.remove(list.size() - 1);
            list.remove(list.size() - 1);
            //取两个数差的绝对值
            int x = Math.abs((a - b));
            //如果存在
            if (x > 0) {
                //记录
                list.add(x);
            }
        }
        //结束,如果都碎了
        if (list.size() == 0) {
            //为0
            return 0;
        } else {
            //返回剩下的
            return list.get(0);
        }
    }

    public static void main(String[] args) {
        System.out.println(lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1}));
    }
}

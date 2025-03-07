package normal7;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2021-09-02
 * 826. 安排工作以达到最大收益
 * 有一些工作：difficulty[i] 表示第 i 个工作的难度，profit[i] 表示第 i 个工作的收益。
 * <p>
 * 现在我们有一些工人。worker[i] 是第 i 个工人的能力，即该工人只能完成难度小于等于 worker[i] 的工作。
 * <p>
 * 每一个工人都最多只能安排一个工作，但是一个工作可以完成多次。
 * <p>
 * 举个例子，如果 3 个工人都尝试完成一份报酬为 1 的同样工作，那么总收益为 $3。如果一个工人不能完成任何工作，他的收益为 $0 。
 * <p>
 * 我们能得到的最大收益是多少？
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入: difficulty = [2,4,6,8,10], profit = [10,20,30,40,50], worker = [4,5,6,7]
 * 输出: 100
 * 解释: 工人被分配的工作难度是 [4,4,6,6] ，分别获得 [20,20,30,30] 的收益。
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= difficulty.length = profit.length <= 10000
 * 1 <= worker.length <= 10000
 * difficulty[i], profit[i], worker[i]  的范围是 [1, 10^5]
 */
public class Code4 {

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        //缓存组
        Map<Integer, Integer> map = new HashMap<>(difficulty.length);
        //循环
        for (int i = 0; i < difficulty.length; i++) {
            //当前key
            int key = difficulty[i];
            //当前收益
            int value = profit[i];
            //最大收益
            int old = map.getOrDefault(key, 0);
            //记录最大
            map.put(key, Math.max(old, value));
        }
        //排个序
        Arrays.sort(difficulty);
        //最小收益
        int min = 0;
        //循环
        for (int i = 0; i < difficulty.length; i++) {
            //当前难度及以下最大收益
            int money = Math.max(map.get(difficulty[i]), min);
            //刷新
            min = money;
            //记录
            profit[i] = money;
        }
        //工人排序
        Arrays.sort(worker);
        //开始遍历难度
        int a = 0, b = 0;
        //和
        int sum = 0;
        //循环
        while (a < difficulty.length && b < worker.length) {
            //当前难度
            int diff = difficulty[a];
            int work = worker[b];
            //如果正好相等
            if (diff == work) {
                //直接记录
                sum += profit[a];
                //下一位
                b++;
            } else if (diff > work) {
                //这个人不行
                b++;
            } else {
                //尝试下一级
                while (difficulty[a] < work) {
                    a++;
                    //如果最大了
                    if (a == difficulty.length) {
                        //结束
                        break;
                    }
                }
                //如果最大了
                if (a == difficulty.length) {
                    //下去
                    a--;
                    //如果还小
                    if (difficulty[a] > work) {
                        a--;
                    }
                } else {
                    //如果正好是
                    if (difficulty[a] == work) {

                    } else {
                        a--;
                    }
                }
                //直接记录
                sum += profit[a];
                //下一位
                b++;
            }
        }
        //返回
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Code4().maxProfitAssignment(new int[]{13, 37, 58}, new int[]{4, 90, 96}, new int[]{34, 73, 45}));
    }

}

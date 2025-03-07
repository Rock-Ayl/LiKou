package normal3;

import java.util.*;

/**
 * Created By Rock-Ayl on 2021-05-02
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
public class Code10 {

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        //报酬
        int money = 0;
        //所有难度列表缓存
        Set<Integer> set = new HashSet<>();
        //每个工作获得最大报酬的缓存
        Map<Integer, Integer> map = new HashMap<>();
        //循环
        for (int i = 0; i < difficulty.length; i++) {
            //当前难度
            int diff = difficulty[i];
            //报酬
            int pro = profit[i];
            //如果存在当前难度
            if (map.containsKey(diff)) {
                //如果当前难度有更大的酬劳了
                if (map.get(diff) < pro) {
                    //更新
                    map.put(diff, pro);
                }
            } else {
                //初始化
                map.put(diff, pro);
            }
            //记录难度
            set.add(diff);
        }
        //转化为arr
        int[] arr = set.stream().mapToInt(Integer::byteValue).toArray();
        //排个序
        Arrays.sort(arr);
        //缓存2
        Map<Integer, Integer> map2 = new HashMap<>();
        //循环
        for (int i = 0; i < arr.length; i++) {
            //记录位置
            map2.put(arr[i], i);
        }
        //当前最小薪酬
        int min = 0;
        //循环
        for (int i : arr) {
            //当前的钱
            int thisMoney = map.get(i);
            //如果当前的前还不如之前的钱
            if (thisMoney < min) {
                //用更小的
                map.put(i, min);
            } else if (thisMoney > min) {
                //更新最小薪酬
                min = thisMoney;
            }
        }
        //循环
        for (int work : worker) {
            //如果存在当前难度
            if (map.containsKey(work)) {
                //直接取出来可获取最大收益然后叠加
                money += map.get(work);
            }
        }
        //返回
        return money;
    }

    public static void main(String[] args) {
        System.out.println(new Code10().maxProfitAssignment(new int[]{2, 4, 6, 8, 10}, new int[]{10, 20, 30, 40, 50}, new int[]{4, 5, 6, 7}));
    }

}

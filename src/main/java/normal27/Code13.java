package normal27;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author ayl
 * @Date 2023-12-29
 * 2611. 老鼠和奶酪
 * 提示
 * 中等
 * 101
 * 相关企业
 * 有两只老鼠和 n 块不同类型的奶酪，每块奶酪都只能被其中一只老鼠吃掉。
 * <p>
 * 下标为 i 处的奶酪被吃掉的得分为：
 * <p>
 * 如果第一只老鼠吃掉，则得分为 reward1[i] 。
 * 如果第二只老鼠吃掉，则得分为 reward2[i] 。
 * 给你一个正整数数组 reward1 ，一个正整数数组 reward2 ，和一个非负整数 k 。
 * <p>
 * 请你返回第一只老鼠恰好吃掉 k 块奶酪的情况下，最大 得分为多少。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：reward1 = [1,1,3,4], reward2 = [4,4,1,1], k = 2
 * 输出：15
 * 解释：这个例子中，第一只老鼠吃掉第 2 和 3 块奶酪（下标从 0 开始），第二只老鼠吃掉第 0 和 1 块奶酪。
 * 总得分为 4 + 4 + 3 + 4 = 15 。
 * 15 是最高得分。
 * 示例 2：
 * <p>
 * 输入：reward1 = [1,1], reward2 = [1,1], k = 2
 * 输出：2
 * 解释：这个例子中，第一只老鼠吃掉第 0 和 1 块奶酪（下标从 0 开始），第二只老鼠不吃任何奶酪。
 * 总得分为 1 + 1 = 2 。
 * 2 是最高得分。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n == reward1.length == reward2.length <= 105
 * 1 <= reward1[i], reward2[i] <= 1000
 * 0 <= k <= n
 */
public class Code13 {

    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        //初始化差数组
        int[] differenceArr = new int[reward1.length];
        //索引数组
        Integer[] indexArr = new Integer[reward1.length];
        //循环
        for (int i = 0; i < differenceArr.length; i++) {
            //计算本奶酪,老鼠1、老鼠2吃的差距
            differenceArr[i] = reward1[i] - reward2[i];
            //记录索引
            indexArr[i] = i;
        }
        //给索引排序
        Arrays.sort(indexArr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                //按照差距排
                return differenceArr[o1] - differenceArr[o2];
            }
        });
        //和
        int sum = 0;
        //索引数组的索引
        int indexArrIndex = indexArr.length;
        //如果1有额度
        while (indexArrIndex > 0) {
            //如果老鼠1有额度
            if (k-- > 0) {
                //老鼠1吃
                sum += reward1[indexArr[--indexArrIndex]];
            } else {
                //老鼠2吃
                sum += reward2[indexArr[--indexArrIndex]];
            }
        }
        //返回结果
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Code13().miceAndCheese(new int[]{1, 1, 3, 4}, new int[]{4, 4, 1, 1}, 2));
    }

}

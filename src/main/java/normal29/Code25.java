package normal29;

/**
 * @Author ayl
 * @Date 2024-03-19
 * 2086. 喂食仓鼠的最小食物桶数
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的字符串 hamsters ，其中 hamsters[i]  要么是：
 * <p>
 * 'H' 表示有一个仓鼠在下标 i ，或者
 * '.' 表示下标 i 是空的。
 * 你将要在空的位置上添加一定数量的食物桶来喂养仓鼠。如果仓鼠的左边或右边至少有一个食物桶，就可以喂食它。更正式地说，如果你在位置 i - 1 或者 i + 1 放置一个食物桶，就可以喂养位置为 i 处的仓鼠。
 * <p>
 * 在 空的位置 放置食物桶以喂养所有仓鼠的前提下，请你返回需要的 最少 食物桶数。如果无解请返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：hamsters = "H..H"
 * 输出：2
 * 解释：
 * 我们可以在下标为 1 和 2 处放食物桶。
 * 可以发现如果我们只放置 1 个食物桶，其中一只仓鼠将得不到喂养。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：street = ".H.H."
 * 输出：1
 * 解释：
 * 我们可以在下标为 2 处放置一个食物桶。
 * 示例 3：
 * <p>
 * 输入：street = ".HHH."
 * 输出：-1
 * 解释：
 * 如果我们如图那样在每个空位放置食物桶，下标 2 处的仓鼠将吃不到食物。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= hamsters.length <= 105
 * hamsters[i] 要么是 'H' ，要么是 '.' 。
 */
public class Code25 {

    public int minimumBuckets(String hamsters) {
        //放置食物数
        int count = 0;
        //缓存
        int[] arr = new int[hamsters.length()];
        //循环
        for (int i = 0; i < hamsters.length(); i++) {
            //当前字符
            char letter = hamsters.charAt(i);
            //如果不是仓鼠
            if ('H' != letter) {
                //本轮过
                continue;
            }
            //判断左右有没有空位
            boolean leftNoSpace = i - 1 < 0 || hamsters.charAt(i - 1) == 'H';
            boolean rightNoSpace = i + 1 >= hamsters.length() || hamsters.charAt(i + 1) == 'H';
            //如果都没有空位
            if (leftNoSpace && rightNoSpace) {
                //不可能
                return -1;
            }
            //如果左边已经放置了食物
            if (i - 1 >= 0 && arr[i - 1] > 0) {
                //本轮过
                continue;
            }
            //如果右边有空位
            if (rightNoSpace == false) {
                //投喂食物
                arr[i + 1]++;
                count++;
            } else {
                //投喂食物
                arr[i - 1]++;
                count++;
            }
        }
        //返回结果
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Code25().minimumBuckets(".HHH."));
    }

}

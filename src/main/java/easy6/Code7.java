package easy6;

/**
 * Created By Rock-Ayl on 2021-02-03
 * 1523. 在区间范围内统计奇数数目
 * 给你两个非负整数 low 和 high 。请你返回 low 和 high 之间（包括二者）奇数的数目。
 * <p>
 * 示例 1：
 * <p>
 * 输入：low = 3, high = 7
 * 输出：3
 * 解释：3 到 7 之间奇数数字为 [3,5,7] 。
 * 示例 2：
 * <p>
 * 输入：low = 8, high = 10
 * 输出：1
 * 解释：8 到 10 之间奇数数字为 [9] 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= low <= high <= 10^9
 */
public class Code7 {

    public static int countOdds(int low, int high) {
        //奇数数量
        int size = 0;
        //如果左边距是奇数
        if (low % 2 != 0) {
            //记录
            size++;
        }
        //如果右边距是奇数
        if (high % 2 != 0) {
            //记录
            size++;
        }
        //如果左右都是奇数
        if (size == 2) {
            //意味等会中间要少一个奇数
            size--;
        }
        //计算中间的奇数
        size += (high - low) / 2;
        //返回
        return size;
    }

    public static void main(String[] args) {
        System.out.println(countOdds(3, 7));
    }
}

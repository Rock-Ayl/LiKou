package easy7;

/**
 * Created By Rock-Ayl on 2021-03-10
 * 剑指 Offer 11. 旋转数组的最小数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
 * <p>
 * 示例 1：
 * <p>
 * 输入：[3,4,5,1,2]
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：[2,2,2,0,1]
 * 输出：0
 * 注意：本题与主站 154 题相同：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/
 */
public class Code14 {

    public static int minArray(int[] numbers) {
        //最小元素
        int min = numbers[0];
        //循环
        for (int i = 1; i < numbers.length; i++) {
            //当前
            int x = numbers[i];
            //取最小
            min = Math.min(min, x);
        }
        //返回
        return min;
    }

    public static void main(String[] args) {
        System.out.println(minArray(new int[]{3, 4, 5, 1, 2}));
    }
}

package normal47;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author ayl
 * @Date 2025-10-19
 * 面试题 16.21. 交换和
 * 同步题目状态
 * <p>
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给定两个整数数组，请交换一对数值（每个数组中取一个数值），使得两个数组所有元素的和相等。
 * <p>
 * 返回一个数组，第一个元素是第一个数组中要交换的元素，第二个元素是第二个数组中要交换的元素。若有多个答案，返回任意一个均可。若无满足条件的数值，返回空数组。
 * <p>
 * 示例 1：
 * <p>
 * 输入：array1 = [4, 1, 2, 1, 1, 2], array2 = [3, 6, 3, 3]
 * 输出：[1, 3]
 * 示例 2：
 * <p>
 * 输入：array1 = [1, 2, 3], array2 = [4, 5, 6]
 * 输出：[]
 * 提示：
 * <p>
 * 1 <= array1.length, array2.length <= 100000
 */
public class Code5 {

    public int[] findSwapValues(int[] array1, int[] array2) {
        //各自的和
        int target = 0;
        //数组2的枚举
        Set<Integer> array2Set = new HashSet<>();
        //循环
        for (int num : array1) {
            //叠加
            target += num;
        }
        //循环
        for (int num : array2) {
            //叠加
            target -= num;
            //记录枚举
            array2Set.add(num);
        }
        //如果不是偶数
        if (target % 2 != 0) {
            //过
            return new int[]{};
        }
        //1需要增加的值
        target = target / 2;
        //循环数字1
        for (int num : array1) {
            //所需
            int need = num - target;
            //如果存在
            if (array2Set.contains(need) == true) {
                //返回结果
                return new int[]{num, need};
            }
        }
        //默认无
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] swapValues = new Code5().findSwapValues(new int[]{4, 1, 2, 1, 1, 2}, new int[]{3, 6, 3, 3});
        System.out.println();
    }

}

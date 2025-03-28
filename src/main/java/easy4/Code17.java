package easy4;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By Rock-Ayl on 2020-12-22
 * 922. 按奇偶排序数组 II
 * 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
 * <p>
 * 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
 * <p>
 * 你可以返回任何满足上述条件的数组作为答案。
 * <p>
 * 示例：
 * <p>
 * 输入：[4,2,5,7]
 * 输出：[4,5,2,7]
 * 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
 */
public class Code17 {

    public static int[] sortArrayByParityII(int[] A) {
        //奇数
        List<Integer> once = new ArrayList<>();
        //偶数
        List<Integer> twice = new ArrayList<>();
        //循环
        for (int i : A) {
            //如果是偶数
            if (i % 2 == 0) {
                //记录
                twice.add(i);
            } else {
                once.add(i);
            }
        }
        //初始化结果
        List<Integer> list = new ArrayList<>();
        //奇偶数的位置
        int po = 0, pt = 0;
        //循环
        for (int i = 0; i < once.size() * 2; i++) {
            //如果是偶数
            if (i % 2 == 0) {
                //获取并组装
                list.add(twice.get(pt));
                //叠加
                pt++;
            } else {
                //获取并组装
                list.add(once.get(po));
                //叠加
                po++;
            }
        }
        //返回
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        for (int i : sortArrayByParityII(new int[]{4,2,5,7})) {
            System.out.println(i);
        }
    }
}

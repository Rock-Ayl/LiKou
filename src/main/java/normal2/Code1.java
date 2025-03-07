package normal2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created By Rock-Ayl on 2021-04-02
 * 面试题 16.06. 最小差
 * 给定两个整数数组a和b，计算具有最小差绝对值的一对数值（每个数组中取一个值），并返回该对数值的差
 * <p>
 * 示例：
 * <p>
 * 输入：{1, 3, 15, 11, 2}, {23, 127, 235, 19, 8}
 * 输出：3，即数值对(11, 8)
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= a.length, b.length <= 100000
 * -2147483648 <= a[i], b[i] <= 2147483647
 * 正确结果在区间 [0, 2147483647] 内
 * 通过次数9,250提交次数22,308
 */
public class Code1 {

    public static int smallestDifference(int[] a, int[] b) {
        //集合
        int[] arr = new int[a.length + b.length];
        //位置
        int p = 0;
        //记录缓存
        Set<Integer> aSet = new HashSet<>();
        //记录缓存
        Set<Integer> bSet = new HashSet<>();
        //循环
        for (int i : a) {
            //记录
            arr[p] = i;
            //记录
            aSet.add(i);
            //递增
            p++;
        }
        //循环
        for (int i : b) {
            //记录
            arr[p] = i;
            //记录
            bSet.add(i);
            //递增
            p++;
        }
        //排序
        Arrays.sort(arr);
        //边界
        int size = arr.length - 1;
        //绝对差
        int min = Integer.MAX_VALUE;
        //循环
        for (int i = 0; i < size; i++) {
            //获取左右
            int x = arr[i];
            int y = arr[i + 1];
            //如果分别是a、b
            if ((aSet.contains(x) && bSet.contains(y)) || (aSet.contains(y) && bSet.contains(x))) {
                //计算绝对差
                int minus = Math.abs((x - y));
                //如果是最小
                if (minus == 0) {
                    //直接返回
                    return min;
                }
                //如果更小
                if (minus < min && minus > 0) {
                    //赋值
                    min = minus;
                }
            }
        }
        //返回
        return min;
    }


    public static void main(String[] args) {
        System.out.println(smallestDifference(new int[]{-2147483648, 1}, new int[]{2147483647, 0}));
    }
}

package normal;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Created By Rock-Ayl on 2020-11-28
 * 260. 只出现一次的数字 III
 * 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。
 * <p>
 * 示例 :
 * <p>
 * 输入: [1,2,1,3,2,5]
 * 输出: [3,5]
 * 注意：
 * <p>
 * 结果输出的顺序并不重要，对于上面的例子， [5, 3] 也是正确答案。
 * 你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？
 */
public class Code8 {

    public static int[] star(int[] nums) {
        int bitmask = 0;
        for (int num : nums) bitmask ^= num;
        int diff = bitmask & (-bitmask);
        int x = 0;
        for (int num : nums) if ((num & diff) != 0) x ^= num;
        return new int[]{x, bitmask ^ x};
    }

    public static int[] singleNumber(int[] nums) {
        //一个set
        Set<Integer> set = new HashSet<>();
        //循环
        for (int num : nums) {
            //如果存在
            if (set.contains(num)) {
                //删除
                set.remove(num);
            } else {
                //加入
                set.add(num);
            }
        }
        //返回
        return set.stream().mapToInt(Number::intValue).toArray();
    }

    public static void main(String[] args) {
        for (int i : star(new int[]{1, 2, 1, 3, 2, 5})) {
            System.out.println(i);
        }
    }
}

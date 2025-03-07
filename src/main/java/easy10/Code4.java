package easy10;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author 安永亮
 * @Date 2021-07-04
 * @Description 645. 错误的集合
 * 集合 s 包含从 1 到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个数字复制了成了集合里面的另外一个数字的值，导致集合 丢失了一个数字 并且 有一个数字重复 。
 * <p>
 * 给定一个数组 nums 代表了集合 S 发生错误后的结果。
 * <p>
 * 请你找出重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,2,4]
 * 输出：[2,3]
 * 示例 2：
 * <p>
 * 输入：nums = [1,1]
 * 输出：[1,2]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 104
 * 1 <= nums[i] <= 104
 */
public class Code4 {

    public int[] findErrorNums(int[] nums) {
        //循环
        int[] result = new int[2];
        //缓存
        Set<Integer> set = new HashSet<>();
        //缓存2
        Set<Integer> set2 = new HashSet<>();
        //指针
        int p = 1;
        //循环
        while (p <= nums.length) {
            //记录
            set2.add(p++);
        }
        //循环
        for (int i = 0; i < nums.length; i++) {
            //当前
            int num = nums[i];
            //如果重复了
            if (set.contains(num)) {
                //找到重复的了
                result[0] = num;
            } else {
                //记录
                set.add(num);
                //删除
                set2.remove(num);
            }
        }
        //结果
        result[1] = set2.iterator().next();
        //返回结果
        return result;
    }

    public static void main(String[] args) {
        for (int errorNum : new Code4().findErrorNums(new int[]{1, 2, 2, 4})) {
            System.out.println(errorNum);
        }
    }

}

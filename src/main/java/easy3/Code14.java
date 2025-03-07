package easy3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created By Rock-Ayl on 2020-11-03
 * 645. 错误的集合
 * 集合 S 包含从1到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个元素复制了成了集合里面的另外一个元素的值，导致集合丢失了一个整数并且有一个元素重复。
 * <p>
 * 给定一个数组 nums 代表了集合 S 发生错误后的结果。你的任务是首先寻找到重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,2,4]
 * 输出: [2,3]
 * 注意:
 * <p>
 * 给定数组的长度范围是 [2, 10000]。
 * 给定的数组是无序的。
 */
public class Code14 {

    public static int[] findErrorNums(int[] nums) {
        //初始化返回值
        int[] result = new int[2];
        //长度
        int num = nums.length;
        //丢失缓存
        Set<Integer> loseSet = new HashSet();
        //丢失缓存组装
        int y = 1;
        //循环
        while (y <= num) {
            //组装并+1
            loseSet.add(y++);
        }
        //重复缓存
        Set<Integer> sameSet = new HashSet<>();
        //找重复的
        for (int i = 0; i < num; i++) {
            //当前位置数
            int x = nums[i];
            //如果存在该数
            if (sameSet.contains(x)) {
                //记录重复
                result[0] = x;
                //找丢失的
                for (int j = i; j < num; j++) {
                    //当前位置数
                    x = nums[j];
                    //删除缓存
                    loseSet.remove(x);
                }
                //中断
                break;
            } else {
                //记录缓存
                sameSet.add(x);
            }
            //该数没有丢失
            loseSet.remove(x);
        }
        //循环
        for (Integer integer : loseSet) {
            //记录丢失的
            result[1] = integer;
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        for (int errorNum : findErrorNums(new int[]{1, 2, 2, 4})) {
            System.out.println(errorNum);
        }
    }
}

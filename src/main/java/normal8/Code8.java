package normal8;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2021-09-21
 * 128. 最长连续序列
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * <p>
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * 示例 2：
 * <p>
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 */
public class Code8 {

    public int longestConsecutive(int[] nums) {
        //判空
        if (nums.length == 0) {
            //返回
            return 0;
        }
        //排个序
        Arrays.sort(nums);
        //最短长度
        int max = 0;
        //初始化
        int last = nums[0];
        //长度
        int size = 1;
        //循环
        for (int i = 1; i < nums.length; i++) {
            //当前
            int num = nums[i];
            //如果是+1
            if (last + 1 == num) {
                //更改
                size++;
            } else if (last == num) {
                //过
            } else {
                //如果刷新了记录
                if (size > max) {
                    //刷新
                    max = size;
                }
                //重置
                size = 1;
            }
            //记录
            last = num;
        }
        //返回结果
        return Math.max(max, size);
    }

    public static void main(String[] args) {
        System.out.println(new Code8().longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }

}

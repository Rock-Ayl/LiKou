package normal12;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ayl
 * @Date 2022-02-21
 * 1004. 最大连续1的个数 III
 * 给定一个二进制数组 nums 和一个整数 k ，如果可以翻转最多k 个 0 ，则返回 数组中连续 1 的最大个数 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 * 输出：6
 * 解释：[1,1,1,0,0,1,1,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 6。
 * 示例 2：
 * <p>
 * 输入：nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
 * 输出：10
 * 解释：[0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 10。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * nums[i] 不是 0 就是 1
 * 0 <= k <= nums.length
 */
public class Code3 {

    public int start(int[] nums, int k) {
        //左右边距,结果
        int left = 0, right = 0, result = 0;
        //循环
        while (right < nums.length) {
            //如果需要填补
            if (nums[right] == 0) {
                //可填补数量
                if (k == 0) {
                    //左边距
                    while (nums[left] == 1) {
                        //移动
                        left++;
                    }
                    //移动
                    left++;
                } else {
                    //递减
                    k--;
                }
            }
            //计算最大
            result = Math.max(result, ++right - left);
        }
        //返回
        return result;
    }

    public int longestOnes(int[] nums, int k) {
        //如果太多了
        if (nums.length <= k) {
            //直接返回
            return nums.length;
        }
        //缓存
        List<Integer> list = new ArrayList<>();
        //循环
        for (int i = 0; i < nums.length; i++) {
            //如果是0
            if (nums[i] == 0) {
                //组装
                list.add(i);
            }
        }
        //如果还是太多
        if (list.size() <= k) {
            //直接返回
            return nums.length;
        }
        //增加一个边界
        list.add(nums.length);
        //左右
        int left = 0, right = k + 1;
        //初始化最大值
        int max = list.get(k);
        //循环
        while (right < list.size()) {
            //计算
            int num = list.get(right++) - list.get(left++) - 1;
            //如果更大
            if (num > max) {
                //刷新
                max = num;
            }
        }
        //返回
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Code3().start(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3));
    }
}

package easy30;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author ayl
 * @Date 2023-05-17
 * 剑指 Offer II 059. 数据流的第 K 大数值
 * 设计一个找到数据流中第 k 大元素的类（class）。注意是排序后的第 k 大元素，不是第 k 个不同的元素。
 * <p>
 * 请实现 KthLargest 类：
 * <p>
 * KthLargest(int k, int[] nums) 使用整数 k 和整数流 nums 初始化对象。
 * int add(int val) 将 val 插入数据流 nums 后，返回当前数据流中第 k 大的元素。
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：
 * ["KthLargest", "add", "add", "add", "add", "add"]
 * [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
 * 输出：
 * [null, 4, 5, 5, 8, 8]
 * <p>
 * 解释：
 * KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
 * kthLargest.add(3);   // return 4
 * kthLargest.add(5);   // return 5
 * kthLargest.add(10);  // return 5
 * kthLargest.add(9);   // return 8
 * kthLargest.add(4);   // return 8
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= 104
 * 0 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * -104 <= val <= 104
 * 最多调用 add 方法 104 次
 * 题目数据保证，在查找第 k 大元素时，数组中至少有 k 个元素
 * <p>
 * <p>
 * 注意：本题与主站 703 题相同： https://leetcode-cn.com/problems/kth-largest-element-in-a-stream/
 */
public class Code21 {

    //缓存
    private List<Integer> list;
    private int k;

    public Code21(int k, int[] nums) {
        //初始化
        this.k = k;
        //判断是否需要裁剪
        if (nums.length <= k) {
            //不需要删减初始化
            this.list = Arrays
                    .stream(nums)
                    //装箱
                    .boxed()
                    //排序
                    .sorted()
                    //转化为列表
                    .collect(Collectors.toList());
        } else {
            //需要跳过初始化
            this.list = Arrays
                    .stream(nums)
                    //装箱
                    .boxed()
                    //排序
                    .sorted()
                    //跳过
                    .skip(nums.length - k)
                    //转化为列表
                    .collect(Collectors.toList());
        }
    }

    public int add(int val) {
        //如果不够长度
        if (list.isEmpty() || list.size() < k) {
            //循环
            for (int i = 0; i < list.size(); i++) {
                //当前
                int num = list.get(i);
                //如果找到了位置
                if (num > val) {
                    //加入
                    list.add(i, val);
                    //跳出
                    break;
                }
            }
            //如果最大
            if (list.size() < k) {
                //放在最后
                list.add(val);
            }
            //返回第N大
            return list.get(0);
        } else if (val <= list.get(0)) {
            //直接返回第N大
            return list.get(0);
        } else {
            //删除第一个
            list.remove(0);
            //循环
            for (int i = 0; i < list.size(); i++) {
                //当前
                int num = list.get(i);
                //如果找到了位置
                if (num > val) {
                    //加入
                    list.add(i, val);
                    //跳出
                    break;
                }
            }
            //如果最大
            if (list.size() < k) {
                //放在最后
                list.add(val);
            }
            //返回第N大
            return list.get(0);
        }
    }

    //null, 4, 5, 5, 8, 8
    public static void main(String[] args) {
        Code21 code = new Code21(3, new int[]{4, 5, 8, 2});
        System.out.println(code.add(3));
        System.out.println(code.add(5));
        System.out.println(code.add(10));
        System.out.println(code.add(9));
        System.out.println(code.add(4));
        System.out.println();
    }

}

package normal40;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2025-03-01
 * 1865. 找出和为指定值的下标对
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你两个整数数组 nums1 和 nums2 ，请你实现一个支持下述两类查询的数据结构：
 * <p>
 * 累加 ，将一个正整数加到 nums2 中指定下标对应元素上。
 * 计数 ，统计满足 nums1[i] + nums2[j] 等于指定值的下标对 (i, j) 数目（0 <= i < nums1.length 且 0 <= j < nums2.length）。
 * 实现 FindSumPairs 类：
 * <p>
 * FindSumPairs(int[] nums1, int[] nums2) 使用整数数组 nums1 和 nums2 初始化 FindSumPairs 对象。
 * void add(int index, int val) 将 val 加到 nums2[index] 上，即，执行 nums2[index] += val 。
 * int count(int tot) 返回满足 nums1[i] + nums2[j] == tot 的下标对 (i, j) 数目。
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：
 * ["FindSumPairs", "count", "add", "count", "count", "add", "add", "count"]
 * [[[1, 1, 2, 2, 2, 3], [1, 4, 5, 2, 5, 4]], [7], [3, 2], [8], [4], [0, 1], [1, 1], [7]]
 * 输出：
 * [null, 8, null, 2, 1, null, null, 11]
 * <p>
 * 解释：
 * FindSumPairs findSumPairs = new FindSumPairs([1, 1, 2, 2, 2, 3], [1, 4, 5, 2, 5, 4]);
 * findSumPairs.count(7);  // 返回 8 ; 下标对 (2,2), (3,2), (4,2), (2,4), (3,4), (4,4) 满足 2 + 5 = 7 ，下标对 (5,1), (5,5) 满足 3 + 4 = 7
 * findSumPairs.add(3, 2); // 此时 nums2 = [1,4,5,4,5,4]
 * findSumPairs.count(8);  // 返回 2 ；下标对 (5,2), (5,4) 满足 3 + 5 = 8
 * findSumPairs.count(4);  // 返回 1 ；下标对 (5,0) 满足 3 + 1 = 4
 * findSumPairs.add(0, 1); // 此时 nums2 = [2,4,5,4,5,4]
 * findSumPairs.add(1, 1); // 此时 nums2 = [2,5,5,4,5,4]
 * findSumPairs.count(7);  // 返回 11 ；下标对 (2,1), (2,2), (2,4), (3,1), (3,2), (3,4), (4,1), (4,2), (4,4) 满足 2 + 5 = 7 ，下标对 (5,3), (5,5) 满足 3 + 4 = 7
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums1.length <= 1000
 * 1 <= nums2.length <= 105
 * 1 <= nums1[i] <= 109
 * 1 <= nums2[i] <= 105
 * 0 <= index < nums2.length
 * 1 <= val <= 105
 * 1 <= tot <= 109
 * 最多调用 add 和 count 函数各 1000 次
 */
public class Code17 {

    //缓存
    private int[] nums1;
    private int[] nums2;
    //统计缓存
    private Map<Integer, Integer> countMap1;
    private Map<Integer, Integer> countMap2;
    //统计缓存1的key排序
    private Integer[] countKeySortArr1;

    public Code17(int[] nums1, int[] nums2) {
        //记录缓存
        this.nums1 = nums1;
        this.nums2 = nums2;
        //初始化
        this.countMap1 = new HashMap<>();
        this.countMap2 = new HashMap<>();
        //循环
        for (int num : nums1) {
            //+1
            this.countMap1.put(num, this.countMap1.getOrDefault(num, 0) + 1);
        }
        //初始化排序数组
        this.countKeySortArr1 = new Integer[this.countMap1.size()];
        //指针
        int countKeySortArr1Index = 0;
        //循环
        for (Integer key : this.countMap1.keySet()) {
            //记录并+1
            this.countKeySortArr1[countKeySortArr1Index++] = key;
        }
        //排序
        Arrays.sort(this.countKeySortArr1, Integer::compareTo);
        //循环
        for (int num : nums2) {
            //+1
            this.countMap2.put(num, this.countMap2.getOrDefault(num, 0) + 1);
        }
    }

    public void add(int index, int val) {
        //获取旧数字
        int oldVal = this.nums2[index];
        //计算新数字
        int newVal = oldVal + val;
        //覆盖为新数字
        this.nums2[index] = newVal;
        //+1
        this.countMap2.put(newVal, this.countMap2.getOrDefault(newVal, 0) + 1);
        //-1
        this.countMap2.put(oldVal, this.countMap2.getOrDefault(oldVal, 0) - 1);
    }

    public int count(int tot) {
        //次数
        int count = 0;
        //循环
        for (Integer left : this.countKeySortArr1) {
            //如果足够大了
            if (left > tot) {
                //跳出
                break;
            }
            //计算右边的
            Integer right = tot - left;
            //获取右边的数量
            int rightCount = this.countMap2.getOrDefault(right, 0);
            //如果不够
            if (rightCount < 1) {
                //本轮过
                continue;
            }
            //叠加本次结果
            count += this.countMap1.get(left) * rightCount;
        }
        //返回
        return count;
    }

    public static void main(String[] args) {
        Code17 code17 = new Code17(new int[]{1, 1, 2, 2, 2, 3}, new int[]{1, 4, 5, 2, 5, 4});
        System.out.println(code17.count(7));
        code17.add(3, 2);
        System.out.println(code17.count(8));
        System.out.println(code17.count(4));
        code17.add(0, 1);
        code17.add(1, 1);
        System.out.println(code17.count(7));
    }

}

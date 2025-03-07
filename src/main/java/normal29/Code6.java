package normal29;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2024-02-21
 * 2080. 区间内查询数字的频率
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 请你设计一个数据结构，它能求出给定子数组内一个给定值的 频率 。
 * <p>
 * 子数组中一个值的 频率 指的是这个子数组中这个值的出现次数。
 * <p>
 * 请你实现 RangeFreqQuery 类：
 * <p>
 * RangeFreqQuery(int[] arr) 用下标从 0 开始的整数数组 arr 构造一个类的实例。
 * int query(int left, int right, int value) 返回子数组 arr[left...right] 中 value 的 频率 。
 * 一个 子数组 指的是数组中一段连续的元素。arr[left...right] 指的是 nums 中包含下标 left 和 right 在内 的中间一段连续元素。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * ["RangeFreqQuery", "query", "query"]
 * [[[12, 33, 4, 56, 22, 2, 34, 33, 22, 12, 34, 56]], [1, 2, 4], [0, 11, 33]]
 * 输出：
 * [null, 1, 2]
 * <p>
 * 解释：
 * RangeFreqQuery rangeFreqQuery = new RangeFreqQuery([12, 33, 4, 56, 22, 2, 34, 33, 22, 12, 34, 56]);
 * rangeFreqQuery.query(1, 2, 4); // 返回 1 。4 在子数组 [33, 4] 中出现 1 次。
 * rangeFreqQuery.query(0, 11, 33); // 返回 2 。33 在整个子数组中出现 2 次。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 105
 * 1 <= arr[i], value <= 104
 * 0 <= left <= right < arr.length
 * 调用 query 不超过 105 次。
 */
public class Code6 {

    //缓存
    private Map<Integer, List<Integer>> cacheMap;

    public Code6(int[] arr) {
        //初始化缓存
        this.cacheMap = new HashMap<>();
        //循环
        for (int i = 0; i < arr.length; i++) {
            //当前数字
            int num = arr[i];
            //如果不存在
            if (this.cacheMap.containsKey(num) == false) {
                //初始化
                this.cacheMap.put(num, new ArrayList<>());
            }
            //记录坐标
            this.cacheMap.get(num).add(i);
        }
    }

    public int query(int left, int right, int value) {
        //如果不存在
        if (this.cacheMap.containsKey(value) == false) {
            //过
            return 0;
        }
        //获取对应的列表
        List<Integer> list = this.cacheMap.get(value);
        //如果没有对应区间
        if (list.get(list.size() - 1) < left || list.get(0) > right) {
            //过
            return 0;
        }
        //寻找左边
        int findLeft = findLeft(list, left, 0, list.size() - 1);
        //寻找右边
        int findRight = findRight(list, right, 0, list.size() - 1);
        //返回
        return findRight - findLeft + 1;
    }

    //双指针寻找左边
    private int findLeft(List<Integer> list, int target, int left, int right) {
        //如果到头了
        if (left + 1 >= right) {
            //判断返回左右
            return list.get(left) < target ? right : left;
        }
        //计算中间
        int mid = left + (right - left) / 2;
        //获取中间的索引
        Integer index = list.get(mid);
        //如果是
        if (index == target) {
            //返回结果
            return mid;
        }
        //判断方向
        if (index < target) {
            //继续寻找
            return findLeft(list, target, mid, right);
        } else {
            //继续寻找
            return findLeft(list, target, left, mid);
        }
    }

    //双指针寻找右边
    private int findRight(List<Integer> list, int target, int left, int right) {
        //如果到头了
        if (left + 1 >= right) {
            //判断返回左右
            return list.get(right) > target ? left : right;
        }
        //计算中间
        int mid = left + (right - left) / 2;
        //获取中间的索引
        Integer index = list.get(mid);
        //如果是
        if (index == target) {
            //返回结果
            return mid;
        }
        //判断方向
        if (index < target) {
            //继续寻找
            return findRight(list, target, mid, right);
        } else {
            //继续寻找
            return findRight(list, target, left, mid);
        }
    }

    public static void main(String[] args) {
        Code6 code6 = new Code6(new int[]{3, 4, 5, 3, 3, 2, 2, 2, 5, 4});
        System.out.println(code6.query(0, 2, 3));
    }

}

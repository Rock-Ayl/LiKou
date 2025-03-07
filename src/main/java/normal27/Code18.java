package normal27;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author ayl
 * @Date 2024-01-11
 * 658. 找到 K 个最接近的元素
 * 中等
 * 相关标签
 * 相关企业
 * 给定一个 排序好 的数组 arr ，两个整数 k 和 x ，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。
 * <p>
 * 整数 a 比整数 b 更接近 x 需要满足：
 * <p>
 * |a - x| < |b - x| 或者
 * |a - x| == |b - x| 且 a < b
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [1,2,3,4,5], k = 4, x = 3
 * 输出：[1,2,3,4]
 * 示例 2：
 * <p>
 * 输入：arr = [1,2,3,4,5], k = 4, x = -1
 * 输出：[1,2,3,4]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= arr.length
 * 1 <= arr.length <= 104
 * arr 按 升序 排列
 * -104 <= arr[i], x <= 104
 */
public class Code18 {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        //初始化优先队列,定义规则
        PriorityQueue<Integer> queue = new PriorityQueue<>(arr.length, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                //计算距离
                int left = Math.abs(x - o1);
                int right = Math.abs(x - o2);
                //如果距离相同
                if (left == right) {
                    //按照数字本身对比
                    return o1 - o2;
                } else {
                    //按照距离
                    return left - right;
                }
            }
        });
        //给定数组加入到优先队列
        queue.addAll(Arrays.stream(arr).boxed().collect(Collectors.toList()));
        //初始化结果
        List<Integer> result = new ArrayList<>(k);
        //循环
        while (k-- > 0) {
            //组装
            result.add(queue.poll());
        }
        //结果排序
        Collections.sort(result);
        //返回
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Code18().findClosestElements(new int[]{1, 2, 3, 4, 5}, 3, 3));
    }

}

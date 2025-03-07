package normal;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created By Rock-Ayl on 2021-03-28
 * 1306. 跳跃游戏 III
 * 这里有一个非负整数数组 arr，你最开始位于该数组的起始下标 start 处。当你位于下标 i 处时，你可以跳到 i + arr[i] 或者 i - arr[i]。
 * <p>
 * 请你判断自己是否能够跳到对应元素值为 0 的 任一 下标处。
 * <p>
 * 注意，不管是什么情况下，你都无法跳到数组之外。
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [4,2,3,0,3,1,2], start = 5
 * 输出：true
 * 解释：
 * 到达值为 0 的下标 3 有以下可能方案：
 * 下标 5 -> 下标 4 -> 下标 1 -> 下标 3
 * 下标 5 -> 下标 6 -> 下标 4 -> 下标 1 -> 下标 3
 * 示例 2：
 * <p>
 * 输入：arr = [4,2,3,0,3,1,2], start = 0
 * 输出：true
 * 解释：
 * 到达值为 0 的下标 3 有以下可能方案：
 * 下标 0 -> 下标 4 -> 下标 1 -> 下标 3
 * 示例 3：
 * <p>
 * 输入：arr = [3,0,2,1,2], start = 2
 * 输出：false
 * 解释：无法到达值为 0 的下标 1 处。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 5 * 10^4
 * 0 <= arr[i] < arr.length
 * 0 <= start < arr.length
 */
public class Code22 {

    /**
     * 递归
     *
     * @return
     */
    public static Set<Integer> execute(int[] arr, int p, Set<Integer> set) {
        //如果越界,或者走过了
        if (p < 0 || p >= arr.length || set.contains(p)) {
            //返回
            return set;
        }
        //开始的位置标记
        set.add(p);
        //位置的数
        int num = arr[p];
        //如果是结果0
        if (num == 0) {
            //返回
            return set;
        }
        //跳到 i + arr[i] 或者 i - arr[i]
        set = execute(arr, p + num, set);
        set = execute(arr, p - num, set);
        //返回
        return set;
    }

    public static boolean canReach(int[] arr, int start) {
        //递归查询
        Set<Integer> set = execute(arr, start, new HashSet<>());
        //循环
        for (int i = 0; i < arr.length; i++) {
            //如果该位置是0 同时 走过该位置
            if (arr[i] == 0 && set.contains(i)) {
                //可以
                return true;
            }
        }
        //默认不可以
        return false;
    }

    public static void main(String[] args) {
        System.out.println(canReach(new int[]{4, 2, 3, 0, 3, 1, 2}, 5));
    }

}

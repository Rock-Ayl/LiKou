package easy27;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2023-01-17
 * 1640. 能否连接形成数组
 * 给你一个整数数组 arr ，数组中的每个整数 互不相同 。另有一个由整数数组构成的数组 pieces，其中的整数也 互不相同 。请你以 任意顺序 连接 pieces 中的数组以形成 arr 。但是，不允许 对每个数组 pieces[i] 中的整数重新排序。
 * <p>
 * 如果可以连接 pieces 中的数组形成 arr ，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [15,88], pieces = [[88],[15]]
 * 输出：true
 * 解释：依次连接 [15] 和 [88]
 * 示例 2：
 * <p>
 * 输入：arr = [49,18,16], pieces = [[16,18,49]]
 * 输出：false
 * 解释：即便数字相符，也不能重新排列 pieces[0]
 * 示例 3：
 * <p>
 * 输入：arr = [91,4,64,78], pieces = [[78],[4,64],[91]]
 * 输出：true
 * 解释：依次连接 [91]、[4,64] 和 [78]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= pieces.length <= arr.length <= 100
 * sum(pieces[i].length) == arr.length
 * 1 <= pieces[i].length <= arr.length
 * 1 <= arr[i], pieces[i][j] <= 100
 * arr 中的整数 互不相同
 * pieces 中的整数 互不相同（也就是说，如果将 pieces 扁平化成一维数组，数组中的所有整数互不相同）
 */
public class Code4 {

    public boolean canFormArray(int[] arr, int[][] pieces) {
        //缓存
        Map<Integer, int[]> map = new HashMap<>();
        //循环
        for (int[] piece : pieces) {
            //记录缓存
            map.put(piece[0], piece);
        }
        //循环
        for (int i = 0; i < arr.length; i++) {
            //当前目标数字
            int target = arr[i];
            //如果不存在
            if (map.containsKey(target) == false) {
                //不是
                return false;
            }
            //获取
            int[] cacheArr = map.get(target);
            //指针
            int p = 1;
            //如果还有
            while (p < cacheArr.length) {
                //下一个目标
                int nextTarget = arr[i + p];
                //下一个值
                int nextNum = cacheArr[p++];
                //如果不同
                if (nextTarget != nextNum) {
                    //不是
                    return false;
                }
            }
            //进位
            i = i + p - 1;
        }
        //默认
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Code4().canFormArray(
                new int[]{91, 4, 64, 78},
                new int[][]{
                        new int[]{78}, new int[]{4, 64}, new int[]{91}
                }));
    }

}

package easy26;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2022-12-15
 * 1356. 根据数字二进制下 1 的数目排序
 * 给你一个整数数组 arr 。请你将数组中的元素按照其二进制表示中数字 1 的数目升序排序。
 * <p>
 * 如果存在多个数字二进制中 1 的数目相同，则必须将它们按照数值大小升序排列。
 * <p>
 * 请你返回排序后的数组。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [0,1,2,3,4,5,6,7,8]
 * 输出：[0,1,2,4,8,3,5,6,7]
 * 解释：[0] 是唯一一个有 0 个 1 的数。
 * [1,2,4,8] 都有 1 个 1 。
 * [3,5,6] 有 2 个 1 。
 * [7] 有 3 个 1 。
 * 按照 1 的个数排序得到的结果数组为 [0,1,2,4,8,3,5,6,7]
 * 示例 2：
 * <p>
 * 输入：arr = [1024,512,256,128,64,32,16,8,4,2,1]
 * 输出：[1,2,4,8,16,32,64,128,256,512,1024]
 * 解释：数组中所有整数二进制下都只有 1 个 1 ，所以你需要按照数值大小将它们排序。
 * 示例 3：
 * <p>
 * 输入：arr = [10000,10000]
 * 输出：[10000,10000]
 * 示例 4：
 * <p>
 * 输入：arr = [2,3,5,7,11,13,17,19]
 * 输出：[2,3,5,17,7,11,13,19]
 * 示例 5：
 * <p>
 * 输入：arr = [10,100,1000,10000]
 * 输出：[10,100,10000,1000]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 500
 * 0 <= arr[i] <= 10^4
 */
public class Code2 {

    public int[] sortByBits(int[] arr) {
        //缓存
        Map<Integer, Integer> map = new HashMap<>();
        //循环
        for (int i : arr) {
            //该数字二进制下的1的数量
            int count = 0;
            //循环
            for (char c : Integer.toBinaryString(i).toCharArray()) {
                //如果是
                if (c == '1') {
                    //叠加
                    count++;
                }
            }
            //记录其关系
            map.put(i, count);
        }
        //封箱、排序、拆箱、返回
        return Arrays.stream(arr)
                .boxed()
                .sorted(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        //获取二进制1的数量
                        int count1 = map.get(o1);
                        int count2 = map.get(o2);
                        //如果不同
                        if (count1 - count2 != 0) {
                            //以这个为准
                            return count1 - count2;
                        }
                        //否则以正常为准
                        return o1 - o2;
                    }
                })
                .mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] result = new Code2().sortByBits(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8});
        System.out.println();
    }

}

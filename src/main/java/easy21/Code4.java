package easy21;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2022-07-14
 * 剑指 Offer II 075. 数组相对排序
 * 给定两个数组，arr1 和 arr2，
 * <p>
 * arr2 中的元素各不相同
 * arr2 中的每个元素都出现在 arr1 中
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= arr1.length, arr2.length <= 1000
 * 0 <= arr1[i], arr2[i] <= 1000
 * arr2 中的元素 arr2[i] 各不相同
 * arr2 中的每个元素 arr2[i] 都出现在 arr1 中
 * <p>
 * <p>
 * 注意：本题与主站 1122 题相同：https://leetcode-cn.com/problems/relative-sort-array/
 */
public class Code4 {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        //缓存
        Map<Integer, Integer> map = new HashMap<>(arr2.length);
        //循环
        for (int i = 0; i < arr2.length; i++) {
            //记录
            map.put(arr2[i], i);
        }
        //排序并返回
        return Arrays.stream(arr1).boxed().sorted(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                //如果都不存在
                if (map.containsKey(o1) == false && map.containsKey(o2) == false) {
                    //返回
                    return o1 - o2;
                }
                //如果不存在
                if (map.containsKey(o1) == false) {
                    //返回
                    return o2;
                }
                //如果不存在
                if (map.containsKey(o2) == false) {
                    //返回
                    return o1;
                }
                //返回
                return map.get(o1) - map.get(o2);
            }
        }).mapToInt(Integer::valueOf).toArray();
    }

    //2,2,2,1,4,3,3,9,6,7,19
    public static void main(String[] args) {

        System.out.println(new Code4().relativeSortArray(new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19}, new int[]{2, 1, 4, 3, 9, 6}));
    }

}

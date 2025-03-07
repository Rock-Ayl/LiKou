package easy10;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author 安永亮
 * @Date 2021-07-06
 * @Description 1122. 数组的相对排序
 * 给你两个数组，arr1 和 arr2，
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
 */
public class Code6 {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        //缓存
        Map<Integer, Integer> map = new HashMap<>();
        //循环
        for (int i : arr1) {
            //存在
            if (map.containsKey(i)) {
                //+1
                map.put(i, map.get(i) + 1);
            } else {
                //初始化
                map.put(i, 1);
            }
        }
        //指针
        int p = 0;
        //结果
        int[] result = new int[arr1.length];
        //循环2
        for (int i : arr2) {
            //次数
            int size = map.get(i);
            //循环
            while (size > 0) {
                //组装
                result[p++] = i;
                //减少
                size--;
            }
            //删除
            map.remove(i);
        }
        //为剩余的key排序
        int[] arrSort = new int[map.size()];
        //排序指针
        int sortP = 0;
        //循环
        for (Integer integer : map.keySet()) {
            //组装
            arrSort[sortP++] = integer;
        }
        //排序
        Arrays.sort(arrSort);
        //循环2
        for (int i : arrSort) {
            //次数
            int size = map.get(i);
            //循环
            while (size > 0) {
                //组装
                result[p++] = i;
                //减少
                size--;
            }
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        for (int i : new Code6().relativeSortArray(new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19}, new int[]{2, 1, 4, 3, 9, 6})) {
            System.out.print(i + ",");
        }
    }

}

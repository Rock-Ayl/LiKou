package easy6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created By Rock-Ayl on 2021-02-17
 * 1200. 最小绝对差
 * 给你个整数数组 arr，其中每个元素都 不相同。
 * <p>
 * 请你找到所有具有最小绝对差的元素对，并且按升序的顺序返回。
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [4,2,1,3]
 * 输出：[[1,2],[2,3],[3,4]]
 * 示例 2：
 * <p>
 * 输入：arr = [1,3,6,10,15]
 * 输出：[[1,3]]
 * 示例 3：
 * <p>
 * 输入：arr = [3,8,-10,23,19,-4,-14,27]
 * 输出：[[-14,-10],[19,23],[23,27]]
 */
public class Code19 {

    public static List<List<Integer>> minimumAbsDifference(int[] arr) {
        //初始化
        List<List<Integer>> result = new ArrayList<>();
        //差
        Integer num = null;
        //排序
        Arrays.sort(arr);
        //光标
        int a = 0;
        int b = 1;
        //循环
        while (b <= arr.length - 1) {
            //获取值
            int x = arr[b], y = arr[a];
            //最小绝对差
            int minus = x - y;
            //判空
            if (num == null) {
                //设为最小绝对差
                num = minus;
                //初始化
                List<Integer> list = new ArrayList<>();
                //组装
                list.add(arr[a]);
                list.add(arr[b]);
                //记录
                result.add(list);
            } else {
                //如果更小的绝对差
                if (minus < num) {
                    //设为最小绝对差
                    num = minus;
                    //清空
                    result.clear();
                    //初始化
                    List<Integer> list = new ArrayList<>();
                    //组装
                    list.add(arr[a]);
                    list.add(arr[b]);
                    //记录
                    result.add(list);
                } else if (minus == num) {
                    //初始化
                    List<Integer> list = new ArrayList<>();
                    //组装
                    list.add(arr[a]);
                    list.add(arr[b]);
                    //记录
                    result.add(list);
                }
            }
            //递增
            a++;
            b++;
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        System.out.println(minimumAbsDifference(new int[]{3, 8, -10, 23, 19, -4, -14, 27}));
    }
}

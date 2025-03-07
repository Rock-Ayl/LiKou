package normal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created By Rock-Ayl on 2020-11-20
 * 1282. 用户分组
 * 有 n 位用户参加活动，他们的 ID 从 0 到 n - 1，每位用户都 恰好 属于某一用户组。给你一个长度为 n 的数组 groupSizes，其中包含每位用户所处的用户组的大小，请你返回用户分组情况（存在的用户组以及每个组中用户的 ID）。
 * <p>
 * 你可以任何顺序返回解决方案，ID 的顺序也不受限制。此外，题目给出的数据保证至少存在一种解决方案。
 * <p>
 * 示例 1：
 * <p>
 * 输入：groupSizes = [3,3,3,3,3,1,3]
 * 输出：[[5],[0,1,2],[3,4,6]]
 * 解释：
 * 其他可能的解决方案有 [[2,1,6],[5],[0,4,3]] 和 [[5],[0,6,2],[4,3,1]]。
 * 示例 2：
 * <p>
 * 输入：groupSizes = [2,1,3,3,3,2]
 * 输出：[[1],[0,5],[2,3,4]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * groupSizes.length == n
 * 1 <= n <= 500
 * 1 <= groupSizes[i] <= n
 */
public class Code6 {

    public static List<List<Integer>> groupThePeople(int[] groupSizes) {
        //id,对应列表缓存
        Map<Integer, List<Integer>> map = new HashMap<>();
        //循环
        for (int i = 0; i < groupSizes.length; i++) {
            //获取当前id
            int x = groupSizes[i];
            //获取列表
            List<Integer> list = map.get(x);
            //判空
            if (list == null) {
                //初始化
                list = new ArrayList<>();
            }
            //记录
            list.add(i);
            //加入缓存
            map.put(x, list);
        }
        //初始化
        List<List<Integer>> result = new ArrayList<>();
        //循环
        for (Map.Entry<Integer, List<Integer>> integerListEntry : map.entrySet()) {
            //当前组
            List<Integer> thisList = integerListEntry.getValue();
            //当前组id
            int size = integerListEntry.getKey();
            //如果未超度限度
            if (thisList.size() <= size) {
                //组装
                result.add(thisList);
            } else {
                //小分组
                List<Integer> thisSmallList = new ArrayList<>();
                //循环
                for (Integer integer : thisList) {
                    //组装
                    thisSmallList.add(integer);
                    //如果即将超过
                    if (thisSmallList.size() == size) {
                        //组装
                        result.add(thisSmallList);
                        //重置
                        thisSmallList = new ArrayList<>();
                    }
                }
            }
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        for (List<Integer> list : groupThePeople(new int[]{2, 1, 3, 3, 3, 2})) {
            for (Integer integer : list) {
                System.out.println(integer);
            }
        }
    }
}

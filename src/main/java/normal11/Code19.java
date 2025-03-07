package normal11;

import java.util.*;

/**
 * @Author ayl
 * @Date 2022-02-17
 * 740. 删除并获得点数
 * 给你一个整数数组 nums ，你可以对它进行一些操作。
 * <p>
 * 每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除 所有 等于 nums[i] - 1 和 nums[i] + 1 的元素。
 * <p>
 * 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,4,2]
 * 输出：6
 * 解释：
 * 删除 4 获得 4 个点数，因此 3 也被删除。
 * 之后，删除 2 获得 2 个点数。总共获得 6 个点数。
 * 示例 2：
 * <p>
 * 输入：nums = [2,2,3,3,3,4]
 * 输出：9
 * 解释：
 * 删除 3 获得 3 个点数，接着要删除两个 2 和 4 。
 * 之后，再次删除 3 获得 3 个点数，再次删除 3 获得 3 个点数。
 * 总共获得 9 个点数。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 2 * 104
 * 1 <= nums[i] <= 104
 */
public class Code19 {

    public int deleteAndEarn(int[] nums) {
        //肯定获得的点数
        int count = 0;
        //缓存
        Map<Integer, Integer> map = new HashMap<>();
        //缓存2
        Set<Integer> set = new HashSet<>();
        //循环
        for (int num : nums) {
            //记录
            set.add(num);
            //记录
            map.put(num, map.getOrDefault(num, 0) + num);
        }
        //准备排序
        List<Integer> sortList = new ArrayList<>(set);
        //排序
        Collections.sort(sortList);
        //初始化可能有争议的组
        List<List<Integer>> groupList = new ArrayList<>();
        io:
        //循环
        for (int i = 0; i < sortList.size(); i++) {
            //当前数字
            int num = sortList.get(i);
            //有边界
            int j = i + 1;
            //如果未越界
            while (j < sortList.size()) {
                //获取
                int next = sortList.get(j);
                //如果关联
                if (next - 1 == num) {
                    //下一个
                    j++;
                    num = next;
                } else {
                    //如果是单个
                    if (i + 1 == j) {
                        //获取key
                        int key = sortList.get(i);
                        //肯定获取的
                        count += map.get(key);
                    } else if (i + 2 == j) {
                        //获取key
                        int key1 = sortList.get(i);
                        int key2 = sortList.get(i + 1);
                        //肯定获取的最大
                        count += Math.max(map.get(key1), map.get(key2));
                    } else {
                        //清算
                        List<Integer> list = new ArrayList<>();
                        //循环
                        for (int k = i; k < j; k++) {
                            //组装
                            list.add(sortList.get(k));
                        }
                        //组装
                        groupList.add(list);
                    }
                    //更新坐标
                    i = j - 1;
                    //结束本轮
                    continue io;
                }
            }
            //如果是单个
            if (i + 1 == j) {
                //获取key
                int key = sortList.get(i);
                //肯定获取的
                count += map.get(key);
            } else if (i + 2 == j) {
                //获取key
                int key1 = sortList.get(i);
                int key2 = sortList.get(i + 1);
                //肯定获取的最大
                count += Math.max(map.get(key1), map.get(key2));
            } else {
                //清算
                List<Integer> list = new ArrayList<>();
                //循环
                for (int k = i; k < j; k++) {
                    //组装
                    list.add(sortList.get(k));
                }
                //组装
                groupList.add(list);
            }
            //更新坐标
            i = j - 1;
        }
        //循环,每一个单独计算
        for (List<Integer> group : groupList) {
            //没个位置最优解
            int[] arr = new int[group.size()];
            //前两个
            arr[0] = map.get(group.get(0));
            arr[1] = Math.max(arr[0], map.get(group.get(1)));
            //循环
            for (int i = 2; i < arr.length; i++) {
                //计算
                arr[i] = Math.max(arr[i - 1], arr[i - 2] + map.get(group.get(i)));
            }
            //记录最大值
            count += arr[arr.length - 1];
        }
        //返回
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Code19().deleteAndEarn(new int[]{2, 2, 3, 3, 3, 4}));
    }
}

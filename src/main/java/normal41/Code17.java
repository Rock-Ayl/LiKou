package normal41;

import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2025-04-06
 * 475. 供暖器
 * 中等
 * 相关标签
 * 相关企业
 * 冬季已经来临。 你的任务是设计一个有固定加热半径的供暖器向所有房屋供暖。
 * <p>
 * 在加热器的加热半径范围内的每个房屋都可以获得供暖。
 * <p>
 * 现在，给出位于一条水平线上的房屋 houses 和供暖器 heaters 的位置，请你找出并返回可以覆盖所有房屋的最小加热半径。
 * <p>
 * 注意：所有供暖器 heaters 都遵循你的半径标准，加热的半径也一样。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: houses = [1,2,3], heaters = [2]
 * 输出: 1
 * 解释: 仅在位置 2 上有一个供暖器。如果我们将加热半径设为 1，那么所有房屋就都能得到供暖。
 * 示例 2:
 * <p>
 * 输入: houses = [1,2,3,4], heaters = [1,4]
 * 输出: 1
 * 解释: 在位置 1, 4 上有两个供暖器。我们需要将加热半径设为 1，这样所有房屋就都能得到供暖。
 * 示例 3：
 * <p>
 * 输入：houses = [1,5], heaters = [2]
 * 输出：3
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= houses.length, heaters.length <= 3 * 104
 * 1 <= houses[i], heaters[i] <= 109
 */
public class Code17 {

    public int findRadius(int[] houses, int[] heaters) {
        //为暖气排序
        Arrays.sort(heaters);
        //每个房子距离最近的加热器的最近距离
        int max = Integer.MIN_VALUE;
        //循环
        for (int house : houses) {
            //最近距离
            int near;
            //如果超过左边界
            if (house <= heaters[0]) {
                //直接使用
                near = heaters[0] - house;
            }
            //如果超过右边界
            else if (house >= heaters[heaters.length - 1]) {
                //直接使用
                near = house - heaters[heaters.length - 1];
            }
            //不在边界
            else {
                //二分寻找最近
                near = find(heaters, house, 0, heaters.length - 1);
            }
            //刷新全局最大结果
            max = Math.max(max, near);
        }
        //返回
        return max;
    }

    //二分寻找最近
    private int find(int[] heaters, int house, int left, int right) {
        //如果到头了
        if (left + 1 == right) {
            //返回结果
            return Math.min(house - heaters[left], heaters[right] - house);
        }
        //计算中间点坐标
        int mid = left + (right - left) / 2;
        //如果是目标
        if (heaters[mid] == house) {
            //直接返回
            return 0;
        }
        //判断方向
        if (house < heaters[mid]) {
            //递归
            return find(heaters, house, left, mid);
        } else {
            //递归
            return find(heaters, house, mid, right);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Code17().findRadius(new int[]{1, 2, 3, 4}, new int[]{1, 4}));
    }

}

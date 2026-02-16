package easy42;

import java.util.ArrayList;
import java.util.List;

/**
 * 3842. 切换灯泡开关
 * 算术评级: 2
 * 同步题目状态
 * <p>
 * 简单
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数数组 bulbs，其中每个元素的取值范围为 1 到 100。
 * <p>
 * 有 100 个电灯泡，按从 1 到 100 编号，初始时所有灯泡均为关闭状态。
 * <p>
 * 对于数组 bulbs 中的每一个元素 bulbs[i]，执行以下操作：
 * <p>
 * 如果第 bulbs[i] 个灯泡当前是关闭状态，将其打开。
 * 如果第 bulbs[i] 个灯泡当前是打开状态，将其关闭。
 * 返回一个整数列表，表示最终处于打开状态的灯泡编号，按升序排列。如果没有灯泡是打开的，返回一个空列表。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： bulbs = [10,30,20,10]
 * <p>
 * 输出： [20,30]
 * <p>
 * 解释：
 * <p>
 * 第 bulbs[0] = 10 个灯泡当前是关闭状态，将其打开。
 * 第 bulbs[1] = 30 个灯泡当前是关闭状态，将其打开。
 * 第 bulbs[2] = 20 个灯泡当前是关闭状态，将其打开。
 * 第 bulbs[3] = 10 个灯泡当前是打开状态，将其关闭。
 * 最终，第 20 个和第 30 个灯泡处于打开状态。
 * 示例 2：
 * <p>
 * 输入： bulbs = [100,100]
 * <p>
 * 输出： []
 * <p>
 * 解释：
 * <p>
 * 第 bulbs[0] = 100 个灯泡当前是关闭状态，将其打开。
 * 第 bulbs[1] = 100 个灯泡当前是打开状态，将其关闭。
 * 最终，没有灯泡处于打开状态。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= bulbs.length <= 100
 * 1 <= bulbs[i] <= 100
 *
 */
public class Code10 {

    public List<Integer> toggleLightBulbs(List<Integer> bulbs) {
        //缓存
        int[] arr = new int[101];
        //循环
        for (Integer bulb : bulbs) {
            //+1
            arr[bulb]++;
        }
        //初始化结果
        List<Integer> resut = new ArrayList<>();
        //循环
        for (int i = 0; i < arr.length; i++) {
            //如果是
            if (arr[i] % 2 != 0) {
                //记录结果
                resut.add(i);
            }
        }
        //返回
        return resut;
    }

    public static void main(String[] args) {

    }

}

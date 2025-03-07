package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By Rock-Ayl on 2020-08-30
 * 1389. 按既定顺序创建目标数组
 * 给你两个整数数组 nums 和 index。你需要按照以下规则创建目标数组：
 * <p>
 * 目标数组 target 最初为空。
 * 按从左到右的顺序依次读取 nums[i] 和 index[i]，在 target 数组中的下标 index[i] 处插入值 nums[i] 。
 * 重复上一步，直到在 nums 和 index 中都没有要读取的元素。
 * 请你返回目标数组。
 * <p>
 * 题目保证数字插入位置总是存在。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [0,1,2,3,4], index = [0,1,2,2,1]
 * 输出：[0,4,1,3,2]
 * 解释：
 * nums       index     target
 * 0            0        [0]
 * 1            1        [0,1]
 * 2            2        [0,1,2]
 * 3            2        [0,1,3,2]
 * 4            1        [0,4,1,3,2]
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,4,0], index = [0,1,2,3,0]
 * 输出：[0,1,2,3,4]
 * 解释：
 * nums       index     target
 * 1            0        [1]
 * 2            1        [1,2]
 * 3            2        [1,2,3]
 * 4            3        [1,2,3,4]
 * 0            0        [0,1,2,3,4]
 * 示例 3：
 * <p>
 * 输入：nums = [1], index = [0]
 * 输出：[1]
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length, index.length <= 100
 * nums.length == index.length
 * 0 <= nums[i] <= 100
 * 0 <= index[i] <= i
 */
public class Code22 {

    public static int[] createTargetArray(int[] nums, int[] index) {
        //初始化
        List<Integer> target = new ArrayList<>();
        //循环
        for (int i = 0; i < nums.length; i++) {
            //插入
            target.add(index[i], nums[i]);
        }
        //返回值
        int[] result = new int[nums.length];
        //循环
        for (int i = 0; i < nums.length; i++) {
            //组装
            result[i] = target.get(i);
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        for (int i : createTargetArray(new int[]{0, 1, 2, 3, 4}, new int[]{0, 1, 2, 2, 1})) {
            System.out.println(i);
        }
    }
}

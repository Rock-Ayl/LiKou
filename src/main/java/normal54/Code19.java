package normal54;

import java.util.ArrayList;
import java.util.List;

/**
 * 954. 二倍数对数组
 * 算术评级: 5
 * 第 114 场周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1548
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给定一个长度为偶数的整数数组 arr，只有对 arr 进行重组后可以满足 “对于每个 0 <= i < len(arr) / 2，都有 arr[2 * i + 1] = 2 * arr[2 * i]” 时，返回 true；否则，返回 false。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [3,1,3,6]
 * 输出：false
 * 示例 2：
 * <p>
 * 输入：arr = [2,1,2,6]
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：arr = [4,-2,2,-4]
 * 输出：true
 * 解释：可以用 [-2,-4] 和 [2,4] 这两组组成 [-2,-4,2,4] 或是 [2,4,-2,-4]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= arr.length <= 3 * 104
 * arr.length 是偶数
 * -105 <= arr[i] <= 105
 *
 */
public class Code19 {

    public boolean canReorderDoubled(int[] arr) {

        /**
         * 分组
         */

        //正数、负数列表
        List<Integer> num1List = new ArrayList<>();
        List<Integer> num2List = new ArrayList<>();
        //0的数量
        int zeroCount = 0;
        //循环
        for (int i = 0; i < arr.length; i++) {
            //判断正数、负数
            if (arr[i] > 0) {
                //记录
                num1List.add(arr[i]);
            } else if (arr[i] < 0) {
                //记录
                num2List.add(arr[i]);
            } else {
                //+1
                zeroCount++;
            }
        }
        //如果不是偶数
        if (zeroCount % 2 != 0 || num1List.size() % 2 != 0 || num2List.size() % 2 != 0) {
            //过
            return false;
        }

        /**
         * 清算 正数
         */

        //排序
        num1List.sort((a, b) -> a.compareTo(b));
        //检查
        if (check(num1List) == false) {
            //返回
            return false;
        }

        /**
         * 清算 负数
         */

        num2List.sort((a, b) -> b.compareTo(a));
        //检查
        if (check(num2List) == false) {
            //返回
            return false;
        }

        /**
         * 结果
         */

        //默认可以
        return true;
    }

    //检查
    private boolean check(List<Integer> numList) {
        //判空
        if (numList.isEmpty()) {
            //过
            return true;
        }
        //索引
        int leftIndex = 0;
        int rightIndex = 0;
        //次数
        int count = 0;
        //循环
        while (true) {

            /**
             * 获取目标数字
             */

            //如果到头了
            if (leftIndex == numList.size()) {
                //过
                return true;
            }
            //当前数字
            Integer num = numList.get(leftIndex);
            //判空
            if (num == null) {
                //+1
                leftIndex++;
                //本轮过
                continue;
            }
            //目标数字
            Integer target = num * 2;

            /**
             * 尝试寻找
             */

            //如果到头了
            if (rightIndex == numList.size()) {
                //失败
                return false;
            }
            //刷新最小右边索引
            rightIndex = Math.max(rightIndex, leftIndex + 1);
            //循环
            while (rightIndex < numList.size()) {
                //获取右边数字
                Integer num2 = numList.get(rightIndex);
                //判空 or 不是
                if (num2 == null || target.equals(num2) == false) {
                    //下一个
                    rightIndex++;
                } else {
                    //置空
                    numList.set(leftIndex, null);
                    numList.set(rightIndex, null);
                    //+1
                    leftIndex++;
                    rightIndex++;
                    //+2
                    count += 2;
                    //跳出
                    break;
                }
                //如果到头了
                if (count == numList.size()) {
                    //返回
                    return true;
                }
                //如果到头了
                if (rightIndex == numList.size()) {
                    //失败
                    return false;
                }
            }
        }
    }

    public static void main(String[] args) {
        //System.out.println(new Code19().canReorderDoubled(new int[]{4, -2, 2, -4}));
        //System.out.println(new Code19().canReorderDoubled(new int[]{2, 1, 2, 6}));
        System.out.println(new Code19().canReorderDoubled(new int[]{4, 4, -2, 8, 4, -1, -2, 4, 2, -1}));
    }

}

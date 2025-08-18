package normal45;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2025-08-18
 * 869. 重新排序得到 2 的幂
 * 尝试过
 * 算术评级: 4
 * 第 93 场周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1505
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给定正整数 n ，我们按任何顺序（包括原始顺序）将数字重新排序，注意其前导数字不能为零。
 * <p>
 * 如果我们可以通过上述方式得到 2 的幂，返回 true；否则，返回 false。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 1
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：n = 10
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 109
 */
public class Code21 {

    public boolean reorderedPowerOf2(int n) {

        /**
         * 计算出所有2的幂
         */

        //数字
        List<Integer> numList = new ArrayList<>();
        //数字
        int indexNumber = 1;
        //加入数字
        numList.add(indexNumber);
        //如果还可以位移
        while (indexNumber << 1 > 0) {
            //位移
            indexNumber = indexNumber << 1;
            //加入数字
            numList.add(indexNumber);
        }

        /**
         * 转为 hash map
         */

        //缓存
        Map<String, Integer> map = new HashMap<>();
        //循环
        for (Integer num : numList) {
            //记录hash
            map.put(hash(num), num);
        }

        /**
         * 计算结果
         */

        //默认不是
        return map.containsKey(hash(n));
    }

    //转为hash key
    private String hash(Integer num) {
        //数组
        int[] arr = new int[10];
        //循环
        while (num > 9) {
            //计算出本次
            int part = num % 10;
            //记录
            arr[part]++;
            //下一个
            num = num / 10;
        }
        //最后
        arr[num]++;
        //转为结果
        StringBuilder str = new StringBuilder();
        //循环
        for (int i : arr) {
            //组装
            str.append(i);
        }
        //返回
        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Code21().reorderedPowerOf2(1));
    }

}

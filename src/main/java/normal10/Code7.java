package normal10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2022-01-19
 * 2023. 连接后等于目标字符串的字符串对
 * 给你一个 数字 字符串数组 nums 和一个 数字 字符串 target ，请你返回 nums[i] + nums[j] （两个字符串连接）结果等于 target 的下标 (i, j) （需满足 i != j）的数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = ["777","7","77","77"], target = "7777"
 * 输出：4
 * 解释：符合要求的下标对包括：
 * - (0, 1)："777" + "7"
 * - (1, 0)："7" + "777"
 * - (2, 3)："77" + "77"
 * - (3, 2)："77" + "77"
 * 示例 2：
 * <p>
 * 输入：nums = ["123","4","12","34"], target = "1234"
 * 输出：2
 * 解释：符合要求的下标对包括
 * - (0, 1)："123" + "4"
 * - (2, 3)："12" + "34"
 * 示例 3：
 * <p>
 * 输入：nums = ["1","1","1"], target = "11"
 * 输出：6
 * 解释：符合要求的下标对包括
 * - (0, 1)："1" + "1"
 * - (1, 0)："1" + "1"
 * - (0, 2)："1" + "1"
 * - (2, 0)："1" + "1"
 * - (1, 2)："1" + "1"
 * - (2, 1)："1" + "1"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 100
 * 1 <= nums[i].length <= 100
 * 2 <= target.length <= 100
 * nums[i] 和 target 只包含数字。
 * nums[i] 和 target 不含有任何前导 0 。
 */
public class Code7 {

    public int numOfPairs(String[] nums, String target) {
        //缓存<长度,String>,两个长度+起来等于target的对比
        Map<Integer, List<String>> map = new HashMap<>();
        //循环
        for (String num : nums) {
            //长度
            int length = num.length();
            //如果超了
            if (length >= target.length()) {
                //过
                continue;
            }
            //获取或初始化
            List<String> list = map.getOrDefault(length, new ArrayList<>());
            //如果其为开始或结尾
            if (target.startsWith(num) || target.endsWith(num)) {
                //记录并组装
                list.add(num);
                map.put(length, list);
            }
        }
        //默认结果
        int sum = 0;
        //循环
        for (Integer leftKey : map.keySet()) {
            //右边key
            int rightKey = target.length() - leftKey;
            //如果不存在
            if (map.containsKey(rightKey) == false) {
                //过
                continue;
            }
            //左边列表
            List<String> leftList = map.get(leftKey);
            //循环
            for (int i = 0; i < leftList.size(); i++) {
                //获取
                String left = leftList.get(i);
                //如果前置不一样
                if (target.startsWith(left) == false) {
                    //过
                    continue;
                }
                //如果左右一致
                if (leftKey == rightKey) {
                    //删除
                    leftList.remove(i);
                }
                //获取右边列表
                List<String> rightList = map.get(rightKey);
                //循环
                for (String right : rightList) {
                    //如果是结尾
                    if (target.endsWith(right)) {
                        //+1
                        sum++;
                    }
                }
                //如果左右一致
                if (leftKey == rightKey) {
                    //回溯
                    leftList.add(i, left);
                }
            }
        }
        //返回
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Code7().numOfPairs(new String[]{"777", "7", "77", "77"}, "7777"));
    }

}

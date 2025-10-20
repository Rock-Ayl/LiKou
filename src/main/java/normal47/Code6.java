package normal47;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2025-10-20
 * 面试题 17.05. 字母与数字
 * 同步题目状态
 * <p>
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给定一个放有字母和数字的数组，找到最长的子数组，且包含的字母和数字的个数相同。
 * <p>
 * 返回该子数组，若存在多个最长子数组，返回左端点下标值最小的子数组。若不存在这样的数组，返回一个空数组。
 * <p>
 * 示例 1：
 * <p>
 * 输入：["A","1","B","C","D","2","3","4","E","5","F","G","6","7","H","I","J","K","L","M"]
 * <p>
 * 输出：["A","1","B","C","D","2","3","4","E","5","F","G","6","7"]
 * 示例 2：
 * <p>
 * 输入：["A","A"]
 * <p>
 * 输出：[]
 * 提示：
 * <p>
 * array.length <= 100000
 */
public class Code6 {

    public String[] findLongestSubarray(String[] array) {
        //长度
        int length = array.length;
        //和
        int sum = 0;
        //缓存
        Map<Integer, Integer> firstMap = new HashMap<>();
        //初始化
        firstMap.put(0, -1);
        //开始结束
        int bestStart = -1;
        int bestLen = 0;
        //循环
        for (int i = 0; i < length; i++) {
            //叠加
            sum += isNumber(array[i]);
            //如果存在
            if (firstMap.containsKey(sum) == true) {
                //获取第一次出现索引
                int firstStartIndex = firstMap.get(sum);
                //计算长度
                int len = i - firstStartIndex;
                //开始节点
                int start = firstStartIndex + 1;
                //如果更大 or 相同但是索引更低
                if (len > bestLen || (len == bestLen && start < bestStart)) {
                    //刷新
                    bestLen = len;
                    bestStart = start;
                }
            }
            //记录第一次出现
            firstMap.putIfAbsent(sum, i);
        }
        //如果没有结果
        if (bestStart == -1) {
            //过
            return new String[]{};
        }
        //返回
        return Arrays.copyOfRange(array, bestStart, bestStart + bestLen);
    }

    //是否为数字,数字返回1,非数字返回-1
    private int isNumber(String word) {
        //当前字符
        int letter = word.charAt(0) - '0';
        //判断
        return (letter >= 0 && letter <= 9) ? 1 : -1;
    }

    public static void main(String[] args) {
        //String[] longestSubarray = new Code6().findLongestSubarray(new String[]{"A", "1", "B", "C", "D", "2", "3", "4", "E", "5", "F", "G", "6", "7", "H", "I", "J", "K", "L", "M"});
        String[] longestSubarray = new Code6().findLongestSubarray(new String[]{
                "A", "1", "B", "C", "D", "2", "3", "4", "E", "5", "F", "G", "6", "7", "H"});
        System.out.println();
    }

}

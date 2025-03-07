package normal35;

import java.util.*;

/**
 * @Author ayl
 * @Date 2024-09-26
 * 3039. 进行操作使字符串为空
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个字符串 s 。
 * <p>
 * 请你进行以下操作直到 s 为 空 ：
 * <p>
 * 每次操作 依次 遍历 'a' 到 'z'，如果当前字符出现在 s 中，那么删除出现位置 最早 的该字符（如果存在的话）。
 * 例如，最初 s = "aabcbbca"。我们执行下述操作：
 * <p>
 * 移除下划线的字符  s = "aabcbbca"。结果字符串为 s = "abbca"。
 * 移除下划线的字符  s = "abbca"。结果字符串为 s = "ba"。
 * 移除下划线的字符  s = "ba"。结果字符串为 s = ""。
 * 请你返回进行 最后 一次操作 之前 的字符串 s 。在上面的例子中，答案是 "ba"。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aabcbbca"
 * 输出："ba"
 * 解释：已经在题目描述中解释。
 * 示例 2：
 * <p>
 * 输入：s = "abcd"
 * 输出："abcd"
 * 解释：我们进行以下操作：
 * - 删除 s = "abcd" 中加粗加斜字符，得到字符串 s = "" 。
 * 进行最后一次操作之前的字符串为 "abcd" 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 5 * 105
 * s 只包含小写英文字母。
 */
public class Code13 {

    public String lastNonEmptyString(String s) {
        //缓存
        Map<Character, List<Integer>> cacheMap = new HashMap<>();
        //最大次数
        int maxCount = 0;
        //循环
        for (int i = 0; i < s.length(); i++) {
            //当前字符
            Character letter = s.charAt(i);
            //如果不存在
            if (cacheMap.containsKey(letter) == false) {
                //初始化
                cacheMap.put(letter, new ArrayList<>());
            }
            //记录当前坐标
            cacheMap.get(letter).add(i);
            //刷新最大长度
            maxCount = Math.max(maxCount, cacheMap.get(letter).size());
        }
        //目标索引
        List<Integer> targetList = new ArrayList<>();
        //循环
        for (List<Integer> value : cacheMap.values()) {
            //如果长度不够
            if (value.size() < maxCount) {
                //本轮过
                continue;
            }
            //记录
            targetList.add(value.get(maxCount - 1));
        }
        //排序
        Collections.sort(targetList);
        //初始化结果
        StringBuilder result = new StringBuilder();
        //循环
        for (Integer index : targetList) {
            //组装
            result.append(s.charAt(index));
        }
        //返回
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Code13().lastNonEmptyString("aabcbbca"));
    }

}

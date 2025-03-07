package normal27;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2023-12-21
 * 2284. 最多单词数的发件人
 * 提示
 * 中等
 * 10
 * 相关企业
 * 给你一个聊天记录，共包含 n 条信息。给你两个字符串数组 messages 和 senders ，其中 messages[i] 是 senders[i] 发出的一条 信息 。
 * <p>
 * 一条 信息 是若干用单个空格连接的 单词 ，信息开头和结尾不会有多余空格。发件人的 单词计数 是这个发件人总共发出的 单词数 。注意，一个发件人可能会发出多于一条信息。
 * <p>
 * 请你返回发出单词数 最多 的发件人名字。如果有多个发件人发出最多单词数，请你返回 字典序 最大的名字。
 * <p>
 * 注意：
 * <p>
 * 字典序里，大写字母小于小写字母。
 * "Alice" 和 "alice" 是不同的名字。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：messages = ["Hello userTwooo","Hi userThree","Wonderful day Alice","Nice day userThree"], senders = ["Alice","userTwo","userThree","Alice"]
 * 输出："Alice"
 * 解释：Alice 总共发出了 2 + 3 = 5 个单词。
 * userTwo 发出了 2 个单词。
 * userThree 发出了 3 个单词。
 * 由于 Alice 发出单词数最多，所以我们返回 "Alice" 。
 * 示例 2：
 * <p>
 * 输入：messages = ["How is leetcode for everyone","Leetcode is useful for practice"], senders = ["Bob","Charlie"]
 * 输出："Charlie"
 * 解释：Bob 总共发出了 5 个单词。
 * Charlie 总共发出了 5 个单词。
 * 由于最多单词数打平，返回字典序最大的名字，也就是 Charlie 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == messages.length == senders.length
 * 1 <= n <= 104
 * 1 <= messages[i].length <= 100
 * 1 <= senders[i].length <= 10
 * messages[i] 包含大写字母、小写字母和 ' ' 。
 * messages[i] 中所有单词都由 单个空格 隔开。
 * messages[i] 不包含前导和后缀空格。
 * senders[i] 只包含大写英文字母和小写英文字母。
 */
public class Code8 {

    public String largestWordCount(String[] messages, String[] senders) {
        //缓存
        Map<String, Integer> countMap = new HashMap<>();
        //最大name、count
        String maxName = "";
        int maxCount = 0;
        //循环
        for (int i = 0; i < messages.length; i++) {
            //名字
            String name = senders[i];
            //本次数量 = 之前数量 + 当前数量
            int count = countMap.getOrDefault(name, 0) + messages[i].split(" ").length;
            //记录
            countMap.put(name, count);
            //如果更大
            if (count > maxCount) {
                //刷新
                maxName = name;
                maxCount = count;
            }
            //如果相同
            if (count == maxCount) {
                //对比字典序
                maxName = maxName.compareTo(name) > 0 ? maxName : name;
            }
        }
        //返回
        return maxName;
    }

    public static void main(String[] args) {
        System.out.println(new Code8().largestWordCount(
                new String[]{"Hello userTwooo", "Hi userThree", "Wonderful day Alice", "Nice day userThree"},
                new String[]{"Alice", "userTwo", "userThree", "Alice"}
        ));
    }
}

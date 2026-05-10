package easy43;

/**
 * 101043. 分数验证器
 * 同步题目状态
 * <p>
 * 简单
 * premium lock icon
 * 相关企业
 * 给你一个字符串数组 events。
 * <p>
 * 一开始，score = 0 且 counter = 0。events 中的每个元素为以下之一：
 * <p>
 * "0", "1", "2", "3", "4", "6"：将该值加到总得分中。
 * "W"：计数器加 1。不增加得分。
 * "WD"：总得分加 1。
 * "NB"：总得分加 1。
 * 从左到右处理数组。当满足以下任一条件时停止处理：
 * <p>
 * events 中的所有元素都已处理完毕，或
 * 计数器变为 10。
 * 返回一个整数数组 [score, counter]，其中：
 * <p>
 * score 是最终的总得分。
 * counter 是最终的计数器值。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： events = ["1","4","W","6","WD"]
 * <p>
 * 输出： [12,1]
 * <p>
 * 解释：
 * <p>
 * 事件	得分	计数器
 * "1"	1	0
 * "4"	5	0
 * "W"	5	1
 * "6"	11	1
 * "WD"	12	1
 * 最终结果：[12, 1]。
 * <p>
 * 示例 2：
 * <p>
 * 输入： events = ["WD","NB","0","4","4"]
 * <p>
 * 输出： [10,0]
 * <p>
 * 解释：
 * <p>
 * 事件	得分	计数器
 * "WD"	1	0
 * "NB"	2	0
 * "0"	2	0
 * "4"	6	0
 * "4"	10	0
 * 最终结果：[10, 0]。
 * <p>
 * 示例 3：
 * <p>
 * 输入： events = ["W","W","W","W","W","W","W","W","W","W","W"]
 * <p>
 * 输出： [0,10]
 * <p>
 * 解释：
 * <p>
 * 出现 10 次 "W" 后，计数器达到 10，因此停止处理。剩余的事件将被忽略。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= events.length <= 1000
 * events[i] 是 "0"、"1"、"2"、"3"、"4"、"6"、"W"、"WD" 或 "NB" 之一。
 */
public class Code7 {

    public int[] scoreValidator(String[] events) {
        //分数
        int score = 0;
        //计数器
        int counter = 0;
        //跳出
        out:
        //循环
        for (String event : events) {
            //判断
            switch (event) {
                case "W":
                    //计数器+1,判断是否满足跳出条件
                    if (++counter == 10) {
                        //跳出
                        break out;
                    }
                    break;
                case "WD":
                case "NB":
                    //分数+1
                    score++;
                    break;
                default:
                    //叠加分数
                    score += Integer.valueOf(event);
                    break;
            }
        }
        //返回
        return new int[]{score, counter};
    }

    public static void main(String[] args) {
        int[] ints = new Code7().scoreValidator(new String[]{"1", "4", "W", "6", "WD"});
        System.out.println();
    }

}

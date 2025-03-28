package normal27;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author ayl
 * @Date 2023-12-28
 * 2512. 奖励最顶尖的 K 名学生
 * 提示
 * 中等
 * 63
 * 相关企业
 * 给你两个字符串数组 positive_feedback 和 negative_feedback ，分别包含表示正面的和负面的词汇。不会 有单词同时是正面的和负面的。
 * <p>
 * 一开始，每位学生分数为 0 。每个正面的单词会给学生的分数 加 3 分，每个负面的词会给学生的分数 减  1 分。
 * <p>
 * 给你 n 个学生的评语，用一个下标从 0 开始的字符串数组 report 和一个下标从 0 开始的整数数组 student_id 表示，其中 student_id[i] 表示这名学生的 ID ，这名学生的评语是 report[i] 。每名学生的 ID 互不相同。
 * <p>
 * 给你一个整数 k ，请你返回按照得分 从高到低 最顶尖的 k 名学生。如果有多名学生分数相同，ID 越小排名越前。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：positive_feedback = ["smart","brilliant","studious"], negative_feedback = ["not"], report = ["this student is studious","the student is smart"], student_id = [1,2], k = 2
 * 输出：[1,2]
 * 解释：
 * 两名学生都有 1 个正面词汇，都得到 3 分，学生 1 的 ID 更小所以排名更前。
 * 示例 2：
 * <p>
 * 输入：positive_feedback = ["smart","brilliant","studious"], negative_feedback = ["not"], report = ["this student is not studious","the student is smart"], student_id = [1,2], k = 2
 * 输出：[2,1]
 * 解释：
 * - ID 为 1 的学生有 1 个正面词汇和 1 个负面词汇，所以得分为 3-1=2 分。
 * - ID 为 2 的学生有 1 个正面词汇，得分为 3 分。
 * 学生 2 分数更高，所以返回 [2,1] 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= positive_feedback.length, negative_feedback.length <= 104
 * 1 <= positive_feedback[i].length, negative_feedback[j].length <= 100
 * positive_feedback[i] 和 negative_feedback[j] 都只包含小写英文字母。
 * positive_feedback 和 negative_feedback 中不会有相同单词。
 * n == report.length == student_id.length
 * 1 <= n <= 104
 * report[i] 只包含小写英文字母和空格 ' ' 。
 * report[i] 中连续单词之间有单个空格隔开。
 * 1 <= report[i].length <= 100
 * 1 <= student_id[i] <= 109
 * student_id[i] 的值 互不相同 。
 * 1 <= k <= n
 */
public class Code12 {

    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        //正负词集合
        Set<String> positiveFeedbackSet = Arrays.stream(positive_feedback).collect(Collectors.toSet());
        Set<String> negativeFeedbackSet = Arrays.stream(negative_feedback).collect(Collectors.toSet());
        //学生id与分数
        Map<Integer, Integer> rankMap = new HashMap<>(student_id.length);
        //循环学生
        for (int i = 0; i < student_id.length; i++) {
            //默认分数
            int rank = 0;
            //获取评语,拆分评语,循环
            for (String word : report[i].split(" ")) {
                //判断是正还是负还是其他情况
                if (positiveFeedbackSet.contains(word)) {
                    //计算
                    rank += 3;
                } else if (negativeFeedbackSet.contains(word)) {
                    //计算
                    rank -= 1;
                }
            }
            //记录id和对应分数
            rankMap.put(student_id[i], rank);
        }
        //计算结果并返回
        return Arrays.stream(student_id)
                //装箱
                .boxed()
                //按照规则排序
                .sorted(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        //如果分数相同
                        if (rankMap.get(o1).equals(rankMap.get(o2))) {
                            //使用id排序
                            return o1 - o2;
                        } else {
                            //使用分数排序
                            return rankMap.get(o2) - rankMap.get(o1);
                        }
                    }
                })
                //只需要前k个
                .limit(k)
                //返回列表
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Integer> resultList = new Code12().topStudents(
                new String[]{"smart", "brilliant", "studious"},
                new String[]{"not"},
                new String[]{"this student is studious", "the student is smart"},
                new int[]{1, 2},
                2);
        System.out.println();
    }

}

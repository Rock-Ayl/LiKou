package easy42;

/**
 * 3793. 查找高词元使用量的用户
 * 已解答
 * 算术评级: 3
 * 同步题目状态
 * <p>
 * 简单
 * premium lock icon
 * 相关企业
 * SQL Schema
 * Pandas Schema
 * 表：prompts
 * <p>
 * +-------------+---------+
 * | Column Name | Type    |
 * +-------------+---------+
 * | user_id     | int     |
 * | prompt      | varchar |
 * | tokens      | int     |
 * +-------------+---------+
 * (user_id, prompt) 是这张表的主键（值互不相同）。
 * 每一行表示一个用户提交给 AI 系统的提示词以及所消耗的词元数量。
 * 根据下列要求编写一个解决方案来分析 AI 提示词的使用模式：
 * <p>
 * 对每一个用户，计算他们提交的 提示词的总数。
 * 对每个用户，计算 每个提示词所使用的平均词元数（舍入到 2 位小数）。
 * 仅包含 至少提交了 3 个提示词 的用户。
 * 仅包含那些 至少提交过一个提示词 且其中的 tokens 数量 超过 自己平均词元使用量的用户。
 * 返回结果表按 平均词元数 降序 排序，然后按 user_id 升序 排序。
 * <p>
 * 结果格式如下所示。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：
 * <p>
 * prompts 表：
 * <p>
 * +---------+--------------------------+--------+
 * | user_id | prompt                   | tokens |
 * +---------+--------------------------+--------+
 * | 1       | Write a blog outline     | 120    |
 * | 1       | Generate SQL query       | 80     |
 * | 1       | Summarize an article     | 200    |
 * | 2       | Create resume bullet     | 60     |
 * | 2       | Improve LinkedIn bio     | 70     |
 * | 3       | Explain neural networks  | 300    |
 * | 3       | Generate interview Q&A   | 250    |
 * | 3       | Write cover letter       | 180    |
 * | 3       | Optimize Python code     | 220    |
 * +---------+--------------------------+--------+
 * 输出：
 * <p>
 * +---------+---------------+------------+
 * | user_id | prompt_count  | avg_tokens |
 * +---------+---------------+------------+
 * | 3       | 4             | 237.5      |
 * | 1       | 3             | 133.33     |
 * +---------+---------------+------------+
 * 解释：
 * <p>
 * 用户 1：
 * 总提示词数 = 3
 * 平均词元数 = (120 + 80 + 200) / 3 = 133.33
 * 有一个提示词为 200 个词元，这超过了平均值
 * 包含在结果中
 * 用户 2:
 * 总提示词数 = 2（少于所需的最小值）
 * 从结果中排除
 * 用户 3:
 * 总提示词数 = 4
 * 平均词元数 = (300 + 250 + 180 + 220) / 4 = 237.5
 * 有包含 300 和 250 个词元的提示词，都大于平均数
 * 包含在结果中
 * 结果表按 avg_tokens 降序排序，然后按 user_id 升序排序。
 */
public class Code4 {

    private String sql = "SELECT a.user_id, a.prompt_count, a.avg_tokens FROM( SELECT a.user_id, a.prompt_count, a.max_tokens, ROUND((a.tokenSum / a.prompt_count), 2) AS avg_tokens FROM (SELECT user_id, sum(tokens) AS tokenSum, COUNT(*) AS prompt_count, MAX(tokens) max_tokens FROM prompts GROUP BY user_id) a WHERE a.prompt_count >= 3) a WHERE a.max_tokens > a.avg_tokens ORDER BY a.avg_tokens DESC, a.user_id ASC";

}

package normal41;

/**
 * @Author ayl
 * @Date 2025-04-01
 * 3475. DNA 模式识别
 * 中等
 * 相关企业
 * SQL Schema
 * Pandas Schema
 * 表：Samples
 * <p>
 * +----------------+---------+
 * | Column Name    | Type    |
 * +----------------+---------+
 * | sample_id      | int     |
 * | dna_sequence   | varchar |
 * | species        | varchar |
 * +----------------+---------+
 * sample_id 是这张表的唯一主键。
 * 每一行包含一个 DNA 序列以一个字符（A，T，G，C）组成的字符串表示以及它所采集自的物种。
 * 生物学家正在研究 DNA 序列中的基本模式。编写一个解决方案以识别具有以下模式的 sample_id：
 * <p>
 * 以 ATG 开头 的序列（一个常见的 起始密码子）
 * 以 TAA，TAG 或 TGA 结尾 的序列（终止密码子）
 * 包含基序 ATAT 的序列（一个简单重复模式）
 * 有 至少 3 个连续 G 的序列（如 GGG 或 GGGG）
 * 返回结果表以 sample_id 升序 排序。
 * <p>
 * 结果格式如下所示。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：
 * <p>
 * Samples 表：
 * <p>
 * +-----------+------------------+-----------+
 * | sample_id | dna_sequence     | species   |
 * +-----------+------------------+-----------+
 * | 1         | ATGCTAGCTAGCTAA  | Human     |
 * | 2         | GGGTCAATCATC     | Human     |
 * | 3         | ATATATCGTAGCTA   | Human     |
 * | 4         | ATGGGGTCATCATAA  | Mouse     |
 * | 5         | TCAGTCAGTCAG     | Mouse     |
 * | 6         | ATATCGCGCTAG     | Zebrafish |
 * | 7         | CGTATGCGTCGTA    | Zebrafish |
 * +-----------+------------------+-----------+
 * 输出：
 * <p>
 * +-----------+------------------+-------------+-------------+------------+------------+------------+
 * | sample_id | dna_sequence     | species     | has_start   | has_stop   | has_atat   | has_ggg    |
 * +-----------+------------------+-------------+-------------+------------+------------+------------+
 * | 1         | ATGCTAGCTAGCTAA  | Human       | 1           | 1          | 0          | 0          |
 * | 2         | GGGTCAATCATC     | Human       | 0           | 0          | 0          | 1          |
 * | 3         | ATATATCGTAGCTA   | Human       | 0           | 0          | 1          | 0          |
 * | 4         | ATGGGGTCATCATAA  | Mouse       | 1           | 1          | 0          | 1          |
 * | 5         | TCAGTCAGTCAG     | Mouse       | 0           | 0          | 0          | 0          |
 * | 6         | ATATCGCGCTAG     | Zebrafish   | 0           | 1          | 1          | 0          |
 * | 7         | CGTATGCGTCGTA    | Zebrafish   | 0           | 0          | 0          | 0          |
 * +-----------+------------------+-------------+-------------+------------+------------+------------+
 * 解释：
 * <p>
 * 样本 1（ATGCTAGCTAGCTAA）：
 * 以 ATG 开头（has_start = 1）
 * 以 TAA 结尾（has_stop = 1）
 * 不包含 ATAT（has_atat = 0）
 * 不包含至少 3 个连续 ‘G’（has_ggg = 0）
 * 样本 2（GGGTCAATCATC）：
 * 不以 ATG 开头（has_start = 0）
 * 不以 TAA，TAG 或 TGA 结尾（has_stop = 0）
 * 不包含 ATAT（has_atat = 0）
 * 包含 GGG（has_ggg = 1）
 * 样本 3（ATATATCGTAGCTA）：
 * 不以 ATG 开头（has_start = 0）
 * 不以 TAA，TAG 或 TGA 结尾（has_stop = 0）
 * 包含 ATAT（has_atat = 1）
 * 不包含至少 3 个连续 ‘G’（has_ggg = 0）
 * 样本 4（ATGGGGTCATCATAA）：
 * 以 ATG 开头（has_start = 1）
 * 以 TAA 结尾（has_stop = 1）
 * 不包含 ATAT（has_atat = 0）
 * 包含 GGGG（has_ggg = 1）
 * 样本 5（TCAGTCAGTCAG）：
 * 不匹配任何模式（所有字段 = 0）
 * 样本 6（ATATCGCGCTAG）：
 * 不以 ATG 开头（has_start = 0）
 * 以 TAG 结尾（has_stop = 1）
 * 包含 ATAT（has_atat = 1）
 * 不包含至少 3 个连续 ‘G’（has_ggg = 0）
 * 样本 7（CGTATGCGTCGTA）：
 * 不以 ATG 开头（has_start = 0）
 * 不以 TAA，TAG 或 TGA 结尾（has_stop = 0）
 * 不包含 ATAT（has_atat = 0）
 * 不包含至少 3 个连续 ‘G’（has_ggg = 0）
 * 注意：
 * <p>
 * 结果以 sample_id 升序排序
 * 对于每个模式，1 表示该模式存在，0 表示不存在
 */
public class Code14 {

    private String sql = "SELECT a.*,IF(b.has_start is null ,0,b.has_start) as has_start,IF(c.has_stop is null,0,c.has_stop) as has_stop,IF(d.has_atat is null,0,d.has_atat) as has_atat ,IF(e.has_ggg is null,0,e.has_ggg) as has_ggg FROM Samples a LEFT JOIN (SELECT a.sample_id,a.dna_sequence,1 as has_start FROM Samples a  WHERE  a.dna_sequence LIKE 'ATG%') b ON a.sample_id = b.sample_id LEFT JOIN (SELECT a.sample_id,a.dna_sequence,1 as has_stop FROM Samples a  WHERE  a.dna_sequence LIKE '%TAA' or a.dna_sequence LIKE '%TAG' or a.dna_sequence LIKE '%TGA') c ON a.sample_id = c.sample_id LEFT JOIN (SELECT a.sample_id,a.dna_sequence,1 as has_atat FROM Samples a  WHERE  a.dna_sequence LIKE '%ATAT%') d ON a.sample_id = d.sample_id LEFT JOIN (SELECT a.sample_id,a.dna_sequence,1 as has_ggg FROM Samples a  WHERE  a.dna_sequence LIKE '%GGG%') e ON a.sample_id = e.sample_id";

}

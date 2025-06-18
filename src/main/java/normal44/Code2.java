package normal44;

/**
 * @Author ayl
 * @Date 2025-06-18
 * 3586. 寻找 COVID 康复患者
 * 已解答
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * SQL Schema
 * Pandas Schema
 * 表：patients
 * <p>
 * +-------------+---------+
 * | Column Name | Type    |
 * +-------------+---------+
 * | patient_id  | int     |
 * | patient_name| varchar |
 * | age         | int     |
 * +-------------+---------+
 * patient_id 是这张表的唯一主键。
 * 每一行表示一个患者的信息。
 * 表：covid_tests
 * <p>
 * +-------------+---------+
 * | Column Name | Type    |
 * +-------------+---------+
 * | test_id     | int     |
 * | patient_id  | int     |
 * | test_date   | date    |
 * | result      | varchar |
 * +-------------+---------+
 * test_id 是这张表的唯一主键。
 * 每一行代表一个 COVID 检测结果。结果可以是阳性、阴性或不确定。
 * 编写一个解决方案以找到从 COVID 中康复的患者——那些曾经检测呈阳性但后来检测呈阴性的患者。
 * <p>
 * 患者如果 至少有一次阳性 检测结果后，在 之后的日期 至少有一次 阴性 检测结果，则被认为已康复。
 * 计算从 首次阳性检测 结果到 该阳性检测 后的 首次阴性检测结果 之间的 康复时间（以天为单位）
 * 仅包括 同时具有阳性及阴性检测结果的患者
 * 返回结果表以 recovery_time 升序 排序，然后以 patient_name 升序 排序。
 * <p>
 * 结果格式如下所示。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：
 * <p>
 * patients 表：
 * <p>
 * +------------+--------------+-----+
 * | patient_id | patient_name | age |
 * +------------+--------------+-----+
 * | 1          | Alice Smith  | 28  |
 * | 2          | Bob Johnson  | 35  |
 * | 3          | Carol Davis  | 42  |
 * | 4          | David Wilson | 31  |
 * | 5          | Emma Brown   | 29  |
 * +------------+--------------+-----+
 * covid_tests 表：
 * <p>
 * +---------+------------+------------+--------------+
 * | test_id | patient_id | test_date  | result       |
 * +---------+------------+------------+--------------+
 * | 1       | 1          | 2023-01-15 | Positive     |
 * | 2       | 1          | 2023-01-25 | Negative     |
 * | 3       | 2          | 2023-02-01 | Positive     |
 * | 4       | 2          | 2023-02-05 | Inconclusive |
 * | 5       | 2          | 2023-02-12 | Negative     |
 * | 6       | 3          | 2023-01-20 | Negative     |
 * | 7       | 3          | 2023-02-10 | Positive     |
 * | 8       | 3          | 2023-02-20 | Negative     |
 * | 9       | 4          | 2023-01-10 | Positive     |
 * | 10      | 4          | 2023-01-18 | Positive     |
 * | 11      | 5          | 2023-02-15 | Negative     |
 * | 12      | 5          | 2023-02-20 | Negative     |
 * +---------+------------+------------+--------------+
 * 输出：
 * <p>
 * +------------+--------------+-----+---------------+
 * | patient_id | patient_name | age | recovery_time |
 * +------------+--------------+-----+---------------+
 * | 1          | Alice Smith  | 28  | 10            |
 * | 3          | Carol Davis  | 42  | 10            |
 * | 2          | Bob Johnson  | 35  | 11            |
 * +------------+--------------+-----+---------------+
 * 解释：
 * <p>
 * Alice Smith (patient_id = 1):
 * 首次阳性检测：2023-01-15
 * 阳性检测后的首次阴性检测：2023-01-25
 * 康复时间：25 - 15 = 10 天
 * Bob Johnson (patient_id = 2):
 * 首次阳性检测：2023-02-01
 * 测试结果不明确：2023-02-05（忽略计算康复时间）
 * 阳性检测后的首次阴性检测：2023-02-12
 * 康复时间：12 - 1 = 11 天
 * Carol Davis (patient_id = 3):
 * 检测呈阴性：2023-01-20（在阳性检测前）
 * 首次阳性检测：2023-02-10
 * 阳性检测后的首次阴性检测：2023-02-20
 * 康复时间：20 - 10 = 10 天
 * 没有包含的患者：
 * David Wilson（patient_id = 4）：只有阳性检测，之后没有阴性检测。
 * Emma Brown（patient_id = 5）：只有阴性检测，从未有阳性检测。
 * 输出表以 recovery_time 升序排序，然后以 patient_name 升序排序。
 */
public class Code2 {

    private String sql = "SELECT a.*,b.recovery_time FROM patients a,(SELECT a.patient_id,DATEDIFF( a.end_min_test_date, a.start_min_test_date ) AS recovery_time FROM (SELECT a.patient_id,a.start_min_test_date,MIN( end_min_test_date ) AS end_min_test_date FROM (SELECT a.patient_id,a.start_min_test_date,b.test_date AS end_min_test_date FROM covid_tests b,( SELECT patient_id, MIN( test_date ) AS start_min_test_date, result FROM covid_tests WHERE result = 'Positive' GROUP BY patient_id ) a WHERE a.start_min_test_date < b.test_date AND a.patient_id = b.patient_id  AND b.result = 'Negative' ) a GROUP BY a.patient_id ) a ) b WHERE a.patient_id = b.patient_id ORDER BY b.recovery_time ASC,a.patient_name ASC";

}

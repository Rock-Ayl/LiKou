package normal42;

import java.util.*;

/**
 * @Author ayl
 * @Date 2025-04-21
 * 2933. 高访问员工
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个长度为 n 、下标从 0 开始的二维字符串数组 access_times 。对于每个 i（0 <= i <= n - 1 ），access_times[i][0] 表示某位员工的姓名，access_times[i][1] 表示该员工的访问时间。access_times 中的所有条目都发生在同一天内。
 * <p>
 * 访问时间用 四位 数字表示， 符合 24 小时制 ，例如 "0800" 或 "2250" 。
 * <p>
 * 如果员工在 同一小时内 访问系统 三次或更多 ，则称其为 高访问 员工。
 * <p>
 * 时间间隔正好相差一小时的时间 不 被视为同一小时内。例如，"0815" 和 "0915" 不属于同一小时内。
 * <p>
 * 一天开始和结束时的访问时间不被计算为同一小时内。例如，"0005" 和 "2350" 不属于同一小时内。
 * <p>
 * 以列表形式，按任意顺序，返回所有 高访问 员工的姓名。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：access_times = [["a","0549"],["b","0457"],["a","0532"],["a","0621"],["b","0540"]]
 * 输出：["a"]
 * 解释："a" 在时间段 [05:32, 06:31] 内有三条访问记录，时间分别为 05:32 、05:49 和 06:21 。
 * 但是 "b" 的访问记录只有两条。
 * 因此，答案是 ["a"] 。
 * 示例 2：
 * <p>
 * 输入：access_times = [["d","0002"],["c","0808"],["c","0829"],["e","0215"],["d","1508"],["d","1444"],["d","1410"],["c","0809"]]
 * 输出：["c","d"]
 * 解释："c" 在时间段 [08:08, 09:07] 内有三条访问记录，时间分别为 08:08 、08:09 和 08:29 。
 * "d" 在时间段 [14:10, 15:09] 内有三条访问记录，时间分别为 14:10 、14:44 和 15:08 。
 * 然而，"e" 只有一条访问记录，因此不能包含在答案中，最终答案是 ["c","d"] 。
 * 示例 3：
 * <p>
 * 输入：access_times = [["cd","1025"],["ab","1025"],["cd","1046"],["cd","1055"],["ab","1124"],["ab","1120"]]
 * 输出：["ab","cd"]
 * 解释："ab"在时间段 [10:25, 11:24] 内有三条访问记录，时间分别为 10:25 、11:20 和 11:24 。
 * "cd" 在时间段 [10:25, 11:24] 内有三条访问记录，时间分别为 10:25 、10:46 和 10:55 。
 * 因此，答案是 ["ab","cd"] 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= access_times.length <= 100
 * access_times[i].length == 2
 * 1 <= access_times[i][0].length <= 10
 * access_times[i][0] 仅由小写英文字母组成。
 * access_times[i][1].length == 4
 * access_times[i][1] 采用24小时制表示时间。
 * access_times[i][1] 仅由数字 '0' 到 '9' 组成。
 */
public class Code3 {

    public List<String> findHighAccessEmployees(List<List<String>> access_times) {
        //缓存
        Map<String, List<Integer>> map = new HashMap<>();
        //循环
        for (List<String> accessTimeList : access_times) {
            //获取用户
            String access = accessTimeList.get(0);
            //获取时间、转为数字
            Integer timeNumber = parseToNumber(accessTimeList.get(1));
            //如果没有,初始化数组
            map.putIfAbsent(access, new ArrayList<>());
            //组装
            map.get(access).add(timeNumber);
        }
        //初始化结果列表
        List<String> result = new ArrayList<>();
        //循环
        for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
            //先给集合排序
            entry.getValue().sort((a, b) -> a - b);
            //判断是否高访问
            if (highAccess(entry.getValue())) {
                //记录员工
                result.add(entry.getKey());
            }
        }
        //返回
        return result;
    }

    //时间转为数字
    private int parseToNumber(String time) {
        //解析小时、分钟
        int hour = Integer.valueOf(time.substring(0, 2));
        int minute = Integer.valueOf(time.substring(2, 4));
        //计算并返回
        return hour * 60 + minute;
    }

    //判断是否为高访问员工
    private boolean highAccess(List<Integer> timeList) {
        //指针
        for (int i = 2; i < timeList.size(); i++) {
            //如果相差不到一个小时
            if (timeList.get(i) - timeList.get(i - 2) < 60) {
                //是目标结果
                return true;
            }
        }
        //默认不是
        return false;
    }

    public static void main(String[] args) {
        List<String> highAccessEmployees = new Code3().findHighAccessEmployees(Arrays.asList(
                Arrays.asList("qzgyyji", "1945"),
                Arrays.asList("qzgyyji", "1855"),
                Arrays.asList("jsxkxtugi", "1859"),
                Arrays.asList("hhjuaxal", "1940"),
                Arrays.asList("hhjuaxal", "1831"),
                Arrays.asList("jsxkxtugi", "1841"),
                Arrays.asList("hhjuaxal", "1918"),
                Arrays.asList("jsxkxtugi", "1941"),
                Arrays.asList("hhjuaxal", "1852")
        ));
        for (String highAccessEmployee : highAccessEmployees) {
            System.out.println(highAccessEmployee);
        }
    }

}
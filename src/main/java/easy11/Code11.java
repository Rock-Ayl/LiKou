package easy11;

import java.util.*;

/**
 * @Author ayl
 * @Date 2021-09-23
 * 剑指 Offer II 042. 最近请求次数
 * 写一个 RecentCounter 类来计算特定时间范围内最近的请求。
 * <p>
 * 请实现 RecentCounter 类：
 * <p>
 * RecentCounter() 初始化计数器，请求数为 0 。
 * int ping(int t) 在时间 t 添加一个新请求，其中 t 表示以毫秒为单位的某个时间，并返回过去 3000 毫秒内发生的所有请求数（包括新请求）。确切地说，返回在 [t-3000, t] 内发生的请求数。
 * 保证 每次对 ping 的调用都使用比之前更大的 t 值。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：
 * inputs = ["RecentCounter", "ping", "ping", "ping", "ping"]
 * inputs = [[], [1], [100], [3001], [3002]]
 * 输出：
 * [null, 1, 2, 3, 3]
 * <p>
 * 解释：
 * RecentCounter recentCounter = new RecentCounter();
 * recentCounter.ping(1);     // requests = [1]，范围是 [-2999,1]，返回 1
 * recentCounter.ping(100);   // requests = [1, 100]，范围是 [-2900,100]，返回 2
 * recentCounter.ping(3001);  // requests = [1, 100, 3001]，范围是 [1,3001]，返回 3
 * recentCounter.ping(3002);  // requests = [1, 100, 3001, 3002]，范围是 [2,3002]，返回 3
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= t <= 109
 * 保证每次对 ping 调用所使用的 t 值都 严格递增
 * 至多调用 ping 方法 104 次
 * <p>
 * <p>
 * 注意：本题与主站 933 题相同： https://leetcode-cn.com/problems/number-of-recent-calls/
 */
public class Code11 {

    class RecentCounter {

        List<Integer> list = new ArrayList<>();

        public RecentCounter() {

        }

        public int ping(int t) {
            //最小时间
            int min = t - 3000;
            //记录本身
            list.add(t);
            //迭代器
            Iterator<Integer> iterator = list.iterator();
            //循环
            while (iterator.hasNext()) {
                //下一个
                int time = iterator.next();
                //如果超时
                if (time < min) {
                    //删除
                    iterator.remove();
                }
            }
            //返回
            return list.size();
        }

    }

}


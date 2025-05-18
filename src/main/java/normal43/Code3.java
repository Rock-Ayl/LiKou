package normal43;

import java.util.*;

/**
 * @Author ayl
 * @Date 2025-05-18
 * 3527. 找到最常见的回答
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个二维字符串数组 responses，其中每个 responses[i] 是一个字符串数组，表示第 i 天调查的回答结果。
 * <p>
 * 请返回在对每个 responses[i] 中的回答 去重 后，所有天数中 最常见 的回答。如果有多个回答出现频率相同，则返回 字典序最小 的那个回答。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： responses = [["good","ok","good","ok"],["ok","bad","good","ok","ok"],["good"],["bad"]]
 * <p>
 * 输出： "good"
 * <p>
 * 解释：
 * <p>
 * 每个列表去重后，得到 responses = [["good", "ok"], ["ok", "bad", "good"], ["good"], ["bad"]]。
 * "good" 出现了 3 次，"ok" 出现了 2 次，"bad" 也出现了 2 次。
 * 返回 "good"，因为它出现的频率最高。
 * 示例 2：
 * <p>
 * 输入： responses = [["good","ok","good"],["ok","bad"],["bad","notsure"],["great","good"]]
 * <p>
 * 输出： "bad"
 * <p>
 * 解释：
 * <p>
 * 每个列表去重后，responses = [["good", "ok"], ["ok", "bad"], ["bad", "notsure"], ["great", "good"]]。
 * "bad"、"good" 和 "ok" 都出现了 2 次。
 * 返回 "bad"，因为它在这些最高频率的词中字典序最小。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= responses.length <= 1000
 * 1 <= responses[i].length <= 1000
 * 1 <= responses[i][j].length <= 10
 * responses[i][j] 仅由小写英文字母组成
 */
public class Code3 {

    public String findCommonResponse(List<List<String>> responses) {
        //最大数量
        int maxCount = 0;
        //最大数量的key
        String maxKey = null;
        //缓存
        Map<String, Integer> map = new HashMap<>();
        //循环
        for (List<String> responseList : responses) {
            //缓存
            Set<String> set = new HashSet<>();
            //循环2
            for (String key : responseList) {
                //如果存在
                if (set.contains(key)) {
                    //本轮过
                    continue;
                }
                //次数
                int count = map.getOrDefault(key, 0) + 1;
                //如果更大
                if (count > maxCount) {
                    //覆盖
                    maxKey = key;
                    maxCount = count;
                }
                //如果相同 and key 优先级更高
                if (count == maxCount && key.compareTo(maxKey) < 0) {
                    //覆盖
                    maxKey = key;
                }
                //记录
                map.put(key, count);
                set.add(key);
            }
        }
        //返回
        return maxKey;
    }

    public static void main(String[] args) {

    }

}

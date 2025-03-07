package normal12;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ayl
 * @Date 2022-03-09
 * 763. 划分字母区间
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：S = "ababcbacadefegdehijhklij"
 * 输出：[9,7,8]
 * 解释：
 * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 * <p>
 * <p>
 * 提示：
 * <p>
 * S的长度在[1, 500]之间。
 * S只包含小写字母 'a' 到 'z' 。
 */
public class Code18 {

    public List<Integer> partitionLabels(String s) {
        //缓存arr
        int[] arr = new int[123];
        //循环
        for (int i = 0; i < s.length(); i++) {
            //记录每个字母最后出现的坐标
            arr[s.charAt(i)] = i;
        }
        //结果
        List<Integer> result = new ArrayList<>();
        //开始位置
        int start = 0;
        //不断走与不断更新的最大边界
        int target = 0;
        //循环
        for (int run = 0; run < s.length(); run++) {
            //更新最大距离
            target = Math.max(target, arr[s.charAt(run)]);
            //如果追上最大距离了
            if (target == run) {
                //记录结果
                result.add(target - start + 1);
                //更新起始位置
                start = run + 1;
            }
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Code18().partitionLabels("ababcbacadefegdehijhklij"));
    }

}

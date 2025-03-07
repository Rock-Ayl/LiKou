package easy33;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author ayl
 * @Date 2023-10-15
 * 100095. 上一个遍历的整数
 * 提示
 * 简单
 * 0
 * 相关企业
 * 给你一个下标从 0 开始的字符串数组 words ，其中 words[i] 要么是一个字符串形式的正整数，要么是字符串 "prev" 。
 * <p>
 * 我们从数组的开头开始遍历，对于 words 中的每个 "prev" 字符串，找到 words 中的 上一个遍历的整数 ，定义如下：
 * <p>
 * k 表示到当前位置为止的连续 "prev" 字符串数目（包含当前字符串），令下标从 0 开始的 整数 数组 nums 表示目前为止遍历过的所有整数，同时用 nums_reverse 表示 nums 反转得到的数组，那么当前 "prev" 对应的 上一个遍历的整数 是 nums_reverse 数组中下标为 (k - 1) 的整数。
 * 如果 k 比目前为止遍历过的整数数目 更多 ，那么上一个遍历的整数为 -1 。
 * 请你返回一个整数数组，包含所有上一个遍历的整数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：words = ["1","2","prev","prev","prev"]
 * 输出：[2,1,-1]
 * 解释：
 * 对于下标为 2 处的 "prev" ，上一个遍历的整数是 2 ，因为连续 "prev" 数目为 1 ，同时在数组 reverse_nums 中，第一个元素是 2 。
 * 对于下标为 3 处的 "prev" ，上一个遍历的整数是 1 ，因为连续 "prev" 数目为 2 ，同时在数组 reverse_nums 中，第二个元素是 1 。
 * 对于下标为 4 处的 "prev" ，上一个遍历的整数是 -1 ，因为连续 "prev" 数目为 3 ，但总共只遍历过 2 个整数。
 * 示例 2：
 * <p>
 * 输入：words = ["1","prev","2","prev","prev"]
 * 输出：[1,2,1]
 * 解释：
 * 对于下标为 1 处的 "prev" ，上一个遍历的整数是 1 。
 * 对于下标为 3 处的 "prev" ，上一个遍历的整数是 2 。
 * 对于下标为 4 处的 "prev" ，上一个遍历的整数是 1 ，因为连续 "prev" 数目为 2 ，同时在数组 reverse_nums 中，第二个元素是 1 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= words.length <= 100
 * words[i] == "prev" 或 1 <= int(words[i]) <= 100
 */
public class Code21 {

    public List<Integer> lastVisitedIntegers(List<String> words) {
        //初始化结果
        List<Integer> list = new ArrayList<>();
        //缓存
        List<String> stack = new ArrayList<>();
        //指针
        int p = stack.size() - 1;
        //循环
        for (String word : words) {
            //如果是pop
            if ("prev".equals(word)) {
                //如果还有
                if (p >= 0) {
                    //获取并位移
                    list.add(Integer.valueOf(stack.get(p--)));
                } else {
                    //默认
                    list.add(-1);
                }
            } else {
                //记录
                stack.add(word);
                //刷新
                p = stack.size() - 1;
            }
        }
        //返回结果
        return list;
    }

    public static void main(String[] args) {
        new Code21().lastVisitedIntegers(Arrays.asList("1", "2", "prev", "prev", "prev"));
    }

}

package normal33;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author ayl
 * @Date 2024-07-04
 * 3016. 输入单词需要的最少按键次数 II
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个字符串 word，由小写英文字母组成。
 * <p>
 * 电话键盘上的按键与 不同 小写英文字母集合相映射，可以通过按压按键来组成单词。例如，按键 2 对应 ["a","b","c"]，我们需要按一次键来输入 "a"，按两次键来输入 "b"，按三次键来输入 "c"。
 * <p>
 * 现在允许你将编号为 2 到 9 的按键重新映射到 不同 字母集合。每个按键可以映射到 任意数量 的字母，但每个字母 必须 恰好 映射到 一个 按键上。你需要找到输入字符串 word 所需的 最少 按键次数。
 * <p>
 * 返回重新映射按键后输入 word 所需的 最少 按键次数。
 * <p>
 * 下面给出了一种电话键盘上字母到按键的映射作为示例。注意 1，*，# 和 0 不 对应任何字母。
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：word = "abcde"
 * 输出：5
 * 解释：图片中给出的重新映射方案的输入成本最小。
 * "a" -> 在按键 2 上按一次
 * "b" -> 在按键 3 上按一次
 * "c" -> 在按键 4 上按一次
 * "d" -> 在按键 5 上按一次
 * "e" -> 在按键 6 上按一次
 * 总成本为 1 + 1 + 1 + 1 + 1 = 5 。
 * 可以证明不存在其他成本更低的映射方案。
 * 示例 2：
 * <p>
 * <p>
 * 输入：word = "xyzxyzxyzxyz"
 * 输出：12
 * 解释：图片中给出的重新映射方案的输入成本最小。
 * "x" -> 在按键 2 上按一次
 * "y" -> 在按键 3 上按一次
 * "z" -> 在按键 4 上按一次
 * 总成本为 1 * 4 + 1 * 4 + 1 * 4 = 12 。
 * 可以证明不存在其他成本更低的映射方案。
 * 注意按键 9 没有映射到任何字母：不必让每个按键都存在与之映射的字母，但是每个字母都必须映射到按键上。
 * 示例 3：
 * <p>
 * <p>
 * 输入：word = "aabbccddeeffgghhiiiiii"
 * 输出：24
 * 解释：图片中给出的重新映射方案的输入成本最小。
 * "a" -> 在按键 2 上按一次
 * "b" -> 在按键 3 上按一次
 * "c" -> 在按键 4 上按一次
 * "d" -> 在按键 5 上按一次
 * "e" -> 在按键 6 上按一次
 * "f" -> 在按键 7 上按一次
 * "g" -> 在按键 8 上按一次
 * "h" -> 在按键 9 上按两次
 * "i" -> 在按键 9 上按一次
 * 总成本为 1 * 2 + 1 * 2 + 1 * 2 + 1 * 2 + 1 * 2 + 1 * 2 + 1 * 2 + 2 * 2 + 6 * 1 = 24 。
 * 可以证明不存在其他成本更低的映射方案。
 */
public class Code3 {

    public int minimumPushes(String word) {
        //count缓存
        Map<Character, Integer> map = new HashMap<>();
        //循环
        for (char letter : word.toCharArray()) {
            //覆盖
            map.put(letter, map.getOrDefault(letter, 0) + 1);
        }
        //只需要count,排序
        List<Integer> countList = map
                .values()
                .stream()
                .sorted((a, b) -> b - a)
                .collect(Collectors.toList());
        //当前优先级使用的数量
        int use = 1;
        //结果
        int result = 0;
        //循环1
        for (int i = 0; i < countList.size(); i = i + 8) {
            //循环2
            for (int j = i; j < Math.min(i + 8, countList.size()); j++) {
                //计算并叠加本次结果
                result += countList.get(j) * use;
            }
            //+1
            use++;
        }
        //返回结果
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Code3().minimumPushes("aabbccddeeffgghhiiiiii"));
    }

}

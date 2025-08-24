package normal45;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * @Author ayl
 * @Date 2025-08-24
 * 3597. 分割字符串
 * 算术评级: 3
 * 第 456 场周赛
 * Q1
 * 同步题目状态
 * <p>
 * 1347
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个字符串 s，按照以下步骤将其分割为 互不相同的段 ：
 * <p>
 * 从下标 0 开始构建一个段。
 * 逐字符扩展当前段，直到该段之前未曾出现过。
 * 只要当前段是唯一的，就将其加入段列表，标记为已经出现过，并从下一个下标开始构建新的段。
 * 重复上述步骤，直到处理完整个字符串 s。
 * 返回字符串数组 segments，其中 segments[i] 表示创建的第 i 段。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： s = "abbccccd"
 * <p>
 * 输出： ["a","b","bc","c","cc","d"]
 * <p>
 * 解释：
 * <p>
 * 下标	添加后的段	已经出现过的段	当前段是否已经出现过？	新段	更新后已经出现过的段
 * 0	"a"	[]	否	""	["a"]
 * 1	"b"	["a"]	否	""	["a", "b"]
 * 2	"b"	["a", "b"]	是	"b"	["a", "b"]
 * 3	"bc"	["a", "b"]	否	""	["a", "b", "bc"]
 * 4	"c"	["a", "b", "bc"]	否	""	["a", "b", "bc", "c"]
 * 5	"c"	["a", "b", "bc", "c"]	是	"c"	["a", "b", "bc", "c"]
 * 6	"cc"	["a", "b", "bc", "c"]	否	""	["a", "b", "bc", "c", "cc"]
 * 7	"d"	["a", "b", "bc", "c", "cc"]	否	""	["a", "b", "bc", "c", "cc", "d"]
 * 因此，最终输出为 ["a", "b", "bc", "c", "cc", "d"]。
 * <p>
 * 示例 2：
 * <p>
 * 输入： s = "aaaa"
 * <p>
 * 输出： ["a","aa"]
 * <p>
 * 解释：
 * <p>
 * 下标	添加后的段	已经出现过的段	当前段是否已经出现过？	新段	更新后已经出现过的段
 * 0	"a"	[]	否	""	["a"]
 * 1	"a"	["a"]	是	"a"	["a"]
 * 2	"aa"	["a"]	否	""	["a", "aa"]
 * 3	"a"	["a", "aa"]	是	"a"	["a", "aa"]
 * 因此，最终输出为 ["a", "aa"]。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 105
 * s 仅包含小写英文字母。
 */
public class Code23 {

    public List<String> partitionString(String s) {
        //缓存
        LinkedHashSet<String> set = new LinkedHashSet<>();
        //索引
        int index = 0;
        //循环
        while (index < s.length()) {
            //初始化字符串
            StringBuilder str = new StringBuilder();
            //循环
            while (index < s.length()) {
                //组装当前
                str.append(s.charAt(index++));
                //如果不存在
                if (set.contains(str.toString()) == false) {
                    //记录
                    set.add(str.toString());
                    //跳出
                    break;
                }
            }
        }
        //返回
        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        List<String> abbccccd = new Code23().partitionString("abbccccd");
        System.out.println();
    }

}

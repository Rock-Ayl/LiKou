package normal54;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 2207. 字符串中最多数目的子序列
 * 算术评级: 4
 * 第 74 场双周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1550
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的字符串 text 和另一个下标从 0 开始且长度为 2 的字符串 pattern ，两者都只包含小写英文字母。
 * <p>
 * 你可以在 text 中任意位置插入 一个 字符，这个插入的字符必须是 pattern[0] 或者 pattern[1] 。注意，这个字符可以插入在 text 开头或者结尾的位置。
 * <p>
 * 请你返回插入一个字符后，text 中最多包含多少个等于 pattern 的 子序列 。
 * <p>
 * 子序列 指的是将一个字符串删除若干个字符后（也可以不删除），剩余字符保持原本顺序得到的字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：text = "abdcdbc", pattern = "ac"
 * 输出：4
 * 解释：
 * 如果我们在 text[1] 和 text[2] 之间添加 pattern[0] = 'a' ，那么我们得到 "abadcdbc" 。那么 "ac" 作为子序列出现 4 次。
 * 其他得到 4 个 "ac" 子序列的方案还有 "aabdcdbc" 和 "abdacdbc" 。
 * 但是，"abdcadbc" ，"abdccdbc" 和 "abdcdbcc" 这些字符串虽然是可行的插入方案，但是只出现了 3 次 "ac" 子序列，所以不是最优解。
 * 可以证明插入一个字符后，无法得到超过 4 个 "ac" 子序列。
 * 示例 2：
 * <p>
 * 输入：text = "aabb", pattern = "ab"
 * 输出：6
 * 解释：
 * 可以得到 6 个 "ab" 子序列的部分方案为 "aaabb" ，"aaabb" 和 "aabbb" 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= text.length <= 105
 * pattern.length == 2
 * text 和 pattern 都只包含小写英文字母。
 *
 */
public class Code6 {

    private static class Node {

        //字符
        private char letter;

        //数字
        private long count;

        //初始化
        public Node(char letter, int count) {
            this.letter = letter;
            this.count = count;
        }

        @Override
        public String toString() {
            return String.format("letter=%c,count=%d", letter, count);
        }

    }

    public long maximumSubsequenceCount(String text, String pattern) {

        /**
         * 寻找第一个数字
         */

        //上一个数字索引
        int firstIndex = 0;
        //如果不是目标数字
        while (firstIndex < text.length() && isLetter(text.charAt(firstIndex), pattern) == false) {
            //+1
            firstIndex++;
        }
        //如果没有目标数字
        if (firstIndex == text.length()) {
            //返回
            return 0;
        }

        /**
         * 计算所有节点
         */

        //统计数量
        int[] countArr = new int[26];
        //节点列表
        List<Node> nodeList = new ArrayList<>();
        //初始化第一个节点
        nodeList.add(new Node(text.charAt(firstIndex), 1));
        countArr[text.charAt(firstIndex) - 'a']++;
        //循环
        for (int i = firstIndex + 1; i < text.length(); i++) {
            //当前字符
            char letter = text.charAt(i);
            //如果不是
            if (isLetter(letter, pattern) == false) {
                //本轮过
                continue;
            }
            //记录数量
            countArr[letter - 'a']++;
            //获取上一个节点
            Node lastNode = nodeList.get(nodeList.size() - 1);
            //如果与上一个相同
            if (letter == lastNode.letter) {
                //+1
                lastNode.count++;
            } else {
                //初始化新的
                nodeList.add(new Node(letter, 1));
            }
        }

        /**
         * 特殊情况处理
         */

        //获取两个字符
        char startLetter = pattern.charAt(0);
        char endLetter = pattern.charAt(1);
        //如果只有一种字符
        if (nodeList.size() == 1) {
            //获取数量
            long count = nodeList.get(0).count;
            //如果两个字符相同
            if (startLetter == endLetter) {
                //高斯算法
                return (1 + count) * (count / 2) + (count % 2 != 0 ? (count + 1) / 2 : 0);
            } else {
                //返回结果
                return count;
            }
        }

        /**
         * 结算结果
         */

        //结果,添加的那个字符算某一种字符的最大数量
        long sum = Arrays.stream(countArr).max().getAsInt();
        //循环
        for (Node node : nodeList) {
            //如果是开始字符
            if (node.letter == startLetter) {
                //计算本次结果
                sum += node.count * countArr[endLetter - 'a'];
            }
            //更新数量
            countArr[node.letter - 'a'] -= node.count;
        }
        //返回
        return sum;
    }

    //判断是否目标数字
    private boolean isLetter(char c, String pattern) {
        //判断
        return c == pattern.charAt(0) || c == pattern.charAt(1);
    }

    public static void main(String[] args) {
        System.out.println(new Code6().maximumSubsequenceCount("vnedkpkkyxelxqptfwuzcjhqmwagvrglkeivowvbjdoyydnjrqrqejoyptzoklaxcjxbrrfmpdxckfjzahparhpanwqfjrpbslsyiwbldnpjqishlsuagevjmiyktgofvnyncizswldwnngnkifmaxbmospdeslxirofgqouaapfgltgqxdhurxljcepdpndqqgfwkfiqrwuwxfamciyweehktaegynfumwnhrgrhcluenpnoieqdivznrjljcotysnlylyswvdlkgsvrotavnkifwmnvgagjykxgwaimavqsxuitknmbxppgzfwtjdvegapcplreokicxcsbdrsyfpustpxxssnouifkypwqrywprjlyddrggkcglbgcrbihgpxxosmejchmzkydhquevpschkpyulqxgduqkqgwnsowxrmgqbmltrltzqmmpjilpfxocflpkwithsjlljxdygfvstvwqsyxlkknmgpppupgjvfgmxnwmvrfuwcrsadomyddazlonjyjdeswwznkaeaasyvurpgyvjsiltiykwquesfjmuswjlrphsdthmuqkrhynmqnfqdlwnwesdmiiqvcpingbcgcsvqmsmskesrajqwmgtdoktreqssutpudfykriqhblntfabspbeddpdkownehqszbmddizdgtqmobirwbopmoqzwydnpqnvkwadajbecmajilzkfwjnpfyamudpppuxhlcngkign", "rr"));
    }

}


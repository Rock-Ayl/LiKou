package normal58;

/**
 * 38. 外观数列
 * 算术评级: 3
 * 同步题目状态
 * <p>
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 「外观数列」是一个数位字符串序列，由递归公式定义：
 * <p>
 * countAndSay(1) = "1"
 * countAndSay(n) 是 countAndSay(n-1) 的行程长度编码。
 * <p>
 * <p>
 * 行程长度编码（RLE）是一种字符串压缩方法，其工作原理是通过将每个最大连续相同字符组替换为该组的长度后加上该字符本身。例如，要压缩字符串 "3322251" ，我们将 "33" 用 "23" 替换，将 "222" 用 "32" 替换，将 "5" 用 "15" 替换并将 "1" 用 "11" 替换。因此压缩后字符串变为 "23321511"。
 * <p>
 * 给定一个整数 n ，返回 外观数列 的第 n 个元素。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 4
 * <p>
 * 输出："1211"
 * <p>
 * 解释：
 * <p>
 * countAndSay(1) = "1"
 * <p>
 * countAndSay(2) = "1" 的行程长度编码 = "11"
 * <p>
 * countAndSay(3) = "11" 的行程长度编码 = "21"
 * <p>
 * countAndSay(4) = "21" 的行程长度编码 = "1211"
 * <p>
 * 示例 2：
 * <p>
 * 输入：n = 1
 * <p>
 * 输出："1"
 * <p>
 * 解释：
 * <p>
 * 这是基本情况。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 30
 *
 */
public class Code16 {

    public String countAndSay(int n) {
        //第一种情况
        String num = "1";
        //循环
        for (int i = 1; i < n; i++) {
            //递归
            num = countAndSayExecute(num);
        }
        //返回结果
        return num;
    }

    //实现本次
    public String countAndSayExecute(String num) {
        //结果
        StringBuilder str = new StringBuilder();
        //索引
        int index = 0;
        //循环
        while (index < num.length()) {
            //当前字符
            char c = num.charAt(index);
            //当前字符的个数
            int count = 0;
            //循环
            while (index < num.length() && num.charAt(index) == c) {
                //+1
                index++;
                count++;
            }
            //添加结果
            str.append(count).append(c);
        }
        //返回结果
        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Code16().countAndSay(4));
    }

}

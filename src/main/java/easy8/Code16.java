package easy8;

/**
 * @Author 安永亮
 * @Date 2021-06-12
 * @Description 28. 实现 strStr()
 * 实现 strStr() 函数。
 * <p>
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。
 * *
 * 说明：
 * <p>
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * <p>
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。
 * <p>
 * 示例 1：
 * <p>
 * 输入：haystack = "hello", needle = "ll"
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：haystack = "aaaaa", needle = "bba"
 * 输出：-1
 * 示例 3：
 * <p>
 * 输入：haystack = "", needle = ""
 * 输出：0
 * <p>
 * 提示：
 * <p>
 * 0 <= haystack.length, needle.length <= 5 * 104
 * haystack 和 needle 仅由小写英文字符组成
 * 通过次数399,667提交次数982,794
 */
public class Code16 {

    public int strStr(String haystack, String needle) {
        //need==0
        if (needle.length() == 0) {
            //返回
            return 0;
        }
        //如果结果比hay大
        if (needle.length() > haystack.length()) {
            //直接返回
            return -1;
        }
        //循环
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            //hay
            int ap = i;
            //need
            int bp = 0;
            //初始化
            char a = '0';
            char b = '0';
            //循环
            while (a == b) {
                //更新
                a = haystack.charAt(ap++);
                b = needle.charAt(bp++);
                //如果到最后一步了
                if (bp == needle.length()) {
                    //再度对比
                    if (a == b) {
                        //返回结果
                        return i;
                    }

                }
            }
        }
        //默认-1
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Code16().strStr("abc", "c"));
    }

}

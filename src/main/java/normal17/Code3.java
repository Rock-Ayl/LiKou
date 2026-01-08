package normal17;

/**
 * @Author ayl
 * @Date 2022-11-05
 * 443. 压缩字符串
 * 给你一个字符数组 chars ，请使用下述算法压缩：
 * <p>
 * 从一个空字符串 s 开始。对于 chars 中的每组 连续重复字符 ：
 * <p>
 * 如果这一组长度为 1 ，则将字符追加到 s 中。
 * 否则，需要向 s 追加字符，后跟这一组的长度。
 * 压缩后得到的字符串 s 不应该直接返回 ，需要转储到字符数组 chars 中。需要注意的是，如果组长度为 10 或 10 以上，则在 chars 数组中会被拆分为多个字符。
 * <p>
 * 请在 修改完输入数组后 ，返回该数组的新长度。
 * <p>
 * 你必须设计并实现一个只使用常量额外空间的算法来解决此问题。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：chars = ["a","a","b","b","c","c","c"]
 * 输出：返回 6 ，输入数组的前 6 个字符应该是：["a","2","b","2","c","3"]
 * 解释："aa" 被 "a2" 替代。"bb" 被 "b2" 替代。"ccc" 被 "c3" 替代。
 * 示例 2：
 * <p>
 * 输入：chars = ["a"]
 * 输出：返回 1 ，输入数组的前 1 个字符应该是：["a"]
 * 解释：唯一的组是“a”，它保持未压缩，因为它是一个字符。
 * 示例 3：
 * <p>
 * 输入：chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
 * 输出：返回 4 ，输入数组的前 4 个字符应该是：["a","b","1","2"]。
 * 解释：由于字符 "a" 不重复，所以不会被压缩。"bbbbbbbbbbbb" 被 “b12” 替代。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= chars.length <= 2000
 * chars[i] 可以是小写英文字母、大写英文字母、数字或符号
 */
public class Code3 {

    public int compress(char[] chars) {
        //指针
        int p = 0;
        //循环
        for (int left = 0; left < chars.length; left++) {
            //字母
            char first = chars[left];
            //右边
            int right = left;
            //如果未越界并且是是相同的
            while (right < chars.length && chars[right] == first) {
                //进位
                right++;
            }
            //最终该char数量
            int num = right - left;
            //首先记录头
            chars[p++] = first;
            //如果大于1
            if (num > 1) {
                //转化为str
                String numberStr = String.valueOf(num);
                //循环
                for (int i = 0; i < numberStr.length(); i++) {
                    //组装
                    chars[p++] = numberStr.charAt(i);
                }
            }
            //更新左边位置
            left = right - 1;
        }
        //指针就是数量
        return p;
    }

    public static void main(String[] args) {
        System.out.println(new Code3().compress(new char[]{'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'}));
    }

}

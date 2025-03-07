package normal7;

/**
 * @Author ayl
 * @Date 2021-09-11
 * 1839. 所有元音按顺序排布的最长子字符串
 * 当一个字符串满足如下条件时，我们称它是 美丽的 ：
 * <p>
 * 所有 5 个英文元音字母（'a' ，'e' ，'i' ，'o' ，'u'）都必须 至少 出现一次。
 * 这些元音字母的顺序都必须按照 字典序 升序排布（也就是说所有的 'a' 都在 'e' 前面，所有的 'e' 都在 'i' 前面，以此类推）
 * 比方说，字符串 "aeiou" 和 "aaaaaaeiiiioou" 都是 美丽的 ，但是 "uaeio" ，"aeoiu" 和 "aaaeeeooo" 不是美丽的 。
 * <p>
 * 给你一个只包含英文元音字母的字符串 word ，请你返回 word 中 最长美丽子字符串的长度 。如果不存在这样的子字符串，请返回 0 。
 * <p>
 * 子字符串 是字符串中一个连续的字符序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：word = "aeiaaioaaaaeiiiiouuuooaauuaeiu"
 * 输出：13
 * 解释：最长子字符串是 "aaaaeiiiiouuu" ，长度为 13 。
 * 示例 2：
 * <p>
 * 输入：word = "aeeeiiiioooauuuaeiou"
 * 输出：5
 * 解释：最长子字符串是 "aeiou" ，长度为 5 。
 * 示例 3：
 * <p>
 * 输入：word = "a"
 * 输出：0
 * 解释：没有美丽子字符串，所以返回 0 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= word.length <= 5 * 105
 * word 只包含字符 'a'，'e'，'i'，'o' 和 'u' 。
 */
public class Code13 {

    //结果,默认0
    int max = 0;
    //上一个,默认a
    char last = 'a';
    //全局组
    char[] arr;

    //寻找开头
    private Integer searchFirst(int p) {
        //如果越界
        if (p < this.arr.length) {
            //如果找到了
            if (this.arr[p] == 'a') {
                //返回
                return p;
            } else {
                //继续找
                return searchFirst(++p);
            }
        } else {
            //未找到
            return null;
        }
    }

    public int longestBeautifulSubstring(String word) {
        //拆分为组
        this.arr = word.toCharArray();
        //双指针,左边
        Integer left = searchFirst(0);
        //如果第一次都没找到
        if (left == null) {
            //直接返回
            return this.max;
        }
        //当前长度
        int p = left + 1;
        //循环
        while (p < this.arr.length) {
            //当前
            char x = this.arr[p];
            //根据上一个去判断
            switch (this.last) {
                case 'a':
                    //如果是a
                    if (x == 'a') {
                        p++;
                    } else if (x == 'e') {
                        p++;
                        //刷新last
                        last = 'e';
                    } else {
                        //重新找
                        left = searchFirst(p);
                        //如果第一次都没找到
                        if (left == null) {
                            //直接返回
                            return this.max;
                        }
                        //下一级
                        p = left + 1;
                    }
                    break;
                case 'e':
                    //如果是e
                    if (x == 'e') {
                        p++;
                    } else if (x == 'i') {
                        p++;
                        //刷新last
                        last = 'i';
                    } else {
                        //重新找
                        left = searchFirst(p);
                        //如果第一次都没找到
                        if (left == null) {
                            //直接返回
                            return this.max;
                        }
                        //下一级
                        p = left + 1;
                        last = 'a';
                    }
                    break;
                case 'i':
                    //如果是i
                    if (x == 'i') {
                        p++;
                    } else if (x == 'o') {
                        p++;
                        //刷新last
                        last = 'o';
                    } else {
                        //重新找
                        left = searchFirst(p);
                        //如果第一次都没找到
                        if (left == null) {
                            //直接返回
                            return this.max;
                        }
                        //下一级
                        p = left + 1;
                        last = 'a';
                    }
                    break;
                case 'o':
                    //如果是i
                    if (x == 'o') {
                        p++;
                    } else if (x == 'u') {
                        p++;
                        //刷新last
                        last = 'u';
                    } else {
                        //重新找
                        left = searchFirst(p);
                        //如果第一次都没找到
                        if (left == null) {
                            //直接返回
                            return this.max;
                        }
                        //下一级
                        p = left + 1;
                        last = 'a';
                    }
                    break;
                case 'u':
                    //如果是u
                    if (x == 'u') {
                        p++;
                    } else {
                        //计算出结果
                        this.max = Math.max(this.max, p - left);
                        //重新找
                        left = searchFirst(p);
                        //如果第一次都没找到
                        if (left == null) {
                            //直接返回
                            return this.max;
                        }
                        //下一级
                        p = left + 1;
                        last = 'a';
                    }
                    break;
            }
        }
        //如果有结果
        if ((p - left) > 4 && arr[arr.length - 1] == 'u') {
            //计算出结果
            this.max = Math.max(this.max, p - left);
        }
        //返回
        return this.max;
    }

    public static void main(String[] args) {
        System.out.println(new Code13().longestBeautifulSubstring("e"));
    }
}

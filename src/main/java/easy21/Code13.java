package easy21;

/**
 * @Author ayl
 * @Date 2022-07-25
 * 1160. 拼写单词
 * 给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。
 * <p>
 * 假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。
 * <p>
 * 注意：每次拼写（指拼写词汇表中的一个单词）时，chars 中的每个字母都只能用一次。
 * <p>
 * 返回词汇表 words 中你掌握的所有单词的 长度之和。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：words = ["cat","bt","hat","tree"], chars = "atach"
 * 输出：6
 * 解释：
 * 可以形成字符串 "cat" 和 "hat"，所以答案是 3 + 3 = 6。
 * 示例 2：
 * <p>
 * 输入：words = ["hello","world","leetcode"], chars = "welldonehoneyr"
 * 输出：10
 * 解释：
 * 可以形成字符串 "hello" 和 "world"，所以答案是 5 + 5 = 10。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= words.length <= 1000
 * 1 <= words[i].length, chars.length <= 100
 * 所有字符串中都仅包含小写英文字母
 */
public class Code13 {

    //尽量空间换时间
    public int countCharacters(String[] words, String chars) {
        //初始化结果
        int result = 0;
        //初始化拥有的库存
        int[] charArr = new int[123];
        //循环
        for (char letter : chars.toCharArray()) {
            //+1
            charArr[letter]++;
        }
        //跳出标记
        out:
        //循环2
        for (String word : words) {
            //初始化当前单词消耗库存
            int[] wordArr = new int[123];
            //循环3
            for (char letter : word.toCharArray()) {
                //先+1再判断是否有没有库存
                if (++wordArr[letter] > charArr[letter]) {
                    //彻底中断本次单词
                    continue out;
                }
            }
            //到这里是成功的结果,记录结果
            result += word.length();
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        System.out.println(
                new Code13().countCharacters(
                        new String[]{"cat", "bt", "hat", "tree"},
                        "atach")
        );
    }

}

package easy4;

/**
 * Created By Rock-Ayl on 2020-12-30
 * 744. 寻找比目标字母大的最小字母
 * 给你一个排序后的字符列表 letters ，列表中只包含小写英文字母。另给出一个目标字母 target，请你寻找在这一有序列表里比目标字母大的最小字母。
 * <p>
 * 在比较时，字母是依序循环出现的。举个例子：
 * <p>
 * 如果目标字母 target = 'z' 并且字符列表为 letters = ['a', 'b']，则答案返回 'a'
 * <p>
 * 示例：
 * <p>
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "a"
 * 输出: "c"
 * <p>
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "c"
 * 输出: "f"
 * <p>
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "d"
 * 输出: "f"
 * <p>
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "g"
 * 输出: "j"
 * <p>
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "j"
 * 输出: "c"
 * <p>
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "k"
 * 输出: "c"
 * <p>
 * 提示：
 * <p>
 * letters长度范围在[2, 10000]区间内。
 * letters 仅由小写字母组成，最少包含两个不同的字母。
 * 目标字母target 是一个小写字母。
 */
public class Code25 {

    public static char nextGreatestLetter(char[] letters, char target) {
        //初始化最小的char
        char min = 'z';
        //是否记录过最小的char
        boolean noMin = false;
        //右边最小的值
        char minRight = 'z';
        //循环
        for (char letter : letters) {
            //如果比目标大同时比最小结果小
            if (letter > target && letter <= min) {
                //记录
                min = letter;
                //打开开关
                noMin = true;
            }
            //寻找最小值
            if (letter < minRight) {
                //记录
                minRight = letter;
            }
        }
        //如果开关开启
        if (noMin) {
            //返回
            return min;
        } else {
            //返回
            return minRight;
        }
    }

    public static void main(String[] args) {
        System.out.println(nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'd'));
    }
}

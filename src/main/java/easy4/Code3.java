package easy4;

/**
 * Created By Rock-Ayl on 2020-12-02
 * 344. 反转字符串
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 * <p>
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * <p>
 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 * <p>
 * 示例 1：
 * <p>
 * 输入：["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 * 示例 2：
 * <p>
 * 输入：["H","a","n","n","a","h"]
 * 输出：["h","a","n","n","a","H"]
 */
public class Code3 {

    public static void reverseString(char[] s) {
        //左右两位置
        int a = 0, b = s.length - 1;
        //如果未重叠
        while (a < b) {
            //换位置
            char x = s[a];
            s[a] = s[b];
            s[b] = x;
            a++;
            b--;
        }
    }

    public static void main(String[] args) {
        reverseString(new char[]{'h', 'e', 'l', 'l', '0'});
    }
}

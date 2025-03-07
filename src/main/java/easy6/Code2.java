package easy6;

/**
 * Created By Rock-Ayl on 2021-01-29
 * 面试题 10.05. 稀疏数组搜索
 * 稀疏数组搜索。有个排好序的字符串数组，其中散布着一些空字符串，编写一种方法，找出给定字符串的位置。
 * <p>
 * 示例1:
 * <p>
 * 输入: words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""], s = "ta"
 * 输出：-1
 * 说明: 不存在返回-1。
 * 示例2:
 * <p>
 * 输入：words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""], s = "ball"
 * 输出：4
 * 提示:
 * <p>
 * words的长度在[1, 1000000]之间
 */
public class Code2 {

    public static int findString(String[] words, String s) {
        //循环
        for (int i = 0; i < words.length; i++) {
            //如果相同
            if (words[i].equals(s)) {
                //返回
                return i;
            }
        }
        //缺省
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findString(new String[]{"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""}, "ball"));
    }
}

package normal40;

import java.util.LinkedList;

/**
 * @Author ayl
 * @Date 2025-03-03
 * 3412. 计算字符串的镜像分数
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个字符串 s。
 * <p>
 * 英文字母中每个字母的 镜像 定义为反转字母表之后对应位置上的字母。例如，'a' 的镜像是 'z'，'y' 的镜像是 'b'。
 * <p>
 * 最初，字符串 s 中的所有字符都 未标记 。
 * <p>
 * 字符串 s 的初始分数为 0 ，你需要对其执行以下过程：
 * <p>
 * 从左到右遍历字符串。
 * 对于每个下标 i ，找到距离最近的 未标记 下标 j，下标 j 需要满足 j < i 且 s[j] 是 s[i] 的镜像。然后 标记 下标 i 和 j，总分加上 i - j 的值。
 * 如果对于下标 i，不存在满足条件的下标 j，则跳过该下标，继续处理下一个下标，不需要进行标记。
 * 返回最终的总分。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： s = "aczzx"
 * <p>
 * 输出： 5
 * <p>
 * 解释：
 * <p>
 * i = 0。没有符合条件的下标 j，跳过。
 * i = 1。没有符合条件的下标 j，跳过。
 * i = 2。距离最近的符合条件的下标是 j = 0，因此标记下标 0 和 2，然后将总分加上 2 - 0 = 2 。
 * i = 3。没有符合条件的下标 j，跳过。
 * i = 4。距离最近的符合条件的下标是 j = 1，因此标记下标 1 和 4，然后将总分加上 4 - 1 = 3 。
 * 示例 2：
 * <p>
 * 输入： s = "abcdef"
 * <p>
 * 输出： 0
 * <p>
 * 解释：
 * <p>
 * 对于每个下标 i，都不存在满足条件的下标 j。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 105
 * s 仅由小写英文字母组成。
 */
public class Code19 {

    public long calculateScore(String s) {
        //对应数组
        int[] otherArr = new int[]{25, 24, 23, 22, 21, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        //分数
        long sum = 0L;
        //链表数组
        LinkedList[] listArr = new LinkedList[26];
        //循环
        for (int i = 0; i < listArr.length; i++) {
            //初始化
            listArr[i] = new LinkedList();
        }
        //循环
        for (int i = 0; i < s.length(); i++) {
            //获取key
            int key = s.charAt(i) - 'a';
            //镜像key
            int otherKey = otherArr[key];
            //获取对应镜像优先队列
            LinkedList<Integer> otherKeyList = listArr[otherKey];
            //如果为空
            if (otherKeyList.isEmpty()) {
                //记录索引
                listArr[key].addLast(i);
            }
            //如果不为空
            else {
                //拉取、计算并叠加分数
                sum += i - otherKeyList.pollLast();
            }
        }
        //返回
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Code19().calculateScore("aczzx"));
    }

}

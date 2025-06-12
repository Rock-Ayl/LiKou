package normal43;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ayl
 * @Date 2025-06-12
 * LCR 177. 撞色搭配
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 整数数组 sockets 记录了一个袜子礼盒的颜色分布情况，其中 sockets[i] 表示该袜子的颜色编号。礼盒中除了一款撞色搭配的袜子，每种颜色的袜子均有两只。请设计一个程序，在时间复杂度 O(n)，空间复杂度O(1) 内找到这双撞色搭配袜子的两个颜色编号。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：sockets = [4, 5, 2, 4, 6, 6]
 * 输出：[2,5] 或 [5,2]
 * 示例 2：
 * <p>
 * 输入：sockets = [1, 2, 4, 1, 4, 3, 12, 3]
 * 输出：[2,12] 或 [12,2]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= sockets.length <= 10000
 */
public class Code23 {

    public int[] sockCollocation(int[] sockets) {

        /**
         * 第一次,计算出结果的异或
         */

        //全量异或值
        int exclusiveOR = sockets[0];
        //循环
        for (int i = 1; i < sockets.length; i++) {
            //求异或
            exclusiveOR = exclusiveOR ^ sockets[i];
        }

        /**
         * 第二次,根据异或值分组
         */

        //转为二进制,并翻转
        StringBuilder exclusiveORStr = new StringBuilder(Integer.toBinaryString(exclusiveOR)).reverse();
        //获取随意一个1的位置
        int oneIndex = exclusiveORStr.indexOf("1");
        //按照 0、1 分组
        List<Integer> oneList = new ArrayList<>();
        List<Integer> zeroList = new ArrayList<>();
        //循环
        for (int socket : sockets) {
            //转为二进制,翻转
            StringBuilder socketStr = new StringBuilder(Integer.toBinaryString(socket)).reverse();
            //默认0
            char letter = '0';
            //如果有值
            if (oneIndex < socketStr.length()) {
                //获取
                letter = socketStr.charAt(oneIndex);
            }
            //如果是1
            if (letter == '1') {
                //分组
                oneList.add(socket);
            } else {
                //分组
                zeroList.add(socket);
            }
        }

        /**
         * 分别求出每组的数字
         */

        //0组的数字
        int zero = zeroList.get(0);
        //循环
        for (int i = 1; i < zeroList.size(); i++) {
            //异或
            zero = zero ^ zeroList.get(i);
        }
        //1组的数字
        int one = oneList.get(0);
        //循环
        for (int i = 1; i < oneList.size(); i++) {
            //异或
            one = one ^ oneList.get(i);
        }

        //返回
        return new int[]{one, zero};
    }

    public static void main(String[] args) {
        int[] ints = new Code23().sockCollocation(new int[]{1, 2, 4, 1, 4, 3, 12, 3});
    }

}

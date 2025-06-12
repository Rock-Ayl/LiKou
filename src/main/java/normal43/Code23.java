package normal43;

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
         * 第二次,根据异或值 某个1的位置 分组, 并求每组 异或值
         */

        //0组的数字
        int zero = 0;
        //1组的数字
        int one = 0;
        //位移次数
        int count = 0;
        //循环,准备找一个位置=1的位移
        while (exclusiveOR % 2 == 0) {
            //+1位移
            count++;
            exclusiveOR = exclusiveOR >> 1;
        }
        //循环
        for (int socket : sockets) {
            //如果同位置是1
            if ((socket >> count) % 2 == 1) {
                //判空
                if (one == 0) {
                    //第一个
                    one = socket;
                } else {
                    //异或
                    one = one ^ socket;
                }
            } else {
                //判空
                if (zero == 0) {
                    //第一个
                    zero = socket;
                } else {
                    //异或
                    zero = zero ^ socket;
                }
            }
        }

        //返回
        return new int[]{one, zero};
    }

    public static void main(String[] args) {
        int[] ints = new Code23().sockCollocation(new int[]{1, 2, 4, 1, 4, 3, 12, 3});
    }

}

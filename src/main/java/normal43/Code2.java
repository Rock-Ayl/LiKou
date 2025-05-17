package normal43;

import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2025-05-17
 * 2274. 不含特殊楼层的最大连续楼层数
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * Alice 管理着一家公司，并租用大楼的部分楼层作为办公空间。Alice 决定将一些楼层作为 特殊楼层 ，仅用于放松。
 * <p>
 * 给你两个整数 bottom 和 top ，表示 Alice 租用了从 bottom 到 top（含 bottom 和 top 在内）的所有楼层。另给你一个整数数组 special ，其中 special[i] 表示  Alice 指定用于放松的特殊楼层。
 * <p>
 * 返回不含特殊楼层的 最大 连续楼层数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：bottom = 2, top = 9, special = [4,6]
 * 输出：3
 * 解释：下面列出的是不含特殊楼层的连续楼层范围：
 * - (2, 3) ，楼层数为 2 。
 * - (5, 5) ，楼层数为 1 。
 * - (7, 9) ，楼层数为 3 。
 * 因此，返回最大连续楼层数 3 。
 * 示例 2：
 * <p>
 * 输入：bottom = 6, top = 8, special = [7,6,8]
 * 输出：0
 * 解释：每层楼都被规划为特殊楼层，所以返回 0 。
 * <p>
 * <p>
 * 提示
 * <p>
 * 1 <= special.length <= 105
 * 1 <= bottom <= special[i] <= top <= 109
 * special 中的所有值 互不相同
 */
public class Code2 {

    public int maxConsecutive(int bottom, int top, int[] special) {
        //排序
        Arrays.sort(special);
        //最大连击次数
        int maxHit = 0;
        //索引
        int specialIndex = 0;
        //循环,从最下面上到最上面
        while (bottom <= top) {
            //计算结束楼层,索引+1
            int end = (specialIndex < special.length ? special[specialIndex++] - 1 : top);
            //计算当前层数连击,并刷新结果
            maxHit = Math.max(maxHit, end - bottom + 1);
            //理论上,从这里新的开始,如果还有楼层的话
            bottom = end + 2;
        }
        //返回
        return maxHit;
    }

    public static void main(String[] args) {
        System.out.println(new Code2().maxConsecutive(2, 9, new int[]{4, 6}));
    }

}

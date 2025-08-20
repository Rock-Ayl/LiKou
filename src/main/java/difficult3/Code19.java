package difficult3;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ayl
 * @Date 2025-08-20
 * 2147. 分隔长廊的方案数
 * 1915
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 在一个图书馆的长廊里，有一些座位和装饰植物排成一列。给你一个下标从 0 开始，长度为 n 的字符串 corridor ，它包含字母 'S' 和 'P' ，其中每个 'S' 表示一个座位，每个 'P' 表示一株植物。
 * <p>
 * 在下标 0 的左边和下标 n - 1 的右边 已经 分别各放了一个屏风。你还需要额外放置一些屏风。每一个位置 i - 1 和 i 之间（1 <= i <= n - 1），至多能放一个屏风。
 * <p>
 * 请你将走廊用屏风划分为若干段，且每一段内都 恰好有两个座位 ，而每一段内植物的数目没有要求。可能有多种划分方案，如果两个方案中有任何一个屏风的位置不同，那么它们被视为 不同 方案。
 * <p>
 * 请你返回划分走廊的方案数。由于答案可能很大，请你返回它对 109 + 7 取余 的结果。如果没有任何方案，请返回 0 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：corridor = "SSPPSPS"
 * 输出：3
 * 解释：总共有 3 种不同分隔走廊的方案。
 * 上图中黑色的竖线表示已经放置好的屏风。
 * 上图每种方案中，每一段都恰好有 两个 座位。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：corridor = "PPSPSP"
 * 输出：1
 * 解释：只有 1 种分隔走廊的方案，就是不放置任何屏风。
 * 放置任何的屏风都会导致有一段无法恰好有 2 个座位。
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * 输入：corridor = "S"
 * 输出：0
 * 解释：没有任何方案，因为总是有一段无法恰好有 2 个座位。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == corridor.length
 * 1 <= n <= 105
 * corridor[i] 要么是 'S' ，要么是 'P' 。
 */
public class Code19 {

    public int numberOfWays(String corridor) {

        /**
         * 构建有效花朵列表
         */

        //初始化有效花朵列表
        List<Long> flowerList = new ArrayList<>();
        //有多少个2个椅子的数对
        int groupCount = 0;
        //有多少个有效花朵分组
        int flowerCount = 0;
        //索引
        int index = 0;
        //循环
        while (index < corridor.length()) {
            //左边的花数量
            long hit = 0L;
            //如果有左边的花并且持续连击
            while (index < corridor.length() && corridor.charAt(index) == 'P') {
                //+1
                hit++;
                index++;
            }
            //如果有
            if (hit > 0) {
                //记录
                flowerList.add(hit);
                flowerCount++;
            }
            //如果越界了
            if (index >= corridor.length()) {
                //跳出
                break;
            }
            //这里找到了第一个座位,解析来找到的花不计数,直到找到第二个作为
            index++;
            //寻找第二个座位
            while (index < corridor.length() && corridor.charAt(index) != 'S') {
                //+1
                hit++;
                index++;
            }
            //如果没找到
            if (index >= corridor.length()) {
                //没有结果
                return 0;
            }
            //这里找到了第二个作为
            index++;
            //+1
            groupCount++;
            //填充
            flowerList.add(-1L);
        }

        /**
         * 计算结果
         */

        //如果没有
        if (groupCount == 0) {
            //过
            return 0;
        }
        //如果只有一对
        if (groupCount == 1) {
            //过
            return 1;
        }
        //如果没有有效的花
        if (flowerCount == 0) {
            //过
            return 1;
        }
        //循环
        for (int i = 0; i < flowerList.size(); i++) {
            //如果是填充
            if (flowerList.get(i) == -1L) {
                //本轮过
                continue;
            }
            //如果是左右边界
            if (i == 0 || i + 1 == flowerList.size()) {
                //单纯是1
                flowerList.set(i, 1L);
                //本轮过
                continue;
            }
            //修复
            flowerList.set(i, flowerList.get(i) + 1L);
        }
        //删除之
        flowerList.removeIf(p -> p == -1);
        //循环
        for (int i = 1; i < flowerList.size(); i++) {
            //计算本次
            flowerList.set(i, flowerList.get(i - 1) * flowerList.get(i) % 1000000007L);
        }
        //返回
        return flowerList.get(flowerList.size() - 1).intValue();
    }

    public static void main(String[] args) {
        //System.out.println(new Code19().numberOfWays("SPPSSSSPPS"));
        //System.out.println(new Code19().numberOfWays("SPSPPSSPSSSS"));
        //System.out.println(new Code19().numberOfWays("PPPPPSPPSPPSPPPSPPPPSPPPPSPPPPSPPSPPPSPSPPPSPSPPPSPSPPPSPSPPPPSPPPPSPPPSPPSPPPPSPSPPPPSPSPPPPSPSPPPSPPSPPPPSPSPSS"));
        System.out.println(new Code19().numberOfWays("PPPPPPPSPPPSPPPPSPPPSPPPPPSPPPSPPSPPSPPPPPSPSPPPPPSPPSPPPPPSPPSPPSPPPSPPPPSPPPPSPPPPPSPSPPPPSPSPPPSPPPPSPPPPPSPSPPSPPPPSPPSPPSPPSPPPSPPSPSPPSSSS"));

    }

}

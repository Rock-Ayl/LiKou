package normal40;

/**
 * @Author ayl
 * @Date 2025-02-26
 * 2260. 必须拿起的最小连续卡牌数
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数数组 cards ，其中 cards[i] 表示第 i 张卡牌的 值 。如果两张卡牌的值相同，则认为这一对卡牌 匹配 。
 * <p>
 * 返回你必须拿起的最小连续卡牌数，以使在拿起的卡牌中有一对匹配的卡牌。如果无法得到一对匹配的卡牌，返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：cards = [3,4,2,3,4,7]
 * 输出：4
 * 解释：拿起卡牌 [3,4,2,3] 将会包含一对值为 3 的匹配卡牌。注意，拿起 [4,2,3,4] 也是最优方案。
 * 示例 2：
 * <p>
 * 输入：cards = [1,0,5,3]
 * 输出：-1
 * 解释：无法找出含一对匹配卡牌的一组连续卡牌。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= cards.length <= 105
 * 0 <= cards[i] <= 106
 */
public class Code14 {

    public int minimumCardPickup(int[] cards) {
        //最短距离
        int minLength = Integer.MAX_VALUE;
        //hash缓存
        int[] arr = new int[1000001];
        //循环
        for (int i = 0; i < cards.length; i++) {
            //获取当前
            int card = cards[i];
            //如果不是第一次
            if (arr[card] != 0) {
                //计算本次距离,并刷新最小距离
                minLength = Math.min(minLength, i - arr[card]);
            }
            //直接覆盖记录索引,平移1位
            arr[card] = i + 1;
        }
        //返回结果, 默认 or 结果+2平移
        return minLength == Integer.MAX_VALUE ? -1 : (minLength + 2);
    }

    public static void main(String[] args) {
        System.out.println(new Code14().minimumCardPickup(new int[]{3, 4, 2, 3, 4, 7}));
    }

}

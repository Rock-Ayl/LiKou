package normal18;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 1996. 游戏中弱角色的数量
 * 你正在参加一个多角色游戏，每个角色都有两个主要属性：攻击 和 防御 。给你一个二维整数数组 properties ，其中 properties[i] = [attacki, defensei] 表示游戏中第 i 个角色的属性。
 * <p>
 * 如果存在一个其他角色的攻击和防御等级 都严格高于 该角色的攻击和防御等级，则认为该角色为 弱角色 。更正式地，如果认为角色 i 弱于 存在的另一个角色 j ，那么 attackj > attacki 且 defensej > defensei 。
 * <p>
 * 返回 弱角色 的数量。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：properties = [[5,5],[6,3],[3,6]]
 * 输出：0
 * 解释：不存在攻击和防御都严格高于其他角色的角色。
 * 示例 2：
 * <p>
 * 输入：properties = [[2,2],[3,3]]
 * 输出：1
 * 解释：第一个角色是弱角色，因为第二个角色的攻击和防御严格大于该角色。
 * 示例 3：
 * <p>
 * 输入：properties = [[1,5],[10,4],[4,3]]
 * 输出：1
 * 解释：第三个角色是弱角色，因为第二个角色的攻击和防御严格大于该角色。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= properties.length <= 105
 * properties[i].length == 2
 * 1 <= attacki, defensei <= 105
 *
 * @Author ayl
 * @Date 2023-01-04
 */
public class Code10 {

    public int numberOfWeakCharacters(int[][] properties) {
        //先按照攻击排序,然后按照防御排序
        Arrays.sort(properties, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                //如果攻击一样
                if (o1[0] - o2[0] == 0) {
                    //按照防御
                    return o1[1] - o2[1];
                } else {
                    //按照攻击
                    return o1[0] - o2[0];
                }
            }
        });
        //结果次数
        int count = 0;
        //上一个arr,默认栈
        int[] lastArr = properties[properties.length - 1];
        //攻击比当前高的历史最高防御
        int maxHistoryDef = 0;
        //循环
        for (int i = properties.length - 2; i >= 0; i--) {
            //当前的arr
            int[] thisArr = properties[i];
            //如果当前的攻击比上一个低
            if (thisArr[0] < lastArr[0]) {
                //刷新历史最高防御
                maxHistoryDef = Math.max(maxHistoryDef, lastArr[1]);
            }
            //如果比攻击比它高的防御低
            if (thisArr[1] < maxHistoryDef) {
                //直接记录结果
                count++;
            } else {
                //如果当前的攻击防御都小于某一个
                if (thisArr[0] < lastArr[0] && thisArr[1] < lastArr[1]) {
                    //记录结果
                    count++;
                }
            }
            //如果值得更新当前记录
            if (thisArr[0] < lastArr[0] && thisArr[1] > lastArr[1]) {
                //更换
                lastArr = thisArr;
            }
        }
        //返回
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Code10().numberOfWeakCharacters(new int[][]{
                new int[]{7, 9},
                new int[]{10, 7},
                new int[]{6, 9},
                new int[]{10, 4},
                new int[]{7, 5},
                new int[]{7, 10}
        }));
    }

}

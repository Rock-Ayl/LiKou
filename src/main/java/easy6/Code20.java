package easy6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created By Rock-Ayl on 2021-02-18
 * 1128. 等价多米诺骨牌对的数量
 * 给你一个由一些多米诺骨牌组成的列表 dominoes。
 * <p>
 * 如果其中某一张多米诺骨牌可以通过旋转 0 度或 180 度得到另一张多米诺骨牌，我们就认为这两张牌是等价的。
 * <p>
 * 形式上，dominoes[i] = [a, b] 和 dominoes[j] = [c, d] 等价的前提是 a==c 且 b==d，或是 a==d 且 b==c。
 * <p>
 * 在 0 <= i < j < dominoes.length 的前提下，找出满足 dominoes[i] 和 dominoes[j] 等价的骨牌对 (i, j) 的数量。
 * <p>
 * 示例：
 * <p>
 * 输入：dominoes = [[1,2],[2,1],[3,4],[5,6]]
 * 输出：1
 */
public class Code20 {

    public static int numEquivDominoPairs(int[][] dominoes) {
        //缓存
        Map<List<Integer>, Integer> map = new HashMap<>();
        //循环
        for (int[] dominoe : dominoes) {
            //获取左右
            int a = dominoe[0], b = dominoe[1];
            //要组装的对象
            List<Integer> list = new ArrayList<>();
            //对比
            if (a >= b) {
                //前小后大
                list.add(b);
                list.add(a);
            } else {
                //前小后大
                list.add(a);
                list.add(b);
            }
            //如果存在该对象
            if (map.containsKey(list)) {
                //+1
                map.put(list, map.get(list) + 1);
            } else {
                //组装
                map.put(list, 1);
            }
        }
        //次数
        int size = 0;
        //循环
        for (Map.Entry<List<Integer>, Integer> entry : map.entrySet()) {
            //获取该类型骨牌个数
            int thisSize = entry.getValue();
            //递增数
            int add = 1;
            //循环
            while (thisSize > 1) {
                //叠加
                size += add;
                //递减
                thisSize--;
                //+1
                add++;
            }
        }
        //返回
        return size;
    }

    public static void main(String[] args) {
        System.out.println(numEquivDominoPairs(new int[][]{new int[]{1, 2}, new int[]{2, 1}, new int[]{3, 4}, new int[]{5, 6}}));
    }

}

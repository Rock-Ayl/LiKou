package normal3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created By Rock-Ayl on 2021-05-01
 * 781. 森林中的兔子
 * 森林中，每个兔子都有颜色。其中一些兔子（可能是全部）告诉你还有多少其他的兔子和自己有相同的颜色。我们将这些回答放在 answers 数组里。
 * <p>
 * 返回森林中兔子的最少数量。
 * <p>
 * 示例:
 * 输入: answers = [1, 1, 2]
 * 输出: 5
 * 解释:
 * 两只回答了 "1" 的兔子可能有相同的颜色，设为红色。
 * 之后回答了 "2" 的兔子不会是红色，否则他们的回答会相互矛盾。
 * 设回答了 "2" 的兔子为蓝色。
 * 此外，森林中还应有另外 2 只蓝色兔子的回答没有包含在数组中。
 * 因此森林中兔子的最少数量是 5: 3 只回答的和 2 只没有回答的。
 * <p>
 * 输入: answers = [10, 10, 10]
 * 输出: 11
 * <p>
 * 输入: answers = []
 * 输出: 0
 * 说明:
 * <p>
 * answers 的长度最大为1000。
 * answers[i] 是在 [0, 999] 范围内的整数。
 */
public class Code9 {

    public int numRabbits(int[] answers) {
        //缓存
        Map<Integer, Integer> map = new HashMap<>();
        //和
        int size = 0;
        //循环
        for (int answer : answers) {
            //叠加并记录
            map.put(answer, map.containsKey(answer) ? map.get(answer) + 1 : 1);
        }
        //循环
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            //当前个数
            int value = entry.getValue();
            //当前组(加上其本身)
            int key = entry.getKey() + 1;
            //如果存在多种颜色
            while (value - key > 0) {
                //递减
                value -= key;
                //记录
                size += key;
            }
            //最后结算一下
            if (value != 0) {
                //直接记录
                size += key;
            }
        }
        //返回
        return size;
    }

    public static void main(String[] args) {
        System.out.println(new Code9().numRabbits(new int[]{0, 0, 1, 1, 1}));
    }
}

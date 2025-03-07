package easy15;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author ayl
 * @Date 2021-11-23
 * 997. 找到小镇的法官
 * 在一个小镇里，按从 1 到 n 为 n 个人进行编号。传言称，这些人中有一个是小镇上的秘密法官。
 * <p>
 * 如果小镇的法官真的存在，那么：
 * <p>
 * 小镇的法官不相信任何人。
 * 每个人（除了小镇法官外）都信任小镇的法官。
 * 只有一个人同时满足条件 1 和条件 2 。
 * 给定数组 trust，该数组由信任对 trust[i] = [a, b] 组成，表示编号为 a 的人信任编号为 b 的人。
 * <p>
 * 如果小镇存在秘密法官并且可以确定他的身份，请返回该法官的编号。否则，返回 -1。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2, trust = [[1,2]]
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：n = 3, trust = [[1,3],[2,3]]
 * 输出：3
 * 示例 3：
 * <p>
 * 输入：n = 3, trust = [[1,3],[2,3],[3,1]]
 * 输出：-1
 * 示例 4：
 * <p>
 * 输入：n = 3, trust = [[1,2],[2,3]]
 * 输出：-1
 * 示例 5：
 * <p>
 * 输入：n = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
 * 输出：3
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 1000
 * 0 <= trust.length <= 104
 * trust[i].length == 2
 * trust[i] 互不相同
 * trust[i][0] != trust[i][1]
 * 1 <= trust[i][0], trust[i][1] <= n
 */
public class Code8 {

    public int findJudge(int n, int[][] trust) {
        //如果信任次数太少
        if (trust.length + 1 < n) {
            //必然没有
            return -1;
        }
        //可能为法官的人
        Map<Integer, Set<Integer>> might = new HashMap();
        //绝对不可能为法官的人
        Set<Integer> cannot = new HashSet<>();
        //循环
        for (int[] ints : trust) {
            //必然不是法官的人
            cannot.add(ints[0]);
            //可能为法官的被信任的人
            Set<Integer> userSet = might.getOrDefault(ints[1], new HashSet<>());
            //组装
            userSet.add(ints[0]);
            //组装
            might.put(ints[1], userSet);
        }
        //如果都不可能成为法官
        if (cannot.size() >= n) {
            //必然没有
            return -1;
        }
        //如果不存在
        if (might.isEmpty()) {
            //如果只需要1
            if (n == 1) {
                //是
                return 1;
            } else {
                //不是
                return -1;
            }
        }
        //循环
        for (Integer one : cannot) {
            //删除不需要的
            might.remove(one);
        }
        //如果不存在
        if (might.isEmpty()) {
            //必然没有
            return -1;
        }
        //目标次数
        int size = n - 1;
        //循环
        for (Map.Entry<Integer, Set<Integer>> entry : might.entrySet()) {
            //如果目标人数没问题
            if (entry.getValue().size() == size) {
                //返回
                return entry.getKey();
            }
        }
        //默认
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Code8().findJudge(1, new int[][]{
        }));
    }

}

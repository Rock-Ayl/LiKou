package normal55;

/**
 * 3577. 统计计算机解锁顺序排列数
 * 算术评级: 4
 * 第 453 场周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1750
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个长度为 n 的数组 complexity。
 * <p>
 * 在房间里有 n 台 上锁的 计算机，这些计算机的编号为 0 到 n - 1，每台计算机都有一个 唯一 的密码。编号为 i 的计算机的密码复杂度为 complexity[i]。
 * <p>
 * 编号为 0 的计算机密码已经 解锁 ，并作为根节点。其他所有计算机必须通过它或其他已经解锁的计算机来解锁，具体规则如下：
 * <p>
 * 可以使用编号为 j 的计算机的密码解锁编号为 i 的计算机，其中 j 是任何小于 i 的整数，且满足 complexity[j] < complexity[i]（即 j < i 并且 complexity[j] < complexity[i]）。
 * 要解锁编号为 i 的计算机，你需要事先解锁一个编号为 j 的计算机，满足 j < i 并且 complexity[j] < complexity[i]。
 * 求共有多少种 [0, 1, 2, ..., (n - 1)] 的排列方式，能够表示从编号为 0 的计算机（唯一初始解锁的计算机）开始解锁所有计算机的有效顺序。
 * <p>
 * 由于答案可能很大，返回结果需要对 109 + 7 取余数。
 * <p>
 * 注意：编号为 0 的计算机的密码已解锁，而 不是 排列中第一个位置的计算机密码已解锁。
 * <p>
 * 排列 是一个数组中所有元素的重新排列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： complexity = [1,2,3]
 * <p>
 * 输出： 2
 * <p>
 * 解释：
 * <p>
 * 有效的排列有：
 * <p>
 * [0, 1, 2]
 * 首先使用根密码解锁计算机 0。
 * 使用计算机 0 的密码解锁计算机 1，因为 complexity[0] < complexity[1]。
 * 使用计算机 1 的密码解锁计算机 2，因为 complexity[1] < complexity[2]。
 * [0, 2, 1]
 * 首先使用根密码解锁计算机 0。
 * 使用计算机 0 的密码解锁计算机 2，因为 complexity[0] < complexity[2]。
 * 使用计算机 0 的密码解锁计算机 1，因为 complexity[0] < complexity[1]。
 * 示例 2：
 * <p>
 * 输入： complexity = [3,3,3,4,4,4]
 * <p>
 * 输出： 0
 * <p>
 * 解释：
 * <p>
 * 没有任何排列能够解锁所有计算机。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= complexity.length <= 105
 * 1 <= complexity[i] <= 109
 */
public class Code15 {

    public int countPermutations(int[] complexity) {
        //最小数字
        int min = complexity[0];
        //循环
        for (int i = 1; i < complexity.length; i++) {
            //如果有 更小 or 相等
            if (min >= complexity[i]) {
                //没办法解锁
                return 0;
            }
        }
        //返回
        return count(complexity.length);
    }

    //计算结果
    private int count(int length) {
        //和
        long sum = 1;
        //结果
        int num = 1;
        //循环
        while (num < length) {
            //相乘,下一个
            sum = sum * num % 1000000007;
            //下一个
            num++;
        }
        //返回
        return (int) (sum % 1000000007);
    }

    public static void main(String[] args) {
        System.out.println(new Code15().countPermutations(new int[]{1, 2, 3}));
    }

}

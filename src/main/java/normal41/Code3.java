package normal41;

import java.util.Arrays;

/**
 * 2327. 知道秘密的人数
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 在第 1 天，有一个人发现了一个秘密。
 * <p>
 * 给你一个整数 delay ，表示每个人会在发现秘密后的 delay 天之后，每天 给一个新的人 分享 秘密。
 * <p>
 * 同时给你一个整数 forget ，表示每个人在发现秘密 forget 天之后会 忘记 这个秘密。一个人 不能 在忘记秘密那一天及之后的日子里分享秘密。
 * <p>
 * 给你一个整数 n ，请你返回在第 n 天结束时，知道秘密的人数。由于答案可能会很大，请你将结果对 109 + 7 取余 后返回。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 6, delay = 2, forget = 4
 * 输出：5
 * 解释：
 * 第 1 天：假设第一个人叫 A 。（一个人知道秘密）
 * 第 2 天：A 是唯一一个知道秘密的人。（一个人知道秘密）
 * 第 3 天：A 把秘密分享给 B 。（两个人知道秘密）
 * 第 4 天：A 把秘密分享给一个新的人 C 。（三个人知道秘密）
 * 第 5 天：A 忘记了秘密，B 把秘密分享给一个新的人 D 。（三个人知道秘密）
 * 第 6 天：B 把秘密分享给 E，C 把秘密分享给 F 。（五个人知道秘密）
 * 示例 2：
 * <p>
 * 输入：n = 4, delay = 1, forget = 3
 * 输出：6
 * 解释：
 * 第 1 天：第一个知道秘密的人为 A 。（一个人知道秘密）
 * 第 2 天：A 把秘密分享给 B 。（两个人知道秘密）
 * 第 3 天：A 和 B 把秘密分享给 2 个新的人 C 和 D 。（四个人知道秘密）
 * 第 4 天：A 忘记了秘密，B、C、D 分别分享给 3 个新的人。（六个人知道秘密）
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= n <= 1000
 * 1 <= delay < forget <= n
 *
 * @Author ayl
 * @Date 2025-03-13
 */
public class Code3 {

    public int peopleAwareOfSecret(int n, int delay, int forget) {
        //知道秘密的人的数组
        long[] knowArr = new long[forget];
        //当前天
        int day = 1;
        //默认有一个人在第一天知道了秘密
        knowArr[0] = 1;
        //循环
        while (++day <= n) {
            //下一轮知道秘密的人的数组
            long[] nextKnowArr = new long[forget];
            //循环,每个人都又过了一天,最后的人忘记了密码
            for (int i = 0; i < knowArr.length - 1; i++) {
                //当前知道秘密的人又过了一天
                nextKnowArr[i + 1] = knowArr[i];
            }
            //循环,这些人传播秘密
            for (int i = delay - 1; i < knowArr.length - 1; i++) {
                //传播秘密
                nextKnowArr[0] = (nextKnowArr[0] + knowArr[i]) % 1000000007L;
            }
            //下一个
            knowArr = nextKnowArr;
        }
        //返回
        return (int) (Arrays.stream(knowArr).sum() % 1000000007L);
    }

    public static void main(String[] args) {
        System.out.println(new Code3().peopleAwareOfSecret(6, 2, 4));
    }

}

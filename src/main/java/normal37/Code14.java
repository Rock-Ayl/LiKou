package normal37;

import java.util.ArrayDeque;

/**
 * @Author ayl
 * @Date 2024-11-18
 * 649. Dota2 参议院
 * 中等
 * 相关标签
 * 相关企业
 * Dota2 的世界里有两个阵营：Radiant（天辉）和 Dire（夜魇）
 * <p>
 * Dota2 参议院由来自两派的参议员组成。现在参议院希望对一个 Dota2 游戏里的改变作出决定。他们以一个基于轮为过程的投票进行。在每一轮中，每一位参议员都可以行使两项权利中的 一 项：
 * <p>
 * 禁止一名参议员的权利：参议员可以让另一位参议员在这一轮和随后的几轮中丧失 所有的权利 。
 * 宣布胜利：如果参议员发现有权利投票的参议员都是 同一个阵营的 ，他可以宣布胜利并决定在游戏中的有关变化。
 * 给你一个字符串 senate 代表每个参议员的阵营。字母 'R' 和 'D'分别代表了 Radiant（天辉）和 Dire（夜魇）。然后，如果有 n 个参议员，给定字符串的大小将是 n。
 * <p>
 * 以轮为基础的过程从给定顺序的第一个参议员开始到最后一个参议员结束。这一过程将持续到投票结束。所有失去权利的参议员将在过程中被跳过。
 * <p>
 * 假设每一位参议员都足够聪明，会为自己的政党做出最好的策略，你需要预测哪一方最终会宣布胜利并在 Dota2 游戏中决定改变。输出应该是 "Radiant" 或 "Dire" 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：senate = "RD"
 * 输出："Radiant"
 * 解释：
 * 第 1 轮时，第一个参议员来自 Radiant 阵营，他可以使用第一项权利让第二个参议员失去所有权利。
 * 这一轮中，第二个参议员将会被跳过，因为他的权利被禁止了。
 * 第 2 轮时，第一个参议员可以宣布胜利，因为他是唯一一个有投票权的人。
 * 示例 2：
 * <p>
 * 输入：senate = "RDD"
 * 输出："Dire"
 * 解释：
 * 第 1 轮时，第一个来自 Radiant 阵营的参议员可以使用第一项权利禁止第二个参议员的权利。
 * 这一轮中，第二个来自 Dire 阵营的参议员会将被跳过，因为他的权利被禁止了。
 * 这一轮中，第三个来自 Dire 阵营的参议员可以使用他的第一项权利禁止第一个参议员的权利。
 * 因此在第二轮只剩下第三个参议员拥有投票的权利,于是他可以宣布胜利
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == senate.length
 * 1 <= n <= 104
 * senate[i] 为 'R' 或 'D'
 */
public class Code14 {

    public String predictPartyVictory(String senate) {
        //初始化队列
        ArrayDeque<Integer> rDeque = new ArrayDeque<>();
        ArrayDeque<Integer> dDeque = new ArrayDeque<>();
        //天使、恶魔需要先跳过的点
        int rWillSkip = 0;
        int dWillSkip = 0;
        //循环
        for (int i = 0; i < senate.length(); i++) {
            //获取当前
            char letter = senate.charAt(i);
            //判断天使还是恶魔
            if (letter == 'R') {
                //如果之前有被禁止
                if (rWillSkip > 0) {
                    //天使-1
                    rWillSkip--;
                } else {
                    //天使记录索引
                    rDeque.addLast(i);
                    //恶魔被禁止一位
                    dWillSkip++;
                }
            } else {
                //如果之前有被禁止
                if (dWillSkip > 0) {
                    //恶魔-1
                    dWillSkip--;
                } else {
                    //恶魔记录索引
                    dDeque.addLast(i);
                    //天使被禁止一位
                    rWillSkip++;
                }
            }
        }
        //判断结果
        if (dDeque.size() - dWillSkip <= 0) {
            //返回
            return "Radiant";
        }
        if (rDeque.size() - rWillSkip <= 0) {
            //返回
            return "Dire";
        }
        //初始化字符串
        StringBuilder str = new StringBuilder();
        //循环
        while (rDeque.isEmpty() == false || dDeque.isEmpty() == false) {
            //如果为空
            if (rDeque.isEmpty()) {
                //拉取
                dDeque.pollFirst();
                //如果没有跳过
                if (--dWillSkip < 0) {
                    //加入
                    str.append('D');
                }
                //本轮过
                continue;
            }
            //如果为空
            if (dDeque.isEmpty()) {
                //拉取
                rDeque.pollFirst();
                //如果没有跳过
                if (--rWillSkip < 0) {
                    //加入
                    str.append('R');
                }
                //本轮过
                continue;
            }
            //如果左边大
            if (rDeque.peekFirst().compareTo(dDeque.peekFirst()) < 0) {
                //拉取
                rDeque.pollFirst();
                //如果没有跳过
                if (--rWillSkip < 0) {
                    //加入
                    str.append('R');
                }
            } else {
                //拉取
                dDeque.pollFirst();
                //如果没有跳过
                if (--dWillSkip < 0) {
                    //加入
                    str.append('D');
                }
            }
        }
        //递归
        return predictPartyVictory(str.toString());
    }

    public static void main(String[] args) {
        System.out.println(new Code14().predictPartyVictory("DRRDRDRDRDDRDRDRD"));
    }

}

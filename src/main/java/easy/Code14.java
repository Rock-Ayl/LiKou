package easy;

/**
 * Created By Rock-Ayl on 2020-08-21
 * LCP 01. 猜数字
 * 小A 和 小B 在玩猜数字。小B 每次从 1, 2, 3 中随机选择一个，小A 每次也从 1, 2, 3 中选择一个猜。他们一共进行三次这个游戏，请返回 小A 猜对了几次？
 * <p>
 * 输入的guess数组为 小A 每次的猜测，answer数组为 小B 每次的选择。guess和answer的长度都等于3。
 * <p>
 * 示例 1：
 * <p>
 * 输入：guess = [1,2,3], answer = [1,2,3]
 * 输出：3
 * 解释：小A 每次都猜对了。
 * <p>
 * 示例 2：
 * <p>
 * 输入：guess = [2,2,3], answer = [3,2,1]
 * 输出：1
 * 解释：小A 只猜对了第二次。
 * <p>
 * 限制：
 * <p>
 * guess的长度 = 3
 * answer的长度 = 3
 * guess的元素取值为 {1, 2, 3} 之一。
 * answer的元素取值为 {1, 2, 3} 之一。
 */
public class Code14 {

    public static int game(int[] guess, int[] answer) {
        //猜对几次
        int num = 0;
        //循环
        for (int i = 0; i < guess.length; i++) {
            //如果相同
            if (guess[i] == answer[i]) {
                //记录
                num++;
            }
        }
        //返回
        return num;
    }

    public static void main(String[] args) {
        System.out.println(game(new int[]{1, 2, 3}, new int[]{4, 5, 6}));
    }
}

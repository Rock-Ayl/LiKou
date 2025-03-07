package easy14;

/**
 * @Author ayl
 * @Date 2021-11-07
 * 374. 猜数字大小
 * 猜数字游戏的规则如下：
 * <p>
 * 每轮游戏，我都会从 1 到 n 随机选择一个数字。 请你猜选出的是哪个数字。
 * 如果你猜错了，我会告诉你，你猜测的数字比我选出的数字是大了还是小了。
 * 你可以通过调用一个预先定义好的接口 int guess(int num) 来获取猜测结果，返回值一共有 3 种可能的情况（-1，1 或 0）：
 * <p>
 * -1：我选出的数字比你猜的数字小 pick < num
 * 1：我选出的数字比你猜的数字大 pick > num
 * 0：我选出的数字和你猜的数字一样。恭喜！你猜对了！pick == num
 * 返回我选出的数字。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 10, pick = 6
 * 输出：6
 * 示例 2：
 * <p>
 * 输入：n = 1, pick = 1
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：n = 2, pick = 1
 * 输出：1
 * 示例 4：
 * <p>
 * 输入：n = 2, pick = 2
 * 输出：2
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 231 - 1
 * 1 <= pick <= n
 */
public class Code8 {

    int number = 2;

    int guess(int num) {
        if (number > num) {
            return 1;
        } else if (number < num) {
            return -1;
        } else {
            return 0;
        }
    }

    public int guessNumber(int n) {
        //左右
        int left = 1, right = n;
        //下一个坐标
        int next = left + (right - left) / 2;
        //如果没有到中间
        while (left + 1 < right) {
            //去猜
            int guess = guess(next);
            //如果是结果
            if (guess == 0) {
                //返回结果
                return next;
            }
            //如果比guess大
            if (guess == -1) {
                //边界移动
                right = next;
            } else {
                //边界移动
                left = next;
            }
            //继续算下一级
            next = left + (right - left) / 2;
        }
        //如果是右边
        if (guess(right) == 0) {
            //返回右边
            return right;
        } else {
            //否则左边
            return left;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Code8().guessNumber(2));
    }

}

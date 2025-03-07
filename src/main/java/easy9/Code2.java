package easy9;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 安永亮
 * @Date 2021-06-14
 * @Description 441. 排列硬币
 * 你总共有 n 枚硬币，你需要将它们摆成一个阶梯形状，第 k 行就必须正好有 k 枚硬币。
 * <p>
 * 给定一个数字 n，找出可形成完整阶梯行的总行数。
 * <p>
 * n 是一个非负整数，并且在32位有符号整型的范围内。
 * <p>
 * 示例 1:
 * <p>
 * n = 5
 * <p>
 * 硬币可排列成以下几行:
 * ¤
 * ¤ ¤
 * ¤ ¤
 * <p>
 * 因为第三行不完整，所以返回2.
 * 示例 2:
 * <p>
 * n = 8
 * <p>
 * 硬币可排列成以下几行:
 * ¤
 * ¤ ¤
 * ¤ ¤ ¤
 * ¤ ¤
 * <p>
 * 因为第四行不完整，所以返回3.
 */
public class Code2 {

    public int arrangeCoins(int n) {
        //结果
        int size = 0;
        //最开始的数量
        int p = 1;
        //不断减少
        while (n > 0) {
            //失去
            n -= p++;
            //记录+1
            size++;
        }
        //如果越界了
        if (n < 0) {
            //-1
            size--;
        }
        //返回
        return size;
    }

    public static void main(String[] args) {
        System.out.println(new Code2().arrangeCoins(8));
    }

}

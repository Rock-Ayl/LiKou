package normal19;

import java.util.Random;

/**
 * @Author ayl
 * @Date 2023-03-16
 * 470. 用 Rand7() 实现 Rand10()
 * 给定方法 rand7 可生成 [1,7] 范围内的均匀随机整数，试写一个方法 rand10 生成 [1,10] 范围内的均匀随机整数。
 * <p>
 * 你只能调用 rand7() 且不能调用其他方法。请不要使用系统的 Math.random() 方法。
 * <p>
 * 每个测试用例将有一个内部参数 n，即你实现的函数 rand10() 在测试时将被调用的次数。请注意，这不是传递给 rand10() 的参数。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1
 * 输出: [2]
 * 示例 2:
 * <p>
 * 输入: 2
 * 输出: [2,8]
 * 示例 3:
 * <p>
 * 输入: 3
 * 输出: [3,8,10]
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= n <= 105
 * <p>
 * <p>
 * 进阶:
 * <p>
 * rand7()调用次数的 期望值 是多少 ?
 * 你能否尽量少调用 rand7() ?
 */
public class Code8 {

    public int rand7() {
        return new Random().nextInt(7);
    }

    public int rand10() {
        //和
        int sum = 0;
        //次数
        int count = 0;
        //循环10次
        while (count++ < 10) {
            //叠加
            sum += rand7();
        }
        //除
        sum = sum % 10;
        //返回
        return sum + 1;
    }

    //收藏的方法

    /**
     * 古典概型
     * 1. 第一次rand7限定[1,6]，判断奇偶性，概率是1/2
     * 2. 第二次rand7限定[1,5]，概率是1/5
     * 3. 二者结合可以得出10种概率相同的结果
     */
    public int star() {
        int first, second;
        while ((first = rand7()) > 6) ;
        while ((second = rand7()) > 5) ;
        if ((first & 1) == 1) {
            return second;
        } else {
            return 5 + second;
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(new Code8().star());
        }
    }

}

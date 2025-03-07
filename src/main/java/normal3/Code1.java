package normal3;


/**
 * Created By Rock-Ayl on 2021-04-23
 * 1052. 爱生气的书店老板
 * 今天，书店老板有一家店打算试营业 customers.length 分钟。每分钟都有一些顾客（customers[i]）会进入书店，所有这些顾客都会在那一分钟结束后离开。
 * <p>
 * 在某些时候，书店老板会生气。 如果书店老板在第 i 分钟生气，那么 grumpy[i] = 1，否则 grumpy[i] = 0。 当书店老板生气时，那一分钟的顾客就会不满意，不生气则他们是满意的。
 * <p>
 * 书店老板知道一个秘密技巧，能抑制自己的情绪，可以让自己连续 X 分钟不生气，但却只能使用一次。
 * <p>
 * 请你返回这一天营业下来，最多有多少客户能够感到满意的数量。
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], X = 3
 * 输出：16
 * 解释：
 * 书店老板在最后 3 分钟保持冷静。
 * 感到满意的最大客户数量 = 1 + 1 + 1 + 1 + 7 + 5 = 16.
 */
public class Code1 {

    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        //长度
        int length = customers.length;
        //总顾客人数
        int all = 0;
        //总生气人数
        int anger = 0;
        //循环
        for (int i = 0; i < length; i++) {
            //当前客人
            int customer = customers[i];
            //加
            all += customer;
            //如果当时生气
            if (grumpy[i] == 1) {
                //记录生气的客户
                anger += customer;
            }
        }
        //最大减少生气的人数
        int max = 0;
        //滑动边界
        int end = length - X;
        //开始滑动
        for (int i = 0; i <= end; i++) {
            //生气人数总和
            int thisAnger = 0;
            //当前位置
            int y = i;
            //循环次数
            int x = X;
            //循环
            while (x > 0) {
                //如果该位置生气了
                if (grumpy[y] == 1) {
                    //记录生气的客人
                    thisAnger += customers[y];
                }
                //递减
                x--;
                //递增
                y++;
            }
            //如果刷新了记录
            if (thisAnger > max) {
                //更新下
                max = thisAnger;
            }
        }
        //返回结果
        return all - anger + max;
    }

    public static void main(String[] args) {
        System.out.println(new Code1().maxSatisfied(new int[]{1, 0, 1, 2, 1, 1, 7, 5}, new int[]{0, 1, 0, 1, 0, 1, 0, 1}, 3));
    }

}

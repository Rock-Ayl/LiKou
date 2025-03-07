package difficult;

import java.util.Arrays;

/**
 * Created By Rock-Ayl on 2020-07-30
 * 135. 分发糖果
 * 老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
 * <p>
 * 你需要按照以下要求，帮助老师给这些孩子分发糖果：
 * <p>
 * 每个孩子至少分配到 1 个糖果。
 * 相邻的孩子中，评分高的孩子必须获得更多的糖果。
 * 那么这样下来，老师至少需要准备多少颗糖果呢？
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,0,2]
 * 输出: 5
 * 解释: 你可以分别给这三个孩子分发 2、1、2 颗糖果。
 * 示例 2:
 * <p>
 * 输入: [1,2,2]
 * 输出: 4
 * 解释: 你可以分别给这三个孩子分发 1、2、1 颗糖果。
 * 第三个孩子只得到 1 颗糖果，这已满足上述两个条件。
 */
public class Code1 {

    /**
     * 我的阶梯思路
     *
     * @param ratings
     * @return
     */
    public static int candy(int[] ratings) {
        //初始化没人该发的糖果
        int[] numArr = new int[ratings.length];
        //每人发一个糖
        Arrays.fill(numArr, 1);
        //左向右循环一次
        for (int i = 0; i < ratings.length - 1; i++) {
            //当前位置
            int a = ratings[i];
            //后面位置
            int b = ratings[i + 1];
            //如果当前位置小于后面位置
            if (a < b) {
                //后面位置等于前面位置糖+1
                numArr[i + 1] = numArr[i] + 1;
            }
        }
        //从后像向左循环
        for (int i = ratings.length - 1; i > 0; i--) {
            //当前位置
            int a = ratings[i];
            //前面位置
            int b = ratings[i - 1];
            //如果当前位置大于前面位置了
            if (b > a) {
                //并且前面位置的糖果小于等于当前位置的糖果了
                if (numArr[i - 1] <= numArr[i]) {
                    //前一位糖果等于当前位置糖果+1
                    numArr[i - 1] = numArr[i] + 1;
                }
            }
        }
        //发的糖果总量
        int num = 0;
        //循环
        for (int i : numArr) {
            //累计
            num = num + i;
        }
        //返回结果
        return num;
    }

    public static void main(String[] args) {
        System.out.println(candy(new int[]{1, 0, 2}));
    }

}

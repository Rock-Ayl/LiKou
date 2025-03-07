package normal21;

import java.util.Stack;

/**
 * @Author ayl
 * @Date 2023-06-17
 * 剑指 Offer II 038. 每日温度
 * 请根据每日 气温 列表 temperatures ，重新生成一个列表，要求其对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: temperatures = [73,74,75,71,69,72,76,73]
 * 输出: [1,1,4,2,1,1,0,0]
 * 示例 2:
 * <p>
 * 输入: temperatures = [30,40,50,60]
 * 输出: [1,1,1,0]
 * 示例 3:
 * <p>
 * 输入: temperatures = [30,60,90]
 * 输出: [1,1,0]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= temperatures.length <= 105
 * 30 <= temperatures[i] <= 100
 * <p>
 * <p>
 * 注意：本题与主站 739 题相同： https://leetcode-cn.com/problems/daily-
 */
public class Code4 {

    public int[] dailyTemperatures(int[] temperatures) {
        //初始化
        int[] result = new int[temperatures.length];
        //栈,用来存储温度坐标
        Stack<Integer> stack = new Stack<>();
        //循环
        for (int i = temperatures.length - 1; i >= 0; i--) {
            //当前温度
            int temperature = temperatures[i];
            //如果当前的比后面的大或相等
            while (stack.isEmpty() == false && temperatures[stack.peek()] <= temperature) {
                //删除之前的
                stack.pop();
            }
            //如果此时后面没有
            if (stack.isEmpty()) {
                //没有比它更大的
                result[i] = 0;
            } else {
                //计算结果距离
                result[i] = stack.peek() - i;
            }
            //组装本次
            stack.push(i);
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        new Code4().dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
    }

}

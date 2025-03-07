package normal5;

/**
 * @Author ayl
 * @Date 2021-07-31
 * 739. 每日温度
 * 请根据每日 气温 列表 temperatures ，请计算在每一天需要等几天才会有更高的温度。如果气温在这之后都不会升高，请在该位置用 0 来代替。
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
 */
public class Code16 {

    public int[] dailyTemperatures(int[] temperatures) {
        //循环
        for (int i = 0; i < temperatures.length - 1; i++) {
            //距离
            int weight = 1;
            //循环
            for (int j = i + 1; j < temperatures.length; j++) {
                //如果存在更高的温度了
                if (temperatures[j] > temperatures[i]) {
                    //记录距离
                    temperatures[i] = weight;
                    //结束
                    break;
                }
                //距离+1
                weight++;
                //如果到底了
                if (j == temperatures.length - 1) {
                    //记录距离
                    temperatures[i] = 0;
                }
            }
        }
        //最后一个肯定是0
        temperatures[temperatures.length - 1] = 0;
        //返回
        return temperatures;
    }

    public static void main(String[] args) {
        for (int i : new Code16().dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})) {
            System.out.println(i);
        }
    }

}

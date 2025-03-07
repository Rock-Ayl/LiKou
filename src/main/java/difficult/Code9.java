package difficult;

/**
 * @Author ayl
 * @Date 2022-04-26
 * 1526. 形成目标数组的子数组最少增加次数
 * 给你一个整数数组 target 和一个数组 initial ，initial 数组与 target  数组有同样的维度，且一开始全部为 0 。
 * <p>
 * 请你返回从 initial 得到  target 的最少操作次数，每次操作需遵循以下规则：
 * <p>
 * 在 initial 中选择 任意 子数组，并将子数组中每个元素增加 1 。
 * 答案保证在 32 位有符号整数以内。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：target = [1,2,3,2,1]
 * 输出：3
 * 解释：我们需要至少 3 次操作从 intial 数组得到 target 数组。
 * [0,0,0,0,0] 将下标为 0 到 4 的元素（包含二者）加 1 。
 * [1,1,1,1,1] 将下标为 1 到 3 的元素（包含二者）加 1 。
 * [1,2,2,2,1] 将下表为 2 的元素增加 1 。
 * [1,2,3,2,1] 得到了目标数组。
 * 示例 2：
 * <p>
 * 输入：target = [3,1,1,2]
 * 输出：4
 * 解释：(initial)[0,0,0,0] -> [1,1,1,1] -> [1,1,1,2] -> [2,1,1,2] -> [3,1,1,2] (target) 。
 * 示例 3：
 * <p>
 * 输入：target = [3,1,5,4,2]
 * 输出：7
 * 解释：(initial)[0,0,0,0,0] -> [1,1,1,1,1] -> [2,1,1,1,1] -> [3,1,1,1,1]
 * -> [3,1,2,2,2] -> [3,1,3,3,2] -> [3,1,4,4,2] -> [3,1,5,4,2] (target)。
 * 示例 4：
 * <p>
 * 输入：target = [1,1,1,1]
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= target.length <= 10^5
 * 1 <= target[i] <= 10^5
 */
public class Code9 {

    public int minNumberOperations(int[] target) {
        //总次数
        int count = 0;
        //上一个山帮你用掉的次数
        int lastMinus = 0;
        //第一个山最高高度
        int top = Math.max(target[0], target[1]);
        //山是否为下山
        boolean desc = target[0] > target[1];
        //循环,找一个完整的山
        for (int i = 2; i < target.length; i++) {
            //当前高,上一个高
            int num = target[i], last = target[i - 1];
            //如果是下山
            if (desc) {
                //如果不可以继续下走
                if (num > last) {
                    //记录当前结果
                    count = count + top - lastMinus;
                    //开始下一作山
                    lastMinus = last;
                    desc = false;
                    top = num;
                    //本次过
                    continue;
                }
            } else {
                //如果这里是最高点
                if (num < last) {
                    //变成下山
                    desc = true;
                } else {
                    //肯定更大
                    top = num;
                }
            }
        }
        //记录最后一个山的结果
        return count + top - lastMinus;
    }

    public static void main(String[] args) {
        System.out.println(new Code9().minNumberOperations(new int[]{3, 4, 2, 5, 6}));
    }

}

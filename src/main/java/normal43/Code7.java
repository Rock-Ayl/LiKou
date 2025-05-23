package normal43;

/**
 * @Author ayl
 * @Date 2025-05-23
 * 3522. 执行指令后的得分
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你两个数组：instructions 和 values，数组的长度均为 n。
 * <p>
 * 你需要根据以下规则模拟一个过程：
 * <p>
 * 从下标 i = 0 的第一个指令开始，初始得分为 0。
 * 如果 instructions[i] 是 "add"：
 * 将 values[i] 加到你的得分中。
 * 移动到下一个指令 (i + 1)。
 * 如果 instructions[i] 是 "jump"：
 * 移动到下标为 (i + values[i]) 的指令，但不修改你的得分。
 * 当以下任一情况发生时，过程会终止：
 * <p>
 * 越界（即 i < 0 或 i >= n），或
 * 尝试再次执行已经执行过的指令。被重复访问的指令不会再次执行。
 * 返回过程结束时的得分。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： instructions = ["jump","add","add","jump","add","jump"], values = [2,1,3,1,-2,-3]
 * <p>
 * 输出： 1
 * <p>
 * 解释：
 * <p>
 * 从下标 0 开始模拟过程：
 * <p>
 * 下标 0：指令是 "jump"，移动到下标 0 + 2 = 2。
 * 下标 2：指令是 "add"，将 values[2] = 3 加到得分中，移动到下标 3。得分变为 3。
 * 下标 3：指令是 "jump"，移动到下标 3 + 1 = 4。
 * 下标 4：指令是 "add"，将 values[4] = -2 加到得分中，移动到下标 5。得分变为 1。
 * 下标 5：指令是 "jump"，移动到下标 5 + (-3) = 2。
 * 下标 2：已经访问过。过程结束。
 * 示例 2：
 * <p>
 * 输入： instructions = ["jump","add","add"], values = [3,1,1]
 * <p>
 * 输出： 0
 * <p>
 * 解释：
 * <p>
 * 从下标 0 开始模拟过程：
 * <p>
 * 下标 0：指令是 "jump"，移动到下标 0 + 3 = 3。
 * 下标 3：越界。过程结束。
 * 示例 3：
 * <p>
 * 输入： instructions = ["jump"], values = [0]
 * <p>
 * 输出： 0
 * <p>
 * 解释：
 * <p>
 * 从下标 0 开始模拟过程：
 * <p>
 * 下标 0：指令是 "jump"，移动到下标 0 + 0 = 0。
 * 下标 0：已经访问过。过程结束。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == instructions.length == values.length
 * 1 <= n <= 105
 * instructions[i] 只能是 "add" 或 "jump"。
 * -105 <= values[i] <= 105
 */
public class Code7 {

    public long calculateScore(String[] instructions, int[] values) {
        //长度
        int length = instructions.length;
        //分数
        long rank = 0L;
        //索引
        int index = 0;
        //走过
        int[] walked = new int[length];
        //如果未越界 and 没走过,则循环
        while (index >= 0 && index < length && walked[index]++ == 0) {
            //如果是add
            if ("add".equals(instructions[index])) {
                //叠加分数,并索引+1
                rank += values[index++];
            } else {
                //索引跳z到目的地
                index += values[index];
            }
        }
        //返回
        return rank;
    }

    public static void main(String[] args) {
        System.out.println(new Code7().calculateScore(
                new String[]{"jump", "add", "add", "jump", "add", "jump"},
                new int[]{2, 1, 3, 1, -2, -3})
        );
    }

}

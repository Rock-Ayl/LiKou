package normal32;

import java.util.Stack;

/**
 * @Author ayl
 * @Date 2024-05-24
 * 1404. 将二进制表示减到 1 的步骤数
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个以二进制形式表示的数字 s 。请你返回按下述规则将其减少到 1 所需要的步骤数：
 * <p>
 * 如果当前数字为偶数，则将其除以 2 。
 * <p>
 * 如果当前数字为奇数，则将其加上 1 。
 * <p>
 * 题目保证你总是可以按上述规则将测试用例变为 1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "1101"
 * 输出：6
 * 解释："1101" 表示十进制数 13 。
 * Step 1) 13 是奇数，加 1 得到 14
 * Step 2) 14 是偶数，除 2 得到 7
 * Step 3) 7  是奇数，加 1 得到 8
 * Step 4) 8  是偶数，除 2 得到 4
 * Step 5) 4  是偶数，除 2 得到 2
 * Step 6) 2  是偶数，除 2 得到 1
 * 示例 2：
 * <p>
 * 输入：s = "10"
 * 输出：1
 * 解释："10" 表示十进制数 2 。
 * Step 1) 2 是偶数，除 2 得到 1
 * 示例 3：
 * <p>
 * 输入：s = "1"
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 500
 * s 由字符 '0' 或 '1' 组成。
 * s[0] == '1'
 */
public class Code4 {

    public int numSteps(String s) {
        //栈
        Stack<Character> stack = new Stack<>();
        //循环
        for (char letter : s.toCharArray()) {
            //加入
            stack.push(letter);
        }
        //结果
        int count = 0;
        //循环
        while (stack.size() > 1) {
            //直接删除最后一个字符
            Character last = stack.pop();
            //本次操作+1
            ++count;
            //如果是0,相当于直接/2,本次计算结束
            if (last.equals('0')) {
                //本轮过
                continue;
            }
            //前方1的数量,统计进位
            int oneCount = 1;
            //如果面前是连续的1
            while (stack.isEmpty() == false && stack.peek().equals('1')) {
                //删除1
                stack.pop();
                //+1
                ++oneCount;
            }
            //如果还有,说明前面的是0
            if (stack.isEmpty() == false) {
                //删除这个0,因为要替换其为1
                stack.pop();
            }
            //固定一个进位
            stack.add('1');
            //叠加这些为0的操作次数(每个进位视为一次/2)
            count += oneCount;
        }
        //返回结果
        return stack.peek().equals('1') ? count : count + 2;
    }

    public static void main(String[] args) {
        System.out.println(new Code4().numSteps("10"));
    }

}

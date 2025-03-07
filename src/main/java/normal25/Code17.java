package normal25;

/**
 * @Author ayl
 * @Date 2023-11-04
 * 678. 有效的括号字符串
 * 中等
 * 612
 * 相关企业
 * 给你一个只包含三种字符的字符串，支持的字符类型分别是 '('、')' 和 '*'。请你检验这个字符串是否为有效字符串，如果是有效字符串返回 true 。
 * <p>
 * 有效字符串符合如下规则：
 * <p>
 * 任何左括号 '(' 必须有相应的右括号 ')'。
 * 任何右括号 ')' 必须有相应的左括号 '(' 。
 * 左括号 '(' 必须在对应的右括号之前 ')'。
 * '*' 可以被视为单个右括号 ')' ，或单个左括号 '(' ，或一个空字符串。
 * 一个空字符串也被视为有效字符串。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "()"
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：s = "(*)"
 * 输出：true
 * 示例 3：
 * <p>
 * 输入：s = "(*))"
 * 输出：true
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 100
 * s[i] 为 '('、')' 或 '*'
 */
public class Code17 {

    //反面判断
    private boolean check2(String s) {
        //每种类型的数量
        int leftCount = 0;
        int midCount = 0;
        int rightCount = 0;
        //循环
        for (int i = s.length() - 1; i >= 0; i--) {
            //当前字符
            char letter = s.charAt(i);
            //为类型分批count
            switch (letter) {
                case ')':
                    leftCount++;
                    break;
                case '*':
                    midCount++;
                    break;
                case '(':
                    rightCount++;
                    break;
            }
            //如果右肯定没有左补
            if (leftCount + midCount < rightCount) {
                //不行
                return false;
            }
        }
        //如果左肯定没有右补
        if (leftCount > midCount + rightCount) {
            //不行
            return false;
        }
        //默认可以
        return true;
    }

    //正面判断
    private boolean check(String s) {
        //每种类型的数量
        int leftCount = 0;
        int midCount = 0;
        int rightCount = 0;
        //循环
        for (int i = 0; i < s.length(); i++) {
            //当前字符
            char letter = s.charAt(i);
            //为类型分批count
            switch (letter) {
                case '(':
                    leftCount++;
                    break;
                case '*':
                    midCount++;
                    break;
                case ')':
                    rightCount++;
                    break;
            }
            //如果右肯定没有左补
            if (leftCount + midCount < rightCount) {
                //不行
                return false;
            }
        }
        //如果左肯定没有右补
        if (leftCount > midCount + rightCount) {
            //不行
            return false;
        }
        //默认可以
        return true;
    }

    public boolean checkValidString(String s) {
        //判断 正 与 反 同时满足
        return check(s) && check2(s);
    }

    //同时维护最大最小情况,则个情况简直牛逼
    public boolean start(String s) {
        //最大最小情况
        int minCount = 0;
        int maxCount = 0;
        //循环
        for (int i = 0; i < s.length(); i++) {
            //字符
            char c = s.charAt(i);
            //根据字符处理
            switch (c) {
                case '(':
                    minCount++;
                    maxCount++;
                    break;
                case ')':
                    minCount = Math.max(minCount - 1, 0);
                    maxCount--;
                    if (maxCount < 0) {
                        return false;
                    }
                    break;
                case '*':
                    minCount = Math.max(minCount - 1, 0);
                    maxCount++;
                    break;
            }
        }
        //返回结果
        return minCount == 0;
    }

    public static void main(String[] args) {
        System.out.println(new Code17().start("(((***)))"));
    }

}

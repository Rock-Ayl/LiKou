package easy19;

/**
 * @Author ayl
 * @Date 2022-05-28
 * 2264. 字符串中最大的 3 位相同数字
 * 给你一个字符串 num ，表示一个大整数。如果一个整数满足下述所有条件，则认为该整数是一个 优质整数 ：
 * <p>
 * 该整数是 num 的一个长度为 3 的 子字符串 。
 * 该整数由唯一一个数字重复 3 次组成。
 * 以字符串形式返回 最大的优质整数 。如果不存在满足要求的整数，则返回一个空字符串 "" 。
 * <p>
 * 注意：
 * <p>
 * 子字符串 是字符串中的一个连续字符序列。
 * num 或优质整数中可能存在 前导零 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：num = "6777133339"
 * 输出："777"
 * 解释：num 中存在两个优质整数："777" 和 "333" 。
 * "777" 是最大的那个，所以返回 "777" 。
 * 示例 2：
 * <p>
 * 输入：num = "2300019"
 * 输出："000"
 * 解释："000" 是唯一一个优质整数。
 * 示例 3：
 * <p>
 * 输入：num = "42352338"
 * 输出：""
 * 解释：不存在长度为 3 且仅由一个唯一数字组成的整数。因此，不存在优质整数。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 3 <= num.length <= 1000
 * num 仅由数字（0 - 9）组成
 */
public class Code12 {

    public String largestGoodInteger(String num) {
        //初始化结果
        int max = -1;
        //连击1
        int hit = 1;
        //上一个数字
        char lastNum = num.charAt(0);
        //循环
        for (int i = 1; i < num.length(); i++) {
            //当前
            char thisNum = num.charAt(i);
            //如果和上一个相同
            if (thisNum == lastNum) {
                //+1,并判断是否满足
                if (++hit == 3) {
                    //尝试刷新
                    max = Math.max(thisNum - '0', max);
                }
            } else {
                //重置
                hit = 1;
                //更换
                lastNum = thisNum;
            }
        }
        //如果没有
        if (max == -1) {
            //默认
            return "";
        }
        //初始化结果
        StringBuilder str = new StringBuilder(3);
        //组装
        str.append(max);
        str.append(max);
        str.append(max);
        //返回
        return str.toString();
    }


    public static void main(String[] args) {
        System.out.println(new Code12().largestGoodInteger("6777133339"));
    }
}

package easy20;

/**
 * @Author ayl
 * @Date 2022-06-11
 * 717. 1 比特与 2 比特字符
 * 有两种特殊字符：
 * <p>
 * 第一种字符可以用一比特 0 表示
 * 第二种字符可以用两比特（10 或 11）表示
 * 给你一个以 0 结尾的二进制数组 bits ，如果最后一个字符必须是一个一比特字符，则返回 true 。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: bits = [1, 0, 0]
 * 输出: true
 * 解释: 唯一的解码方式是将其解析为一个两比特字符和一个一比特字符。
 * 所以最后一个字符是一比特字符。
 * 示例 2:
 * <p>
 * 输入：bits = [1,1,1,0]
 * 输出：false
 * 解释：唯一的解码方式是将其解析为两比特字符和两比特字符。
 * 所以最后一个字符不是一比特字符。
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= bits.length <= 1000
 * bits[i] 为 0 或 1
 */
public class Code6 {

    public boolean isOneBitCharacter(int[] bits) {
        //如果最后一个不是0
        if (bits[bits.length - 1] != 0) {
            //肯定不是
            return false;
        }
        //循环
        for (int i = 0; i < bits.length; i++) {
            //当前
            int left = bits[i];
            //如果当前是最后一个了
            if (i == bits.length - 1) {
                //直接返回对应结果
                return left == 0;
            }
            //如果当前满足2
            if (left == 1) {
                //额外进1
                i += 1;
            } else if (left == 0) {
                //直接过
            } else {
                //不是
                return false;
            }
            //如果b是最后一个
            if (i == bits.length - 1) {
                //肯定不是
                return false;
            }
        }
        //默认
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Code6().isOneBitCharacter(new int[]{1, 1, 1, 0}));
    }

}

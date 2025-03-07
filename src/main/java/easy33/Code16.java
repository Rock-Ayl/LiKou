package easy33;

/**
 * @Author ayl
 * @Date 2023-09-29
 * 面试题 05.07. 配对交换
 * 提示
 * 简单
 * 88
 * 相关企业
 * 配对交换。编写程序，交换某个整数的奇数位和偶数位，尽量使用较少的指令（也就是说，位0与位1交换，位2与位3交换，以此类推）。
 * <p>
 * 示例1:
 * <p>
 * 输入：num = 2（或者0b10）
 * 输出 1 (或者 0b01)
 * 示例2:
 * <p>
 * 输入：num = 3
 * 输出：3
 * 提示:
 * <p>
 * num的范围在[0, 2^30 - 1]之间，不会发生整数溢出。
 */
public class Code16 {

    public int exchangeBits(int num) {
        //如果是1
        if (num == 1) {
            //过
            return 2;
        }
        //转化为二进制
        String oldBit = Integer.toBinaryString(num);
        //如果不是偶数
        if (oldBit.length() % 2 != 0) {
            //进位
            oldBit = "0" + oldBit;
        }
        //初始化新的
        StringBuilder newBit = new StringBuilder();
        //初始化指针
        int i;
        //循环
        for (i = oldBit.length() - 1; i >= 1; i = i - 2) {
            //组装
            newBit.append(oldBit.charAt(i - 1));
            newBit.append(oldBit.charAt(i));
        }
        //重新转为10进制结果
        return Integer.parseInt(newBit.reverse().toString(), 2);
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(252076907));
        System.out.println(Integer.toBinaryString(788947819));
        System.out.println(new Code16().exchangeBits(520721303));;
    }

}

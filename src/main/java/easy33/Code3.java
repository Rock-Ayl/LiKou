package easy33;

import java.util.LinkedList;

/**
 * @Author ayl
 * @Date 2023-08-25
 * 面试题 05.03. 翻转数位
 * 提示
 * 简单
 * 108
 * 相关企业
 * 给定一个32位整数 num，你可以将一个数位从0变为1。请编写一个程序，找出你能够获得的最长的一串1的长度。
 * <p>
 * 示例 1：
 * <p>
 * 输入: num = 1775(110111011112)
 * 输出: 8
 * 示例 2：
 * <p>
 * 输入: num = 7(01112)
 * 输出: 4
 */
public class Code3 {

    public int reverseBits(int num) {
        //转化为二进制
        String binaryStr = Integer.toBinaryString(num);
        //如果是正数
        if (num > 0) {
            //多个0
            binaryStr = '0' + binaryStr;
        }
        //结果
        int maxHit = 0;
        //0的数量
        int zero = 0;
        //初始化列表
        LinkedList<Character> list = new LinkedList<>();
        //循环
        for (char c : binaryStr.toCharArray()) {
            //如果是1
            if (c == '1') {
                //记录
                list.addLast(c);
                //本轮过
                continue;
            }
            //如果还可以0变1
            if (zero < 1) {
                //记录
                list.addLast(c);
                zero++;
                //本轮过
                continue;
            }
            //刷新最大值
            maxHit = Math.max(maxHit, list.size());
            //如果不够0变1
            while (zero == 1) {
                //获取最后一个
                Character first = list.removeFirst();
                //如果是0
                if (first == '0') {
                    //跳出
                    break;
                }
            }
            //记录本次
            list.addLast(c);
        }
        //返回
        return Math.max(maxHit, list.size());
    }

    public static void main(String[] args) {
        System.out.println(new Code3().reverseBits(7));
    }

}

package normal25;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author ayl
 * @Date 2023-11-06
 * LCR 165. 解密数字
 * 中等
 * 607
 * 相关企业
 * 现有一串神秘的密文 ciphertext，经调查，密文的特点和规则如下：
 * <p>
 * 密文由非负整数组成
 * 数字 0-25 分别对应字母 a-z
 * 请根据上述规则将密文 ciphertext 解密为字母，并返回共有多少种解密结果。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: ciphertext = 216612
 * 输出: 6
 * 解释: 216612 解密后有 6 种不同的形式，分别是 "cbggbc"，"vggbc"，"vggm"，"cbggm"，"cqggbc" 和 "cqggm"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= ciphertext < 231
 */
public class Code18 {

    //初始化结果列表
    private List<String> result = new ArrayList<>();

    //递归
    private void next(List<Integer> list, int p, StringBuilder str) {
        //如果越界
        if (list.size() <= p) {
            //记录结果
            result.add(str.toString());
            //过
            return;
        }
        //当前数字
        int num = list.get(p);
        //如果只有一个
        if (p == list.size() - 1) {
            //直接组装
            str.append((char) (num + 97));
            //记录结果
            result.add(str.toString());
            //回溯
            str.deleteCharAt(str.length() - 1);
            //过
            return;
        }
        //直接组装当前
        str.append((char) (num + 97));
        //递归
        next(list, p + 1, str);
        //回溯
        str.deleteCharAt(str.length() - 1);
        //如果不符合2个数字
        if (num == 0) {
            //过
            return;
        }
        //两个数字的情况
        int doubleNum = num * 10 + list.get(p + 1);
        //如果大了
        if (doubleNum > 25) {
            //过
            return;
        }
        //组装当前
        str.append((char) (doubleNum + 97));
        //递归
        next(list, p + 2, str);
        //回溯
        str.deleteCharAt(str.length() - 1);
    }

    public int crackNumber(int ciphertext) {
        //初始化数字集合
        List<Integer> list = new ArrayList<>();
        //循环
        while (ciphertext > 0) {
            //组装当前
            list.add(ciphertext % 10);
            //下一个
            ciphertext = ciphertext / 10;
        }
        //翻转
        Collections.reverse(list);
        //递归
        next(list, 0, new StringBuilder());
        //返回结果
        return this.result.size();
    }

    public static void main(String[] args) {

        System.out.println(new Code18().crackNumber(216612));
    }

}

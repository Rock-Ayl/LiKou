package easy3;

/**
 * Created By Rock-Ayl on 2020-11-01
 * 面试题 01.06. 字符串压缩
 * 字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。
 * <p>
 * 示例1:
 * <p>
 * 输入："aabcccccaaa"
 * 输出："a2b1c5a3"
 * 示例2:
 * <p>
 * 输入："abbccd"
 * 输出："abbccd"
 * 解释："abbccd"压缩后为"a1b2c2d1"，比原字符串长度更长。
 * 提示：
 * <p>
 * 字符串长度在[0, 50000]范围内。
 */
public class Code12 {

    public static String compressString(String S) {
        //长度
        int length = S.length();
        //判空
        if (length < 1) {
            //返回
            return S;
        }
        //初始化返回值
        StringBuffer result = new StringBuffer();
        //当前值
        String lastValue = S.charAt(0) + "";
        //当前连击
        int size = 1;
        //循环
        for (int i = 1; i < length; i++) {
            //获取当前
            String thisValue = S.charAt(i) + "";
            //如果相同
            if (lastValue.equals(thisValue)) {
                //叠加连击
                size++;
            } else {
                //记录上一个结果
                result.append(lastValue + size);
                //当前值更新
                lastValue = thisValue;
                //连击更新
                size = 1;
            }
        }
        //最后一个更新
        result.append(lastValue + size);
        //对比长度
        if (result.length() < length) {
            //返回
            return result.toString();
        } else {
            //返回原来的
            return S;
        }
    }

    public static void main(String[] args) {
        System.out.println(compressString("aabcccccaaa"));
    }
}

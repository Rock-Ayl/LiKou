package easy12;

/**
 * @Author ayl
 * @Date 2021-10-05
 * 1784. 检查二进制字符串字段
 * 给你一个二进制字符串 s ，该字符串 不含前导零 。
 * <p>
 * 如果 s 最多包含 一个由连续的 '1' 组成的字段 ，返回 true​​​ 。否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "1001"
 * 输出：false
 * 解释：字符串中的 1 没有形成一个连续字段。
 * 示例 2：
 * <p>
 * 输入：s = "110"
 * 输出：true
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 100
 * s[i]​​​​ 为 '0' 或 '1'
 * s[0] 为 '1'
 */
public class Code7 {

    public boolean checkOnesSegment(String s) {
        //组
        char[] arr = s.toCharArray();
        //连续一的字段数
        int size = 0;
        //循环
        for (int i = 0; i < arr.length; i++) {
            //当前
            char x = arr[i];
            //如果是1
            if (x == '1') {
                //先记录
                size++;
                //如果连续1数量超过1了
                if (size > 1) {
                    //直接不可以
                    return false;
                }
                //j要同步给i的位置,默认到头
                int point = arr.length - 1;
                //继续寻找
                for (int j = i + 1; j < arr.length; j++) {
                    //如果不是1了
                    if (arr[j] != '1') {
                        //同步的位置不是头了
                        point = j;
                        //结束j循环
                        break;
                    }
                }
                //同步
                i = point;
            }
        }
        //如果只有一个
        if (size == 1) {
            //正确
            return true;
        } else {
            //错误
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Code7().checkOnesSegment("1001"));
    }

}

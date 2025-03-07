package normal3;

import java.util.HashMap;
import java.util.Map;

/**
 * Created By Rock-Ayl on 2021-05-13
 * 6. Z 字形变换
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 * <p>
 * 请你实现这个将字符串进行指定行数变换的函数：
 * <p>
 * string convert(string s, int numRows);
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "PAYPALISHIRING", numRows = 3
 * 输出："PAHNAPLSIIGYIR"
 * 示例 2：
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * 示例 3：
 * <p>
 * 输入：s = "A", numRows = 1
 * 输出："A"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 1000
 * s 由英文字母（小写和大写）、',' 和 '.' 组成
 * 1 <= numRows <= 1000
 */
public class Code20 {

    public String convert(String s, int numRows) {
        //如果不动
        if (numRows == 1) {
            //返回
            return s;
        }
        //循环
        Map<Integer, StringBuffer> map = new HashMap<>();
        //循环
        for (int i = 1; i <= numRows; i++) {
            //初始化
            map.put(i, new StringBuffer());
        }
        //升序
        boolean asc = true;
        //排序
        int sort = 1;
        //循环
        for (char c : s.toCharArray()) {
            //获取当前行
            StringBuffer str = map.get(sort);
            //组装
            str.append(c);
            //装回去
            map.put(sort, str);
            //如果是升序
            if (asc) {
                //如果可以继续升
                if (sort < numRows) {
                    //递增
                    sort++;
                } else {
                    //降序了
                    asc = false;
                    sort--;
                }
            } else {
                //如果可以继续降
                if (sort > 1) {
                    //递减
                    sort--;
                } else {
                    //降序了
                    asc = true;
                    sort++;
                }
            }
        }
        //结果
        StringBuffer result = new StringBuffer();
        //循环
        for (int i = 1; i <= numRows; i++) {
            //组装
            result.append(map.get(i));
        }
        //结果
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Code20().convert("AB", 1));
    }

}

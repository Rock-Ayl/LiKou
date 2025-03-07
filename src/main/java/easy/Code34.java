package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By Rock-Ayl on 2020-09-13
 * 剑指 Offer 05. 替换空格
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 */
public class Code34 {

    public static String replaceSpace(String s) {
        //初始化
        List<String> list = new ArrayList<>();
        //循环
        for (char c : s.toCharArray()) {
            //组装
            list.add(c + "");
        }
        //循环
        for (int i = 0; i < s.length(); i++) {
            //如果当前位置是空格
            if (" ".equals(list.get(i))) {
                //当前位置设置为%20
                list.set(i, "%20");
            }
        }
        //返回
        StringBuffer result = new StringBuffer();
        //循环
        for (String s1 : list) {
            //叠加
            result.append(s1);
        }
        //返回
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(replaceSpace("We are happy."));
    }
}

package normal54;

import java.util.ArrayList;
import java.util.List;

/**
 * 722. 删除注释
 * 算术评级: 7
 * 同步题目状态
 * <p>
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给一个 C++ 程序，删除程序中的注释。这个程序source是一个数组，其中source[i]表示第 i 行源码。 这表示每行源码由 '\n' 分隔。
 * <p>
 * 在 C++ 中有两种注释风格，行内注释和块注释。
 * <p>
 * 字符串// 表示行注释，表示//和其右侧的其余字符应该被忽略。
 */
public class Code2 {

    public List<String> removeComments(String[] source) {
        //是否跳过,默认不跳过
        boolean skip = false;
        //初始化结果
        List<String> result = new ArrayList<>();
        //当前字符串
        StringBuilder str = new StringBuilder();
        //循环
        for (int i = 0; i < source.length; i++) {
            //字符串
            String partStr = source[i];
            //索引
            int index = 0;
            //循环
            while (index < partStr.length()) {
                //如果是【//】
                if (partStr.charAt(index) == '/' && index + 1 < partStr.length() && partStr.charAt(index + 1) == '/') {
                    //如果正常没跳过
                    if (skip == false) {
                        //结束
                        break;
                    } else {
                        //下一个
                        index++;
                    }
                }
                //如果是【/*】
                else if (partStr.charAt(index) == '/' && index + 1 < partStr.length() && partStr.charAt(index + 1) == '*') {
                    //如果有开头
                    if (skip == true) {
                        //下一个
                        index++;
                    } else {
                        //进位
                        index += 2;
                        //跳过
                        skip = true;
                    }
                }
                //如果是【*/】
                else if (partStr.charAt(index) == '*' && index + 1 < partStr.length() && partStr.charAt(index + 1) == '/') {
                    //如果有开头
                    if (skip == true) {
                        //进位
                        index += 2;
                        //重新不跳过
                        skip = false;
                    } else {
                        //组装
                        str.append(partStr.charAt(index));
                        //下一个
                        index++;
                    }
                }
                //一般字符串
                else {
                    //如果没有跳过
                    if (skip == false) {
                        //组装
                        str.append(partStr.charAt(index));
                    }
                    //下一个
                    index++;
                }
            }
            //如果 没有处于跳过阶段 and 有内容
            if (skip == false && str.length() > 0) {
                //组装
                result.add(str.toString());
                //重置
                str = new StringBuilder();
            }
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        List<String> strings = new Code2().removeComments(new String[]{"a//*b/*/c", "blank", "d/*/e/*/f"});
        System.out.println();
    }

}

package easy26;

import java.util.Stack;

/**
 * @Author ayl
 * @Date 2022-12-22
 * 1598. 文件夹操作日志搜集器
 * 每当用户执行变更文件夹操作时，LeetCode 文件系统都会保存一条日志记录。
 * <p>
 * 下面给出对变更操作的说明：
 * <p>
 * "../" ：移动到当前文件夹的父文件夹。如果已经在主文件夹下，则 继续停留在当前文件夹 。
 * "./" ：继续停留在当前文件夹。
 * "x/" ：移动到名为 x 的子文件夹中。题目数据 保证总是存在文件夹 x 。
 * 给你一个字符串列表 logs ，其中 logs[i] 是用户在 ith 步执行的操作。
 * <p>
 * 文件系统启动时位于主文件夹，然后执行 logs 中的操作。
 * <p>
 * 执行完所有变更文件夹操作后，请你找出 返回主文件夹所需的最小步数 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：logs = ["d1/","d2/","../","d21/","./"]
 * 输出：2
 * 解释：执行 "../" 操作变更文件夹 2 次，即可回到主文件夹
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：logs = ["d1/","d2/","./","d3/","../","d31/"]
 * 输出：3
 * 示例 3：
 * <p>
 * 输入：logs = ["d1/","../","../","../"]
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= logs.length <= 103
 * 2 <= logs[i].length <= 10
 * logs[i] 包含小写英文字母，数字，'.' 和 '/'
 * logs[i] 符合语句中描述的格式
 * 文件夹名称由小写英文字母和数字组成
 */
public class Code7 {

    public int minOperations(String[] logs) {
        //步数
        int count = 0;
        //循环
        for (String log : logs) {
            //判断操作
            switch (log) {
                //回退
                case "../":
                    //递减、最小为0
                    count = Math.max(count-1, 0);
                    break;
                //停留
                case "./":
                    //直接跳过
                    break;
                //其他
                default:
                    //进位
                    count++;
                    break;
            }
        }
        //返回结果
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Code7().minOperations(new String[]{"d1/", "d2/", "./", "d3/", "../", "d31/"}));
    }

}

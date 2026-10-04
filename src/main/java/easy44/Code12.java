package easy44;

/**
 * 4070. 拨号的最少旋转次数 I
 * 同步题目状态
 * <p>
 * 简单
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个长度为 10、由数字组成的字符串 s。
 * <p>
 * 拨号盘上的数字 0 到 9 按顺序排列，且拨号盘是环形的，因此 0 和 9 相邻。指针最初指向 0。
 * <p>
 * 要按顺序拨出 s 中的每个数字，需要旋转指针，直到它指向该数字。每次旋转都会将指针移动到一个相邻的数字，你可以向任一方向旋转。如果指针已经指向要拨出的数字，则无需旋转。
 * <p>
 * 返回拨出 s 中所有数字所需的最少总旋转次数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： s = "0192837465"
 * <p>
 * 输出： 25
 * <p>
 * 解释：
 * <p>
 * 步骤	起始数字	目标数字	旋转次数
 * 1	0	0	0
 * 2	0	1	1
 * 3	1	9	2
 * 4	9	2	3
 * 5	2	8	4
 * 6	8	3	5
 * 7	3	7	4
 * 8	7	4	3
 * 9	4	6	2
 * 10	6	5	1
 * 总旋转次数为 0 + 1 + 2 + 3 + 4 + 5 + 4 + 3 + 2 + 1 = 25，这是最少的总旋转次数。
 * <p>
 * 示例 2：
 * <p>
 * 输入： s = "1200210200"
 * <p>
 * 输出： 12
 * <p>
 * 解释：
 * <p>
 * 步骤	起始数字	目标数字	旋转次数
 * 1	0	1	1
 * 2	1	2	1
 * 3	2	0	2
 * 4	0	0	0
 * 5	0	2	2
 * 6	2	1	1
 * 7	1	0	1
 * 8	0	2	2
 * 9	2	0	2
 * 10	0	0	0
 * 总旋转次数为 1 + 1 + 2 + 0 + 2 + 1 + 1 + 2 + 2 + 0 = 12，这是最少的总旋转次数。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * s.length == 10
 * s 仅由数字 '0' 到 '9' 组成
 */
public class Code12 {

    public int minRotations(String s) {
        //结果
        int sum = 0;
        //当前索引
        int index = 0;
        //循环
        for (int i = 0; i < s.length(); i++) {
            //当前数字
            int num = s.charAt(i) - '0';
            //移动本次
            sum += move(index, num);
            //记录下一个
            index = num;
        }
        //返回
        return sum;
    }

    //从开始移动到结束
    private int move(int start, int end) {
        //如果相同
        if (start == end) {
            //返回
            return 0;
        }
        //最小次数
        int min;
        //第一种情况,直接过去
        if (start < end) {
            //计算
            min = end - start;
        } else {
            //计算
            min = (10 - start) + end;
        }
        //第二种情况,反着过去
        if (start > end) {
            //计算
            min = Math.min(min, start - end);
        } else {
            //计算并对比
            min = Math.min(min, start + 10 - end);
        }
        //返回结果
        return min;
    }

    public static void main(String[] args) {
        System.out.println(new Code12().minRotations("0192837465"));
    }

}

package easy42;

/**
 * 面试题 05.01. 插入
 * 同步题目状态
 * <p>
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给定两个整型数字 N 与 M，以及表示比特位置的 i 与 j（i <= j，且从 0 位开始计算）。
 * <p>
 * 编写一种方法，使 M 对应的二进制数字插入 N 对应的二进制数字的第 i ~ j 位区域，不足之处用 0 补齐。具体插入过程如图所示。
 * <p>
 * <p>
 * <p>
 * 题目保证从 i 位到 j 位足以容纳 M， 例如： M = 10011，则 i～j 区域至少可容纳 5 位。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：N = 1024(10000000000), M = 19(10011), i = 2, j = 6
 * 输出：N = 1100(10001001100)
 * 示例 2：
 * <p>
 * 输入：N = 0, M = 31(11111), i = 0, j = 4
 * 输出：N = 31(11111)
 */
public class Code3 {

    public int insertBits(int N, int M, int i, int j) {
        //如果N太小
        if (N <= M) {
            //直接返回
            return M;
        }
        //转为二进制
        StringBuffer str = new StringBuffer(Integer.toBinaryString(N));
        //区间
        int left = str.length() - j - 1;
        int right = str.length() - i - 1;
        //循环
        for (int k = Math.max(0, left); k <= Math.min(right, str.length() - 1); k++) {
            //默认为0
            str.setCharAt(k, '0');
        }
        //返回结果 = (N 默认填充空间为0) + ( M 位移到指定位置)
        return Integer.parseInt(str.toString(), 2) + (M << i);
    }

    public static void main(String[] args) {
        //System.out.println(new Code3().insertBits(1024, 19, 2, 6));
        System.out.println(new Code3().insertBits(1143207437, 1017033, 11, 31));
    }

}

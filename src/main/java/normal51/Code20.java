package normal51;

/**
 * 2683. 相邻值的按位异或
 * 算术评级: 3
 * 第 345 场周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1518
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 下标从 0 开始、长度为 n 的数组 derived 是由同样长度为 n 的原始 二进制数组 original 通过计算相邻值的 按位异或（⊕）派生而来。
 * <p>
 * 特别地，对于范围 [0, n - 1] 内的每个下标 i ：
 * <p>
 * 如果 i = n - 1 ，那么 derived[i] = original[i] ⊕ original[0]
 * 否则 derived[i] = original[i] ⊕ original[i + 1]
 * 给你一个数组 derived ，请判断是否存在一个能够派生得到 derived 的 有效原始二进制数组 original 。
 * <p>
 * 如果存在满足要求的原始二进制数组，返回 true ；否则，返回 false 。
 * <p>
 * 二进制数组是仅由 0 和 1 组成的数组。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：derived = [1,1,0]
 * 输出：true
 * 解释：能够派生得到 [1,1,0] 的有效原始二进制数组是 [0,1,0] ：
 * derived[0] = original[0] ⊕ original[1] = 0 ⊕ 1 = 1
 * derived[1] = original[1] ⊕ original[2] = 1 ⊕ 0 = 1
 * derived[2] = original[2] ⊕ original[0] = 0 ⊕ 0 = 0
 * 示例 2：
 * <p>
 * 输入：derived = [1,1]
 * 输出：true
 * 解释：能够派生得到 [1,1] 的有效原始二进制数组是 [0,1] ：
 * derived[0] = original[0] ⊕ original[1] = 1
 * derived[1] = original[1] ⊕ original[0] = 1
 * 示例 3：
 * <p>
 * 输入：derived = [1,0]
 * 输出：false
 * 解释：不存在能够派生得到 [1,0] 的有效原始二进制数组。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == derived.length
 * 1 <= n <= 105
 * derived 中的值不是 0 就是 1 。
 */
public class Code20 {

    public boolean doesValidArrayExist(int[] derived) {
        //判断是否为有效数组
        return count(derived, 0) || count(derived, 1);
    }

    //计算本次
    private boolean count(int[] derived, int first) {
        //数组
        int[] arr = new int[derived.length];
        //第一个字段固定
        arr[0] = first;
        //循环
        for (int i = 1; i < arr.length; i++) {
            //判断当前数字 0 or 1
            if (derived[i - 1] == 0) {
                //如果前一个0
                if (arr[i - 1] == 0) {
                    //当前0
                    arr[i] = 0;
                } else {
                    //当前1
                    arr[i] = 1;
                }
            } else {
                //如果前一个0
                if (arr[i - 1] == 0) {
                    //当前0
                    arr[i] = 1;
                } else {
                    //当前1
                    arr[i] = 0;
                }
            }
        }
        //最后判断最后一个数值的结果
        return (arr[derived.length - 1] ^ arr[0]) == derived[derived.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Code20().doesValidArrayExist(new int[]{1, 1, 0}));
    }

}
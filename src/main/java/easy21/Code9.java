package easy21;

/**
 * @Author ayl
 * @Date 2022-07-20
 * 1089. 复写零
 * 给你一个长度固定的整数数组 arr，请你将该数组中出现的每个零都复写一遍，并将其余的元素向右平移。
 * <p>
 * 注意：请不要在超过该数组长度的位置写入元素。
 * <p>
 * 要求：请对输入的数组 就地 进行上述修改，不要从函数返回任何东西。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,0,2,3,0,4,5,0]
 * 输出：null
 * 解释：调用函数后，输入的数组将被修改为：[1,0,0,2,3,0,0,4]
 * 示例 2：
 * <p>
 * 输入：[1,2,3]
 * 输出：null
 * 解释：调用函数后，输入的数组将被修改为：[1,2,3]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 10000
 * 0 <= arr[i] <= 9
 */
public class Code9 {

    public void duplicateZeros(int[] arr) {
        //循环
        for (int i = 0; i < arr.length; i++) {
            //如果当前不是0
            if (arr[i] != 0) {
                //过
                continue;
            }
            //循环2
            for (int j = arr.length - 1; j > i; j--) {
                //复制
                arr[j] = arr[j - 1];
            }
            //进位
            i++;
        }
    }

    public static void main(String[] args) {
        new Code9().duplicateZeros(new int[]{1, 0, 2, 3, 0, 4, 5, 0});
    }

}

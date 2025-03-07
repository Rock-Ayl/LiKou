package easy;

/**
 * Created By Rock-Ayl on 2020-09-14
 * 1299. 将每个元素替换为右侧最大元素
 * 给你一个数组 arr ，请你将每个元素用它右边最大的元素替换，如果是最后一个元素，用 -1 替换。
 * <p>
 * 完成所有替换操作后，请你返回这个数组。
 * <p>
 * 示例：
 * <p>
 * 输入：arr = [17,18,5,4,6,1]
 * 输出：[18,6,6,6,1,-1]
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 10^4
 * 1 <= arr[i] <= 10^5
 */
public class Code35 {

    public static int[] replaceElements(int[] arr) {
        //长度
        int size = arr.length;
        //新的
        int[] newArr = new int[size];
        //最后一个是-1
        newArr[size - 1] = -1;
        //最大值初始化
        int max = arr[size - 1];
        //循环
        for (int i = size - 2; i >= 0; i--) {
            //新array当前位置为当前最大值
            newArr[i] = max;
            //当前现在的最大值
            int thisValue = arr[i];
            //如果大于当前
            if (thisValue > max) {
                //更新
                max = thisValue;
            }
        }
        //返回
        return newArr;
    }

    public static void main(String[] args) {
        for (int x : replaceElements(new int[]{17, 18, 5, 4, 6, 1})) {
            System.out.println(x);
        }
    }
}

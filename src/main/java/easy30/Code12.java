package easy30;

/**
 * @Author ayl
 * @Date 2023-04-27
 * 剑指 Offer II 069. 山峰数组的顶部
 * 符合下列属性的数组 arr 称为 山峰数组（山脉数组） ：
 * <p>
 * arr.length >= 3
 * 存在 i（0 < i < arr.length - 1）使得：
 * arr[0] < arr[1] < ... arr[i-1] < arr[i]
 * arr[i] > arr[i+1] > ... > arr[arr.length - 1]
 * 给定由整数组成的山峰数组 arr ，返回任何满足 arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1] 的下标 i ，即山峰顶部。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [0,1,0]
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：arr = [1,3,5,4,2]
 * 输出：2
 * 示例 3：
 * <p>
 * 输入：arr = [0,10,5,2]
 * 输出：1
 * 示例 4：
 * <p>
 * 输入：arr = [3,4,5,1]
 * 输出：2
 * 示例 5：
 * <p>
 * 输入：arr = [24,69,100,99,79,78,67,36,26,19]
 * 输出：2
 * <p>
 * <p>
 * 提示：
 * <p>
 * 3 <= arr.length <= 104
 * 0 <= arr[i] <= 106
 * 题目数据保证 arr 是一个山脉数组
 * <p>
 * <p>
 * 进阶：很容易想到时间复杂度 O(n) 的解决方案，你可以设计一个 O(log(n)) 的解决方案吗？
 */
public class Code12 {

    //递归
    public int next(int[] arr, int left, int mid, int right) {
        //如果是山顶
        if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
            //过
            return mid;
        }
        //如果山顶在左边
        if (arr[mid] > arr[mid + 1]) {
            //递归左边
            return next(arr, left, left + ((mid - left) / 2), mid);
        } else {
            //递归右边
            return next(arr, mid, mid + ((mid - left) / 2) + 1, right);
        }
    }

    public int peakIndexInMountainArray(int[] arr) {
        //实现
        return next(arr, 0, arr.length / 2, arr.length - 1);
    }

    public static void main(String[] args) {
        System.out.println(new Code12().peakIndexInMountainArray(new int[]{40, 48, 61, 75, 100, 99, 98, 39, 30, 10}));
    }

}

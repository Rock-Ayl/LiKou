package easy8;

/**
 * Created By Rock-Ayl on 2021-05-30
 * 面试题 17.16. 按摩师
 * 一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。
 * <p>
 * 注意：本题相对原题稍作改动
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： [1,2,3,1]
 * 输出： 4
 * 解释： 选择 1 号预约和 3 号预约，总时长 = 1 + 3 = 4。
 * 示例 2：
 * <p>
 * 输入： [2,7,9,3,1]
 * 输出： 12
 * 解释： 选择 1 号预约、 3 号预约和 5 号预约，总时长 = 2 + 9 + 1 = 12。
 * 示例 3：
 * <p>
 * 输入： [2,1,4,5,3,1,1,3]
 * 输出： 12
 * 解释： 选择 1 号预约、 3 号预约、 5 号预约和 8 号预约，总时长 = 2 + 4 + 3 + 3 = 12。
 * 通过次数55,988提交次数107,627
 */
public class Code3 {

    public int massage(int[] nums) {
        //判空
        if (nums.length == 0) {
            //返回
            return 0;
        }
        //判空
        if (nums.length == 1) {
            //返回
            return nums[0];
        }
        //初始化动态规划
        int[] arr = new int[nums.length];
        //初始化前两个
        arr[0] = nums[0];
        arr[1] = Math.max(nums[0], nums[1]);
        //循环
        for (int i = 2; i < nums.length; i++) {
            //当前赚
            int earn = nums[i];
            //如果当前的有得赚
            if (earn + arr[i - 2] > arr[i - 1]) {
                //刷新纪录
                arr[i] = earn + arr[i - 2];
            } else {
                //保持
                arr[i] = arr[i - 1];
            }
        }
        //返回最后一个
        return arr[arr.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Code3().massage(new int[]{2, 1, 4, 5, 3, 1, 1, 3}));
    }

}

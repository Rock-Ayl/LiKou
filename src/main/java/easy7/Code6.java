package easy7;

/**
 * Created By Rock-Ayl on 2021-03-02
 * 283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * <p>
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 */
public class Code6 {

    public static int[] moveZeroes(int[] nums) {
        //位置
        int p = 0;
        //开始p2
        int p2 = 1;
        //循环
        while (p < nums.length) {
            io:
            //循环
            for (int i = p; i < nums.length; i++) {
                //当前数
                int a = nums[i];
                //如果是0
                if (a == 0) {
                    //如果位置有更大的
                    if (i > p2) {
                        //开始p2
                        p2 = i;
                    }
                    //循环
                    for (int i2 = p2; i2 < nums.length; i2++) {
                        //当前数
                        int y = nums[i2];
                        //循环
                        if (y != 0) {
                            //记录
                            int c = a;
                            //移动
                            nums[i] = y;
                            nums[i2] = c;
                            //中断到io
                            break io;
                        }
                    }
                }
            }
            //递加
            p++;
        }
        //返回
        return nums;
    }

    public static void main(String[] args) {
        for (int i : moveZeroes(new int[]{0, 0, 1, 3, 12})) {
            System.out.println(i);
        }
    }
}

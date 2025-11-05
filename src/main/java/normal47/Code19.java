package normal47;

/**
 * @Author ayl
 * @Date 2025-11-05
 */
public class Code19 {

    public int maxGoodNumber(int[] nums) {
        //构建对应情况
        int one = build(nums, 0, 1, 2);
        int two = build(nums, 0, 2, 1);
        int three = build(nums, 1, 2, 0);
        int four = build(nums, 1, 0, 2);
        int five = build(nums, 2, 0, 1);
        int six = build(nums, 2, 1, 0);
        //比较
        int a = Math.max(one, two);
        int b = Math.max(three, four);
        int c = Math.max(five, six);
        //返回
        return Math.max(Math.max(a, b), c);
    }

    //构建数字
    private int build(int[] nums, int one, int two, int three) {
        //合并
        return merge(merge(nums[one], nums[two]), nums[three]);
    }

    //合并数字
    private int merge(int num1, int num2) {
        //位移次数
        int count = 0;
        //位移数字
        int moveNumber = num2;
        //如果可以位移
        while (moveNumber != 0) {
            //位移
            moveNumber = moveNumber >> 1;
            //+1
            count++;
        }
        //数字1位移对应次数 + 数字2
        return (num1 << count) + num2;
    }

    public static void main(String[] args) {
        System.out.println(new Code19().maxGoodNumber(new int[]{2, 8, 16}));
    }

}

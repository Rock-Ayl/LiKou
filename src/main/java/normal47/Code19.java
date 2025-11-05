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
        return Integer.parseInt(Integer.toBinaryString(nums[one]) +
                Integer.toBinaryString(nums[two]) +
                Integer.toBinaryString(nums[three]), 2);
    }

    public static void main(String[] args) {
        System.out.println(new Code19().maxGoodNumber(new int[]{2, 8, 16}));
    }

}

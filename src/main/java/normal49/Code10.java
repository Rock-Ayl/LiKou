package normal49;

/**
 * @Author ayl
 * @Date 1/2/26
 */
public class Code10 {

    public int minOperations(int[] nums) {
        //缓存
        int[] arr = new int[100001];
        //索引
        int index = nums.length;
        //+1,如果可以继续
        while (index > 0 && arr[nums[index - 1]] == 0) {
            //+1
            arr[nums[--index]]++;
        }
        //返回
        return index / 3 + (index % 3 == 0 ? 0 : 1);
    }

    public static void main(String[] args) {
        //System.out.println(new Code10().minOperations(new int[]{3, 8, 3, 6, 5, 8}));
        //System.out.println(new Code10().minOperations(new int[]{2, 2}));
        System.out.println(new Code10().minOperations(new int[]{87, 15, 26, 32, 32, 18}));
    }

}

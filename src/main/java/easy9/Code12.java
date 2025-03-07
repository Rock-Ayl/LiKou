package easy9;

/**
 * @Author 安永亮
 * @Date 2021-06-24
 * @Description LCS 01. 下载插件
 * 小扣打算给自己的 VS code 安装使用插件，初始状态下带宽每分钟可以完成 1 个插件的下载。假定每分钟选择以下两种策略之一:
 * <p>
 * 使用当前带宽下载插件
 * 将带宽加倍（下载插件数量随之加倍）
 * 请返回小扣完成下载 n 个插件最少需要多少分钟。
 * <p>
 * 注意：实际的下载的插件数量可以超过 n 个
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * <p>
 * 输出：2
 * <p>
 * 解释：
 * 以下两个方案，都能实现 2 分钟内下载 2 个插件
 * <p>
 * 方案一：第一分钟带宽加倍，带宽可每分钟下载 2 个插件；第二分钟下载 2 个插件
 * 方案二：第一分钟下载 1 个插件，第二分钟下载 1 个插件
 * 示例 2：
 * <p>
 * 输入：n = 4
 * <p>
 * 输出：3
 * <p>
 * 解释：
 * 最少需要 3 分钟可完成 4 个插件的下载，以下是其中一种方案:
 * 第一分钟带宽加倍，带宽可每分钟下载 2 个插件;
 * 第二分钟下载 2 个插件;
 * 第三分钟下载 2 个插件。
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 10^5
 */
public class Code12 {

    public int leastMinutes(int n) {
        //消耗时间
        int time = 0;
        //下载速度
        int download = 1;
        //当一半还是大于下载速度时
        while (n / 2 > download) {
            //偶数
            if (n % 2 != 0) {
                //+1
                n++;
            }
            //减半
            n = n / 2;
            //记录
            time++;
        }
        //如果还需要计算
        if (n != download) {
            if (n == 3) {
                return time + 3;
            }
            if (n == 2) {
                return time + 2;
            }
        }
        //返回结果
        return time + 1;
    }

    public static void main(String[] args) {
        System.out.println(new Code12().leastMinutes(10));
    }

}

package normal45;

/**
 * @Author ayl
 * @Date 2025-08-01
 * 1980. 找出不同的二进制字符串
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个字符串数组 nums ，该数组由 n 个 互不相同 的二进制字符串组成，且每个字符串长度都是 n 。请你找出并返回一个长度为 n 且 没有出现 在 nums 中的二进制字符串。如果存在多种答案，只需返回 任意一个 即可。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = ["01","10"]
 * 输出："11"
 * 解释："11" 没有出现在 nums 中。"00" 也是正确答案。
 * 示例 2：
 * <p>
 * 输入：nums = ["00","01"]
 * 输出："11"
 * 解释："11" 没有出现在 nums 中。"10" 也是正确答案。
 * 示例 3：
 * <p>
 * 输入：nums = ["111","011","001"]
 * 输出："101"
 * 解释："101" 没有出现在 nums 中。"000"、"010"、"100"、"110" 也是正确答案。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == nums.length
 * 1 <= n <= 16
 * nums[i].length == n
 * nums[i] 为 '0' 或 '1'
 * nums 中的所有字符串 互不相同
 */
public class Code15 {

    private static class Node {

        //节点数量,默认0
        private int count = 0;

        //左节点0
        private Node left;

        //有节点1
        private Node right;

    }

    public String findDifferentBinaryString(String[] nums) {
        //初始化主节点
        Node root = new Node();
        //循环
        for (String num : nums) {
            //构建
            set(root, num, 0);
        }
        //最终长度
        int length = nums[0].length();
        //初始化结果
        StringBuilder str = new StringBuilder();
        //递归
        build(str, root);
        //如果不够
        while (str.length() < length) {
            //直接使用0
            str.append('0');
        }
        //返回
        return str.toString();
    }

    //构建结果
    private void build(StringBuilder str, Node node) {
        //如果左边没有
        if (node.left == null) {
            //直接使用
            str.append('0');
            //过
            return;
        }
        //如果右边没有
        if (node.right == null) {
            //直接使用
            str.append('1');
            //过
            return;
        }
        //如果左边节点少
        if (node.left.count <= node.right.count) {
            //使用左边
            str.append('0');
            //走左边
            build(str, node.left);
        } else {
            //使用右边
            str.append('1');
            //走右边
            build(str, node.right);
        }
    }

    //组装节点
    private void set(Node node, String num, int index) {
        //如果到头了
        if (index >= num.length()) {
            //过
            return;
        }
        //+1
        node.count++;
        //获取当前
        char letter = num.charAt(index);
        //判断
        if (letter == '0') {
            //如果为空
            if (node.left == null) {
                //初始化
                node.left = new Node();
            }
            //下一个
            set(node.left, num, index + 1);
        } else {
            //如果为空
            if (node.right == null) {
                //初始化
                node.right = new Node();
            }
            //下一个
            set(node.right, num, index + 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Code15().findDifferentBinaryString(new String[]{"00", "10"}));
    }

}
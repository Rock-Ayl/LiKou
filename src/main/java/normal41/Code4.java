package normal41;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2025-03-15
 * 388. 文件的最长绝对路径
 * 尝试过
 * 中等
 * 相关标签
 * 相关企业
 * 假设有一个同时存储文件和目录的文件系统。下图展示了文件系统的一个示例：
 * <p>
 * <p>
 * <p>
 * 这里将 dir 作为根目录中的唯一目录。dir 包含两个子目录 subdir1 和 subdir2 。subdir1 包含文件 file1.ext 和子目录 subsubdir1；subdir2 包含子目录 subsubdir2，该子目录下包含文件 file2.ext 。
 * <p>
 * 在文本格式中，如下所示(⟶表示制表符)：
 * <p>
 * dir
 * ⟶ subdir1
 * ⟶ ⟶ file1.ext
 * ⟶ ⟶ subsubdir1
 * ⟶ subdir2
 * ⟶ ⟶ subsubdir2
 * ⟶ ⟶ ⟶ file2.ext
 * 如果是代码表示，上面的文件系统可以写为 "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext" 。'\n' 和 '\t' 分别是换行符和制表符。
 * <p>
 * 文件系统中的每个文件和文件夹都有一个唯一的 绝对路径 ，即必须打开才能到达文件/目录所在位置的目录顺序，所有路径用 '/' 连接。上面例子中，指向 file2.ext 的 绝对路径 是 "dir/subdir2/subsubdir2/file2.ext" 。每个目录名由字母、数字和/或空格组成，每个文件名遵循 name.extension 的格式，其中 name 和 extension由字母、数字和/或空格组成。
 * <p>
 * 给定一个以上述格式表示文件系统的字符串 input ，返回文件系统中 指向 文件 的 最长绝对路径 的长度 。 如果系统中没有文件，返回 0。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：input = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"
 * 输出：20
 * 解释：只有一个文件，绝对路径为 "dir/subdir2/file.ext" ，路径长度 20
 * 示例 2：
 * <p>
 * <p>
 * 输入：input = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"
 * 输出：32
 * 解释：存在两个文件：
 * "dir/subdir1/file1.ext" ，路径长度 21
 * "dir/subdir2/subsubdir2/file2.ext" ，路径长度 32
 * 返回 32 ，因为这是最长的路径
 * 示例 3：
 * <p>
 * 输入：input = "a"
 * 输出：0
 * 解释：不存在任何文件
 * 示例 4：
 * <p>
 * 输入：input = "file1.txt\nfile2.txt\nlongfile.txt"
 * 输出：12
 * 解释：根目录下有 3 个文件。
 * 因为根目录中任何东西的绝对路径只是名称本身，所以答案是 "longfile.txt" ，路径长度为 12
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= input.length <= 104
 * input 可能包含小写或大写的英文字母，一个换行符 '\n'，一个制表符 '\t'，一个点 '.'，一个空格 ' '，和数字。
 */
public class Code4 {

    private static class Node {

        //名称
        private String name;

        //等级
        private int level;

        //子节点列表
        private List<Node> nodeList = new ArrayList<>();

        //初始化
        public Node(String name, int level) {
            this.name = name;
            this.level = level;
        }

        @Override
        public String toString() {
            return String.format("name=%s,level=%s", this.name, this.level);
        }

    }

    public int lengthLongestPath(String input) {
        //节点层级缓存
        Map<Integer, Node> nodeMap = new HashMap<>();
        //初始化头结点列表
        List<Node> zeroNodeList = new ArrayList<>();
        //指针
        int index = 0;
        //循环
        while (index < input.length()) {
            //等级,默认为
            int level = 0;
            //如果是转义\n
            if (input.charAt(index) == '\n') {
                //+1
                index++;
            }
            //如果是转义\t
            while (input.charAt(index) == '\t') {
                //+1等级
                level++;
                //+1
                index++;
            }
            //初始化字符串
            StringBuilder str = new StringBuilder();
            //如果存在 and 不是转义
            while (index < input.length() && input.charAt(index) != '\n' && input.charAt(index) != '\t') {
                //组装、并+1
                str.append(input.charAt(index++));
            }
            //初始化节点
            Node node = new Node(str.toString(), level);
            //判断是否是头结点
            if (node.level > 0) {
                //加入到父节点下面
                nodeMap.get(node.level - 1).nodeList.add(node);
            } else {
                //记录头节点
                zeroNodeList.add(node);
            }
            //覆盖本身记录
            nodeMap.put(node.level, node);
        }
        //最大深度
        StringBuilder maxDeep = new StringBuilder();
        //循环
        for (Node root : zeroNodeList) {
            //计算
            StringBuilder deep = countLength(root);
            //如果是文件 and 更大
            if (isFile(deep) && deep.length() > maxDeep.length()) {
                //更新
                maxDeep = deep;
            }
        }
        //返回
        return maxDeep.length();
    }

    //计算深度
    private StringBuilder countLength(Node root) {
        //判空
        if (root == null) {
            //过
            return new StringBuilder();
        }
        //初始化
        StringBuilder str = new StringBuilder();
        //如果不是头节点
        if (root.level > 0) {
            //插入头
            str.append('/');
        }
        //组装
        str.append(root.name);
        //子节点最大长度
        StringBuilder childMax = new StringBuilder();
        //循环
        for (Node child : root.nodeList) {
            //递归子节点
            StringBuilder childDeep = countLength(child);
            //如果是文件 and 更大
            if (isFile(childDeep) && childDeep.length() > childMax.length()) {
                //更新
                childMax = childDeep;
            }
        }
        //组装
        str.append(childMax);
        //返回结果
        return str;
    }

    //判断是否为一个文件
    private boolean isFile(StringBuilder childDeep) {
        //索引
        int index = childDeep.length() - 1;
        //循环
        while (index >= 0) {
            //如果是.
            if (childDeep.charAt(index) == '.') {
                //是
                return true;
            }
            //-1
            index--;
        }
        //默认不是
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Code4().lengthLongestPath("a"));
    }

}

package normal22;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author ayl
 * @Date 2023-07-27
 * 1233. 删除子文件夹
 * 你是一位系统管理员，手里有一份文件夹列表 folder，你的任务是要删除该列表中的所有 子文件夹，并以 任意顺序 返回剩下的文件夹。
 * <p>
 * 如果文件夹 folder[i] 位于另一个文件夹 folder[j] 下，那么 folder[i] 就是 folder[j] 的 子文件夹 。
 * <p>
 * 文件夹的「路径」是由一个或多个按以下格式串联形成的字符串：'/' 后跟一个或者多个小写英文字母。
 * <p>
 * 例如，"/leetcode" 和 "/leetcode/problems" 都是有效的路径，而空字符串和 "/" 不是。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：folder = ["/a","/a/b","/c/d","/c/d/e","/c/f"]
 * 输出：["/a","/c/d","/c/f"]
 * 解释："/a/b" 是 "/a" 的子文件夹，而 "/c/d/e" 是 "/c/d" 的子文件夹。
 * 示例 2：
 * <p>
 * 输入：folder = ["/a","/a/b/c","/a/b/d"]
 * 输出：["/a"]
 * 解释：文件夹 "/a/b/c" 和 "/a/b/d" 都会被删除，因为它们都是 "/a" 的子文件夹。
 * 示例 3：
 * <p>
 * 输入: folder = ["/a/b/c","/a/b/ca","/a/b/d"]
 * 输出: ["/a/b/c","/a/b/ca","/a/b/d"]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= folder.length <= 4 * 104
 * 2 <= folder[i].length <= 100
 * folder[i] 只包含小写字母和 '/'
 * folder[i] 总是以字符 '/' 起始
 * folder 每个元素都是 唯一 的
 */
public class Code12 {

    //前缀树节点
    private static class Node {

        //该节点下文件夹列表
        private List<String> folderList;

        //下一级节点map
        private Map<String, Node> children;

        //初始化
        public Node() {
            this.folderList = new ArrayList<>();
            this.children = new HashMap<>();
        }

    }

    //主节点
    private Node rootNode;

    //插入文件夹
    private void insertFolder(String folder) {
        //拆分
        String[] wordArr = folder.split("/");
        //当前节点
        Node node = this.rootNode;
        //循环
        for (String word : wordArr) {
            //如果不存在
            if (node.children.containsKey(word) == false) {
                //初始化一个
                node.children.put(word, new Node());
            }
            //下一个
            node = node.children.get(word);
        }
        //记录已存在文件夹
        node.folderList.add(folder);
    }

    //收集当前满足条件内容
    private List<String> collect(Node node) {
        //怕空
        if (node == null) {
            //过
            return Collections.EMPTY_LIST;
        }
        //如果有最上一级目录
        if (node.folderList.size() > 0) {
            //直接返回
            return node.folderList;
        }
        //递归子集并收集文件夹
        return node.children
                .values()
                .stream()
                .flatMap(p -> collect(p).stream())
                .collect(Collectors.toList());
    }

    public List<String> removeSubfolders(String[] folder) {
        //初始化主节点
        this.rootNode = new Node();
        //循环
        for (String value : folder) {
            //插入文件夹
            insertFolder(value);
        }
        //收集所有最上级结果
        return collect(this.rootNode);
    }

    public static void main(String[] args) {
        Code12 code12 = new Code12();
        List<String> strings = code12.removeSubfolders(new String[]{"/a", "/a/b", "/c/d", "/c/d/e", "/c/f"});
        System.out.println();
    }

}

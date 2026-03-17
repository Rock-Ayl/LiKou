package difficult5;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 212. 单词搜索 II
 * 尝试过
 * 算术评级: 7
 * 同步题目状态
 * <p>
 * 困难
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words， 返回所有二维网格上的单词 。
 * <p>
 * 单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
 * 输出：["eat","oath"]
 * 示例 2：
 * <p>
 * <p>
 * 输入：board = [["a","b"],["c","d"]], words = ["abcb"]
 * 输出：[]
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 12
 * board[i][j] 是一个小写英文字母
 * 1 <= words.length <= 3 * 104
 * 1 <= words[i].length <= 10
 * words[i] 由小写英文字母组成
 * words 中的所有字符串互不相同
 */
public class Code3 {

    private static class Node {

        //子节点数组
        private Node[] children = null;

        //到此结尾的单词
        private List<String> wordList = null;

    }

    //主节点
    private Node root = new Node();

    public List<String> findWords(char[][] board, String[] words) {
        //循环
        for (String word : words) {
            //构建节点
            build(word);
        }
        //走过的路
        int[][] walkedArr = new int[board.length][board[0].length];
        //初始化结果
        Set<String> result = new HashSet<>();
        //循环
        for (int i = 0; i < board.length; i++) {
            //循环2
            for (int j = 0; j < board[0].length; j++) {
                //从开始寻找
                find(result, board, walkedArr, this.root, i, j);
            }
        }
        //去重,返回
        return new ArrayList<>(result);
    }

    //构建节点
    private void build(String word) {
        //当前节点
        Node node = this.root;
        //循环
        for (int i = 0; i < word.length(); i++) {
            //计算key
            int key = word.charAt(i) - 'a';
            //判空
            if (node.children == null) {
                //初始化
                node.children = new Node[26];
            }
            //判空
            if (node.children[key] == null) {
                //初始化
                node.children[key] = new Node();
            }
            //下一个
            node = node.children[key];
        }
        //判空
        if (node.wordList == null) {
            //初始化
            node.wordList = new ArrayList<>();
        }
        //记录最终的单词
        node.wordList.add(word);
    }

    //寻找
    private void find(Set<String> result, char[][] board, int[][] walkedArr, Node node, int x, int y) {
        //越界
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
            //过
            return;
        }
        //如果走过了
        if (walkedArr[x][y] == 1) {
            //过
            return;
        }
        //计算本次key
        int key = board[x][y] - 'a';
        //判空
        if (node.children == null || node.children[key] == null) {
            //过
            return;
        }
        //获取下一个节点
        Node nextNode = node.children[key];
        //判空
        if (nextNode.wordList != null) {
            //记录本次结果
            result.addAll(nextNode.wordList);
        }
        //记录走过了
        walkedArr[x][y] = 1;
        //上下左右
        find(result, board, walkedArr, nextNode, x + 1, y);
        find(result, board, walkedArr, nextNode, x - 1, y);
        find(result, board, walkedArr, nextNode, x, y + 1);
        find(result, board, walkedArr, nextNode, x, y - 1);
        //回溯
        walkedArr[x][y] = 0;
    }

    public static void main(String[] args) {
        List<String> wordList = new Code3().findWords(new char[][]{
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        }, new String[]{"oath", "pea", "eat", "rain"});
        System.out.println();
    }

}
package normal29;

import java.util.*;

/**
 * @Author ayl
 * @Date 2024-02-26
 * 1452. 收藏清单
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个数组 favoriteCompanies ，其中 favoriteCompanies[i] 是第 i 名用户收藏的公司清单（下标从 0 开始）。
 * <p>
 * 请找出不是其他任何人收藏的公司清单的子集的收藏清单，并返回该清单下标。下标需要按升序排列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：favoriteCompanies = [["leetcode","google","facebook"],["google","microsoft"],["google","facebook"],["google"],["amazon"]]
 * 输出：[0,1,4]
 * 解释：
 * favoriteCompanies[2]=["google","facebook"] 是 favoriteCompanies[0]=["leetcode","google","facebook"] 的子集。
 * favoriteCompanies[3]=["google"] 是 favoriteCompanies[0]=["leetcode","google","facebook"] 和 favoriteCompanies[1]=["google","microsoft"] 的子集。
 * 其余的收藏清单均不是其他任何人收藏的公司清单的子集，因此，答案为 [0,1,4] 。
 * 示例 2：
 * <p>
 * 输入：favoriteCompanies = [["leetcode","google","facebook"],["leetcode","amazon"],["facebook","google"]]
 * 输出：[0,1]
 * 解释：favoriteCompanies[2]=["facebook","google"] 是 favoriteCompanies[0]=["leetcode","google","facebook"] 的子集，因此，答案为 [0,1] 。
 * 示例 3：
 * <p>
 * 输入：favoriteCompanies = [["leetcode"],["google"],["facebook"],["amazon"]]
 * 输出：[0,1,2,3]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= favoriteCompanies.length <= 100
 * 1 <= favoriteCompanies[i].length <= 500
 * 1 <= favoriteCompanies[i][j].length <= 20
 * favoriteCompanies[i] 中的所有字符串 各不相同 。
 * 用户收藏的公司清单也 各不相同 ，也就是说，即便我们按字母顺序排序每个清单， favoriteCompanies[i] != favoriteCompanies[j] 仍然成立。
 * 所有字符串仅包含小写英文字母。
 */
public class Code10 {

    //节点实体
    private class Node {

        //内容
        private List<String> list;

        //索引
        private Integer index;

        //初始化
        public Node(List<String> list, Integer index) {
            //排序
            Collections.sort(list);
            //记录
            this.list = list;
            this.index = index;
        }

        //根据map,是否有专属单词
        public boolean hadOnlyWord(Map<String, Integer> wordMap) {
            //循环
            for (String word : this.list) {
                //如果出现次数小于2,视为只有一个
                if (wordMap.getOrDefault(word, 0) < 2) {
                    //是
                    return true;
                }
            }
            //默认
            return false;
        }

        //根据列表,匹配是否存在父级节点
        public boolean match(List<Node> nodeList, int startIndex) {
            //跳出标记
            out:
            //循环
            for (int i = startIndex; i < nodeList.size(); i++) {
                //获取本次要匹配的节点
                Node matchNode = nodeList.get(i);
                //获取二者节点列表
                List<String> thisList = this.list;
                List<String> matchList = matchNode.list;
                //因为所有人收藏都不一样,所以要满足父级条件,父级一定比子集长
                if (matchList.size() <= thisList.size()) {
                    //本轮过
                    continue;
                }
                //允许不匹配的次数,如果这个次数小于0,视为无法成为父级
                int canErrorCount = matchList.size() - thisList.size();
                //双指针
                int leftIndex = 0;
                int rightIndex = 0;
                //循环
                while (true) {
                    //如果错太多了
                    if (canErrorCount < 0) {
                        //本轮过
                        continue out;
                    }
                    //如果完全匹配了
                    if (leftIndex >= thisList.size()) {
                        //有匹配,返回true
                        return true;
                    }
                    //如果结束本次匹配
                    if (rightIndex >= matchList.size()) {
                        //本轮过
                        continue out;
                    }
                    //如果相同
                    if (thisList.get(leftIndex).equals(matchList.get(rightIndex))) {
                        //双进位
                        leftIndex++;
                        rightIndex++;
                    } else {
                        //单进位并记录错误
                        rightIndex++;
                        canErrorCount--;
                    }
                }
            }
            //默认
            return false;
        }

    }

    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        //初始化单词出现次数map
        Map<String, Integer> wordMap = new HashMap<>();
        //初始化列表
        List<Node> nodeList = new ArrayList<>(favoriteCompanies.size());
        //循环
        for (int i = 0; i < favoriteCompanies.size(); i++) {
            //初始化节点
            nodeList.add(new Node(favoriteCompanies.get(i), i));
            //循环
            for (String word : favoriteCompanies.get(i)) {
                //次数+1
                wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
            }
        }
        //按照长度排序
        nodeList.sort(Comparator.comparingInt(a -> a.list.size()));
        //初始化结果列表
        List<Integer> result = new ArrayList<>();
        //循环
        for (int i = 0; i < nodeList.size(); i++) {
            //当前节点
            Node thisNode = nodeList.get(i);
            //如果存在唯一的单词 or 匹配到任意的子集条件
            if (thisNode.hadOnlyWord(wordMap) || thisNode.match(nodeList, i + 1) == false) {
                //记录本次结果
                result.add(thisNode.index);
            }
        }
        //给结果排序
        Collections.sort(result);
        //返回
        return result;
    }

    public static void main(String[] args) {
        List<Integer> result = new Code10().peopleIndexes(Arrays.asList(
                Arrays.asList("leetcode", "google", "facebook"),
                Arrays.asList("google", "microsoft"),
                Arrays.asList("google", "facebook"),
                Arrays.asList("google"),
                Arrays.asList("amazon")
        ));
        System.out.println();
    }

}

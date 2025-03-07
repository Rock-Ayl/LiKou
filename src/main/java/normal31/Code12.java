package normal31;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author ayl
 * @Date 2024-05-07
 * 每年，政府都会公布一万个最常见的婴儿名字和它们出现的频率，也就是同名婴儿的数量。有些名字有多种拼法，例如，John 和 Jon 本质上是相同的名字，但被当成了两个名字公布出来。给定两个列表，一个是名字及对应的频率，另一个是本质相同的名字对。设计一个算法打印出每个真实名字的实际频率。注意，如果 John 和 Jon 是相同的，并且 Jon 和 Johnny 相同，则 John 与 Johnny 也相同，即它们有传递和对称性。
 * <p>
 * 在结果列表中，选择 字典序最小 的名字作为真实名字。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：names = ["John(15)","Jon(12)","Chris(13)","Kris(4)","Christopher(19)"], synonyms = ["(Jon,John)","(John,Johnny)","(Chris,Kris)","(Chris,Christopher)"]
 * 输出：["John(27)","Chris(36)"]
 * <p>
 * <p>
 * 提示：
 * <p>
 * names.length <= 100000
 */
public class Code12 {

    //婴儿节点
    private static class Node {

        //初始化的名称
        private String initName;

        //名称集合
        private Set<String> nameSet;

        //出现数量
        private Integer count;

        //初始化1
        public Node() {
            this.nameSet = new HashSet<>();
            this.count = 0;
        }

        //初始化2
        public Node(String name, Integer count) {
            //初始化
            this.initName = name;
            this.nameSet = new HashSet<>();
            this.nameSet.add(name);
            this.count = count;
            this.initName = name;
        }

        //初始化3
        public Node(String nameStr) {
            //获取分隔符索引
            int index = nameStr.indexOf("(");
            //拆分出名称
            String name = nameStr.substring(0, index);
            //拆分出数字
            Integer count = Integer.valueOf(nameStr.substring(index + 1, nameStr.length() - 1));
            //初始化
            this.nameSet = new HashSet<>();
            this.nameSet.add(name);
            this.count = count;
            this.initName = name;
        }

        //转为结果
        public String toResultStr() {
            //选出优先级最高的名称
            String firstName = nameSet.stream().sorted().findFirst().get();
            //返回结果
            return String.format("%s(%s)", firstName, this.count);
        }

    }

    //同名节点
    private static class Synonym {

        //名称1
        private String leftName;

        //名城2
        private String rightName;

        //初始化
        public Synonym(String synonymStr) {
            //获取分隔符索引
            int index = synonymStr.indexOf(",");
            //拆分并组装
            this.leftName = synonymStr.substring(1, index);
            this.rightName = synonymStr.substring(index + 1, synonymStr.length() - 1);
        }

    }

    //合并
    private void merge(Map<String, Node> nodeMap, Synonym synonym) {
        //获取两个节点
        Node node1 = nodeMap.get(synonym.leftName);
        //判空
        if (node1 == null) {
            //过
            return;
        }
        Node node2 = nodeMap.get(synonym.rightName);
        //判空
        if (node2 == null) {
            //过
            return;
        }
        //如果节点相同
        if (node1 == node2) {
            //过
            return;
        }
        //初始化一个新节点
        Node newNode = new Node();
        //合并二者为新节点
        newNode.nameSet.addAll(node1.nameSet);
        newNode.nameSet.addAll(node2.nameSet);
        newNode.count += node1.count + node2.count;
        //循环所有名称
        for (String newNodeName : newNode.nameSet) {
            //覆盖原有节点
            nodeMap.put(newNodeName, newNode);
        }
    }

    //加入缓存
    private void putNode(Map<String, Node> nodeMap, Node node) {
        //如果存在
        if (nodeMap.containsKey(node.initName)) {
            //叠加count
            nodeMap.get(node.initName).count += node.count;
        } else {
            //直接加入缓存
            nodeMap.put(node.initName, node);
        }
    }

    public String[] trulyMostPopular(String[] names, String[] synonyms) {
        //节点缓存
        Map<String, Node> nodeMap = new HashMap<>();
        //同名节点缓存
        Set<Synonym> synonymSet = new HashSet<>();
        //循环
        for (String nameStr : names) {
            //初始化节点,加入缓存
            putNode(nodeMap, new Node(nameStr));
        }
        //循环
        for (String synonymStr : synonyms) {
            //初始化同名节点
            Synonym synonym = new Synonym(synonymStr);
            //组装至缓存
            synonymSet.add(synonym);
            //初始化节点,加入缓存
            putNode(nodeMap, new Node(synonym.leftName, 0));
            putNode(nodeMap, new Node(synonym.rightName, 0));
        }
        //循环
        for (Synonym synonym : synonymSet) {
            //解析同名节点、尝试合并
            merge(nodeMap, synonym);
        }
        //去重、返回结果
        return new HashSet<>(nodeMap.values())
                //流
                .stream()
                //不需要没有内容的节点
                .filter(p -> p.count.compareTo(0) > 0)
                //转为所需str
                .map(Node::toResultStr)
                .toArray(String[]::new);
    }

    public static void main(String[] args) {
        String[] strings = new Code12().trulyMostPopular(
                new String[]{"John(15)", "Jon(12)", "Chris(13)", "Kris(4)", "Christopher(19)"},
                new String[]{"(Jon,John)", "(John,Johnny)", "(Chris,Kris)", "(Chris,Christopher)"}
        );
        System.out.println();
    }

}

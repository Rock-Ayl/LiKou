package normal29;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author ayl
 * @Date 2024-02-27
 * 1366. 通过投票对团队排名
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 现在有一个特殊的排名系统，依据参赛团队在投票人心中的次序进行排名，每个投票者都需要按从高到低的顺序对参与排名的所有团队进行排位。
 * <p>
 * 排名规则如下：
 * <p>
 * 参赛团队的排名次序依照其所获「排位第一」的票的多少决定。如果存在多个团队并列的情况，将继续考虑其「排位第二」的票的数量。以此类推，直到不再存在并列的情况。
 * 如果在考虑完所有投票情况后仍然出现并列现象，则根据团队字母的字母顺序进行排名。
 * 给你一个字符串数组 votes 代表全体投票者给出的排位情况，请你根据上述排名规则对所有参赛团队进行排名。
 * <p>
 * 请你返回能表示按排名系统 排序后 的所有团队排名的字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：votes = ["ABC","ACB","ABC","ACB","ACB"]
 * 输出："ACB"
 * 解释：A 队获得五票「排位第一」，没有其他队获得「排位第一」，所以 A 队排名第一。
 * B 队获得两票「排位第二」，三票「排位第三」。
 * C 队获得三票「排位第二」，两票「排位第三」。
 * 由于 C 队「排位第二」的票数较多，所以 C 队排第二，B 队排第三。
 * 示例 2：
 * <p>
 * 输入：votes = ["WXYZ","XYZW"]
 * 输出："XWYZ"
 * 解释：X 队在并列僵局打破后成为排名第一的团队。X 队和 W 队的「排位第一」票数一样，但是 X 队有一票「排位第二」，而 W 没有获得「排位第二」。
 * 示例 3：
 * <p>
 * 输入：votes = ["ZMNAGUEDSJYLBOPHRQICWFXTVK"]
 * 输出："ZMNAGUEDSJYLBOPHRQICWFXTVK"
 * 解释：只有一个投票者，所以排名完全按照他的意愿。
 * 示例 4：
 * <p>
 * 输入：votes = ["BCA","CAB","CBA","ABC","ACB","BAC"]
 * 输出："ABC"
 * 解释：
 * A 队获得两票「排位第一」，两票「排位第二」，两票「排位第三」。
 * B 队获得两票「排位第一」，两票「排位第二」，两票「排位第三」。
 * C 队获得两票「排位第一」，两票「排位第二」，两票「排位第三」。
 * 完全并列，所以我们需要按照字母升序排名。
 * 示例 5：
 * <p>
 * 输入：votes = ["M","M","M","M"]
 * 输出："M"
 * 解释：只有 M 队参赛，所以它排名第一。
 */
public class Code11 {

    //队伍节点
    private class Node {

        //队伍名称
        private Character group;

        //排名数组
        private int[] rankArr;

        //初始化队伍节点
        public Node(Character group, int groupSize) {
            this.group = group;
            this.rankArr = new int[groupSize];
        }

        //比较器
        public int compareTo(Node anotherNode) {
            //二者分数列表
            int[] thisRankArr = this.rankArr;
            int[] anotherRankArr = anotherNode.rankArr;
            //优先级指针
            int p = 0;
            //如果存在评分
            while (p < thisRankArr.length) {
                //获取二者评分,默认0
                int thisRank = thisRankArr[p];
                int anotherRank = anotherRankArr[p];
                //如果优先级不一样
                if (thisRank != anotherRank) {
                    //返回结果
                    return anotherRank - thisRank;
                }
                //优先级进位
                p++;
            }
            //排序一样
            return 0;
        }

    }

    public String rankTeams(String[] votes) {
        //如果只有一个
        if (votes.length == 1) {
            //直接返回
            return votes[0];
        }
        //队伍数量
        int groupSize = votes[0].length();
        //初始化队伍map
        Map<Character, Node> groupMap = new HashMap<>(groupSize);
        //循环所有评分
        for (String vote : votes) {
            //循环每个队伍评分
            for (int i = 0; i < vote.length(); i++) {
                //当前队伍
                Character group = vote.charAt(i);
                //如果不存在队伍
                if (groupMap.containsKey(group) == false) {
                    //初始化该队伍
                    groupMap.put(group, new Node(group, groupSize));
                }
                //记录本次评分
                groupMap.get(group).rankArr[i]++;
            }
        }
        //返回
        return groupMap
                //只需要节点
                .values()
                //流
                .stream()
                //按照比较器排序
                .sorted(Node::compareTo)
                //拆箱,将队伍转为string
                .map(p -> p.group.toString())
                //合并为最后结果
                .collect(Collectors.joining());
    }

    public static void main(String[] args) {
        System.out.println(new Code11().rankTeams(new String[]{"ABC", "ACB", "ABC", "ACB", "ACB"}));
    }

}

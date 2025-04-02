package normal41;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ayl
 * @Date 2025-04-02
 * 851. 喧闹和富有
 * 中等
 * 相关标签
 * 相关企业
 * 有一组 n 个人作为实验对象，从 0 到 n - 1 编号，其中每个人都有不同数目的钱，以及不同程度的安静值（quietness）。为了方便起见，我们将编号为 x 的人简称为 "person x "。
 * <p>
 * 给你一个数组 richer ，其中 richer[i] = [ai, bi] 表示 person ai 比 person bi 更有钱。另给你一个整数数组 quiet ，其中 quiet[i] 是 person i 的安静值。richer 中所给出的数据 逻辑自洽（也就是说，在 person x 比 person y 更有钱的同时，不会出现 person y 比 person x 更有钱的情况 ）。
 * <p>
 * 现在，返回一个整数数组 answer 作为答案，其中 answer[x] = y 的前提是，在所有拥有的钱肯定不少于 person x 的人中，person y 是最不安静的人（也就是安静值 quiet[y] 最小的人）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：richer = [[1,0],[2,1],[3,1],[3,7],[4,3],[5,3],[6,3]], quiet = [3,2,5,4,6,1,7,0]
 * 输出：[5,5,2,5,4,5,6,7]
 * 解释：
 * answer[0] = 5，
 * person 5 比 person 3 有更多的钱，person 3 比 person 1 有更多的钱，person 1 比 person 0 有更多的钱。
 * 唯一较为安静（有较低的安静值 quiet[x]）的人是 person 7，
 * 但是目前还不清楚他是否比 person 0 更有钱。
 * answer[7] = 7，
 * 在所有拥有的钱肯定不少于 person 7 的人中（这可能包括 person 3，4，5，6 以及 7），
 * 最安静（有较低安静值 quiet[x]）的人是 person 7。
 * 其他的答案也可以用类似的推理来解释。
 * 示例 2：
 * <p>
 * 输入：richer = [], quiet = [0]
 * 输出：[0]
 * <p>
 * 提示：
 * <p>
 * n == quiet.length
 * 1 <= n <= 500
 * 0 <= quiet[i] < n
 * quiet 的所有值 互不相同
 * 0 <= richer.length <= n * (n - 1) / 2
 * 0 <= ai, bi < n
 * ai != bi
 * richer 中的所有数对 互不相同
 * 对 richer 的观察在逻辑上是一致的
 */
public class Code15 {

    //人物实体
    private static class Person {

        //人物编号
        private int index;

        //安静值
        private int quiet;

        //其目标最小安静的值的人
        private Person minPerson;

        //比当前用户更穷的人的列表
        private List<Person> poolPersonList = new ArrayList<>();

        //更有钱的人数量
        private int richerCount = 0;

        //初始化
        public Person(int index, int quite) {
            this.index = index;
            this.quiet = quite;
            //默认最小安静是自己
            this.minPerson = this;
        }

    }

    public int[] loudAndRich(int[][] richer, int[] quiet) {
        //最富有人员名单,0=富有,1=不再最富有
        int[] arr = new int[quiet.length];
        //人员节点缓存
        Person[] nodeArr = new Person[quiet.length];
        //循环
        for (int i = 0; i < quiet.length; i++) {
            //初始化人员,并记录缓存
            nodeArr[i] = new Person(i, quiet[i]);
        }
        //循环
        for (int[] rich : richer) {
            //获取富有的人、贫穷的人
            Person big = nodeArr[rich[0]];
            Person small = nodeArr[rich[1]];
            //记录关系
            big.poolPersonList.add(small);
            //其更有钱的人数+1
            small.richerCount++;
            //其不是最富有的人了
            arr[small.index] = 1;
        }
        //结果
        int[] result = new int[quiet.length];
        //循环
        for (int i = 0; i < arr.length; i++) {
            //如果是最富有的
            if (arr[i] == 0) {
                //递归计算
                count(result, nodeArr[i]);
            }
        }
        //返回
        return result;
    }

    //递归计算
    private void count(int[] result, Person person) {
        //记录该节点,目标最小安静值的人
        result[person.index] = person.minPerson.index;
        //循环比他更穷的人
        for (Person child : person.poolPersonList) {
            //如果该节点更小
            if (person.minPerson.quiet < child.minPerson.quiet) {
                //刷新更穷的人的最小安静人
                child.minPerson = person.minPerson;
            }
            //由于计算完了,删除其与子节点关系,若之后,子节点没有更有钱的人,递归子节点
            if (--child.richerCount == 0) {
                //递归子级
                count(result, child);
            }
        }
    }

    public static void main(String[] args) {
        int[] ints = new Code15().loudAndRich(new int[][]{
                new int[]{1, 0},
                new int[]{2, 1},
                new int[]{3, 1},
                new int[]{3, 7},
                new int[]{4, 3},
                new int[]{5, 3},
                new int[]{6, 3}
        }, new int[]{3, 2, 5, 4, 6, 1, 7, 0});
        System.out.println();
    }

}

package normal27;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2023-12-14
 * 1600. 王位继承顺序
 * 提示
 * 中等
 * 74
 * 相关企业
 * 一个王国里住着国王、他的孩子们、他的孙子们等等。每一个时间点，这个家庭里有人出生也有人死亡。
 * <p>
 * 这个王国有一个明确规定的王位继承顺序，第一继承人总是国王自己。我们定义递归函数 Successor(x, curOrder) ，给定一个人 x 和当前的继承顺序，该函数返回 x 的下一继承人。
 * <p>
 * Successor(x, curOrder):
 * 如果 x 没有孩子或者所有 x 的孩子都在 curOrder 中：
 * 如果 x 是国王，那么返回 null
 * 否则，返回 Successor(x 的父亲, curOrder)
 * 否则，返回 x 不在 curOrder 中最年长的孩子
 * 比方说，假设王国由国王，他的孩子 Alice 和 Bob （Alice 比 Bob 年长）和 Alice 的孩子 Jack 组成。
 * <p>
 * 一开始， curOrder 为 ["king"].
 * 调用 Successor(king, curOrder) ，返回 Alice ，所以我们将 Alice 放入 curOrder 中，得到 ["king", "Alice"] 。
 * 调用 Successor(Alice, curOrder) ，返回 Jack ，所以我们将 Jack 放入 curOrder 中，得到 ["king", "Alice", "Jack"] 。
 * 调用 Successor(Jack, curOrder) ，返回 Bob ，所以我们将 Bob 放入 curOrder 中，得到 ["king", "Alice", "Jack", "Bob"] 。
 * 调用 Successor(Bob, curOrder) ，返回 null 。最终得到继承顺序为 ["king", "Alice", "Jack", "Bob"] 。
 * 通过以上的函数，我们总是能得到一个唯一的继承顺序。
 * <p>
 * 请你实现 ThroneInheritance 类：
 * <p>
 * ThroneInheritance(string kingName) 初始化一个 ThroneInheritance 类的对象。国王的名字作为构造函数的参数传入。
 * void birth(string parentName, string childName) 表示 parentName 新拥有了一个名为 childName 的孩子。
 * void death(string name) 表示名为 name 的人死亡。一个人的死亡不会影响 Successor 函数，也不会影响当前的继承顺序。你可以只将这个人标记为死亡状态。
 * string[] getInheritanceOrder() 返回 除去 死亡人员的当前继承顺序列表。
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：
 * ["ThroneInheritance", "birth", "birth", "birth", "birth", "birth", "birth", "getInheritanceOrder", "death", "getInheritanceOrder"]
 * [["king"], ["king", "andy"], ["king", "bob"], ["king", "catherine"], ["andy", "matthew"], ["bob", "alex"], ["bob", "asha"], [null], ["bob"], [null]]
 * 输出：
 * [null, null, null, null, null, null, null, ["king", "andy", "matthew", "bob", "alex", "asha", "catherine"], null, ["king", "andy", "matthew", "alex", "asha", "catherine"]]
 * <p>
 * 解释：
 * ThroneInheritance t= new ThroneInheritance("king"); // 继承顺序：king
 * t.birth("king", "andy"); // 继承顺序：king > andy
 * t.birth("king", "bob"); // 继承顺序：king > andy > bob
 * t.birth("king", "catherine"); // 继承顺序：king > andy > bob > catherine
 * t.birth("andy", "matthew"); // 继承顺序：king > andy > matthew > bob > catherine
 * t.birth("bob", "alex"); // 继承顺序：king > andy > matthew > bob > alex > catherine
 * t.birth("bob", "asha"); // 继承顺序：king > andy > matthew > bob > alex > asha > catherine
 * t.getInheritanceOrder(); // 返回 ["king", "andy", "matthew", "bob", "alex", "asha", "catherine"]
 * t.death("bob"); // 继承顺序：king > andy > matthew > bob（已经去世）> alex > asha > catherine
 * t.getInheritanceOrder(); // 返回 ["king", "andy", "matthew", "alex", "asha", "catherine"]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= kingName.length, parentName.length, childName.length, name.length <= 15
 * kingName，parentName， childName 和 name 仅包含小写英文字母。
 * 所有的参数 childName 和 kingName 互不相同。
 * 所有 death 函数中的死亡名字 name 要么是国王，要么是已经出生了的人员名字。
 * 每次调用 birth(parentName, childName) 时，测试用例都保证 parentName 对应的人员是活着的。
 * 最多调用 105 次birth 和 death 。
 * 最多调用 10 次 getInheritanceOrder 。
 */
public class Code2 {

    //人
    public static class Person {

        //名称
        private String name;

        //是否死亡
        private boolean dead;

        //孩子列表,顺序代表长幼
        private List<Person> children;

        //初始化
        Person(String name) {
            //记录名称
            this.name = name;
            //默认未死
            this.dead = false;
            //初始化孩子列表
            this.children = new ArrayList<>();
        }

    }

    //国王
    private Person king;
    //人员名单
    private Map<String, Person> personMap;
    //继承顺序列表
    private List<String> inheritanceOrderList;

    public Code2(String kingName) {
        //初始化国王
        this.king = new Person(kingName);
        //初始化人员名单
        this.personMap = new HashMap<>();
        //初始化继承顺序
        //记录国王
        this.personMap.put(this.king.name, this.king);
        //重新计算继承循序
        resetInheritanceOrder();
    }

    //出生
    public void birth(String parentName, String childName) {
        //初始化孩子
        Person child = new Person(childName);
        //绑定父子关系
        this.personMap.get(parentName).children.add(child);
        //记录孩子
        this.personMap.put(child.name, child);
        //继承名单需要更新
        this.inheritanceOrderList = null;
    }

    //死亡
    public void death(String name) {
        //设置死亡
        this.personMap.get(name).dead = true;
        //继承名单需要更新
        this.inheritanceOrderList = null;
    }

    //获取继承顺序
    public List<String> getInheritanceOrder() {
        //重新计算
        resetInheritanceOrder();
        //返回
        return this.inheritanceOrderList;
    }

    //重新计算继承顺序
    private void resetInheritanceOrder() {
        //如果存在,说明不需要重新计算
        if (this.inheritanceOrderList != null) {
            //过
            return;
        }
        //初始化
        this.inheritanceOrderList = new ArrayList<>();
        //从国王开始重新计算
        nextOrder(this.king);
    }

    //递归计算继承
    private void nextOrder(Person person) {
        //判空
        if (person == null) {
            //过
            return;
        }
        //如果没死
        if (person.dead == false) {
            //顺位继承
            this.inheritanceOrderList.add(person.name);
        }
        //循环孩子
        for (Person child : person.children) {
            //尝试继承
            nextOrder(child);
        }
    }

}

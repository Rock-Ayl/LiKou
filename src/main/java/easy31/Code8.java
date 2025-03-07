package easy31;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2023-05-29
 * 面试题 03.06. 动物收容所
 * 动物收容所。有家动物收容所只收容狗与猫，且严格遵守“先进先出”的原则。在收养该收容所的动物时，收养人只能收养所有动物中“最老”（由其进入收容所的时间长短而定）的动物，或者可以挑选猫或狗（同时必须收养此类动物中“最老”的）。换言之，收养人不能自由挑选想收养的对象。请创建适用于这个系统的数据结构，实现各种操作方法，比如enqueue、dequeueAny、dequeueDog和dequeueCat。允许使用Java内置的LinkedList数据结构。
 * <p>
 * enqueue方法有一个animal参数，animal[0]代表动物编号，animal[1]代表动物种类，其中 0 代表猫，1 代表狗。
 * <p>
 * dequeue*方法返回一个列表[动物编号, 动物种类]，若没有可以收养的动物，则返回[-1,-1]。
 * <p>
 * 示例1:
 * <p>
 * 输入：
 * ["AnimalShelf", "enqueue", "enqueue", "dequeueCat", "dequeueDog", "dequeueAny"]
 * [[], [[0, 0]], [[1, 0]], [], [], []]
 * 输出：
 * [null,null,null,[0,0],[-1,-1],[1,0]]
 * 示例2:
 * <p>
 * 输入：
 * ["AnimalShelf", "enqueue", "enqueue", "enqueue", "dequeueDog", "dequeueCat", "dequeueAny"]
 * [[], [[0, 0]], [[1, 0]], [[2, 1]], [], [], []]
 * 输出：
 * [null,null,null,null,[2,1],[0,0],[1,0]]
 * 说明:
 * <p>
 * 收纳所的最大容量为20000
 */
public class Code8 {

    //猫狗队列
    private LinkedList<Integer> catList;
    private LinkedList<Integer> dogList;
    //编号对应时间
    private Map<Integer, Integer> timeMap;
    //时间
    private int count;
    //空数组
    private int[] emptyArr;

    public Code8() {
        //初始化
        this.catList = new LinkedList<>();
        this.dogList = new LinkedList<>();
        this.timeMap = new HashMap<>();
        this.count = 0;
        this.emptyArr = new int[]{-1, -1};
    }

    public void enqueue(int[] animal) {
        //如果是猫
        if (animal[1] == 0) {
            //记录
            catList.addLast(animal[0]);
        } else {
            //记录
            dogList.addLast(animal[0]);
        }
        //记录时间
        this.timeMap.put(animal[0], count++);
    }

    public int[] dequeueAny() {
        //判空
        if (this.dogList.isEmpty()) {
            //实现
            return dequeueCat();
        }
        //判空
        if (this.catList.isEmpty()) {
            //实现
            return dequeueDog();
        }
        //如果猫大于狗
        if (timeMap.get(catList.peekFirst()) < timeMap.get(dogList.peekFirst())) {
            //实现
            return dequeueCat();
        } else {
            //实现
            return dequeueDog();
        }
    }

    public int[] dequeueDog() {
        //判空
        if (this.dogList.isEmpty()) {
            //过
            return emptyArr;
        }
        return new int[]{dogList.pollFirst(), 1};
    }

    public int[] dequeueCat() {
        //判空
        if (this.catList.isEmpty()) {
            //过
            return emptyArr;
        }
        return new int[]{catList.pollFirst(), 0};
    }

}

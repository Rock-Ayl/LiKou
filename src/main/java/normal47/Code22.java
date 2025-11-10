package normal47;

import java.util.Iterator;
import java.util.List;

/**
 * @Author ayl
 * @Date 2025-11-10
 * 341. 扁平化嵌套列表迭代器
 * 尝试过
 * 算术评级: 4
 * 同步题目状态
 * <p>
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给你一个嵌套的整数列表 nestedList 。每个元素要么是一个整数，要么是一个列表；该列表的元素也可能是整数或者是其他列表。请你实现一个迭代器将其扁平化，使之能够遍历这个列表中的所有整数。
 * <p>
 * 实现扁平迭代器类 NestedIterator ：
 * <p>
 * NestedIterator(List<NestedInteger> nestedList) 用嵌套列表 nestedList 初始化迭代器。
 * int next() 返回嵌套列表的下一个整数。
 * boolean hasNext() 如果仍然存在待迭代的整数，返回 true ；否则，返回 false 。
 * 你的代码将会用下述伪代码检测：
 * <p>
 * initialize iterator with nestedList
 * res = []
 * while iterator.hasNext()
 * append iterator.next() to the end of res
 * return res
 * 如果 res 与预期的扁平化列表匹配，那么你的代码将会被判为正确。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nestedList = [[1,1],2,[1,1]]
 * 输出：[1,1,2,1,1]
 * 解释：通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,1,2,1,1]。
 * 示例 2：
 * <p>
 * 输入：nestedList = [1,[4,[6]]]
 * 输出：[1,4,6]
 * 解释：通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,4,6]。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nestedList.length <= 500
 * 嵌套列表中的整数值在范围 [-106, 106] 内
 */
public class Code22 {

    private interface NestedInteger {

        public boolean isInteger();

        public Integer getInteger();

        public List<NestedInteger> getList();

    }

    private static class NestedIterator implements Iterator<Integer> {

        //缓存
        private List<NestedInteger> nestedList;

        public NestedIterator(List<NestedInteger> nestedList) {
            //记录缓存
            this.nestedList = nestedList;
        }

        @Override
        public Integer next() {
            //递归展开
            unwind();
            //如果没有
            if (this.nestedList.size() == 0) {
                //过
                return null;
            }
            //获取第一个
            NestedInteger nestedInteger = this.nestedList.get(0);
            //删除该节点
            this.nestedList.remove(0);
            //返回数字
            return nestedInteger.getInteger();
        }

        @Override
        public boolean hasNext() {
            //尝试展开
            unwind();
            //如果还有,视为还有
            return this.nestedList.size() > 0;
        }

        //展开,直到第一个是 数字 or null
        private void unwind() {
            //如果没有
            if (this.nestedList.size() == 0) {
                //过
                return;
            }
            //获取第一个
            NestedInteger nestedInteger = this.nestedList.get(0);
            //如果是数字
            if (nestedInteger.isInteger() == true) {
                //返回数字
                return;
            }
            //删除该节点
            this.nestedList.remove(0);
            //加入所有嵌套列表
            this.nestedList.addAll(0, nestedInteger.getList());
            //继续递归展开
            unwind();
        }

    }

}

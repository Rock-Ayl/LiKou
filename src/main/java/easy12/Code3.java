package easy12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author ayl
 * @Date 2021-10-01
 */
public class Code3 {

    // Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

    class PeekingIterator implements Iterator<Integer> {

        //指针
        int p = 0;
        //列表
        List<Integer> list = new ArrayList<>();

        public PeekingIterator(Iterator<Integer> iterator) {
            //循环
            while (iterator.hasNext()) {
                //组装下一个
                list.add(iterator.next());
            }
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            //如果有的偷窥
            if (p < list.size()) {
                //偷窥
                return list.get(p);
            }
            //默认
            return null;
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            //如果满足条件
            if (p < list.size()) {
                //下一个
                return list.get(p++);
            } else {
                //空
                return null;
            }
        }

        @Override
        public boolean hasNext() {
            //如果满足条件
            if (p < list.size()) {
                //是
                return true;
            }
            //默认
            return false;
        }

    }

}

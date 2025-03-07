package easy9;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author 安永亮
 * @Date 2021-06-25
 * @Description
 */
public class Code13 {

    class MinStack {

        List<Integer> list;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            list = new LinkedList<>();
        }

        public void push(int x) {
            list.add(x);
        }

        public void pop() {
            list.remove(list.size() - 1);
        }

        public int top() {
            return list.get(list.size() - 1);
        }

        public int getMin() {
            //最大
            int min = Integer.MAX_VALUE;
            //循环
            for (Integer integer : list) {
                if (integer < min) {
                    min = integer;
                }
            }
            return min;
        }

    }

}

package normal57;

import java.util.*;

/**
 * 2408. 设计 SQL
 * 算术评级: 3
 * 同步题目状态
 * <p>
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给定两个字符串数组 names 和 columns，大小都为 n。其中 names[i] 是第 i 个表的名称，columns[i] 是第 i 个表的列数。
 * <p>
 * 您需要实现一个支持以下 操作 的类：
 * <p>
 * 在特定的表中 插入 一行。插入的每一行都有一个 id。id 是使用自动递增方法分配的，其中第一个插入行的 id 为 1，同一个表中的后续其他行的 id 为上一个插入行的 id (即使它已被删除) 加 1。
 * 从指定表中 删除 一行。注意，删除一行 不会 影响下一个插入行的 id。
 * 从任何表中 查询 一个特定的单元格并返回其值。
 * 从任何表以 csv 格式 导出 所有行。
 * 实现 SQL 类:
 * <p>
 * SQL(String[] names, int[] columns)
 * 创建 n 个表。
 * bool ins(String name, String[] row)
 * 将 row 插入表 name 中并返回 true。
 * 如果 row.length 不 匹配列的预期数量，或者 name 不是 一个合法的表，不进行任何插入并返回 false。
 * void rmv(String name, int rowId, int columnId)
 * 从表 name 中移除行 rowId。
 * 如果 name 不是 一个合法的表或者没有 id 为 rowId 的行，不进行删除。
 * String sel(String name, int rowId, int columnId)
 * 返回表 name 中位于特定的 rowId 和 columnId 的单元格的值。
 * 如果 name 不是 一个合法的表，或者单元格 (rowId, columnId) 不合法，返回 "<null>"。
 * String[] exp(String name)
 * 返回表 name 中出现的行。
 * 如果 name 不是 一个合法的表，返回一个空数组。每一行以字符串表示，每个单元格的值（包括 行的 id）以 "," 分隔。
 * 示例 1：
 * <p>
 * 输入：
 * <p>
 * ["SQL","ins","sel","ins","exp","rmv","sel","exp"]
 * [[["one","two","three"],[2,3,1]],["two",["first","second","third"]],["two",1,3],["two",["fourth","fifth","sixth"]],["two"],["two",1],["two",2,2],["two"]]
 * 输出：
 * <p>
 * [null,true,"third",true,["1,first,second,third","2,fourth,fifth,sixth"],null,"fifth",["2,fourth,fifth,sixth"]]
 * 解释：
 * <p>
 * // 创建 3 张表。
 * SQL sql = new SQL(["one", "two", "three"], [2, 3, 1]);
 * <p>
 * // 将 id 为 1 的行添加到表 "two"。返回 True。
 * sql.ins("two", ["first", "second", "third"]);
 * <p>
 * // 从表 "two" 中 id 为 1 的行
 * // 其中第 3 列返回值 "third"。
 * sql.sel("two", 1, 3);
 * <p>
 * // 将另外一个 id 为 2 的行添加到表 "two"。返回 True。
 * sql.ins("two", ["fourth", "fifth", "sixth"]);
 * <p>
 * // 导出表 "two" 的行。
 * // 目前表中有两行 id 为 1 和 2 。
 * sql.exp("two");
 * <p>
 * // 删除表 "two" 当中的第一行。注意第二行的 id
 * // 依然为 2。
 * sql.rmv("two", 1);
 * <p>
 * // 从表 "two" 中 id 为 2 的行
 * // 其中第 2 列返回值 "fifth"。
 * sql.sel("two", 2, 2);
 * <p>
 * // 导出表 "two" 的行。
 * // 目前表中有一行 id 为 2。
 * sql.exp("two");
 * 示例 2：
 * <p>
 * 输入：
 * ["SQL","ins","sel","ins","exp","rmv","sel","exp"]
 * [[["one","two","three"],[2,3,1]],["two",["first","second","third"]],["two",1,3],["two",["fourth","fifth","sixth"]],["two"],["two",1],["two",2,2],["two"]]
 * 输出：
 * [null,true,"third",true,["1,first,second,third","2,fourth,fifth,sixth"],null,"fifth",["2,fourth,fifth,sixth"]]
 * 解释：
 * // 创建 3 张表
 * SQL sQL = new SQL(["one", "two", "three"], [2, 3, 1]);
 * <p>
 * // 将 id 为 1 的行添加到表 "two"。返回 True。
 * sQL.ins("two", ["first", "second", "third"]);
 * <p>
 * // 从表 "two" 中 id 为 1 的行
 * // 其中第 3 列返回值 "third"。
 * sQL.sel("two", 1, 3);
 * <p>
 * // 删除表 "two" 的第一行。
 * sQL.rmv("two", 1);
 * <p>
 * // 返回 "<null>" 因为 id 为 1 的单元格
 * // 已经从表 "two" 中删除。
 * sQL.sel("two", 1, 2);
 * <p>
 * // 返回 False 因为列的数量不正确。
 * sQL.ins("two", ["fourth", "fifth"]);
 * <p>
 * // 将 id 为 2 的行添加到表 "two"。返回 True。
 * sQL.ins("two", ["fourth", "fifth", "sixth"]);
 * <p>
 * <p>
 * 提示:
 * <p>
 * n == names.length == columns.length
 * 1 <= n <= 104
 * 1 <= names[i].length, row[i].length, name.length <= 10
 * names[i], row[i], name 由小写英文字母组成。
 * 1 <= columns[i] <= 10
 * 1 <= row.length <= 10
 * 所有的 names[i] 都是 不同 的。
 * 最多调用 ins 和 rmv 2000 次。
 * 最多调用 sel 104 次。
 * 最多调用 exp 500 次。
 * 进阶：如果表因多次删除而变得稀疏，您会选择哪种方法？为什么？考虑对内存使用和性能的影响。
 */
public class Code23 {

    public Code23(List<String> names, List<Integer> columns) {
        //初始化map
        tableNodeMap = new HashMap<>(names.size());
        //初始化表
        for (int i = 0; i < names.size(); i++) {
            //初始化表
            TableNode tableNode = new TableNode(names.get(i), columns.get(i));
            //加入map
            tableNodeMap.put(tableNode.name, tableNode);
        }
    }

    //表map
    private Map<String, TableNode> tableNodeMap;

    //表
    private static class TableNode {

        //表名
        private String name;

        //列数量
        private int columnCount;

        //行列表
        private List<RowNode> rowList;

        //初始化
        public TableNode(String name, int columnCount) {
            this.name = name;
            this.columnCount = columnCount;
            this.rowList = new ArrayList<>();
        }

        //方便调试
        @Override
        public String toString() {
            return "Table{" +
                    "name='" + name + '\'' +
                    ", columnCount=" + columnCount +
                    ", rowList=" + rowList.size() +
                    '}';
        }

    }

    //数据行
    private static class RowNode {

        //是否删除,默认不删除
        private boolean deleted = false;

        //行数据
        private List<String> row;

        //行id
        private int rowId;

        //初始化
        public RowNode(int rowId, List<String> row) {
            this.row = row;
            this.rowId = rowId;
        }

        //方便调试
        @Override
        public String toString() {
            return "Row{" +
                    "deleted=" + deleted +
                    ", row=" + row +
                    ", rowId=" + rowId +
                    '}';
        }

    }

    public boolean ins(String name, List<String> row) {
        //获取表
        TableNode table = tableNodeMap.get(name);
        //判空
        if (table == null) {
            //过
            return false;
        }
        //如果列不同
        if (row.size() != table.columnCount) {
            //过
            return false;
        }
        //初始化,加入行列表
        return table.rowList.add(new RowNode(table.rowList.size() + 1, row));
    }

    public void rmv(String name, int rowId) {
        //获取表
        TableNode table = tableNodeMap.get(name);
        //判空
        if (table == null || table.rowList.size() <= rowId - 1) {
            //过
            return;
        }
        //删除之
        RowNode rowNode = table.rowList.get(rowId - 1);
        //判断是否删除
        if (rowNode.deleted) {
            //过
            return;
        }
        //标记删除
        rowNode.deleted = true;
    }

    public String sel(String name, int rowId, int columnId) {
        //获取表
        TableNode table = tableNodeMap.get(name);
        //判空
        if (table == null || table.rowList.size() <= rowId - 1) {
            //过
            return "<null>";
        }
        //获取行
        RowNode rowNode = table.rowList.get(rowId - 1);
        //判断是否删除
        if (rowNode.deleted) {
            //过
            return "<null>";
        }
        //判断列是否超出范围
        if (columnId - 1 >= rowNode.row.size()) {
            //过
            return "<null>";
        }
        //返回值
        return rowNode.row.get(columnId - 1);
    }

    public List<String> exp(String name) {
        //获取表
        TableNode table = tableNodeMap.get(name);
        //判空
        if (table == null) {
            //过
            return null;
        }
        //初始化结果
        List<String> resultList = new ArrayList<>();
        //遍历行列表
        for (RowNode rowNode : table.rowList) {
            //判断是否删除
            if (rowNode.deleted) {
                //过
                continue;
            }
            //初始化行
            StringBuilder str = new StringBuilder(rowNode.rowId + ",");
            //遍历行数据
            for (String s : rowNode.row) {
                //组装
                str.append(s).append(",");
            }
            //删除最后一个逗号
            str.deleteCharAt(str.length() - 1);
            //组装
            resultList.add(str.toString());
        }
        //返回值
        return resultList;
    }

    public static void main(String[] args) {
        Code23 code23 = new Code23(Arrays.asList("one", "two", "three"), Arrays.asList(2, 3, 1));

        code23.ins("two", Arrays.asList("first", "second", "third"));
        System.out.println(code23.sel("two", 1, 3));

        code23.exp("two");
        code23.rmv("two", 1);
        System.out.println(code23.sel("two", 2, 2));
        ;
        code23.exp("two");

    }

}

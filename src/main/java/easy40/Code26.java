package easy40;

/**
 * @Author ayl
 * @Date 2025-07-17
 * 3570. 查找无可用副本的书籍
 * 已解答
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * SQL Schema
 * Pandas Schema
 * 表：library_books
 * <p>
 * +------------------+---------+
 * | Column Name      | Type    |
 * +------------------+---------+
 * | book_id          | int     |
 * | title            | varchar |
 * | author           | varchar |
 * | genre            | varchar |
 * | publication_year | int     |
 * | total_copies     | int     |
 * +------------------+---------+
 * book_id 是这张表的唯一主键。
 * 每一行包含图书馆中一本书的信息，包括图书馆拥有的副本总数。
 * 表：borrowing_records
 * <p>
 * +---------------+---------+
 * | Column Name   | Type    |
 * +---------------+---------+
 * | record_id     | int     |
 * | book_id       | int     |
 * | borrower_name | varchar |
 * | borrow_date   | date    |
 * | return_date   | date    |
 * +---------------+---------+
 * record_id 是这张表的唯一主键。
 * 每一行代表一笔借阅交易并且如果这本书目前被借出并且还没有被归还，return_date 为 NULL。
 * 编写一个解决方案以找到 所有 当前被借出（未归还） 且图书馆中 无可用副本 的书籍。
 * <p>
 * 如果存在一条借阅记录，其 return_date 为 NULL，那么这本书被认为 当前是借出的。
 * 返回结果表按当前借阅者数量 降序 排列，然后按书名 升序 排列。
 * <p>
 * 结果格式如下所示。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：
 * <p>
 * library_books 表：
 * <p>
 * +---------+------------------------+------------------+----------+------------------+--------------+
 * | book_id | title                  | author           | genre    | publication_year | total_copies |
 * +---------+------------------------+------------------+----------+------------------+--------------+
 * | 1       | The Great Gatsby       | F. Scott         | Fiction  | 1925             | 3            |
 * | 2       | To Kill a Mockingbird  | Harper Lee       | Fiction  | 1960             | 3            |
 * | 3       | 1984                   | George Orwell    | Dystopian| 1949             | 1            |
 * | 4       | Pride and Prejudice    | Jane Austen      | Romance  | 1813             | 2            |
 * | 5       | The Catcher in the Rye | J.D. Salinger    | Fiction  | 1951             | 1            |
 * | 6       | Brave New World        | Aldous Huxley    | Dystopian| 1932             | 4            |
 * +---------+------------------------+------------------+----------+------------------+--------------+
 * borrowing_records 表：
 * <p>
 * +-----------+---------+---------------+-------------+-------------+
 * | record_id | book_id | borrower_name | borrow_date | return_date |
 * +-----------+---------+---------------+-------------+-------------+
 * | 1         | 1       | Alice Smith   | 2024-01-15  | NULL        |
 * | 2         | 1       | Bob Johnson   | 2024-01-20  | NULL        |
 * | 3         | 2       | Carol White   | 2024-01-10  | 2024-01-25  |
 * | 4         | 3       | David Brown   | 2024-02-01  | NULL        |
 * | 5         | 4       | Emma Wilson   | 2024-01-05  | NULL        |
 * | 6         | 5       | Frank Davis   | 2024-01-18  | 2024-02-10  |
 * | 7         | 1       | Grace Miller  | 2024-02-05  | NULL        |
 * | 8         | 6       | Henry Taylor  | 2024-01-12  | NULL        |
 * | 9         | 2       | Ivan Clark    | 2024-02-12  | NULL        |
 * | 10        | 2       | Jane Adams    | 2024-02-15  | NULL        |
 * +-----------+---------+---------------+-------------+-------------+
 * 输出：
 * <p>
 * +---------+------------------+---------------+-----------+------------------+-------------------+
 * | book_id | title            | author        | genre     | publication_year | current_borrowers |
 * +---------+------------------+---------------+-----------+------------------+-------------------+
 * | 1       | The Great Gatsby | F. Scott      | Fiction   | 1925             | 3                 |
 * | 3       | 1984             | George Orwell | Dystopian | 1949             | 1                 |
 * +---------+------------------+---------------+-----------+------------------+-------------------+
 * 解释：
 * <p>
 * The Great Gatsby (book_id = 1)：
 * 总副本数：3
 * 当前被 Alice Smith，Bob Johnson 和 Grace Miller 借阅（3 名借阅者）
 * 可用副本数：3 - 3 = 0
 * 因为 available_copies = 0，所以被包含
 * 1984 (book_id = 3):
 * 总副本数：1
 * 当前被 David Brown 借阅（1 名借阅者）
 * 可用副本数：1 - 1 = 0
 * 因为 available_copies = 0，所以被包含
 * 未被包含的书：
 * To Kill a Mockingbird (book_id = 2)：总副本数 = 3，当前借阅者 = 2，可用副本 = 1
 * Pride and Prejudice (book_id = 4)：总副本数 = 2，当前借阅者 = 1，可用副本 = 1
 * The Catcher in the Rye (book_id = 5)：总副本数 = 1，当前借阅者 = 0，可用副本 = 1
 * Brave New World (book_id = 6)：总副本数 = 4，当前借阅者 = 1，可用副本 = 3
 * 结果顺序：
 * The Great Gatsby 有 3 名当前借阅者，排序第一
 * 1984 有 1 名当前借阅者，排序第二
 * 输出表以 current_borrowers 降序排序，然后以 book_title 升序排序。
 */
public class Code26 {

    private String sql = "SELECT b.book_id,b.title,b.author,b.genre,b.publication_year,b.total_copies as current_borrowers FROM (SELECT a.book_id,count(*) as no_return_count FROM (SELECT book_id FROM borrowing_records WHERE return_date is null) a GROUP BY a.book_id ) a , library_books b WHERE a.book_id = b.book_id AND a.no_return_count = b.total_copies ORDER BY b.total_copies DESC, b.title ASC";

}

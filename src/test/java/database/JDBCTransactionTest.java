package database;

/**
 * Created by liker on 20/07/2015 0020.
 * Group iTailor.hunters.neu.edu.cn
 */
public class JDBCTransactionTest{
    public static void main(String[] args) {
        String sql = "insert into dog.account(name,password) values(\"t2\",\"thea\")";
        JDBCTransaction jdbcTransaction = new JDBCTransaction();
        jdbcTransaction.saveData(sql);
        String qsql = "select * from dog.account";
        jdbcTransaction.queryData(qsql);
        jdbcTransaction.mysqlDump();
//        jdbcTransaction.mysqlRestore();

    }
}
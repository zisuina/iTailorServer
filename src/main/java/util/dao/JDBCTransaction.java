package util.dao;

import java.io.*;
import java.sql.*;

/**
 * Created by liker on 20/07/2015 0020.
 * Group iTailor.hunters.neu.edu.cn
 */
public class JDBCTransaction {
    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;

    public static Connection getConnection() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = null;
        String url = "jdbc:mysql://localhost:3306/dog?useUnicode=true&characterEncoding=utf-8";
        String user = "hunters";
        String password = "hunters";
        connection = DriverManager.getConnection(url, user, password);
        return connection;
    }

    public boolean saveData(String sql) {
        try {
            connection = getConnection();
            statement = connection.createStatement();
            statement.execute(sql);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //批量数据处理
    public boolean saveData(String[] sql) {

        try {
            connection = getConnection();
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            for (int i = 0; i < sql.length; i++) {
                statement.execute(sql[i]);
            }
            connection.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void queryData(String sql) {
        try {
            connection = getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
//            while (resultSet.next()) {
//                System.out.println(resultSet.findColumn("id"));
//                System.out.println(resultSet.getString("password"));
//            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //备份数据库
    public void mysqlDump() {
        String username = "hunters";
        String password = "hunters";
        String database = "dog";
        String backupFilepath = ".//mysql_bk.sql";
        String backup = "mysqldump -u" + username + " -p" + password + " " + database;
        System.out.println(backup);
        try {
            Process p = Runtime.getRuntime().exec("cmd.exe /c " + backup);
            InputStreamReader inputStreamReader = new InputStreamReader(p.getInputStream(), "utf8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuffer stringBuffer = new StringBuffer("");
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuffer.append(line + "\r\n");
            }
            FileOutputStream fileOutputStream = new FileOutputStream(backupFilepath);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "utf8");
            outputStreamWriter.write(stringBuffer.toString());
            outputStreamWriter.flush();
            inputStreamReader.close();
            bufferedReader.close();
            fileOutputStream.close();
            System.out.println("Backup Successfully");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Backup Fail");
        }
    }
    //恢复数据库
    public void mysqlRestore() {
        String username = "hunters";
        String password = "hunters";
        String database = "dog";
        String backupFilepath = ".//mysql_bk.sql";
        String restore = "mysqldump -u" + username + " -p" + password + " " + database;
        System.out.println(restore);
        try {
            Process p = Runtime.getRuntime().exec("cmd.exe /c " + restore);

            OutputStream outputStream = p.getOutputStream();//控制台输出流
            FileInputStream fileInputStream = new FileInputStream(backupFilepath);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "utf8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuffer stringBuffer = new StringBuffer("");
            String outLine;
            while ((outLine = bufferedReader.readLine()) != null) {
                stringBuffer.append(outLine + "\r\n");
            }
            Writer writer = new BufferedWriter(new OutputStreamWriter(outputStream, "utf8"));
            writer.write(stringBuffer.toString());
//            writer.flush();
            inputStreamReader.close();
            bufferedReader.close();
//            writer.close();
            fileInputStream.close();
            System.out.println("Restore Successfully");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Restore Fail");
        }
    }

}

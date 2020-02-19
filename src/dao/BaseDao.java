package dao;

import java.sql.*;

/**
 * @Author: laoyu
 * @Date: 2020/2/18 10:03
 * @Description: 数据库操作辅助类
 */
public class BaseDao {
    /**
     * 连接数据库的4个字符串
    连接地址
     MySQL数据库的java驱动
     用户名
     密码
     */
    static final String URL="jdbc:mysql://localhost:3306/rainquality?useUnicode=True&characterEncoding=UTF-8";
    static final String DRIVER="com.mysql.jdbc.Driver";
    static final String USERNAME="root";
    static final String PASSWORD="root";

//    //数据库连接对象
//    static Connection conn=null;
//    //PreparedStatement
//    static PreparedStatement pstmt=null;
//    //结果集对象
//    static ResultSet rs=null;

    /**
     * 连接数据库的方法
     * @return 数据库连接对象
     */
    public static Connection getConn(){
        Connection connection=null;

        if (connection==null) {
            //加载驱动
            try {
                Class.forName(DRIVER);
                connection= DriverManager.getConnection(URL,USERNAME,PASSWORD);
                System.out.println("数据库连接成功。");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return connection;
    }

    /**
     * 释放资源的方法
     * @param rs 结果集对象
     * @param conn 数据库连接对象
     * @param pstmt 执行SQL的对象
     */
    public static void closeAll(ResultSet rs, Connection conn,PreparedStatement pstmt){
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

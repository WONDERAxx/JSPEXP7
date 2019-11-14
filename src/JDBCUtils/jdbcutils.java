package JDBCUtils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

public class jdbcutils {
	public static Connection getConnection() throws Exception {

    	Properties pro = new Properties();
        InputStream is = jdbcutils.class.getClassLoader().getResourceAsStream("druid.properties");
        pro.load(is);
        //��ȡ���ӳض���
        DataSource ds = DruidDataSourceFactory.createDataSource(pro);
        //��ȡ����
        Connection conn = ds.getConnection();
		return conn;
		//return DriverManager.getConnection(url, user, password);
    	
    }
    public static void close(Statement stmt,Connection conn){
        if( stmt != null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if( conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * �ͷ���Դ
     * @param stmt
     * @param conn
     */
    public static void close(ResultSet rs,Statement stmt, Connection conn){
        if( rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if( stmt != null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if( conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

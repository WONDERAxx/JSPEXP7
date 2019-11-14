package check;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.mbeans.UserMBean;

import JDBCUtils.jdbcutils;
import JavaBean.User;


public class checkUser {
	 static List<User> list = null;
	static{//获取数据库里面的信息
		Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
       
        try {
        	
            conn = jdbcutils.getConnection();
            //定义sql
            String sql = "select * from user";
            //获取执行sql的对象
            stmt = conn.createStatement();
            //执行sql
            rs = stmt.executeQuery(sql);
            //遍历结果集，封装对象，装载集合
            User emp = null;
           
            list = new ArrayList<User>();
            while(rs.next()){
                //获取数据
                String id = rs.getString("id");
                String password = rs.getString("password");
                // 创建emp对象,并赋值
               emp = new User();
                emp.setId(id);
                emp.setPassword(password);
                //装载集合
                list.add(emp);
               //System.out.println(id + "------" + name + "------" + job + "------" + salary + "------" + dept);
            }
        } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			jdbcutils.close(rs,stmt,conn);
        }
	}
	public boolean checkUser(User user){
		int i = 0;
		for (; i < list.size(); i++) {
        	User emp = list.get(i);
            /*System.out.println(emp.getId()+ "------"+emp.getPassword());*/
			if(emp.getId().equals(user.getId())&&emp.getPassword().equals(user.getPassword())){
				return true;
			}
        }
		if(i>=list.size()){
			return false;
		}else{
		return true ;
		}
	}
}

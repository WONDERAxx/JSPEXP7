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
	static{//��ȡ���ݿ��������Ϣ
		Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
       
        try {
        	
            conn = jdbcutils.getConnection();
            //����sql
            String sql = "select * from user";
            //��ȡִ��sql�Ķ���
            stmt = conn.createStatement();
            //ִ��sql
            rs = stmt.executeQuery(sql);
            //�������������װ����װ�ؼ���
            User emp = null;
           
            list = new ArrayList<User>();
            while(rs.next()){
                //��ȡ����
                String id = rs.getString("id");
                String password = rs.getString("password");
                // ����emp����,����ֵ
               emp = new User();
                emp.setId(id);
                emp.setPassword(password);
                //װ�ؼ���
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

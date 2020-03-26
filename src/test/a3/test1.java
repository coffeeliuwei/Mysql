package test.a3;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class test1 {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
ComboPooledDataSource pool = new ComboPooledDataSource();
		/**
		 * 		// 手工指定连接参数
		pool.setDriverClass("com.mysql.jdbc.Driver");
		pool.setJdbcUrl("jdbc:mysql://127.0.0.1/jsp_db?useUnicode=true&characterEncoding=UTF-8");
		pool.setUser("root");
		pool.setPassword("111111");
		
		// 手工指定性能参数
		pool.setInitialPoolSize(2);
		pool.setMinPoolSize(2);
		pool.setMaxPoolSize(10);
		pool.setMaxIdleTime(30);
		pool.setIdleConnectionTestPeriod(300);
		 * 
		 */
		// 一个Connection代表一次访问
		Connection conn = pool.getConnection();
		
		// 查询操作		
		Statement stmt = conn.createStatement(); 
		ResultSet rs = stmt.executeQuery("SELECT * FROM student");		
		
	    while(rs.next())
	    {
	    	// 取出这一行记录
	    	int id = rs.getInt("id");
	    	String name = rs.getString("name");
	    	String phone = rs.getString("phone"); // 可能为null
	    	Date birthday = rs.getDate("birthday");
	    	System.out.println(id + "\t" + name + "\t" + phone );	           
	    }    
		
		conn.close(); // 连接放回池子
		
		pool.close(); // 数据源如果关闭，相应的池子也就销毁了

	}

}

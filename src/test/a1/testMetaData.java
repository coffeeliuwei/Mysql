package test.a1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class testMetaData {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");

		// 连接MySQL服务器
		String username= "root";
		String password = "111111";
		String connectionUrl = "jdbc:mysql://127.0.0.1:3306/jsp_db?useUnicode=true&characterEncoding=UTF-8";
		
		Connection conn = DriverManager.getConnection(connectionUrl, username, password);
		System.out.println("连接成功!");
		
		///////////////////////////////////////////////
		
		// 数据库查询: Statement语句 ,  ResultSet结果集
		String sql = "SELECT id as 学号, name as 姓名,birthday  FROM student";
		Statement stmt = conn.createStatement(); 
		ResultSet rs = stmt.executeQuery(sql);
				
		// 显示元数据信息
		ResultSetMetaData rsmd = rs.getMetaData();
		int numColumn = rsmd.getColumnCount();
		for(int i=1; i<= numColumn; i++) // 列序号 1,2,3, ...
		{
			String name = rsmd.getColumnName(i); // 列名
			String label = rsmd.getColumnLabel(i); // 列标题 (别名)
			int type = rsmd.getColumnType(i); // 类型, 参考 java.sql.Types定义
			String typeName = rsmd.getColumnTypeName(i); // 类型名称
			System.out.printf("第%d列: %s, %s, %s \n", i, name, label, typeName);
		}		
	    //////////////////////////////////////////////
	    conn.close();
		System.out.println("关闭连接!");

	}

}

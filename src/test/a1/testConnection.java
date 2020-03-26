package test.a1;

import java.util.List;

import com.coffee.mysql.SqlConnection;

public class testConnection {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");

		///////////////////////////////////////////////

		// 连接MySQL服务器
		SqlConnection conn = new SqlConnection();
		conn.connect("127.0.0.1", 3306, "jsp_db", "root", "111111");
				
		// 简化查询
		String sql = "SELECT id,name,birthday  FROM student";
		List<String[]> rows = conn.query(sql); 
		for(int i=0; i<rows.size(); i++)
		{
			// 每一行数据用一个数组表示
			String[] row = rows.get(i);
			String id = row[0];
			String name = row[1];
			String birthday = row[2];
			
			System.out.println(id + "\t" + name + "\t" + birthday);
		}
		
	    //////////////////////////////////////////////
	    conn.close();
		System.out.println("关闭连接!");

	}

}

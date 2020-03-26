package test.a1;

import java.util.List;

import test.pojo.Student;

import com.coffee.mysql.SqlConnection;
import com.coffee.mysql.SqlValueParser;

public class testConnection1 {

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
		
		// 列值转换工具类
		SqlValueParser vp = new SqlValueParser();
		
		for(int i=0; i<rows.size(); i++)
		{
			// 每一行数据用一个数组表示
			String[] row = rows.get(i);			
			Student stu = new Student();
			int k = 0;
			stu.id = Integer.valueOf(row[k++]); //vp.asInt(row[k++], 0);
			stu.name = vp.asString(row[k++], "无名字");
			stu.birthday = vp.asDate(row[k++], null);
			System.out.println(stu.id + "\t" + stu.name + ", " + stu.birthday.toLocaleString());
		}
		
	    //////////////////////////////////////////////
	    conn.close();
		System.out.println("关闭连接!");

	}

}

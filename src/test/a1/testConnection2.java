package test.a1;

import java.util.List;
import java.util.Map;

import test.pojo.Student;

import com.coffee.mysql.SqlConnection;
import com.coffee.mysql.SqlValueParser;

public class testConnection2 {

	public static void testQuery1() throws Exception
	{
		// 注册MySQL驱动 
		Class.forName("com.mysql.jdbc.Driver");

		///////////////////////////////////////////////

		SqlConnection conn = new SqlConnection();
		conn.connect("127.0.0.1", 3306, "jsp_db", "root", "111111");
				
		// 查询并转为 List<Map>
		String sql = "SELECT id,name,birthday  FROM student";
		List<Map> rows = conn.query(sql,0); 
		
		SqlValueParser vp = new SqlValueParser();		
		for(Map<String,String> row : rows)
		{
			Student stu = new Student();
			stu.id = vp.asInt(row.get("id"), 0); 
			stu.name = vp.asString(row.get("name"), "无名字");
			stu.birthday = vp.asDate(row.get("birthday"), null);
			
			System.out.println(stu.id + "\t" + stu.name + ", " + stu.birthday);
		}
		
	    //////////////////////////////////////////////
	    conn.close();
		System.out.println("关闭连接!");
	}
	
	public static void testQuery2() throws Exception
	{
		// 注册MySQL驱动 
		Class.forName("com.mysql.jdbc.Driver");

		///////////////////////////////////////////////

		SqlConnection conn = new SqlConnection();
		conn.connect("127.0.0.1", 3306, "jsp_db", "root", "111111");
				
		// 查询获取单行记录
		String sql = "SELECT id,name,birthday  FROM student WHERE id=20200001";
		String[] row = conn.get(sql); 
		
		SqlValueParser vp = new SqlValueParser();		
		if(row != null)
		{
			Student stu = new Student();
			int k = 0;
			stu.id = vp.asInt(row[k++], 0); 
			stu.name = vp.asString(row[k++], "无名字");
			stu.birthday = vp.asDate(row[k++], null);
			
			System.out.println(stu.id + "\t" + stu.name + ", " + stu.birthday);
		}
		
	    //////////////////////////////////////////////
	    conn.close();
		System.out.println("关闭连接!");
	}

	
	public static void main(String[] args)
	{
		try
		{
			testQuery2();
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

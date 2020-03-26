package test.a1;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import test.pojo.Student;

import com.coffee.mysql.Sql;
import com.coffee.mysql.SqlConnection;
import com.coffee.mysql.util.SqlInsert;
import com.coffee.mysql.util.SqlUpdate;
import com.coffee.mysql.util.SqlWhere;


public class Test
{
	//普通方式
	public static void testConnect() throws Exception
	{
		Class.forName("com.mysql.jdbc.Driver");
		String username= "root";
		String password = "111111";
		String connectionUrl = "jdbc:mysql://127.0.0.1:3306/jsp_db?useUnicode=true&characterEncoding=UTF-8";
		
		Connection conn = DriverManager.getConnection(connectionUrl, username, password);
		System.out.println("连接成功!");
		
		conn.close();
		System.out.println("关闭连接!");
	}
	//普通方式
	public static void testQuery() throws Exception
	{
		// 注册MySQL驱动 ( 注：统一加上这一步吧 ！ )
		// 将来有些运行环境 下不支持驱动的自动加载，例如，Java Web的环境 里, 所以统一加上这句
		Class.forName("com.mysql.jdbc.Driver");
		// 连接MySQL服务器
		String username= "root";
		String password = "111111";
		String connectionUrl = "jdbc:mysql://127.0.0.1:3306/jsp_db?useUnicode=true&characterEncoding=UTF-8";
		
		Connection conn = DriverManager.getConnection(connectionUrl, username, password);
		System.out.println("连接成功!");
		
		///////////////////////////////////////////////
		
		// 数据库查询, Statement语句  ResultSet结果集
		Statement stmt = conn.createStatement(); 
		ResultSet rs = stmt.executeQuery("SELECT * FROM student");
		
		//如果有数据，rs.next()返回true
	    while(rs.next())
	    {
	    	// 取出这一行记录
	    	int id = rs.getInt("id");
	    	String name = rs.getString("name");
	    	String phone = rs.getString("phone"); // 可能为null
	    	Date birthday = rs.getDate("birthday");
	    	
	    	System.out.println(id + "\t" + name + "\t" + phone );	           
	    }
	    
	    //////////////////////////////////////////////
		conn.close();
		System.out.println("关闭连接!");
	}
	//普通方式
	public static void testInsert() throws Exception
	{
		// 注册MySQL驱动 ( 注：统一加上这一步吧 ！ )
		// 将来有些运行环境 下不支持驱动的自动加载，例如，Java Web的环境 里, 所以统一加上这句
		Class.forName("com.mysql.jdbc.Driver");

		// 连接MySQL服务器
		String username= "root";
		String password = "111111";
		String connectionUrl = "jdbc:mysql://127.0.0.1:3306/jsp_db?useUnicode=true&characterEncoding=UTF-8";
		
		Connection conn = DriverManager.getConnection(connectionUrl, username, password);
		System.out.println("连接成功!");
		
		///////////////////////////////////////////////
		String sql = "INSERT INTO student(`id`,`name`,`birthday`) "
				+ "VALUES ('20201200', '颜良', '1997-4-19') ";
		System.out.println("SQL: "+ sql);
	
		
		Statement stmt = conn.createStatement(); 		
		//stmt.execute(sql);
	    int count = stmt.executeUpdate(sql);
	    System.out.println("受影响的行数为: " + count);
	    
	    //////////////////////////////////////////////
		conn.close();
		System.out.println("关闭连接!");
	}

	//普通方式  有自增主键时，可以取回新增的主键的值
	public static void testInsert2() throws Exception
	{
		// 连接MySQL服务器
		String username= "root";
		String password = "111111";
		String connectionUrl = "jdbc:mysql://127.0.0.1:3306/jsp_db?useUnicode=true&characterEncoding=UTF-8";
		
		Connection conn = DriverManager.getConnection(connectionUrl, username, password);
		System.out.println("连接成功!");
		
		///////////////////////////////////////////////
		String sql = "INSERT INTO leave_event(`stuId`,`daysFrom`,`daysTo`,`type`,`reason`) "
				+ "VALUES ('20200004', '2020-03-24', '2020-03-30', '2', '出国') ";
		System.out.println("SQL: "+ sql);
	
		
		Statement stmt = conn.createStatement(); 		
		stmt.execute(sql, Statement.RETURN_GENERATED_KEYS);
		
		// 取得自动生成的主键的值
		ResultSet rs = stmt.getGeneratedKeys(); 		
		while(rs.next())
		{
            int id = rs.getInt(1);
            System.out.println("产生的主键是："+id);
        }
	    
	    //////////////////////////////////////////////
		conn.close();
		System.out.println("关闭连接!");
	}
	/////////////////////////////////////////////////////////////////////////////////////////////
	//封装各种操作
	public static void testQuery1() throws Exception
	{
		Class.forName("com.mysql.jdbc.Driver");
		// 连接MySQL服务器
		String username= "root";
		String password = "111111";
		String connectionUrl = "jdbc:mysql://127.0.0.1:3306/jsp_db?useUnicode=true&characterEncoding=UTF-8";		
		Connection conn = DriverManager.getConnection(connectionUrl, username, password);
		System.out.println("连接成功!");		
		//////////////////////////////////////////////			
		// 构造查询语句
		SqlWhere where = new SqlWhere();
		where.add("id>20200003");//  (id>20200003)
		where.add2("sex", true);		
		String sql = "SELECT * FROM student" 
				+ where
				+ " ORDER BY id ASC ";
		System.out.println("SQL:" + sql);	
		// 数据库查询, Statement语句  ResultSet结果集
		Statement stmt = conn.createStatement(); 
		ResultSet rs = stmt.executeQuery(sql);		
		//如果有数据，rs.next()返回true
	    while(rs.next())
	    {
	    	// 取出这一行记录
	    	int id = rs.getInt("id");
	    	String name = rs.getString("name");
	    	String phone = rs.getString("phone"); // 可能为null
	    	Date birthday = rs.getDate("birthday");
	    	
	    	System.out.println(id + "\t" + name + "\t" + phone );	           
	    }
	    
	    //////////////////////////////////////////////
		conn.close();
	}
	public static void testInsert3() throws Exception
	{
		Class.forName("com.mysql.jdbc.Driver");
		// 连接MySQL服务器
		String username= "root";
		String password = "111111";
		String connectionUrl = "jdbc:mysql://127.0.0.1:3306/jsp_db?useUnicode=true&characterEncoding=UTF-8";
		Connection conn = DriverManager.getConnection(connectionUrl, username, password);
		System.out.println("连接成功!");
		//////////////////////////////////////////////	
//		String sql = "INSERT INTO student(`id`,`name`,`birthday`) "
//				+ "VALUES ('20181200', '韩', '1997-4-19') ";		
		SqlInsert insert = new SqlInsert("student");
		insert.add2("id", 20201201);
		insert.add2("name", "张");
		insert.add2("birthday", "1995-5-1");	
		String sql = insert.toString();
		System.out.println("SQL: "+ sql);
		Statement stmt = conn.createStatement(); 		
		//stmt.execute(sql);
	    int count = stmt.executeUpdate(sql);
	    System.out.println("受影响的行数为: " + count);    
	    //////////////////////////////////////////////
		conn.close();
	}
	public static void testUpdate() throws Exception
	{
		Class.forName("com.mysql.jdbc.Driver");
		// 连接MySQL服务器
		String username= "root";
		String password = "111111";
		String connectionUrl = "jdbc:mysql://127.0.0.1:3306/jsp_db?useUnicode=true&characterEncoding=UTF-8";
		Connection conn = DriverManager.getConnection(connectionUrl, username, password);
		System.out.println("连接成功!");
		//////////////////////////////////////////////	
		SqlUpdate update = new SqlUpdate("student");
		update.add("birthday", "1997-10-02");
		SqlWhere where = new SqlWhere();
		where.add2("id", 20200001);
		String sql = update.toString() + where;
		System.out.println("SQL: "+ sql);
		Statement stmt = conn.createStatement(); 		
		stmt.execute(sql);
	    int count = stmt.getUpdateCount();
	    System.out.println("受影响的行数为: " + count);
	    
	    //////////////////////////////////////////////
		conn.close();
		
	}
	public static void testQuery5() throws Exception
	{
		// 连接MySQL服务器
		SqlConnection conn = new SqlConnection();
		conn.connect("127.0.0.1", 3306, "jsp_db", "root", "111111");
				
		// 查询并获取单条记录		
		String sql = "select * from student where id=20200001";
		Student stu = (Student)conn.get(sql, Student.class);
		if(stu != null)
		{
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
			testUpdate();
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

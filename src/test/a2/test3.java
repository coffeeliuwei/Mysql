package test.a2;

import com.coffee.mysql.SqlConnection;

import test.pojo.Student;

public class test3 {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
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

}

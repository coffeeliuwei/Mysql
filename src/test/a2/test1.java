package test.a2;

import java.util.List;

import test.pojo.Student;

import com.coffee.mysql.SqlConnection;

public class test1 {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		SqlConnection conn = new SqlConnection();
		conn.connect("127.0.0.1", 3306, "jsp_db", "root", "111111");
				
		// 简化查询
		String sql = "SELECT *  FROM student";
		List<Student> rows =  (List<Student>) conn.query(sql, Student.class);
		for(Student stu: rows)
		{
			System.out.println(stu.id + "\t" + stu.name + ", " + stu.birthday);
		}
	    
		//////////////////////////////////////////////
	    conn.close();
		System.out.println("关闭连接!");
	}

}

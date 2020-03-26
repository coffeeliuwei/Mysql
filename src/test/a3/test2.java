package test.a3;

import java.util.List;

import test.pojo.Student;

import com.coffee.DB.DB;

public class test2 {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		String sql = "SELECT id,name,phone FROM student";
		List<Student> rows =  (List<Student>) DB.query(sql, Student.class);
		for(Student stu: rows)
		{
			System.out.println(stu.id + "\t" + stu.name + ", " + stu.birthday);
		}
		Student stu = (Student)DB.get(sql, Student.class);
		if(stu != null)
		{
			System.out.println(stu.id + "\t" + stu.name + ", " + stu.birthday);
		}
		
//		List<String[]> rows = DB.query(sql);
//		
//	    for(String[] row : rows)
//	    {
//	    	// 取出这一行记录
//	    	int id = Integer.valueOf(row[0]);
//	    	String name = row[1];
//	    	String phone = row[2];
//	    	System.out.println(id + "\t" + name + "\t" + phone );	           
//	    }   
	}

}

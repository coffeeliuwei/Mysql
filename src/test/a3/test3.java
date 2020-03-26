package test.a3;

import java.text.SimpleDateFormat;
import java.util.Date;

import test.pojo.Student;

import com.coffee.DB.DB;
import com.coffee.mysql.util.SqlWhere;

public class test3 {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
//		Student pojo=new Student();
//		pojo.setId(202000111);
//		pojo.setName("张飞");
//		pojo.setPhone("1300000001");
//		pojo.setSex(true);
//		pojo.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse("1990-01-02"));
//        DB.insert(pojo);
//        System.out.println(pojo);
		
        ////带输入参数查询演示
        SqlWhere where=new SqlWhere();
        where.add2("name","刘伟").add2("id", 20200001);
        String s="select * from Student";
        s=s+where;
        System.out.println(s);
       Student pojo= (Student) DB.get(s,Student.class);
       System.out.println(pojo.getId()+pojo.getName()+pojo.getPhone()+pojo.getBirthday()+pojo.getSex());
	}

}

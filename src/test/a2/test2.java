package test.a2;

import java.text.DateFormat;

import test.pojo.LeaveEvent;

import com.coffee.mysql.Sql;
import com.coffee.mysql.SqlConnection;

public class test2 {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// 连接MySQL服务器
				SqlConnection conn = new SqlConnection();
				conn.connect("127.0.0.1", 3306, "jsp_db", "root", "111111");
						
				// 日期格式化工具
				DateFormat df = Sql.dateFormat();
				
				// 创建POJO对象并赋值
				LeaveEvent row = new LeaveEvent();
				row.setStuId(20190001);
				row.setDaysFrom( df.parse("2020-07-05"));
				row.setDaysTo( df.parse("2020-07-10"));
				row.setType((byte)1);
				row.setReason("休息");
				
				// 将POJO插入到数据库
				conn.insert( row );
				System.out.println("主键ID=" + row.getId());
				
				//////////////////////////////////////////////
			    conn.close();
				System.out.println("关闭连接!");

	}

}

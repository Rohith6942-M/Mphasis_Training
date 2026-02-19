package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
	
	public static Connection getCon()
	{
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/rohith";
		String user = "root";
		String pas = "root@39";
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,user,pas);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}
	
	public void saveStudent(Student st)
	{
		try {
			String sql = "insert into student(id,emp_name,college,city) values(?,?,?,?);";
			Connection con = StudentDao.getCon();
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, st.getId());
			pst.setString(2, st.getName());
			pst.setString(3, st.getClg());
			pst.setString(4, st.getCity());
			pst.execute();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public List<Student> getAllStudents()
	{
		List<Student>stList = new ArrayList<>();
		try {
			String sql = "select * from student";
			PreparedStatement pst = StudentDao.getCon().prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				Student st = new Student();
				st.setId(rs.getInt(1));
				st.setName(rs.getString(2));
				st.setClg(rs.getString(3));
				st.setCity(rs.getString(4));
				stList.add(st);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return stList;
		
	}
	
	public void updateStudent(Student st)
	{
		try {
			String sql = "update student set emp_name = ?, college = ?, city = ? where id = ?";
			PreparedStatement pst = StudentDao.getCon().prepareStatement(sql);
			pst.setString(1,  st.getName());
			pst.setString(2,  st.getClg());
			pst.setString(3, st.getCity());
			pst.setInt(4, st.getId());
			pst.execute();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void deleteStudent(int id)
	{
		try {
			String sql = "delete from student where id = ?";
			PreparedStatement pst = StudentDao.getCon().prepareStatement(sql);
			pst.setInt(1, id);
			pst.execute();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}

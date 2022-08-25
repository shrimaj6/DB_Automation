package com.qa.db.automation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class DB_Test extends Base_Class{
	@Test
	public void getTableData() throws SQLException {
		con = this.setUp();
		//Statement Object to send queries.
		Statement stmt = con.createStatement();
		ResultSet rs=stmt.executeQuery("Select * from student2");
		while (rs.next())
	    {
	        int Id =rs.getInt(1);
	        String FirstName=rs.getString(2);
	        String LastName =rs.getString(3);
	        String City =rs.getString(4);
	        System.out.println(Id+"  "+FirstName+"  "+LastName+ " "+City);
	    }
	}
		@Test
		 public void insertData() throws SQLException {
			 con=this.setUp();
			 PreparedStatement ps = con.prepareStatement("insert into student2 values(?,?,?,?)");
			 ps.setInt(1,8);
			 ps.setString(2, "hitesh");
			 ps.setString(3, "lad");
			 ps.setString(4, "nagpur");
			 ps.executeUpdate();
			 getTableData();
		 }
		
		@Test 
		 
		 public void updateTableData () throws SQLException {
			con=this.setUp();
			 PreparedStatement ps = con.prepareStatement("update student2 set FirstName = ? where Id = ?");
			 ps.setString(1, "Om");
			 ps.setInt(2, 2);
			 ps.executeUpdate();
			 getTableData(); 
		 }
		
		@Test
		
		public void deleteTaleData() throws SQLException {
			 con=this.setUp();
			 PreparedStatement ps = con.prepareStatement("delete from student2 where Id= ?");
			 ps.setInt(1, 4);
			 ps.executeUpdate();
			 getTableData(); 
			
		}
		
			
		



		
	

}
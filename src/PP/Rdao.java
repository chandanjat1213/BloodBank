package PP;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Rdao {
   
	public Connection con;
	public Connection getcon() throws ClassNotFoundException,SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/blood","root","1213");
	}
	public int addperson(Person p) throws ClassNotFoundException,SQLException
	{
		con = getcon();
		String qr = "insert into bloodbank values(?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(qr);
		ps.setString(1, p.getName());
		ps.setInt(2, p.getAge());
		ps.setString(3, p.getBgroup());
		ps.setString(4, p.getHospital());
		int i = ps.executeUpdate();
		con.close();
		return i;
	}
	public int update(Person p) throws ClassNotFoundException,SQLException
	{
		con=getcon();
		String qr = "update bloodbank set age=?,gruop=?,hospital=? where name=?";
		PreparedStatement ps = con.prepareStatement(qr);
		ps.setInt(1, p.getAge());
		ps.setString(2, p.getBgroup());
		ps.setString(3, p.getHospital());
		ps.setString(4, p.getName());
		int i = ps.executeUpdate();
		con.close();
		return i;
	}
	public int delete(Person p) throws ClassNotFoundException,SQLException
	{
	   con=getcon();
	   String qr = "delete from bloodbank where name=?";
	   PreparedStatement ps = con.prepareStatement(qr);
	   ps.setString(1, p.getName());
	   int i = ps.executeUpdate();
	   con.close();
	   return i;
	}
	public List<Person> show()throws ClassNotFoundException,SQLException
	{
		con=getcon();
		String qr = "select * from bloodbank";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(qr);
		List<Person> al = new ArrayList<Person>();
		while(rs.next())
		{
			Person p = new Person();
			p.setName(rs.getString("name"));
			p.setAge(rs.getInt("age"));
			p.setBgroup(rs.getString("gruop"));
			p.setHospital(rs.getString("hospital"));
			al.add(p);
		}
		return al;
	}
}

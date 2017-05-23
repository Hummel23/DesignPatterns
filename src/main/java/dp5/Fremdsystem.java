package dp5;

import java.sql.*;
import java.util.*;

class Fremdsystem {
	 
	private Connection conn = null;
	private Statement stmt = null;
	
	Fremdsystem(final String user, final String password)
	{
		try
		{
			String DB_URL = "jdbc:mysql://db.f4.htw-berlin.de:3306/_"+user+"__mockupdatadb";
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL,user,password);
		} catch(Exception e)
		{
			e.printStackTrace();		//Handle errors for Class.forName
		}
	}

	private ResultSet getAll(Character firstLetter)
	{
		ResultSet rs = null;
		char firstLetterToUpperCase = Character.toUpperCase(firstLetter);
		try
		{
			System.out.print(firstLetterToUpperCase +" ");
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM mockupdatatable WHERE nachname LIKE '"+firstLetterToUpperCase+"%'");

		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		return rs;
	}
	
	Map<Integer, String> createMap(Character ch)
	{
		Map<Integer, String> map = new HashMap<>();
		try 
		{
			ResultSet rs = this.getAll(ch);

			while(rs.next())
			{
				int id  = rs.getInt("id");
				String vorname = rs.getString("vorname");
				String nachname = rs.getString("nachname");

				map.put(id, vorname+" "+nachname);
			}
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		return map;
	}

	// nur für Testzwecke
//	public void printAll(Character c)
//	{
//		try
//		{
//			ResultSet rs = this.getAll(c);
//
//			while(rs.next())
//			{
//				int id  = rs.getInt("id");
//				String vorname = rs.getString("vorname");
//				String nachname = rs.getString("nachname");
//				String email = rs.getString("email");
//				String ipnr = rs.getString("ipnr");
//
//				System.out.printf("%3d  %-10s %-12s %-30s %-10s %n", id, vorname, nachname, email, ipnr);
//			}
//		}
//		catch(SQLException se)
//		{
//			se.printStackTrace();
//		}
//	}

	void close()
	{
		try{
			stmt.close();
			conn.close();
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		System.out.println("Goodbye!");
	}
}

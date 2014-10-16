package sql;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;

public class Query {
	static public boolean Book(int c1, String c2, int c3, String c4, Date c5,
			double c6) {
		try {
			SqlCon sqlC = new SqlCon();
			sqlC.setWrite();
			System.out.println("New SqlCon(1) over");
			Connection conn = sqlC.getConn();
			System.out.println("getConn Over");
			Statement statement = conn.createStatement();
			System.out.println("conn.createStatement() OVER");
			if (sqlC.isOnline() == false) {
				statement.executeQuery("use bookdb");
				System.out.println("use bookdb");
			}
			String ss = String.format(
					"insert into book values(%d,\'%s\',%d,\'%s\',\'%s\',%f)",
					c1, c2, c3, c4, c5.toString(), c6);
			System.out.println(ss);
			statement.executeUpdate(ss);
		} catch (SQLException e) {
			// e.printStackTrace();
			System.out.println("NewBook Error");
			return false;
		}
		return true;
	}

	static public boolean UpBook(int c1, String c2, int c3, String c4, Date c5,
			double c6) {
		try {
			SqlCon sqlC = new SqlCon();
			sqlC.setWrite();
			System.out.println("New SqlCon(1) over");
			Connection conn = sqlC.getConn();
			System.out.println("getConn Over");
			Statement statement = conn.createStatement();
			System.out.println("conn.createStatement() OVER");
			if (sqlC.isOnline() == false) {
				statement.executeQuery("use bookdb");
				System.out.println("use bookdb");
			}
			String ss = String
					.format(
							"update book set Title=\'%s\',AuthorID=\'%d\',Publisher=\'%s\',PublishDate=\'%s\',Price=%f where ISBN=%d",
							c2, c3, c4, c5.toString(), c6, c1);
			System.out.println(ss);
			statement.executeUpdate(ss);
		} catch (SQLException e) {
			// e.printStackTrace();
			System.out.println("NewBook Error");
			return false;
		}
		return true;
	}

	static public boolean Author(int c1, String c2, int c3, String c4) {
		SqlCon sqlC = new SqlCon();
		sqlC.setWrite();
		Connection conn = sqlC.getConn();
		try {
			Statement statement = conn.createStatement();
			if (sqlC.isOnline() == false)
				statement.executeUpdate("use bookdb");
			String ss = String.format(
					"insert into author values(%d,\'%s\',%d,\'%s\')", c1, c2,
					c3, c4);
			System.out.println(ss);
			statement.executeUpdate(ss);
		} catch (SQLException e) {
			// e.printStackTrace();
			System.out.println("NewBook Error");
			return false;
		}
		return true;
	}

	static public boolean DelBook(int c1) {
		try {
			SqlCon sqlC = new SqlCon();
			sqlC.setWrite();
			System.out.println("New SqlCon(1) over");
			Connection conn = sqlC.getConn();
			System.out.println("getConn Over");
			Statement statement = conn.createStatement();
			System.out.println("conn.createStatement() OVER");
			if (sqlC.isOnline() == false) {
				statement.executeQuery("use bookdb");
				System.out.println("use bookdb");
			}
			String ss = String.format("delete from book where ISBN=%d", c1);
			System.out.println(ss);
			statement.executeUpdate(ss);
		} catch (SQLException e) {
			// e.printStackTrace();
			System.out.println("DelBook Error");
			return false;
		}
		return true;
	}

}

package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.sina.sae.util.SaeUserInfo;

/**
 * �������Ϊ0Ϊ����Ϊ����Ϊд
 */
public class SqlCon {
	private boolean online = false;///�������������ͬ
	
	final static private String driver = "com.mysql.jdbc.Driver";
	final static private int WAIT = 10;
	final static private String URLW = "jdbc:mysql://w.rdc.sae.sina.com.cn:3307/app_yuiffy";
	final static private String URLR = "jdbc:mysql://r.rdc.sae.sina.com.cn:3307/app_yuiffy";
	final static private String PASSWORD = "1234567";

	static private String user = SaeUserInfo.getAccessKey();
	static private String password = SaeUserInfo.getSecretKey();
	private String url = URLR;
	private Connection conn;

	public SqlCon() {
		if(!isOnline()){
			url = "jdbc:mysql://localhost:3306/Mysql";
			user = "root";
			password = PASSWORD;
		}
		System.out.println("正在准备连接MySQL");
		try {
			Class.forName(driver).newInstance();
		} catch (InstantiationException e2) {
			e2.printStackTrace();
		} catch (IllegalAccessException e2) {
			e2.printStackTrace();
		} catch (ClassNotFoundException e2) {
			e2.printStackTrace();
		}
		DriverManager.setLoginTimeout(WAIT);
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e1) {
			e1.printStackTrace();
			System.out.println("SqlCon���ӷ�����������");
		}
		System.out.println("SqlCon Over!");
	}

	/**
	 * @param x
	 *            Ϊ0Ϊ��������Ϊд
	 */
	public void setWrite() {
		if (isOnline()) {
			this.url = SqlCon.URLW;
			try {
				conn = DriverManager.getConnection(url, user, password);
			} catch (SQLException e1) {
				e1.printStackTrace();
				System.out.println("SqlCon����д������������");
			}
		}
	}

	public Connection getConn() {
		return this.conn;
	}

	public void setOnline(boolean online) {
		this.online = online;
	}

	public boolean isOnline() {
		return this.online;
	}

}

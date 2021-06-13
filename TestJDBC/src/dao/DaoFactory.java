package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoFactory {


	public static MemberDao createMemberDao() {
		return new MemberDaoImpl(establishedConnection());
	}

	private static void driverLoad() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("JDBCドライバをロード出来ません。");
		}
	}

	private static Connection establishedConnection() {
		driverLoad();
		Connection con=null;

		try {
			con= DriverManager.getConnection(
				"jdbc:mysql://localhost/mydb","root","bump0307"
				);
		} catch (SQLException e) {
			System.out.println("コネクションオブジェクトを取得出来ません。");
		}
		return con;

	}
}

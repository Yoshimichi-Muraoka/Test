package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DbTest")
public class DbTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DbTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Connection con =null;

		try {
			Class.forName("com.mysql.jdbc.Driver");]
		} catch (ClassNotFoundException e) {
			System.out.println("JDBCドライバをロード出来ません。");
		}


		try {
			con = DriverManager.getConnection(
				"jdbc:mysql://localhost/mydb","root","bump0307"
			);
			request.getRequestDispatcher("/WEB-INF/test.jsp")
			.forward(request, response);
		} catch (SQLException e) {
			System.out.println("コネクションオブジェクトを取得出来ません。");
		} finally {
			try {
				if(con!=null) {
					con.close();
				}
			} catch (SQLException e) {
				System.out.println("コネクションを切断出来ませんでした。");
			}
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}

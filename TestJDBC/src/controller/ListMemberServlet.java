package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoFactory;
import dao.MemberDao;
import domain.Member;

/**
 * Servlet implementation class ListMemberServlet
 */
@WebServlet("/ListMemberServlet")
public class ListMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public ListMemberServlet() {

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		      MemberDao memberDao = DaoFactory.createMemberDao();
		      List<Member> memberList = memberDao.findAll();
		      request.setAttribute("memberList", memberList);
		      request.getRequestDispatcher("/WEB-INF/listMember.jsp")
		          .forward(request, response);
		    } catch (Exception e) {
		      throw new ServletException(e);
		    }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}

package jp.co.aforce.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.dao.MemberDAO;

/**
 * Servlet implementation class Delete
 */
@WebServlet("/controller/delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		MemberDAO dao = new MemberDAO();
		
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			int line = dao.deleteMember(id);
			request.setAttribute("message", "削除が完了しました。");
		} catch(Exception e) {
			request.setAttribute("message", "削除に失敗しました。");
		}
		request.getRequestDispatcher("../views/menu.jsp")
			.forward(request, response);
	}

}

package jp.co.aforce.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.dao.MemberDAO;
import jp.co.aforce.model.Member;

/**
 * Servlet implementation class FormValue
 */
@WebServlet("/controller/form-value-delete")
public class FormValueDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		MemberDAO dao = new MemberDAO();
		
		Member member = null;
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			member = dao.getMember(id);
		} catch(Exception e) {
			request.setAttribute("message", "入力されたIDは存在しません。");
			request.getRequestDispatcher("../views/menu.jsp")
				.forward(request, response);
			return;
		}
		request.setAttribute("member", member);
		request.getRequestDispatcher("../views/delete-member-valued.jsp")
			.forward(request, response);
	}

}

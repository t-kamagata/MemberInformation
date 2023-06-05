package jp.co.aforce.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.dao.MemberDAO;
import jp.co.aforce.model.Member;

/**
 * Servlet implementation class Update
 */
@WebServlet("/controller/update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		Member member = new Member();
		int id = Integer.parseInt(request.getParameter("id"));
		member.setId(id);
		member.setLast_name(request.getParameter("last_name"));
		member.setFirst_name(request.getParameter("first_name"));
		member.setSex(request.getParameter("sex"));
		Date date = Date.valueOf(
				request.getParameter("year") + "-" +
				request.getParameter("month") + "-" +
				request.getParameter("day")
			);
		member.setBirth_day(date);
		member.setJob(request.getParameter("job"));
		member.setPhone_number(
				Integer.parseInt(request.getParameter("phone_number"))
			);
		member.setMail_address(request.getParameter("mail_address"));
		
		
		MemberDAO dao = new MemberDAO();
		try {
			int line = dao.updateMember(member);
			
			if(line == 1) {
				request.setAttribute("message", "更新が完了しました。");
			} else {
				request.setAttribute("message", "更新できませんでした。");
			}
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("../views/menu.jsp")
			.forward(request, response);
	}

}

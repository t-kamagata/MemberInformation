<%@page import="jp.co.aforce.model.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
	h3 {
		margin-bottom: 5px;
	}
	a {
		color: black;
		text-decoration: none;
	}
</style>
<body>
	<h1>会員情報削除</h1>
	<form action="../controller/form-value-delete" name="selectForm" method="POST">
		<label>ID: </label>
		<input type="text" name="id" id="id" value="${ member.id }" readonly>
		<button id="formBtn" type="button">取得</button>
	</form>
	<form action="../controller/delete" name="myform" method="POST">
		<input type="hidden" name="id" value="${ member.id }">
		<ul>
			<li>
				<h3>名前</h3>
				<div>
					<label>姓</label>
					<input type="text" value="${ member.last_name }" name="last_name" id="last_name" readonly>
					<label>名</label>
					<input type="text" value="${ member.first_name }" name="first_name" id="first_name" readonly>
				</div>
			</li>
			<li>
				<h3>性別</h3>
				<div>
					<%
						Member member = (Member) request.getAttribute("member");
						boolean isMan = member.getSex().equals("男") ? true : false;
					%>
					<label>男</label>
					<input type="radio" value="男" name="sex" id="male" <%= isMan ? "checked" : "disabled" %>>
					<label>女</label>
					<input type="radio" value="女" name="sex" id="female" <%= !isMan ? "checked" : "disabled" %>>
				</div>
			</li>
			<li>
				<h3>生年月日</h3>
				<div>
					<select name="year">
						<% int year = member.getBirth_day().toLocalDate().getYear(); %>
						<% for(int i = 1920; i <= 2020; i++) { %>
							<option value="<%= i %>" readonly <%= year == i ? "selected" : "disabled" %>><%= i %></option>
						<% } %>
					</select>
					<label>年</label>
					<select name="month">
						<% int month = member.getBirth_day().toLocalDate().getMonth().getValue(); %>
						<% for(int i = 1; i <= 12; i++) { %>
							<option value="<%= String.format("%02d", i) %>"
								readonly <%= month == i ? "selected" : "disabled" %>>
								<%= String.format("%02d", i) %>
							</option>
						<% } %>
					</select>
					<label>月</label>
					<select name="day">
						<% int day = member.getBirth_day().toLocalDate().getDayOfMonth(); %>
						<% for(int i = 1; i <= 31; i++) { %>
							<option value="<%= String.format("%02d", i) %>"
								readonly <%= day == i ? "selected" : "disabled" %>>
								<%= String.format("%02d", i) %>
							</option>
						<% } %>
					</select>
					<label>日</label>
				</div>
			</li>
			<li>
				<h3>電話番号</h3>
				<div>
					<input type="text" readonly value="${ member.phone_number }" name="phone_number" id="phone_number">
				</div>
			</li>
			<li>
				<h3>メールアドレス</h3>
				<div>
					<input type="text" readonly value="${ member.mail_address }" name="mail_address" id="mail_address">
				</div>
			</li>
			<li>
				<h3>職業</h3>
				<div>
					<% String job = member.getJob(); %>
					<select name="job">
						<option readonly value="会社員" <%= job.equals("会社員") ? "selected" : "disabled"%>>
							会社員
						</option>
						<option readonly value="自営業" <%= job.equals("自営業") ? "selected" : "disabled"%>>
							自営業
						</option>
						<option readonly value="学生" <%= job.equals("学生") ? "selected" : "disabled"%>>
							学生
						</option>
						<option readonly value="その他" <%= job.equals("その他") ? "selected" : "disabled"%>>
							その他
						</option>
					</select>
				</div>
			</li>
		</ul>
		<input type="button" id="btn" value="削除">
	</form>
	<div>
		<button><a href="/MemberInformation/views/menu.jsp">戻る</a></button>
	</div>
	<script src="/MemberInformation/js/validator.js"></script>
	<script src="/MemberInformation/js/formValueValidator.js"></script>
</body>
</html>
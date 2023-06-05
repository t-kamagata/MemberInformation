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
	<h1>会員情報登録</h1>
	<form action="../controller/create" name="myform" method="POST">
		<ul>
			<li>
				<h3>名前</h3>
				<div>
					<label>姓</label>
					<input type="text" name="last_name" id="last_name">
					<label>名</label>
					<input type="text" name="first_name" id="first_name">
				</div>
			</li>
			<li>
				<h3>性別</h3>
				<div>
					<label>男</label>
					<input type="radio" value="男" name="sex" id="male">
					<label>女</label>
					<input type="radio" value="女" name="sex" id="female">
				</div>
			</li>
			<li>
				<h3>生年月日</h3>
				<div>
					<select name="year">
						<% for(int i = 1920; i <= 2020; i++) { %>
							<option value="<%= i %>"><%= i %></option>
						<% } %>
					</select>
					<label>年</label>
					<select name="month">
						<% for(int i = 1; i <= 12; i++) { %>
							<option value="<%= String.format("%02d", i) %>"><%= String.format("%02d", i) %></option>
						<% } %>
					</select>
					<label>月</label>
					<select name="day">
						<% for(int i = 1; i <= 31; i++) { %>
							<option value="<%= String.format("%02d", i) %>"><%= String.format("%02d", i) %></option>
						<% } %>
					</select>
					<label>日</label>
				</div>
			</li>
			<li>
				<h3>電話番号</h3>
				<div>
					<input type="text" name="phone_number" id="phone_number">
				</div>
			</li>
			<li>
				<h3>メールアドレス</h3>
				<div>
					<input type="text" name="mail_address" id="mail_address">
				</div>
			</li>
			<li>
				<h3>職業</h3>
				<div>
					<select name="job">
						<option value="会社員">会社員</option>
						<option value="自営業">自営業</option>
						<option value="学生">学生</option>
						<option value="その他">その他</option>
					</select>
				</div>
			</li>
		</ul>
		<input type="button" id="btn" value="登録">
	</form>
	<div>
		<button onclick="document.myform.reset()">リセット</button>
		<button><a href="/MemberInformation/views/menu.jsp">戻る</a></button>
	</div>
	<script src="/MemberInformation/js/validator.js"></script>
</body>
</html>
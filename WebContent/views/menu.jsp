<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% String message = (String) request.getAttribute("message"); %>
	<%if(message != null) { %>
		<h3><%= message %></h3>
	<% } %>
	<div>
		<a href="/MemberInformation/views/create-member.jsp">登録</a>
		<a href="/MemberInformation/views/update-member.jsp">更新</a>
		<a href="/MemberInformation/views/delete-member.jsp">削除</a>
		<a>ログアウト</a>
	</div>
</body>
</html>
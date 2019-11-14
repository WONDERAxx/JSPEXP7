<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<jsp:useBean id="user" class="JavaBean.User"/>
		<jsp:setProperty property="*" name= "user"/>
		<jsp:useBean id="checkuser" class="check.checkUser"/>
		<%
				boolean flag = checkuser.checkUser(user);
				if(flag){
					request.getRequestDispatcher("welcome.jsp").forward(request, response);
				}else{
					request.getRequestDispatcher("error.jsp").forward(request, response);
				}
		%>
</body>
</html>
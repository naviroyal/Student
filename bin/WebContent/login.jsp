<%@page import="com.student.util.Userutil"%>
<%@page import="com.student.bean.CredentialsBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>`
<% 
	String uname = request.getParameter("email");
	String password = request.getParameter("password");
	//System.out.print(uname);
	CredentialsBean cb = new CredentialsBean();
	cb.setUserId(uname);
	cb.setPassword(password);
	Userutil uu = new Userutil();
	String s = uu.login(cb);
	System.out.println(uname+"gcchj");
	if(s.equals("A")){
		cb.setUserType(s);
		session.setAttribute("bean", cb);
		RequestDispatcher rd=request.getRequestDispatcher("admin.jsp");  
		rd.forward(request, response);//method may be include or forward  
	}
	else if(s.equals("T")){
		cb.setUserType(s);
		session.setAttribute("bean", cb);
		RequestDispatcher rd=request.getRequestDispatcher("teacher.jsp");  
		rd.forward(request, response);//method may be include or forward  
	}
	else
	{
		cb.setUserType(s);
		session.setAttribute("bean", cb);
		RequestDispatcher rd=request.getRequestDispatcher("student.jsp");  
		rd.forward(request, response);
	}
		
	
%>
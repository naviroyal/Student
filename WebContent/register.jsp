<%@page import="com.student.bean.ProfileBean"%>
<%@page import="com.student.dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.Date"%>
    
<%
		
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String psw = request.getParameter("password");
		String d = request.getParameter("dob");
		String gender =request.getParameter("gender");
		String street = request.getParameter("street");
		String location = request.getParameter("location");
		String city =request.getParameter("city");
		String state = request.getParameter("state");
		String pincode = request.getParameter("pincode");
		String phone_number =request.getParameter("phone_number");
		String email_address = request.getParameter("email_address");
		String userId=request.getParameter("email_address");
		ProfileBean profileBean = new ProfileBean();
		profileBean.setUserId(userId);
		profileBean.setFirstName(fname);
		profileBean.setLastName(lname);
		profileBean.setPassword(psw);
		profileBean.setDateOfBirth(d);
		profileBean.setGender(gender);
		profileBean.setStreet(street);
		profileBean.setLocation(location);
		profileBean.setCity(city);
		profileBean.setState(state);
		profileBean.setPincode(pincode);
		profileBean.setMobileNo(phone_number);
		profileBean.setEmailId(email_address);
		UserDao ud = new UserDao();
		String s=ud.createUser(profileBean);	
		if(s.equals("Success"))
		{
			System.out.println("Successful");
		}
		else
		{
			System.out.println("UNSuccessful");
		}
%>

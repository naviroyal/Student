package com.student.util;

import com.student.bean.ProfileBean;
import com.student.dao.UserDao;
import com.student.bean.CredentialsBean;
import com.student.dao.CredentialsDao;
import com.student.util.Authentication;

public class Userutil {
	private Authentication auth = new Authentication();
	public String login(CredentialsBean credentialsBean)
	{
		if(auth.authenticate(credentialsBean))
		{
			CredentialsDao cd=new CredentialsDao();
			CredentialsBean cb=cd.findByID(credentialsBean.getUserId());
			String type=cb.getUserType();
			return type;
		}
		return "S";
	}
	public boolean logout(String userId)
	{
		CredentialsBean cb=new CredentialsBean();
		cb.setUserId(userId);
		if(auth.changeLoginStatus(cb,0)) return true;
		return false;
	}
	public String changePassword(CredentialsBean credentialsBean,String newPassword)
	{
		CredentialsBean cb=new CredentialsBean();
		if(auth.authenticate(cb))
		{
			cb.setPassword(newPassword);
			CredentialsDao cd = new CredentialsDao();
			if(cd.updatePassword(cb)) return "S";
		}
		return "F";
	}
	public String register(ProfileBean profileBean, CredentialsBean credentialsBean) {
		UserDao ud = new UserDao();
		CredentialsDao cd = new CredentialsDao();
		if(ud.createUser(profileBean).equals("Success") && cd.createCredential(credentialsBean).equals("Success")) {
			return "S";
		}
		return "F";
	}
}

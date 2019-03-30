package com.student.util;

import com.student.bean.CredentialsBean;
import com.student.bean.ProfileBean;

public interface User {
	String login(CredentialsBean credentialsBean);
	boolean logout(String userId);
	String changePassword(CredentialsBean credentialsBean,String newPassword);
	String register(ProfileBean profileBean, CredentialsBean credentialsBean);
	
}

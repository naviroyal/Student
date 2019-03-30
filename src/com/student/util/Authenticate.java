package com.student.util;

import com.student.bean.CredentialsBean;

public interface Authenticate {
	boolean authenticate(CredentialsBean credentialsBean);
	String authorize(String userId);
	boolean changeLoginStatus(CredentialsBean credentialsBean, int loginStatus);
}

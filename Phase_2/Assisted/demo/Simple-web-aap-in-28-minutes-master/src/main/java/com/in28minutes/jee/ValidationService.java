package com.in28minutes.jee;

public class ValidationService {
	public boolean isUserValid(String user,String password)
	{
		if(user.equals("bhumikaSingh") && password.equals("bhumi123"))
		return true;
		
		return false;
		
	}

}

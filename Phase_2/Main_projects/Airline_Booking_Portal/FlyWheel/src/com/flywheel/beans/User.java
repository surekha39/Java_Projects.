package com.flywheel.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_data")
public class User {
   @Id
   @GeneratedValue(strategy =  GenerationType.AUTO)
   @Column(name = "user_id")
   private int userId;
   @Column(name ="user_mail")
   private String email;

    
   public User() {
	   
   }

public User(String email) {
	super();
	this.email = email;
	
}

public User(int userId, String email) {
	super();
	this.userId = userId;
	this.email = email;
	
}

public int getUserId() {
	return userId;
}

public void setUserId(int userId) {
	this.userId = userId;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}



@Override
public String toString() {
	return "User [email=" + email +  "]";
}


   
}

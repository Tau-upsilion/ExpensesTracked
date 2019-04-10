package com.example.ExpensesTracked_Backend.service.imp;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String name;

    private String email;
    
    private String password;
    
    private String age;
    
    private String gender;
    
    private String token;
    
    private boolean error;
    
    private String error_msg;
    
    public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException{
		return super.clone();
	}

	public User() {
		this.error = false;
    }
	
    
    public User(Integer id, String name, String email, String password, String age, String gender) {
    	this.name = name;
    	this.email = email;
    	this.password = password;
    	this.age = age;
    	this.gender = gender;
    }
    
    public void setGender(String gender) {
    	this.gender = gender;
    }
    public String getGender() {
    	return gender;
    }
    public void setAge(String age) {
    	this.age = age;
    }
    public String getAge() {
    	return age;
    }
    public String getPassword() {
    	return password;
    }
    public void setPassword(String password) {
    	this.password = password;
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getToken() {
		return this.token;
	}
	public void setToken(String token) {
		this.token = token;
	}

	public String getError_msg() {
		return error_msg;
	}

	public void setError_msg(String error_msg) {
		this.error_msg = error_msg;
	}


}
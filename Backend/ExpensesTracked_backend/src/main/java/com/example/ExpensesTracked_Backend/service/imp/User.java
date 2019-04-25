package com.example.ExpensesTracked_Backend.service.imp;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class User implements Cloneable{
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
    
    /**
     * returns error message
     * @return error
     */
    public boolean isError() {
		return error;
	}

    /**
     * sets error message 
     * @param error
     */
	public void setError(boolean error) {
		this.error = error;
	}
	
	/**
	 * clone class
	 */
	@Override
	public Object clone() throws CloneNotSupportedException{
		return super.clone();
	}

	/**
	 * sets user error to false
	 */
	public User() {
		this.error = false;
    }
	
    /**
     * User constructor
     * @param id
     * @param name
     * @param email
     * @param password
     * @param age
     * @param gender
     */
    public User(Integer id, String name, String email, String password, String age, String gender) {
    	this.name = name;
    	this.email = email;
    	this.password = password;
    	this.age = age;
    	this.gender = gender;
    }
    
    /**
     * sets user gender
     * @param gender
     */
    public void setGender(String gender) {
    	this.gender = gender;
    }
    /**
     * returns user's gender
     * @return gender
     */
    public String getGender() {
    	return gender;
    }
    /**
     * sets user's age
     * @param age
     */
    public void setAge(String age) {
    	this.age = age;
    }
    /**
     * returns user's age
     * @return age
     */
    public String getAge() {
    	return age;
    }
    /**
     * returns user's password
     * @return password 
     */
    public String getPassword() {
    	return password;
    }
    /**
     * sets user's password
     * @param password
     */
    public void setPassword(String password) {
    	this.password = password;
    }

    /**
     * gets User's ID
     * @return id
     */
	public Integer getId() {
		return id;
	}

	/**
	 * sets user's ID
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * returns user's name
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * sets user's name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/** 
	 * returns user's email
	 * @return email
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 * sets user's email
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * returns user's token
	 * @return token
	 */
	public String getToken() {
		return this.token;
	}
	/**
	 * sets user's token 
	 * @param token
	 */
	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * returns error message
	 * @return error_msg
	 */
	public String getError_msg() {
		return error_msg;
	}

	/**
	 * sets error message for user
	 * @param error_msg
	 */
	public void setError_msg(String error_msg) {
		this.error_msg = error_msg;
	}


}
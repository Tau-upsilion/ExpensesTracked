package com.example.ExpensesTracked_Backend;
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
    
    private Integer age;
    
    private String gender;
    
    private String token;
    
    public void setGender(String gender) {
    	this.gender = gender;
    }
    public String getGender() {
    	return gender;
    }
    public void setAge(Integer age) {
    	this.age = age;
    }
    public Integer getAge() {
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


}
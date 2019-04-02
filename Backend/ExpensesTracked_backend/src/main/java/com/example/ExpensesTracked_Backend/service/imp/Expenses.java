package com.example.ExpensesTracked_Backend;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class Expenses {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    
    private String description;
    
	private String category;

    private String expensesName;
    
    private int userId;

    private int amount;
    
    private String token;
    public void setId(Integer i) {
    	this.id = i;
    }
    public Integer getId() {
    	return this.id;
    }
    public void setExpensesname(String n) {
    	this.expensesName = n; 
    }
    public void setAmount(int m) {
    	this.amount = m;
    }
    public int getAmount() {
    	return this.amount;
    }
    public String getExpensesName() {
    	return this.expensesName;
    }
    public int getUserID() {
    	return this.userId;
    }
    public void setUserID(int i) {
    	this.userId = i;
    }
    public String getToken() {
    	return this.token;
    }
    public void setToken(String token) {
    	this.token = token;
    }
    public String randomToken() {
    	String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    	
    	int lower = 10;
    	int upper = 20;
    	
    	int n = (int) (Math.random() * (upper - lower)) + lower;
    	
    	StringBuilder sb = new StringBuilder(n);
    	
    	for (int i = 0; i < n; i++)
    	{
    		int index = (int) ((int) characters.length() * Math.random()); 
    		
    		sb.append(characters.charAt(index));
    	}
    	token = sb.toString();
    	return token;
    }
    public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}

}
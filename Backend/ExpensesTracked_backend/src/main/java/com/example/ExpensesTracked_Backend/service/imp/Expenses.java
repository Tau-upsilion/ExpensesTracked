package com.example.ExpensesTracked_Backend.service.imp;
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

    private String amount;
    
    private String token;
    
    private boolean error;
    
    private String error_msg;
   
    
    /**
     * expenses constructor
     * @param description
     * @param category
     * @param expensesName
     * @param amount
     * @param token
     */
    public Expenses(String description, String category, String expensesName, String amount, String token) {
    	this.description = description;
    	this.category = category;
    	this.expensesName = expensesName;
    	this.amount = amount;
    	this.token = token;
    	this.error = false;
    }
    /**
	 * sets ID
	 * @param id
	 */
    public void setId(Integer i) {
    	this.id = i;
    }
    /**
     * gets ID
     * @return id
     */
    public Integer getId() {
    	return this.id;
    }
    /**
     * sets expense's name
     * @param n
     */
    public void setExpensesname(String n) {
    	this.expensesName = n; 
    }
    /**
     * sets expense amount
     * @param m
     */
    public void setAmount(String m) {
    	this.amount = m;
    }
    /**
     * returns expense amount
     * @return amount
     */
    public String getAmount() {
    	return this.amount;
    }
    /**
     * returns expense name
     * @return expense name
     */
    public String getExpensesName() {
    	return this.expensesName;
    }
    /**
     * returns user's ID
     * @return userID
     */
    public int getUserID() {
    	return this.userId;
    }
    /**
     * sets User's ID
     * @param i
     */
    public void setUserID(int i) {
    	this.userId = i;
    }
    /**
     * returns token
     * @return token 
     */
    public String getToken() {
    	return this.token;
    }
    /**
     * sets Token
     * @param token
     */
    public void setToken(String token) {
    	this.token = token;
    }
    /**
     * creates a random token to be used
     * @return
     */
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
    /**
     * returns expense description
     * @return description
     */
    public String getDescription() {
		return description;
	}
    /**
     * sets expense description
     * @param description
     */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * returns category
	 * @return category
	 */
	public String getCategory() {
		return category;
	}
	/**
	 * sets category
	 * @param category
	 */
	public void setCategory(String category) {
		this.category = category;
	}
/**
 * returns true if there is an error, false otherwise
 * @return error
 */
	public boolean isError() {
		return error;
	}

	/**
	 * sets error, true if there is an error, false otherwise
	 * @param error
	 */
	public void setError(boolean error) {
		this.error = error;
	}

	/**
	 * returns error message
	 * @return error_msg
	 */
	public String getError_msg() {
		return error_msg;
	}

	/**
	 * sets the error message
	 * @param error_msg
	 */
	public void setError_msg(String error_msg) {
		this.error_msg = error_msg;
	}

}
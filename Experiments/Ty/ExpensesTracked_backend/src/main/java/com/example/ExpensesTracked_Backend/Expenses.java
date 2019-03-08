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
    

}
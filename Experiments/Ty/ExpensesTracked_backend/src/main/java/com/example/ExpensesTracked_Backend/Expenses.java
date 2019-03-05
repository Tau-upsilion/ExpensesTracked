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

    private String Expensesname;

    private int amount;
    
    public void setExpensesname(String n) {
    	this.Expensesname = n; 
    }
    public void setAmount(int m) {
    	this.amount = m;
    }
    public int getAmount() {
    	return this.amount;
    }
    public String expensesName() {
    	return this.Expensesname;
    }
    
    

}
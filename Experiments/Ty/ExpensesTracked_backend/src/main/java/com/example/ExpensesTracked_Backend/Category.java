package com.example.ExpensesTracked_Backend;

//Main controller: git mapping and URL for all catergories

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Category {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String categoryName;
	
    public void setId(Integer i)
    {
    	this.id = i;
    }
    
    public Integer getId()
    {
    	return this.id;
    }
    
    public void setCategoryName(String n)
    {
    	this.categoryName = n; 
    }
    
    public String getCategoryName()
    {
    	return this.categoryName;
    }
}

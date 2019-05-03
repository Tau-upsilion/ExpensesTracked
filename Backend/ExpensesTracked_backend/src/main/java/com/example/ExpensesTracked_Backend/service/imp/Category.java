package com.example.ExpensesTracked_Backend.service.imp;

import javax.persistence.Entity;


//Main controller: git mapping and URL for all catergories

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Category Class
 *
 */
@Entity
public class Category {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String categoryName;
    
    private String categoryType;
    
    private String date;
    
    /**
     * Category Constructor
     * @param id
     * @param categoryName
     * @param date
     * @param categoryType
     */
    public Category (Integer id, String categoryName, String date, String categoryType)
    {
    	this.id = id;
    	this.categoryName = categoryName;
    	this.categoryType = categoryType;
    	this.date = date;
    }
	
    /**
     * sets ID
     * @param i
     */
    public void setId(Integer i)
    {
    	this.id = i;
    }
    
    /**
     * gets ID
     * @return id
     */
    public Integer getId()
    {
    	return this.id;
    }
    
    /**
     * sets Category Name
     * @param n
     */
    public void setCategoryName(String n)
    {
    	this.categoryName = n; 
    }
    
    /**
     * returns category name
     * @return categoryName
     */
    public String getCategoryName()
    {
    	return this.categoryName;
    }
    
    public void setCategoryDate (String d)
    {
    	this.date = d;
    }
    
    public String getCategoryDate()
    {
    	return this.date;
    }
    
    public void setCategoryType (String type)
    {
    	this.categoryType = type;
    }
    
    public String getCategoryType()
    {
    	return this.categoryType;
    }
}

// ELEC 279 Assignment 1 Dawson Tilley | 20053139
package com.example.guessmaster;
public class Date {
private int day;
private int month;
private int year;
// Date instance variables followed by default constructor
Date(){
	day=1;
	month=1;
	year=1;
	
}
// Date Constructor that creates Date based off of year, month, day inputs
Date(int day,int month,int year){
	this.day=day;
	this.month=month;
	this.year=year;
}
// Date Copy Constructor
Date(Date copyDate){
	this.day=copyDate.day;
	this.month=copyDate.month;
	this.year=copyDate.year;	
	
}
// Date Constructor that creates a Date Class Obj from string in form DD/MM/YYYY
Date(String inDate){
	this.day=Integer.parseInt(inDate.substring(0, 2));
	this.month=Integer.parseInt(inDate.substring(3,5));
	this.year=Integer.parseInt(inDate.substring(6));
			
}
// Day accessor method
public int getDay() {
	return this.day;
}
//Month Accesor Method
public int getMonth() {
	return this.month;
}
// Year Accessor method
public int getYear() {
	return this.year;
}
// Date equals method checks if two date objects are same date
public boolean equals(Date othDate) {
	if (this.day==othDate.day && this.month==othDate.month && this.year ==othDate.year) {
		//System.out.println("Strings are Equal");
		return true ;
	}
	else {
		//System.out.println("Strings Not equal");
		return false;
	}
	
}

}

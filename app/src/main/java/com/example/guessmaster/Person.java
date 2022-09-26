// ELEC 279 Assignment 2 Dawson Tilley | 20053139
package com.example.guessmaster;
public abstract class Person {
private String name;
private Date birthday;
private double difficulty;


// instance variable
// constructor given string and date obj
Person(String name, Date birthday, double difficulty){
	this.name= name;
	this.birthday= new Date(birthday);
	this.difficulty = difficulty;
}
// copy constructor 
Person (Person newPerson){
	this.name= newPerson.name;
	this.birthday= new Date(newPerson.birthday);
	this.difficulty = newPerson.difficulty;
	
}
// accessor for name
public String getName() {
	return this.name;
}
// accesor for birthday
public Date getBirthday() {
	return (new Date(this.birthday));
}
// mutator for name
public void setName(String name) {
	this.name= name;
}
// mutator for birthday
public void setBirthday(Date birthday) {
	this.birthday= new Date (birthday);
}
// converts person to return string seen below 
public String toString(Person myPerson) {
	return (myPerson.name+", was born on "+myPerson.birthday.getDay()+" "+ 
myPerson.birthday.getMonth()+", "+ myPerson.birthday.getYear());
		
}
// returns the awardedpoint for a guess
public int getAwardedPointNumber() {
	double diff =  this.difficulty*100;
	 int points= (int) diff;
	 
	 return points;
}
// abstract methods filled in within the singer and politician classes
public abstract String personType() ;
public abstract Person clone();

//start message for each time a new person needs to be guessed
public String startMessage() {
	String XXX= new String (this.personType());
	return ("Guess the Birthday of the "+XXX+" "+this.name);
}
// closing method
public String closingMessage() {
	return ("Congratulations! You were Correct, " +this.toString());
	
}

}

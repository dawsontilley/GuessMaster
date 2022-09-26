// ELEC 279 Assignment 2 Dawson Tilley 20053139
package com.example.guessmaster;
public class Politician extends Person {
private String party;
// this class is extended from person it contains some modified methods
// constructor
Politician(String name, Date birthday, double difficulty, String party){
	super(name,birthday,difficulty);
	this.party=party;
}
// copy constructor
Politician(Politician myObj){
	super(myObj);
	this.party= myObj.party;
} // clone class
public Politician clone() {
	return new Politician (this);
}
// modded toString
public String toString() {
	return (super.toString(this)+". They are a member of the "+this.party+" party.");
}
// person type gives type of person
public String personType() {
	return "Politician";
}
}

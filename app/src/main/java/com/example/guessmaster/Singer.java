// Dawson Tilley 20053139 Assignment 2 ELEC 279
package com.example.guessmaster;
public class Singer extends Person {
private String debutAlbum;
private Date debutAlbum_ReleaseDate;
// singer is a child of person class
// constructor 
Singer(String name, Date birthday, double difficulty,String debutAlbum, Date Release){
	super(name,birthday,difficulty);
	this.debutAlbum=debutAlbum;
	this.debutAlbum_ReleaseDate= Release;
}
// copy constructor 
Singer(Singer myObj){
	super(myObj);
	this.debutAlbum = new String (myObj.debutAlbum);
	this.debutAlbum_ReleaseDate = new Date(myObj.debutAlbum_ReleaseDate);
}
// clone method
public Singer clone() {
	return new Singer(this);
}
// modded toString to include debut album name and release date
public String toString() {
	String superString = super.toString(this);
	return (superString+". Their debut album was "+ this.debutAlbum+", and was released on "+this.debutAlbum_ReleaseDate.getDay()+"/"+this.debutAlbum_ReleaseDate.getMonth()+"/"+this.debutAlbum_ReleaseDate.getYear());
	
} // returns type of person
public String personType() {
	return "Singer";
}

}

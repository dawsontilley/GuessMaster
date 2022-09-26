//Dawson Tilley 20053139 ELEC 279 Lab5
package com.example.guessmaster;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import android.os.Bundle;
import java.util.Arrays ;
import java.util.Scanner;
import java.util.Random;
// import arrays for array, scanner for input and random for random number


public class GuessMaster2 extends AppCompatActivity {
private Person [] people=new Person[1];
private int numPoints=0;
private int numPeople=1;
private TextView personName;
private TextView pointTotal;
private TextView Message;
private Button guessButton;
private EditText guessInput;
private Button changeButton;
private ImageView personImage;
private Person currPerson;

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		guessInput = (EditText) findViewById(R.id.guessEditText);
		guessButton= (Button) findViewById(R.id.GuessButton);
		changeButton = (Button) findViewById(R.id.changeButton);
		personName= (TextView) findViewById(R.id.personNameText);
		Message= (TextView) findViewById(R.id.messageText);
		pointTotal= (TextView) findViewById(R.id.pointTotalText);
		personImage= (ImageView) findViewById(R.id.personImage);
		numPoints=0;

		pointTotal.setText("Total Points: "+numPoints);
		Politician trudeau = new Politician("Justin Trudeau", new Date(25, 12, 1971), 0.25,"Liberal");
		Singer dion = new Singer("Celine Dion", new Date(30, 3, 1961), 0.5, "La voix du bon Dieu", new Date(6, 11, 1981));
		Singer robertson = new Singer("Ed Robertson", new Date(25, 10, 1970), 0.75, "Gordon", new Date(7, 28, 1992));
		addPerson(trudeau);
		addPerson(dion);
		addPerson(robertson);
		Message.setText("Welcome, Let's Start the Game.");
		startGame();
		changeButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick (View v){
				changePerson();
			}
		});
		guessButton.setOnClickListener(new View.OnClickListener(){
		@Override
				public void onClick(View v){
			guess();
			}
		});

		}
public void changePerson(){
		guessInput.getText().clear();
		Message.setText("");
		startGame();
}

	// initalize instance variables
public void addPerson(Person myPerson){
	// takes in a person and adds it to the person array
	people=Arrays.copyOf(people, numPeople);
	people[numPeople-1]= myPerson;
	numPeople  +=1;
}
// this takes in a person from the person array and essentially runs the game
// it prints start message then runs a while loop so the user can keep guessing until they get it right
// once they get it right it prints exit message
public void guess() {
	//Scanner keyboard=new Scanner(System.in); // prep the scanner for checking a users guess
	
	//System.out.println(myPerson.startMessage());

	//boolean correct=false;
	// Start a while loop so the user keeps guessing till they get it right

		// takes the next input of the keyboard
	String guess1= guessInput.getText().toString();
	// checks if user types exit, if they do it exits the game
	if (guess1.contains("quit")) {

		System.exit(0);
	}
	// takes input and makes a date type from the string
	
	Date guess= new Date(guess1);
	// create variables from guess date to compare easier
	int gyear=guess.getYear();
	int gmonth=guess.getMonth();
	int gday=guess.getDay();
	// below are the actual dates for the celeb
	int cyear=currPerson.getBirthday().getYear();
	int cmonth=currPerson.getBirthday().getMonth();
	int cday=currPerson.getBirthday().getDay();
	
	// if the dates equal each other print correct, and change the correct to true
	if (guess.equals(currPerson.getBirthday())){
		Message.setText(currPerson.closingMessage()+ "You Won "+currPerson.getAwardedPointNumber()+" Points in this Round");
		numPoints += currPerson.getAwardedPointNumber();
		pointTotal.setText("Total Points: "+numPoints);
		guessInput.getText().clear();
		startGame();

		//correct=true;
	} // else if check if the year is earlier
	else if (gyear < cyear) {
	Message.setText("Incorrect. Try a later year");
	guessInput.getText().clear();}
	//if year is right check if month is earlier
	else if (gyear==cyear && gmonth<cmonth) {
		Message.setText("Incorrect. Try a later month");
		guessInput.getText().clear();
	}// if year is right and month is right check if day is earlier than correct
	else if (gyear==cyear && gmonth==cmonth && gday<cday) {
		Message.setText("Incorrect. Try a later day");
		guessInput.getText().clear();
	}//do the same process here as above except flip the sign so its for later guesses
	else if (gyear>cyear) {
		Message.setText("Incorrect. Try an earlier year");
		guessInput.getText().clear();
	}
	else if (gyear==cyear && gmonth>cmonth) {
		Message.setText("Incorrect. Try an earlier month.");
		guessInput.getText().clear();
	}
		// 
	else if (gyear==cyear && gmonth==cmonth && gday>cday) {
		Message.setText("Incorrect. Try an earlier day.");
		guessInput.getText().clear();
	}
	//end of while


	
	
	
}
//generate random Order for array to be used in
public int randomOrder() {
	Random rand = new Random();
	int randomNum= rand.nextInt(this.numPeople-1);
	return randomNum;
}
// start game calls random order to get array index then check date to compare user to the stored value
// in while loop so only way out is quit functionality
public void startGame() {
	//System.out.println("Welcome! Let's start the game that critics say is the next big way to procrastinate! .... Its Time for Celeberity Birthday Guessing!");
	//System.out.println("Current Points:"+ numPoints); // prints out starting points
	//System.out.println("PLEASE ENTER DATES IN FORM DD/MM/YYYY or type \"quit\" to exit"); // instructions for game
	// while loop runs the game picking a random person for the user to guess until they type quit
	// it also prints out the points a user guesses each time they get a guess right 

		int guess = randomOrder();
		Person personToGuess= people [guess];

		currPerson= personToGuess.clone();
		personName.setText(currPerson.startMessage());
		if (currPerson.getName().contains("Justin Trudeau")){
			personImage.setImageResource(R.drawable.justin);
		}
		else if (currPerson.getName().contains("Ed Robertson")){
			personImage.setImageResource(R.drawable.ed);
		}
		else{
			personImage.setImageResource(R.drawable.celine);
		}


		//System.out.println("You won "+personToGuess.getAwardedPointNumber() +" points in this round. Your total number of points is "+ numPoints+".");
		//System.out.println("Time for you next Person!");
		
		
		
		
		
		

	
	
	
}
 }

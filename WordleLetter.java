//Author:Elian Pena Ramos
//CS 1101
//TA:Alireza Nouri
//4/22/24
//Instructor:Daniel Mejia
//CL 3
//Wordle
/*
[CS1101] Comprehensive Lab 3
This work is to be done individually. It is not permitted to.
share, reproduce, or alter any part of this assignment for any
purpose. Students are not permitted to share code, upload
this assignment online in any form, or view/receive/
modifying code written by anyone else. This assignment is part.
of an academic course at The University of Texas at El Paso and
a grade will be assigned for the work produced individually by
the student.
*/
public class WordleLetter {
	private char letter;
	private String color;
	//An constructor that receives the letters of the guess word
	public WordleLetter(char letterIn) {
		this.letter = letterIn;
	}
	//A setter that sets the respective color to the guess word's letters (green, yellow and red).
	public void setColor(String color) {
		this.color = color;
	}
	//A boolean method that checks if the a color variable has been set to a color
	public boolean isColorSet() {
		return !(color.equals(null));
	}
	//A boolean method that checks if a letter is green 
	public boolean isGreen() {
		return color.equals("green");
	}

	public String toString() {
		/*
		 * Determine the special characters to add at the beginning of the String
		 * to change the text color to the right color.
		 */
		String colorCode;
		if (color.equals("green")) {
			colorCode = "\u001B[32m";
		} else if (color.equals("yellow")) {
			colorCode = "\u001B[33m";
		} else {
			colorCode = "\u001B[31m";
		}

		/*
		 * These are the special character to add
		 * to the end of the String
		 * to signify the end of the color change.
		 */
		String resetCode = "\u001B[0m";

		/*
		 * Surround the letter with space characters and with
		 * the above color changing special characters.
		 */
		return String.format(
				"%s %s %s",
				colorCode, letter, resetCode);
	}
}

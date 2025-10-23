
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
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordBank {
  //This method is used to get the answer from a file. It receives an integer that the user puts, then, it returns a String with the 
  //answer that is going to be sent to the WordleGame constructor that will send it to the object in the start game
  public static String getAnswerForPuzzleNumber(int puzzleNumber) {
    try {
      /* Create a file scanner to read answers.txt */
      Scanner scanner = new Scanner(new File("answers.txt"));

      /* Skip the first puzzleNumber number of words in the file */
      for (int i = 0; i < puzzleNumber; i++) {
        scanner.next();
      }

      /* Return the very next word */
      return scanner.next();

    } catch (Exception e) {
      /* Handle exception */
      System.out.println("Input/File not found!");
    }
    return null;
  }

  // A method that returns a boolean value if the guessed word does exist in the dictinary file
  public static boolean checkInDictionary(String proposed) {
    try {
      Scanner scanner = new Scanner(new File("dictionary.txt"));
      //A while loop to trasverse the dictionary's words
      while (scanner.hasNextLine()) {
        //When the guess word matches with any of the dictionary words it will return a true value, if not, an false value
        if (scanner.next().equals(proposed)) {
          return true;
        }
      }
    } catch (Exception e) {
      System.out.println("Input/File not found!");
    }
    return false;
  }
}


//Author:Elian Pena Ramos

//4/22/24

//Wordle

import java.io.FileNotFoundException;

public class WordleGame {
  /* allGuesses represents the wordle game */
  private WordleLetter[][] allGuesses = new WordleLetter[6][5];
  //An attribute that storages the answer
  private String answer;
  //An attributes that storages the line number that is being used at the moment
  private int guessLine = 0;
  //An attribute that storages the guess of the user
  private String guessWord = "";
  //An array that holds every character of the current guessed word
  private WordleLetter[] wordleLetters = new WordleLetter[5];
  //A constructor that storages the answer in the variable "answer" using the get function from the WordBnak class.
  //This constructor admits an intefer that is the user's previous input. That input is going to be passed to the function
  // getAnswerForPuzzleNumber() that will return a String answer
  public WordleGame(int puzzleNumber) {
    this.answer = WordBank.getAnswerForPuzzleNumber(puzzleNumber);
  }
  //A getter method for the answer attribute
  public String getAnswer() {
    return this.answer;
  }
  //A method called "guess" that will determinate the color of the letters and count the number of the current line
  public void guess(String guessWord) {
    //This sets the user's guess into a variable that can be used outside this method
    this.guessWord = guessWord;
    //A for loop that will trasverse every single letter of a valid guess
    for (int i = 0; i < 5; i++) {
      //This for loop will create an new object using the "WordleLetter" constructor every time it is used, 
      //those objects are going to be storaged in an 2D array. It storages char values each one being one of the word's letters
      this.allGuesses[this.guessLine][i] = new WordleLetter(guessWord.charAt(i));
      //This if condition will check if the letters of the guess word (each one of them storaged in a 2D array)
      // are the same as the answer, if they are the same they will set the letter to green
      if (guessWord.charAt(i) == this.getAnswer().charAt(i)) {
        this.allGuesses[this.guessLine][i].setColor("green");
        //if the letter does not match the same position as the answer's letter, but the letter is in somewhere of the word then it
        //will set the letter to yellow. A contains() function is used in order to know if the letter is inside the array
      } else if (this.getAnswer().contains("" + guessWord.charAt(i))) {
        this.allGuesses[this.guessLine][i].setColor("yellow");
      } else {
        //If the word's letter from the user's guess does not exist in the answer, the letter would be red
        this.allGuesses[this.guessLine][i].setColor("red");
      }
    }
    //This variable adds +1 each time this function is used, it keeps track of the current used line
    this.guessLine++;
  }
  //A method that returns the number of guesses so far
  public int getNumberGuessesSoFar() {
    return this.guessLine;
  }
  //This method returns the an array with the spelling of the guessed word from the user
  public WordleLetter[] getGuess(int guessNumber) {
    for (int j = 0; j < 5; j++) {
      this.wordleLetters[j] = this.allGuesses[guessNumber][j];
    }
    return this.wordleLetters;
  }
  //This method will return a true boolean value if the game has been won or if all the rows are full. This will end the game.
  public boolean isGameOver() {
    return isGameWin() || this.guessLine == 6;
  }
//If the user wins, this method will return a true boolean value. This happens when the guess word and the answer are the same word;
//the user guessed the word correctly
  public boolean isGameWin() {
    return this.guessWord.equals(this.answer);
  }

  public String toString() {
    /* result will be used to build the full answer String */
    String result = "";
    /* for each word guessed so far */
    for (int i = 0; i < getNumberGuessesSoFar(); i++) {
      /* get each letter of each word */
      for (int j = 0; j < 5; j++) {
        /* concatenate it to the result */
        /* WordleLetter's toString() is automatically invoked here. */
        result += getGuess(i)[j];
      }
      /* new line separator between each word */
      result += "\n";
    }
    return result;
  }
}

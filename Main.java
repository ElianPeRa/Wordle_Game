
//Author:Elian Pena Ramos
//Run the Main class that will execute all other
//4/22/24
//Wordle
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    //This is a method that helps to ensure that the numbers that the user inputs are in fact numbers and are valid
    //it has a String as a parameter so it can be able to storage any character and with it 
    public static boolean validNumber(String n) {
        //it starts with a for loop, then, it iterates every single character and checks that the characters are numbers with a if
        //conditional, if there is something that is not a number it will return false
        for (int i = 0; i < n.length(); i++) {
            if ('9' < n.charAt(i) || n.charAt(i) < '0') {
                System.out.println("Input another number please");
                return false;
            }
        }
        //when the characters are verificated numbers, they will be converted to an integer, in that datatype it is possible to
        //check if the number is in the correct range valid numbers using a conditional
        int m = Integer.parseInt(n);
        if (m > -1 && m < 2316) {
            return true;
        }
        //This method will return a boolean, if the condicions are met it will be true, if not, it will return a false
        return false;
    }

    /* Do not modify the method signature. */
    public static WordleGame startGame(Scanner scanner) {
        System.out.println("Welcome to Wordle ^_____^ /n Plese enter a number between 0-2315");
        String number = scanner.nextLine();
        //validNumber is a method that will return a boolean if the number is valid. it has a "!" so in case that the function
        //returns a false the while loop can executed and it will ask the user to try again.
        while (!validNumber(number)) {
            number = scanner.nextLine();
            System.out.println("Please try with a valid number please");
        }
        int correctNumber = Integer.parseInt(number);
        //This instance creates an object in the class "WordleGame", it will get the answer (the word that has to be guessed) from the
        //WordleLetter class that is going to get the anser from the WordBank class
        WordleGame puzzle = new WordleGame(correctNumber);
        //The object is going to be returned into the "game" object
        return puzzle;
    }

    /* Do not modify the method signature. */
    //A function that asks for a guess and displays the game board
    public static void playGame(Scanner scanner, WordleGame game) {
        //A while loop that is used to check if the game is over or won, either way the game ends
        while (!game.isGameOver()) {
            System.out.println("Write a word with 5 letters please");
            //the funciont toLowerCase is used so it can make easier to work with the chars and Strings
            String guessWord = scanner.nextLine().toLowerCase();
            //This while loop has a function as condition that checks if the guessed word exists in the dictionary,
            // the function will return a boolean, if the word does not exist then it will ask the user for another input until 
            //the player inputs something valid
            while (!WordBank.checkInDictionary(guessWord)) {
                System.out.println("Try again another word please");
                guessWord = scanner.nextLine().toLowerCase();
            }
            //This object is used with a function that will recive the user's word and it will check each one of its letters
            game.guess(guessWord);
            //This print prints the current guesses
            System.out.println(game.toString());
        }
    }

    /* Do not modify the method signature. */
    public static void reportGameOutcome(WordleGame game) {
        //This if condition will print a message in case that the user gussed correctly the word
        if (game.isGameWin()) {
            System.out.println("YOU WON!!!!!!!! ^_^");
        }
        //This condition will print a message indicating that the game is over and the user lost
        if (game.isGameOver()) {
            System.out.println("The answer was " + game.getAnswer());
        }
    }

    /* This main method body should not be modified. */
    public static void main(String[] args) {
        /*
         * Only use this Scanner for user input, do not create new ones via new
         * Scanner(System.in).
         */
        Scanner scanner = new Scanner(System.in);
        //creation of the object that is going to be used so the user can play
        WordleGame game = startGame(scanner);
        //Functions that are called so the game can start
        playGame(scanner, game);
        reportGameOutcome(game);
    }
}

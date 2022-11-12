import java.util.Arrays;
import java.util.Scanner;

public class Hangman {

    public static String[] words = {"ant", "baboon", "badger", "bat", "bear", "beaver", "camel",
    "cat", "clam", "cobra", "cougar", "coyote", "crow", "deer",
    "dog", "donkey", "duck", "eagle", "ferret", "fox", "frog", "goat",
    "goose", "hawk", "lion", "lizard", "llama", "mole", "monkey", "moose",
    "mouse", "mule", "newt", "otter", "owl", "panda", "parrot", "pigeon", 
    "python", "rabbit", "ram", "rat", "raven","rhino", "salmon", "seal",
    "shark", "sheep", "skunk", "sloth", "snake", "spider", "stork", "swan",
    "tiger", "toad", "trout", "turkey", "turtle", "weasel", "whale", "wolf",
    "wombat", "zebra"};

    public static String[] gallows = {"+---+\n" +
    "|   |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    "+---+\n" +
    "|   |\n" +
    "O   |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    "+---+\n" +
    "|   |\n" +
    "O   |\n" +
    "|   |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|   |\n" +
    "     |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" + //if you were wondering, the only way to print '\' is with a trailing escape character, which also happens to be '\'
    "     |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" +
    "/    |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" + 
    "/ \\  |\n" +
    "     |\n" +
    " =========\n"};

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String word = randomWord();
        // Need to replace the word with '_'
        char[] placeholders = new char[word.length()];
        for (int i = 0; i < placeholders.length; i++) {
            placeholders[i] = '_';
        }
        // System.out.println(Arrays.toString(placeholders));

        int missedChances = 0;
        int lives = gallows.length - 1; 
        // lives/turns are 6
        char[] missedGuesses = new char[lives];

        while (missedChances < lives) {
            // Print Gallows
            System.out.println(gallows[missedChances]);
            // for testing
            System.out.println(word);

            // Print Word placeholder
            System.out.print("Word:\t");
            printPlaceholders(placeholders);
            System.out.print("\n");

            // Print Misses
            System.out.print("Misses:\t");
            printMissedGuesses(missedGuesses);
            System.out.print("\n");

            System.out.print("Guess:\t");
            // there is no scan.nextChar
            char guess = scan.nextLine().charAt(0);
            System.out.print("\n");
            
            // Checking guess with the word
            if (checkGuess(word, guess)) {
                updatePlaceholders(guess, placeholders, word);
                printPlaceholders(placeholders);
            } else {
                missedGuesses[missedChances] = guess;
                // System.out.println(Arrays.toString(missedGuesses));
                missedChances++;
            }
            

        }

        


        
        


        
        
        
        scan.close();





    }

    public static String randomWord() {
        int numOfWords = words.length;
        int wordIndex = (int) (Math.random() * numOfWords);
        return words[wordIndex];
    }

    public static void printPlaceholders(char[] placeholders) {
        for (int i = 0; i < placeholders.length; i++) {
            System.out.print(placeholders[i] + " ");
        }
        System.out.print("\n");
    }

    public static void printMissedGuesses(char[] missedGuesses) {
        for (int i = 0; i < missedGuesses.length; i++) {
            System.out.print(missedGuesses[i]);
        }
    }

    public static boolean checkGuess(String word, char guess) {
        for (int i = 0; i < word.length(); i++) {
            if (guess == word.charAt(i)) {
                return true;
            }
        }
        return false;
    }

    public static void updatePlaceholders(char guess, char[] placeholder, String word) {
        for (int i = 0; i < placeholder.length; i++) {
            if (guess == word.charAt(i)) {
                placeholder[i] = guess;
            }
        }
    }

}






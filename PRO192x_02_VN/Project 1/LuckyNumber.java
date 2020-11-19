import java.util.Scanner;

public class LuckyNumber {
    public static int totalGames = 0; //tong so game choi
    public static int totalGuesses = 0; // tong so lan doan
    public static int bestGame = Integer.MAX_VALUE; //so lan doan it nhat
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        boolean reset;
        do {
            play();
            System.out.print("Do you want to play again? ");
            String playAgain = input.next();
            //neu nguoi choi chon y, yes, Y, YES thi choi lai
            if (playAgain.toLowerCase().equals("y") || playAgain.toLowerCase().equals("yes")) {
                System.out.println();
                reset = true;
            } else {
                reset = false;
            }
        } while (reset);
        report();
    }
    public static void play() {
        totalGames++;
        System.out.println("I'm thinking of a number between 1 and 100...");
        long numLucky = Math.round(Math.random() * 100);
        int guessPerGame = 0; //so lan doan moi game
        boolean guessAgain = true;
        int numGuess;
        System.out.print("Your guess? ");
        do {
            if (input.hasNextInt()) {
                //neu la so nguyen
                numGuess = input.nextInt();
                guessPerGame++;
                totalGuesses++;
                // lap lai vong lap neu doan sai
                if (numGuess < numLucky) {
                    System.out.println("It's lower.");
                    System.out.print("Your guess? ");
                } else if (numGuess > numLucky) {
                    System.out.println("It's higher.");
                    System.out.print("Your guess? ");
                } else {
                    //neu doan dung thi dung vong lap
                    if (guessPerGame < bestGame) {
                        bestGame = guessPerGame;
                    }
                    System.out.println("You got it right in " + guessPerGame + " guesses!");
                    guessAgain = false;
                }
            } else {
                //neu khong phai so hoac so nguyen thi nhap lai
                input.next();
                System.out.println("Not a Number or Integer, Guess again");
                System.out.print("Your guess? ");
            }
        } while (guessAgain);
    }
    public static void report() {
        double guessAverage = (double)totalGuesses/totalGames; //so lan doan trung binh
        System.out.println();
        System.out.println("Overall results:");
        System.out.println("Total games   = " + totalGames);
        System.out.println("Total guesses = " + totalGuesses);
        System.out.println("Guesses/game  = " + guessAverage);
        System.out.println("Best game     = " + bestGame);
    }
}

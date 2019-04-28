package pl.kordas.portfolio;

import java.util.Random;
import java.util.Scanner;

public class GameService {

    Scanner scanner = new Scanner(System.in);
    private String playerName;
    private int playerScore = 0;
    private int opponentScore = 0;
    private int gameEnder = 5;
    private int playerWeapon;
    private int opponentWeapon;

    public int getPlayerScore() {
        return playerScore;
    }

    public int getOpponentScore() {
        return opponentScore;
    }

    public void startGame() {

        System.out.println("Tell me your name:");
        playerName = scanner.nextLine();


        do {
            playerPickingWeapon();
            opponentPickingWeapon();

            System.out.println(playerWeapon + " against " + opponentWeapon);
            checkingBattleResults(playerWeapon, opponentWeapon);
            System.out.println(playerScore + " : " + opponentScore);
        }
        while (playerScore < gameEnder && opponentScore < gameEnder);

        endGame();

    }

    public int playerPickingWeapon() {
        System.out.println("Choose your weapon");
        System.out.println("1 - Rock ; 2 - Paper ; 3 - Scissors");

        return playerWeapon = scanner.nextInt();
    }

    public int opponentPickingWeapon() {
        int[] arsenal = {1, 2, 3};
        Random r = new Random();
        int pick = r.ints(0, 3).limit(1).findFirst().getAsInt();

        return opponentWeapon = arsenal[pick];
    }


    public void checkingBattleResults(int player, int opponent) {
        if (opponent == player) {

        } else if ((opponent == 1 && player == 3) ||
                (opponent == 2 && player == 1) ||
                (opponent == 3 && player == 2)) {
            opponentScore += 1;
        } else {
            playerScore += 1;
        }
    }

    public void endGame() {

        if (playerScore == gameEnder){
            System.out.println(playerName + " WON!");
        } else {
            System.out.println("You lost!");
        }

    }

}

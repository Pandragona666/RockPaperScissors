package pl.kordas.portfolio;

import java.util.Random;
import java.util.Scanner;

public class GameService {

    private String playerName;
    private int playerScore = 0;
    private int opponentScore = 0;
    private int gameEnder = 5;
    private int playerWeapon;
    private int opponentWeapon;

    Scanner scanner = new Scanner(System.in);

    public void startGame() {

//        System.out.println("Tell me your name:");
//        playerName = scanner.nextLine();

        pickingWeapon();

        System.out.println( playerWeapon + " against " + opponentWeapon);
        checkingBattleResults();
        System.out.println(playerScore + " : " + opponentScore);

    }

    public void pickingWeapon() {
        System.out.println("Choose your weapon");
        System.out.println("1 - Rock ; 2 - Paper ; 3 - Scissors");
        playerWeapon = scanner.nextInt();

        int[] arsenal = {1,2,3};
        Random r = new Random();
        int pick = r.ints(1, 4).limit(1).findFirst().getAsInt();
        opponentWeapon = arsenal[pick];


    }

    public void checkingBattleResults() {
        if (opponentWeapon == playerWeapon) {
            System.out.println("Remis");
        }
        if ((opponentWeapon == 1 && playerWeapon == 3) ||
                (opponentWeapon == 2 && playerWeapon == 1) ||
                (opponentWeapon == 3 && playerWeapon == 2)) {
            opponentScore += 1;
        }else {
            playerScore += 1;
        }
    }

    public void endGame() {

    }

}

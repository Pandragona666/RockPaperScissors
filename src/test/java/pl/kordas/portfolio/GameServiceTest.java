package pl.kordas.portfolio;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class GameServiceTest {

    private GameService gameService = new GameService();

//    @BeforeEach
//    public void setup(){
//        gameService = new GameService();
//    }

    //("1 - Rock ; 2 - Paper ; 3 - Scissors");
    @ParameterizedTest(name = "expecting \"{2}\" when given {0} and {1}")
    @CsvSource({
            // given: 1 and 1 (Rock vs. Rock) , expected "0" for both
            "1, 1, 0, 0",
            // given: 2 and 2 (Paper vs. Paper), expected "0" for both
            "2, 2, 0, 0",
            // given: 3 and 3 (Scissors vs. Scissors), expected "0" for both
            "3, 3, 0, 0",
    })
    public void checkingBattleInCaseOfTheSameWeapons(int inputPlayer, int inputOpponent, int expectedPlayerScore, int expectedOpponentScore) throws Exception {
        //when
        gameService.checkingBattleResults(inputPlayer,inputOpponent);

        //then
        assertThat(gameService.getPlayerScore()).isEqualTo(expectedPlayerScore);
        assertThat(gameService.getOpponentScore()).isEqualTo(expectedOpponentScore);
    }

    //("1 - Rock ; 2 - Paper ; 3 - Scissors");
    @ParameterizedTest(name = "expecting \"{2}\" when given {0} and {1}")
    @CsvSource({
            // given: 1 and 2 (Rock vs. Paper), expected "0" for Player and "1" for Opponent
            "1, 2, 0, 1",
            // given: 1 and 3, (Rock vs. Scissors), expected "1" for Player and "0" for Opponent
            "1, 3, 1, 0",
            // given: 2 and 1, (Paper vs. Rock), expected "1" for Player and "0" for Opponent
            "2, 1, 1, 0",
            // given: 2 and 3, (Paper vs. Scissors), expected "0" for Player and "1" for Opponent
            "2, 3, 0, 1",
            // given: 3 and 1, (Scissors vs. Rock), expected "0" for Player and "1" for Opponent
            "3, 1, 0, 1",
            // given: 3 and 2, (Scissors vs. Paper), expected "1" for Player and "0" for Opponent
            "3, 2, 1, 0",
    })
    public void checkingBattleInCaseOfDifferentWeapon(int inputPlayer, int inputOpponent, int expectedPlayerScore, int expectedOpponentScore){
        //when
        gameService.checkingBattleResults(inputPlayer,inputOpponent);

        //then
        assertThat(gameService.getPlayerScore()).isEqualTo(expectedPlayerScore);
        assertThat(gameService.getOpponentScore()).isEqualTo(expectedOpponentScore);
    }


    @Test
    public void checkingBattleRockAgainstPaper() throws Exception {
        //given
        final int playerInput = 1;
        final int opponentInput = 2;

        //when
        gameService.checkingBattleResults(playerInput,opponentInput);


        //then
        assertThat(gameService.getOpponentScore()).isEqualTo(1);
        assertThat(gameService.getPlayerScore()).isEqualTo(0);
    }


    //("1 - Rock ; 2 - Paper ; 3 - Scissors");
    @Test
    public void checkingBattlePaperAgainstRock() throws Exception {
        //given
        final int playerInput = 2;
        final int opponentInput = 1;

        //when
        gameService.checkingBattleResults(playerInput,opponentInput);


        //then
        assertThat(gameService.getOpponentScore()).isEqualTo(0);
        assertThat(gameService.getPlayerScore()).isEqualTo(1);
    }

    @Test
    public void checkingBattlePaperAgainstScissors() throws Exception {
        //given
        final int playerInput = 2;
        final int opponentInput = 3;

        //when
        gameService.checkingBattleResults(playerInput,opponentInput);


        //then
        assertThat(gameService.getOpponentScore()).isEqualTo(1);
        assertThat(gameService.getPlayerScore()).isEqualTo(0);
    }

    @Test
    public void checkingBattleRockAgainstScissors() throws Exception {
        //given
        final int playerInput = 1;
        final int opponentInput = 3;

        //when
        gameService.checkingBattleResults(playerInput,opponentInput);


        //then
        assertThat(gameService.getOpponentScore()).isEqualTo(0);
        assertThat(gameService.getPlayerScore()).isEqualTo(1);
    }



    @Test
    public void opponentPicksWeaponBetweenOneAndThree() throws Exception {
        //given
        GameService gameService1= new GameService();

        //when
        int result = gameService1.opponentPickingWeapon();

        //then
        assertThat(result).isBetween(1,3);
    }

}
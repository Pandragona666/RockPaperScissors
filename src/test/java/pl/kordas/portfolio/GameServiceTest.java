package pl.kordas.portfolio;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.Assertions.*;

public class GameServiceTest {

    private GameService gameService;

    @Before
    public void testSetup() throws Exception {
        gameService = new GameService();
    }


    //("1 - Rock ; 2 - Paper ; 3 - Scissors");
    /*@ParameterizedTest(name = "expecting \"{2}\" when given {0} and {1}")
    @CsvSource({
            // given: 1 and 1, expected "0"
            "1, 1, 0",
            // given: 1 and 1, expected "0"
            "2, 2, 0",
            // given: 1 and 1, expected "0"
            "3, 3, 0",
    })
    public void checkingBattleInCaseOfTheSameWeapons(int input, int input2, int expected) throws Exception {
        //when
        int result = gameService.checkingBattleResults(input,input2);

        //then
        assertThat(result).isEqualTo(expected);
    }*/

    //("1 - Rock ; 2 - Paper ; 3 - Scissors");
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
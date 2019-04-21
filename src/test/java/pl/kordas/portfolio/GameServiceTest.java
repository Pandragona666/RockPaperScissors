package pl.kordas.portfolio;

import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.ranges.Range;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.*;

public class GameServiceTest {

    private GameService gameService;

    @Before
    public void testSetup() throws Exception {
        gameService = new GameService();
    }

    //("1 - Rock ; 2 - Paper ; 3 - Scissors");
    @Test
    public void checkingBattleRockAgainstScissors() throws Exception {
        //given
        final int playerInput = 1;
        final int opponentInput = 2;

        //when
        gameService.checkingBattleResults(playerInput,opponentInput);


        //then
        assertThat(gameService.getOpponentScore()).isEqualTo(1);
        assertThat(gameService.getPlayerScore()).isEqualTo(0);
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
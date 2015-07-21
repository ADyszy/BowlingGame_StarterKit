import static org.junit.Assert.*;

import org.junit.Test;

public class BowlingGameCalcTest {

	private static void makeRolls(BowlingGameResult game, int... args) {
		for (int i : args) {
			game.roll(i);
		}
	}

	@Test
	public void whenRoll5ThenScore5() {
		BowlingGameResult game = new BowlingGameResult();
		makeRolls(game, 5);
		assertEquals(5, game.score());
	}

	@Test
	public void whenRoll5Roll3ThenScore8() {
		BowlingGameResult game = new BowlingGameResult();
		makeRolls(game, 3, 5);
		assertEquals(8, game.score());
	}

	@Test
	public void whenRoll10Roll3Roll4ThenScore24() {
		BowlingGameResult game = new BowlingGameResult();
		makeRolls(game, 10, 3, 4);
		assertEquals(24, game.score());
	}

	@Test
	public void whenRoll7Roll3Roll4ThenScore18() {
		BowlingGameResult game = new BowlingGameResult();
		makeRolls(game, 7, 3, 4);
		assertEquals(18, game.score());
	}

	@Test
	public void whenRoll10Roll10Roll4Roll1ThenScore44() {
		BowlingGameResult game = new BowlingGameResult();
		makeRolls(game, 10, 10, 4, 1);
		assertEquals(44, game.score());
	}

	@Test
	public void whenRoll2Roll3ThirteenTimesInARowThenScore50() {
		BowlingGameResult game = new BowlingGameResult();	
		makeRolls(game,2,3,2,3,2,3,2,3,2,3,2,3,2,3,2,3,2,3,2,3,2,3,2,3,2,3);
		assertEquals(50, game.score());
	}

	@Test
	public void whenRoll7Roll3Roll10Roll1Roll2ThenScore36() {
		BowlingGameResult game = new BowlingGameResult();
		makeRolls(game, 7, 3, 10, 1, 2);
		assertEquals(36, game.score());
	}

	@Test
	public void whenRoll10Roll6Roll4Roll1ThenScore32() {
		BowlingGameResult game = new BowlingGameResult();		
		makeRolls(game, 10, 6, 4, 1);
		assertEquals(32, game.score());
	}

	@Test
	public void shouldIsFinishedWhenHaveNotBonusInTenRoundThenTrue() {
		BowlingGameResult game = new BowlingGameResult();
		for (int i = 0; i < 10; i++) {
			makeRolls(game, 2, 3);
		}
		assertEquals(true, game.isFinished());
	}

	@Test
	public void shouldIsFinishedWhenHaveSpareInTenRoundThenTrue() {
		BowlingGameResult game = new BowlingGameResult();
		for (int i = 0; i < 9; i++) {
			makeRolls(game, 2, 3);
		}
		makeRolls(game, 6, 4, 3);
		assertEquals(true, game.isFinished());
	}

	@Test
	public void shouldIsFinishedWhenHaveStrikeInTenRoundThenTrue() {
		BowlingGameResult game = new BowlingGameResult();
		for (int i = 0; i < 9; i++) {
			makeRolls(game, 2, 3);
		}
		makeRolls(game, 10, 5, 5);
		assertEquals(true, game.isFinished());
	}

	@Test
	public void fullGameTestOneWhenHaveNotBonusThenScore50() {
		BowlingGameResult game = new BowlingGameResult();
		for (int i = 0; i < 10; i++) {
			makeRolls(game, 2, 3);
		}
		assertEquals(50, game.score());
	}

	@Test
	public void fullGameTestOneWhenHaveSpareInTenRound() {
		BowlingGameResult game = new BowlingGameResult();
		for (int i = 0; i < 9; i++) {
			makeRolls(game, 2, 3);
		}
		makeRolls(game, 6, 4, 2);
		assertEquals(57, game.score());
	}

	@Test
	public void fullGameTestOneWhenHaveStrikeInTenRound() {
		BowlingGameResult game = new BowlingGameResult();
		for (int i = 0; i < 9; i++) {
			makeRolls(game, 2, 3);
		}
		makeRolls(game, 10, 10, 5);
		assertEquals(70, game.score());
	}

	@Test
	public void fullGameTestOnlyStrikeInGameThenScore300() {
		BowlingGameResult game = new BowlingGameResult();
		for (int i = 0; i < 12; i++) {
			makeRolls(game, 10);
		}
		assertEquals(300, game.score());
	}

	@Test
	public void whenRoll7Roll3ThenScore10() {
		BowlingGameResult game = new BowlingGameResult();
		makeRolls(game, 7, 3);
		assertEquals(10, game.score());
	}

	@Test
	public void whenRoll10Roll10Roll10ThenScore60() {
		BowlingGameResult game = new BowlingGameResult();
		makeRolls(game, 10, 10, 10 );
		assertEquals(60, game.score());
	}

}

/*
 * Bryan Munoz-Romero
 */

/*
 * This class has all the players scores, and contains all the game data and logic.
 */

public class PigGame
{
	public static int SCORE_TO_WIN = 100;
	private PairsOfDice dice; //Pig game will need a pair of dice to roll
	private int scoreForPlayer1;
	private int scoreForPlayer2;
	private int scoreForPlayer3;
	private int scoreForPlayer4;
	private int roundScore;
	private boolean isTurnForPlayer1;
	private boolean isTurnForPlayer2;
	private boolean isTurnForPlayer3;
	private boolean isTurnForPlayer4;
	
	public PigGame()
	{
		reset();
	}
	
	private void reset()
	{
		dice = new PairsOfDice();
		scoreForPlayer1 = 0;
		scoreForPlayer2 = 0;
		scoreForPlayer3 = 0;
		scoreForPlayer4 = 0;
		roundScore = 0;
		isTurnForPlayer1 = true;
		isTurnForPlayer2 = false;
		isTurnForPlayer3 = false;
		isTurnForPlayer4 = false;
	}

	public int getScoreForPlayer1()
	{
		return scoreForPlayer1;
	}

	public int getScoreForPlayer2()
	{
		return scoreForPlayer2;
	}

	public int getScoreForPlayer3()
	{
		return scoreForPlayer3;
	}

	public int getScoreForPlayer4()
	{
		return scoreForPlayer4;
	}

	public int getRoundScore()
	{
		return roundScore;
	}
	
	public boolean isGameOver()
	{
		return scoreForPlayer1 >= SCORE_TO_WIN || 
				scoreForPlayer2 >= SCORE_TO_WIN || 
				scoreForPlayer3 >= SCORE_TO_WIN || 
				scoreForPlayer4 >= SCORE_TO_WIN;
	}
	
	
	//Win checkers
	public boolean didPlayer1Win()
	{
		if(isTurnForPlayer1)
			return scoreForPlayer1 + roundScore >= SCORE_TO_WIN;
			
		return scoreForPlayer1 > SCORE_TO_WIN;
	}
	
	public boolean didPlayer2Win()
	{
		if(isTurnForPlayer2)
			return scoreForPlayer2 + roundScore >= SCORE_TO_WIN;
			
		return scoreForPlayer2 > SCORE_TO_WIN;
	}
	
	public boolean didPlayer3Win()
	{
		if(isTurnForPlayer3)
			return scoreForPlayer3 + roundScore >= SCORE_TO_WIN;
			
		return scoreForPlayer3 > SCORE_TO_WIN;
	}
	
	public boolean didPlayer4Win()
	{
		if(isTurnForPlayer4)
			return scoreForPlayer4 + roundScore >= SCORE_TO_WIN;
			
		return scoreForPlayer4 > SCORE_TO_WIN;
	}
	
	//Check if they can play still
	public boolean canPlayerGoAgain()
	{
		return !(dice.getValue1() == 1 || dice.getValue2() == 1);//
	}
	
	//Add scores and changes turns
	public void turnOverDice()
	{
		if(isTurnForPlayer1)//
			scoreForPlayer1 += roundScore;//
		else if(isTurnForPlayer2)
			scoreForPlayer2 += roundScore;
		else if(isTurnForPlayer3)
			scoreForPlayer3 += roundScore;
		else if(isTurnForPlayer4)
			scoreForPlayer4 += roundScore;
		
		roundScore = 0;
		
		//Cycles through turns
		if(isTurnForPlayer1)//
		{
			isTurnForPlayer1 = !isTurnForPlayer1;//
			isTurnForPlayer2 = !isTurnForPlayer2;
		}
		else if(isTurnForPlayer2)
		{
			isTurnForPlayer2 = !isTurnForPlayer2;
			isTurnForPlayer3 = !isTurnForPlayer3;
		}
		else if(isTurnForPlayer3)
		{
			isTurnForPlayer3 = !isTurnForPlayer3;
			isTurnForPlayer4 = !isTurnForPlayer4;
		}
		else if(isTurnForPlayer4)
		{
			isTurnForPlayer4 = !isTurnForPlayer4;
			isTurnForPlayer1 = !isTurnForPlayer1;
		}
	}
	
	public String outputAfterTurn()
	{
		return String.format("+----+  +----+\n" + 
							"| %d |  | %d |\n" + 
							"+----+  +----+\n" + 
							"round score: %d\n" + 
							"game score: %d\n" + 
							"total score: %d\n", dice.getValue1(), dice.getValue2(),
							roundScore, (isTurnForPlayer1 ? scoreForPlayer1 : (isTurnForPlayer2 ? scoreForPlayer2 : (isTurnForPlayer3 ? scoreForPlayer3 : scoreForPlayer4))), 
							(isTurnForPlayer1 ? scoreForPlayer1 : (isTurnForPlayer2 ? scoreForPlayer2 : (isTurnForPlayer3 ? scoreForPlayer3 : scoreForPlayer4))) + roundScore);
	}
	
	//Depending on the dice this will score and 0 the score too by numbers of ones gain
	public void takeTurn()
	{
		dice = new PairsOfDice();
				
		if(canPlayerGoAgain())
		{	
			roundScore = dice.getValue1() + dice.getValue2() + roundScore;
		}
		else
		{
			if(dice.getValue1() == 1 && dice.getValue2() == 1)
			{
				if(isTurnForPlayer1)
				{
					scoreForPlayer1 = 0;
					roundScore = 0;
				}
				else if(isTurnForPlayer2)
				{
					scoreForPlayer2 = 0;
					roundScore = 0;
				}
				else if(isTurnForPlayer3)
				{
					scoreForPlayer3 = 0;
					roundScore = 0;
				}
				else if(isTurnForPlayer4)
				{
					scoreForPlayer4 = 0;
					roundScore = 0;
				}
			}
			else
			{
				roundScore = 0;
			}
		}

	}
}

/*
 * Bryan Munoz-Romero
 */

import java.util.Scanner;//
import java.util.concurrent.TimeUnit;//

public class PigGameDriver
{
	public static void main(String[] args) throws InterruptedException
	{
		Scanner scan = new Scanner(System.in);//
		PigGame game = new PigGame();//
		
		int choice;//
		
		do
		{
			System.out.println("\n\n***********************");//
			System.out.println("* Your score: " + game.getScoreForPlayer1());//
			System.out.println("* CPU 2 score : " + game.getScoreForPlayer2());//-
			System.out.println("* CPU 3 score : " + game.getScoreForPlayer3());//-
			System.out.println("* CPU 4 score : " + game.getScoreForPlayer4());//-
			System.out.println("***********************");//
			
			//Player 1, user
			do
			{
				System.out.print("Enter 1 to roll, -1 to quit the game, another value to turn over dice: ");//
				choice = scan.nextInt();//
				
				if(choice == 1)//
				{
					game.takeTurn();//
					System.out.println(game.outputAfterTurn());//
					
					if(game.didPlayer1Win())//
					{
						choice = -1; //This ends the game//
						System.out.println("You won!");//
						game.turnOverDice();//
					}
					else if(!game.canPlayerGoAgain())
					{
						choice = 0; //This will turn over dice//
						System.out.println("You are forced to turn over dice");//
						game.turnOverDice();//
					}
				}
				else if(choice != -1)//
				{
					System.out.println("You decided to turn over dice");//
					game.turnOverDice();//
				}
				
			} while(choice == 1);//
			
			if(choice != -1)//
			{
				System.out.println("\n****************************************");//
				//Computer's turn
				int computerDone = 0;//-
				
				do
				{
					TimeUnit.SECONDS.sleep(2);//
					game.takeTurn();//
					System.out.println(game.outputAfterTurn());//
					
					if(game.didPlayer2Win())//-
					{
						choice = -1; //This ends the game//
						System.out.println("CPU 2 Won!");//-
						computerDone = 3;//-
						game.turnOverDice();//
					}
					else if(game.didPlayer3Win())//-
					{
						choice = -1; //This ends the game//
						System.out.println("CPU 3 Won!");//-
						computerDone = 3;//-
						game.turnOverDice();//
					}
					else if(game.didPlayer4Win())//-
					{
						choice = -1; //This ends the game//
						System.out.println("CPU 4 Won!");//-
						computerDone = 3;//-
						game.turnOverDice();//
					}
					else if(!game.canPlayerGoAgain())//
					{
						System.out.printf("CPU %d is force to turn over dice.\n", computerDone + 2);//-
						game.turnOverDice();//
						computerDone++;//-
					}
					else if(game.getRoundScore() >= 20)//
					{
						System.out.printf("CPU %d volutarily turns over dice.\n", computerDone + 2);//-
						game.turnOverDice();//
						computerDone++;//-
					}
					
				} while(computerDone != 3);//-
				
			}
			
		} while(choice != -1 && !game.isGameOver());//
		
		System.out.println("Game over.");//
		
		scan.close();
	}
}

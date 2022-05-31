/*
 * Bryan Munoz-Romero
 */

public class PairsOfDice
{
	private int val1, val2;
	private static final int max = 6;
	private static final int min = 1;
	
	public PairsOfDice()
	{
		val1 = getRandomValue();
		val2 = getRandomValue();
	}
	
	private int getRandomValue()
	{
		int rand = (int) ((Math.random() * (max - min)) + min);
		int result = 0;
		
		switch(rand)
		{
			case 1:
				result = Die.One.getNum();
				break;
			case 2:
				result = Die.Two.getNum();
				break;
			case 3:
				result = Die.Three.getNum();
				break;
			case 4:
				result = Die.Four.getNum();
				break;
			case 5:
				result = Die.Five.getNum();
				break;
			case 6:
				result = Die.Six.getNum();
				break;
		}
		
		return result;
	}
	
	public int getValue1()
	{
		return val1;
	}
	
	public int getValue2()
	{
		return val2;
	}
}

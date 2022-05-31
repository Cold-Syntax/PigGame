/*
 * Bryan Munoz-Romero
 */

public enum Die
{
	One(1), Two(2), Three(3), Four(4), Five(5), Six(6);
	
	//Convert String to number
	private int num;
	
	Die(int num)
	{
		this.num = num;
	}
	
	public int getNum()
	{
		return num;
	}
}

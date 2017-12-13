package Lab4one;

public class Cards 
{
	private String rank;
	private String suit;
	private int pointValue;
	
	public Cards(String rank, String suit, int pointValue)
	{
		this.rank = rank;
		this.suit = suit;
		this.pointValue = pointValue;
	}
	
	public String getRank() 
	{
		return this.rank;
	}

	public String getSuit() 
	{
		return this.suit;
	}

	public int getPointValue() 
	{
		return this.pointValue;
	}
	
	public boolean equals(Cards otherCard)
	{
		if(this.pointValue == otherCard.pointValue)
		{
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() 
	{
		return "Cards [rank=" + rank + ", suit=" + suit + ", pointValue=" + pointValue + "]";
	}

}

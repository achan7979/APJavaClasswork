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
	
	/**
	 * This method returns the intstance's rank
	 * 
	 * @return a string representing the rank
	 */
	public String getRank() 
	{
		return this.rank;
	}
	
	/**
	 * This method returns the intstance's suit
	 * 
	 * @return a string representing the suit
	 */
	public String getSuit() 
	{
		return this.suit;
	}
	
	/**
	 * This method returns the intstance's point value
	 * 
	 * @return an integer representing the point value
	 */
	public int getPointValue() 
	{
		return this.pointValue;
	}
	
	/**
	 * Tests to see if the instance's point value is equal to another instances point value
	 * 
	 * @param Cards a card object
	 * @return a boolean telling us if the cards are equal or not
	 */
	public boolean equals(Cards otherCard)
	{
		return this.pointValue == otherCard.pointValue;
	}
	
	/**
	 * Displays the card object as a string
	 * 
	 * @return a string that describes the card
	 */
	@Override
	public String toString() 
	{
		return "Cards [rank = " + rank + ", suit = " + suit + ", pointValue = " + pointValue + "]";
	}

}

package Lab4one;

public class DeckTester 
{
	public static void main(String[] args) 
	{
		String[] ranks = {"ACE","2","3","4","5","6","7","8","9","10","JACK","QUEEN","KING"};
		String[] suits = {"DIAMOND","CLOVER","HEART","SPADE"};
		int[] pointValues = {1,2,3,4,5,6,7,8,9,10,11,12,13};
		
		Deck theDeck = new Deck(ranks,suits,pointValues);
		theDeck.shuffle();
		for(int i = theDeck.size()-1; i >= 0; i--)
		{
			System.out.println(theDeck.deal().toString());
		}
	}
}

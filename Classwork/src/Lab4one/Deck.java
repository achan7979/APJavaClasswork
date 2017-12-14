package Lab4one;

import java.util.ArrayList;

public class Deck 
{
	private ArrayList<Cards> unDealt = new ArrayList<Cards>();
	private ArrayList<Cards> Dealt = new ArrayList<Cards>();
	
	public Deck(String[] ranks, String[] suits, int[] pointValues)
	{
		for(int rank = 0; rank < ranks.length; rank++)
		{
			for(int suit = 0; suit < suits.length; suit++)
			{
				Cards card = new Cards(ranks[rank], suits[suit], pointValues[rank]);
				this.unDealt.add(card);
			}
		}
	}
	
	public boolean isEmpty()
	{
		return this.unDealt.size() == 0;
	}
	
	public int size()
	{
		return this.unDealt.size();
	}
	
	public Cards deal()
	{
		if(this.isEmpty())
		{
			return null;
		}
		else
		{
			this.Dealt.add(this.unDealt.get(this.size()-1));
		}
		return this.unDealt.remove(this.size()-1);
	}
	
	public void shuffle()
	{
		for(int k = this.size()-1; k >= 0; k--)
		{
			int r = (int) (Math.random()*k+1);
			swap(this.unDealt,k,r);
		}
	}
	
	private static void swap(ArrayList<Cards> a, int i, int j)
	{
	    Cards temp = a.get(i);
	    a.set(i,a.get(j));
	    a.set(j,temp);
	}
}

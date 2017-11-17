package LearnJavaTheHardWayHORSE;

public class HorseBarn
{
	/**The spaces in the barn. Each array element holds a reference to the horse
	 * that is currently occupying the space. A null value indicates an empty space.
	 */
	private Horse[] spaces;
	
	public HorseBarn(Horse[] spaces)
	{
		this.spaces = spaces;
	}
	
	/** Returns the index of the space that contains the horse with the specified name.
	 * Precondition: No two horses in the barn have the same name.
	 * @param name the name of the horse to find
	 * @return the index of the space containing the horse with the specified name;
	 * -1 if no horse with the specified name is in the barn.
	 */
	public int findHorseSpace(String name)
	{
		for(int i = 0; i < this.spaces.length; i++)
		{
			if(this.spaces[i] != null && name.equals(this.spaces[i].getName()))
				return i;
		}
		return -1;
	}
	
	/** Consolidates the barn by moving horses so that the horses are in adjacent spaces,
	 * 	starting at index 0, with no empty space between any two horses.
	 * 	Postcondition: The order of the horses is the same as before the consolidation.
	 */
	public void consolidate()
	{
		Horse[] newSpaces = new Horse[this.spaces.length];
		int nextSpot = 0;
		for(Horse nextHorse : this.spaces)
		{
			if(nextHorse != null)
			{
				newSpaces[nextSpot] = nextHorse;
				nextSpot++;
			}
		}
		this.spaces = newSpaces;
	}
	
	public String toString()
	{
		String barn = "";
		for(int i = 0; i < this.spaces.length; i++)
		{
			if(this.spaces[i] != null)
				barn = barn + this.spaces[i] + " ";
			else
				barn = barn + "[null] ";
		}
		return barn;
	}
}

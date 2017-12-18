package ReadingCSVFiles;

public class UhHuh 
{
	private String name; 
	private String idk; 
	
	public UhHuh(String name, String price) 
	{ 
		this.name = name; 
		this.idk = price; 
	}
	
	public String getName() 
	{
        return name;
    }
	
	public void setName(String name) 
	{ 
		this.name = name; 
	}
	
	public String getPrice() 
	{
        return idk;
    }
	
	public void setPrice(String yes) 
	{ 
		this.idk = yes; 
	}
	
	@Override public String toString() 
	{ 
		return "UhHuh [name = " + name + ", uhhhhhh = " + idk + "]"; 
	}
}

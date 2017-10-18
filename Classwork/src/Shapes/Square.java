package Shapes;

public class Square extends Rectangle
{
	private double side;
	public Square(double side) 
	{
		super(side, side);
		this.side = side;
	}
	
	@Override
	public String toString()
	{
		return "Square Side Length = " + side + "/t Area = " + this.area() + "t/ Perimeter = " + this.perimeter();
	}
}

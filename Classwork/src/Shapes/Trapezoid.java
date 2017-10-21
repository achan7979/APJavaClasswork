package Shapes;

public class Trapezoid extends Rectangle
{
	int s2 = (int) Math.random()*5 + 1; 
	int h = (int) Math.random()*20 + 5;
	private double length;
	private double width;
	public Trapezoid(double length, double width) 
	{
		super(length, width);
		this.length = length;
		this.width = width;
	}
	
	public double perimeter()
	{
		return (width*2) + (length*2) + s2;
	}
	
	public double area()
	{
		return ((width+length+s2)*h)/2;
	}
	
	public String toString()
	{
		return "Trapezoid Width = " + this.width + "\t base 1 = " + this.length + "\t base 2 = " + (this.length + s2) + "\t height = " + h + 
				"\t Area = " + this.area() + "\t Perimeter = " + this.perimeter();
	}
}

package Shapes;

public class Circle implements Shape
{
	private double radius;
	private static double pi = 3.1415926535;
	public Circle(double radius)
	{
		this.radius = radius;
	}
	@Override
	public double perimeter()
	{
		return 2*radius*pi;
	}
	@Override
	public double area()
	{
		return radius*radius*pi;
	}
	@Override
	public String toString() 
	{
		return "Circle Radius = " + radius + "\t Area = " + this.area() + "\t Circumfrence = " + this.perimeter();
	}
}

package Shapes;
import java.util.Random;

public class ShapeUtilities 
{
	public static Shape getRandomShape()
	{
		Random r = new Random();
		int x = r.nextInt(3);
		switch(x)
		{
		case 0:
			return new Circle(r.nextInt(100)+1);
		case 1:
			return new Rectangle(r.nextInt(100)+1,r.nextInt(100)+1);
		default:
			return new Square(r.nextInt(100)+1);
		}
	}
	public static double sumPerimeter(Shape[] shapeArray)
	{
		double sum = 0;
		for(int i = 0; i < shapeArray.length; i++)
		{
			sum += shapeArray[i].perimeter();
		}
		return sum;
	}
	public static double sumArea(Shape[] shapeArray)
	{
		double sum = 0;
		for(int i = 0; i < shapeArray.length; i++)
		{
			sum += shapeArray[i].area();
		}
		return sum;
	}
}

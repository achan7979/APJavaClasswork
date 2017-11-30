package Person;

public class Student extends Person
{
	public Student(String firstName, String familyName, int[] dob, int ssn, String birthplace) {
		super(firstName, familyName, dob, ssn, birthplace);
		// TODO Auto-generated constructor stub
	}
	private String school;
	private double osis;
	private int gradeLevel;
	private double gpa;
	private String[] classes;
	@Override
	public String greeting() 
	{
		return null;
	}
}

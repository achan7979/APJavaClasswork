package Person;

public class Teacher extends Person
{
	public Teacher(String firstName, String familyName, int[] dob, int ssn, String birthplace) {
		super(firstName, familyName, dob, ssn, birthplace);
		// TODO Auto-generated constructor stub
	}
	private String school;
	private int salary;
	private String subject;
	private String prefix;
	@Override
	public String greeting() 
	{
		return null;
	}
}

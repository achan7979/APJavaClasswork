package Person;

public abstract class Person 
{
	private String firstName;
	private String familyName;
	private int[] dob;
	private int ssn;
	private String birthplace;
	public abstract String greeting();
	public Person (String firstName, String familyName, int[] dob, int ssn, String birthplace)
	{
		this.firstName = firstName;
		this.familyName = familyName;
		this.dob = dob;
		this.ssn = ssn;
		this.birthplace = birthplace;
	}
	public int calculateAge(int[] date)
	{
		return 0;
	}
}

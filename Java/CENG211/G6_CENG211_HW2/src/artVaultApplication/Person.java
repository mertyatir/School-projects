package artVaultApplication;

public abstract class Person implements IComparable<Object>,ISearchable
{
	private String name;
	private int born;
	private int died;
	private String nationality;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getBorn() {
		return born;
	}
	public void setBorn(int born) {
		this.born = born;
	}
	public int getDied() {
		return died;
	}
	public void setDied(int died) {
		this.died = died;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	
	
}

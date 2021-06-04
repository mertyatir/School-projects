package artVaultApplication;

public abstract class Artwork implements IComparable<Object>,ISearchable,ITradable
{
	
	private String name;
	private String style;
	public abstract float CalculateCost();
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	
	
	
}

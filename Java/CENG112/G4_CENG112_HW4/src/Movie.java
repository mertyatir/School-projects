
public class Movie implements IMedia
{
	private String mediaName;
	private int mediaPrice;
	private int mediaYear;
	private String directorName;
	private String actressName;
	private String actorName;
	
	
	public boolean equals(Object other) 
	{
		if(other==null)
			return false;
		if(getClass()!=other.getClass())
			return false;
		Movie o=(Movie) other;
		if(mediaName.equals(o.mediaName)&&mediaPrice==o.mediaPrice&&
				mediaYear==o.mediaYear&&directorName.equals(o.directorName)) 
		{
			return true;
		}
		else
		return false;
	}


	public String getDirectorName() {
		return directorName;
	}

	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}

	public String getActressName() {
		return actressName;
	}

	public void setActressName(String actressName) {
		this.actressName = actressName;
	}

	public String getActorName() {
		return actorName;
	}

	public void setActorName(String actorName) {
		this.actorName = actorName;
	}

	public void setMediaName(String mediaName) {
		this.mediaName = mediaName;
	}

	public void setMediaPrice(int mediaPrice) {
		this.mediaPrice = mediaPrice;
	}

	public void setMediaYear(int mediaYear) {
		this.mediaYear = mediaYear;
	}

	public String toString() {
		return "Movie [" + (mediaName != null ? "mediaName=" + mediaName + ", " : "") + "mediaPrice=" + mediaPrice
				+ ", mediaYear=" + mediaYear + ", "
				+ (directorName != null ? "directorName=" + directorName + ", " : "")
				+ (actressName != null ? "actressName=" + actressName + ", " : "")
				+ (actorName != null ? "actorName=" + actorName : "") + "]";
	}

	public String mediaName() {
		return mediaName;
	}

	public String mediaType() {
		return "Movie";
	}

	public int mediaPrice() {
		return mediaPrice;
	}

	public int mediaYear() {
		return mediaYear;
	}
}

public class Book implements IMedia 
{
	private String mediaName;
	private int mediaPrice;
	private int mediaYear;
	private String authorName;
	
	
	

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
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
		return "Book [" + (mediaName != null ? "mediaName=" + mediaName + ", " : "") + "mediaPrice=" + mediaPrice
				+ ", mediaYear=" + mediaYear + ", " + (authorName != null ? "authorName=" + authorName : "") + "]";
	}
	
	public String mediaName() {
		return mediaName;
	}

	public String mediaType() {
		return "Book";
	}
	public int mediaPrice() {
		return mediaPrice;
	}
	public int mediaYear() {
		return mediaYear;
	}

	public boolean equals(Object other) {
		if(other==null)
			return false;
		if(getClass()!=other.getClass())
			return false;
		Book o=(Book) other;
		if(mediaName.equals(o.mediaName)&& mediaPrice==o.mediaPrice&&
				mediaYear==o.mediaYear&&authorName.equals(o.authorName)) 
		{
			return true;
		}
		else
			
		return false;
	}
}
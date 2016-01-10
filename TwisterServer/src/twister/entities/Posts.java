package twister.entities;

public class Posts {
	private String content;
	private String date;
	private String username;
	
	
	
	public Posts() {
		super();
	}

	public Posts(String content, String date, String username) {
		super();
		this.content = content;
		this.date = date;
		this.username = username;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}

package twister.entities;

import java.util.List;

public class User {
	private String username;
	private String realname;
	private String password;
	private String biography;
	private String email;
	private List<String> meFollow;
	private List<String> followMe;

	public User() {
		super();
	}

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public User(String username, String realname, String biography,
			String email, String password) {
		super();
		this.username = username;
		this.realname = realname;
		this.biography = biography;
		this.email = email;
		this.password = password;

	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<String> getMeFollow() {
		return meFollow;
	}

	public void setMeFollow(List<String> meFollow) {
		this.meFollow = meFollow;
	}

	public List<String> getFollowMe() {
		return followMe;
	}

	public void setFollowMe(List<String> followMe) {
		this.followMe = followMe;
	}

}

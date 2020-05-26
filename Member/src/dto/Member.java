package dto;

public class Member {

	private int userno;
	private String id;
	private String nickname;
	private String email;
	

	@Override
	public String toString() {
		return "Member [userno=" + userno + ", id=" + id + ", nickname=" + nickname + ", email=" + email + "]";
	}

	public int getUserno() {
		return userno;
	}

	public void setUserno(int userno) {
		this.userno = userno;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}

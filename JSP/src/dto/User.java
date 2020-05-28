package dto;

public class User {

	private String id;
	private String pwd;

	@Override
	public String toString() {
		return "User [id=" + id + ", pwd=" + pwd + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

}

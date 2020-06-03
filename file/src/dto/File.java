package dto;

public class File {

	private int fileno;
	private String originName;
	private String storedName;

	@Override
	public String toString() {
		return "File [fileno=" + fileno + ", originName=" + originName + ", storedName=" + storedName + "]";
	}

	public int getFileno() {
		return fileno;
	}

	public void setFileno(int fileno) {
		this.fileno = fileno;
	}

	public String getOriginName() {
		return originName;
	}

	public void setOriginName(String originName) {
		this.originName = originName;
	}

	public String getStoredName() {
		return storedName;
	}

	public void setStoredName(String storedName) {
		this.storedName = storedName;
	}

}

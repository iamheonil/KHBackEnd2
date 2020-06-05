package dto;

public class BoardUpload {

	private String title;
	private String writer;
	private String filename;
	private String originName;
	private String storedName;
	private String content;

	@Override
	public String toString() {
		return "BoardUpload [title=" + title + ", writer=" + writer + ", filename=" + filename + ", originName="
				+ originName + ", storedName=" + storedName + ", content=" + content + "]";
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}

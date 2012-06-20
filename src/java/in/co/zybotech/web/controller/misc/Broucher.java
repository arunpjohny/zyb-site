package in.co.zybotech.web.controller.misc;

public class Broucher {
	private int id;

	private String caption;

	public Broucher() {
	}

	public Broucher(int id, String caption) {
		super();
		this.id = id;
		this.caption = caption;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}
}

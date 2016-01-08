package domain;

/**
 * @author umut - pc
 *
 */
public enum EnumProjectStatus {

	ON_GOING(1, "On Going"), COMPLETED(2, "Completed"), NOT_STARTED(0, "Not Started Yet"), ERROR(-1, "Error");

	private int code;
	private String text;

	private EnumProjectStatus(int code, String text) {
		this.setCode(code);
		this.setText(text);
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public static EnumProjectStatus getByText(String text) {

		for (EnumProjectStatus e : values()) {
			if (e.getText().toUpperCase().equals(text.toUpperCase().trim())) {
				return e;
			}
		}
		return ERROR;

	}

	public static String[] getTextLabels() {

		String[] labels = new String[values().length - 1];
		int i = 0;
		for (EnumProjectStatus e : values()) {
			if (e.getCode() != -1) {
				labels[i] = e.getText();
				i++;
			}
		}
		return labels;

	}
}

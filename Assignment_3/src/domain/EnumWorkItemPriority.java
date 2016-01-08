package domain;

/**
 * @author umut.taherzadeh
 *
 */
public enum EnumWorkItemPriority {

    TRIVIAL(1, "Trivial"), MINOR(2, "Minor"), MAJOR(3, "Major"), CRITICAL(4, "Critical"), BLOCKER(5, "Blocker"), ERROR(-1, "Error");

    private int code;
    private String text;

    private EnumWorkItemPriority(int code, String text) {
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

    public static EnumWorkItemPriority getByText(String text) {

        for (EnumWorkItemPriority e : values()) {
            if (e.getText().toUpperCase().equals(text.toUpperCase())) {
                return e;
            }
        }
        return ERROR;

    }

    public static String[] getTextLabels() {

        String[] labels = new String[values().length - 1];
        int i = 0;
        for (EnumWorkItemPriority e : values()) {
            if (e.getCode() != -1) {
                labels[i] = e.getText();
                i++;
            }
        }
        return labels;

    }
}

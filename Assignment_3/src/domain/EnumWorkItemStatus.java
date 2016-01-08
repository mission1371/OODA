package domain;

/**
 * @author umut.taherzadeh
 *
 */
public enum EnumWorkItemStatus {

    NOT_PLANNED(0, "Not - Planned"), PLANNED(1, "Planned"), ON_GOING(2, "On - Going"), COMPLETED(3, "Completed"), ERROR(-1, "Error");

    private int code;
    private String text;

    private EnumWorkItemStatus(int code, String text) {
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

    public static EnumWorkItemStatus getByText(String text) {

        for (EnumWorkItemStatus e : values()) {
            if (e.getText().toUpperCase().equals(text.toUpperCase().trim())) {
                return e;
            }
        }
        return ERROR;

    }

    public static String[] getTextLabels() {

        String[] labels = new String[values().length - 1];
        int i = 0;
        for (EnumWorkItemStatus e : values()) {
            if (e.getCode() != -1) {
                labels[i] = e.getText();
                i++;
            }
        }
        return labels;

    }
}

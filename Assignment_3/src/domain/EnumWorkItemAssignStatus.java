package domain;

/**
 * @author umut.taherzadeh
 *
 */
public enum EnumWorkItemAssignStatus {

    ASSIGNED(1, "Assigned"), NOT_ASSIGNED(0, "Not Assigned"), ERROR(-1, "Error");

    private int code;
    private String text;

    private EnumWorkItemAssignStatus(int code, String text) {
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

    public static EnumWorkItemAssignStatus getByText(String text) {

        for (EnumWorkItemAssignStatus e : values()) {
            if (e.getText().toUpperCase().equals(text.toUpperCase())) {
                return e;
            }
        }
        return ERROR;

    }

    public static String[] getTextLabels() {

        String[] labels = new String[values().length - 1];
        int i = 0;
        for (EnumWorkItemAssignStatus e : values()) {
            if (e.getCode() != -1) {
                labels[i] = e.getText();
                i++;
            }
        }
        return labels;

    }

}